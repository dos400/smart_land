package uz.hamroev.smartland

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.WindowInsets
import android.view.WindowManager
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatDelegate
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import uz.hamroev.smartland.activity.HomeActivity
import uz.hamroev.smartland.cache.Cache
import uz.hamroev.smartland.databinding.ActivityMainBinding
import uz.hamroev.smartland.firebase.UpdateData
import uz.hamroev.smartland.shadow.RenderScriptBlur
import uz.hamroev.smartland.shadow.RenderScriptProvider
import uz.hamroev.smartland.utils.network.NetworkHelper
import uz.hamroev.smartland.utils.showToast

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private val TAG = "MainActivity"
    lateinit var networkHelper: NetworkHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        setContentView(binding.root)

        Cache.init(this)
        networkHelper = NetworkHelper(this)

        init_shadow()
        @Suppress("DEPRECATION")
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.insetsController?.hide(WindowInsets.Type.statusBars())
        } else {
            window.setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
            )
        }
        supportActionBar?.hide()

        isHaveInternet()



        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this, HomeActivity::class.java))
            finish()
        }, 2200)

        startAnimation()

    }

    private fun isHaveInternet() {
        if (networkHelper.isNetworkConnected()) {
            try {
                val db = Firebase.firestore
                db.collection("update")
                    .get()
                    .addOnSuccessListener { result ->
                        for (documentSnapshot in result) {
                            val isHaveUpdateBoolean =
                                documentSnapshot.data.get("isHaveUpdate") as Boolean
                            isHaveUpdate(isHaveUpdateBoolean)
                        }
                    }
                    .addOnFailureListener { exception ->

                    }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    private fun isHaveUpdate(haveUpdateBoolean: Boolean?) {
        Cache.isHaveUpdate = haveUpdateBoolean
    }

    private fun init_shadow() {
        val renderScriptProvider = RenderScriptProvider(this)
        binding.typeWriter.clipToOutline = true
        binding.spaceShadow.blurScript = RenderScriptBlur(renderScriptProvider)
    }


    private fun startAnimation() {

        binding.typeWriter.animateText("Smart\nland")
        binding.typeWriter.setCharacterDeley(110)

        val animTeam = AnimationUtils.loadAnimation(this, R.anim.anim_intro_team)
        val animVersion = AnimationUtils.loadAnimation(this, R.anim.anim_intro_version)
        val animImage = AnimationUtils.loadAnimation(this, R.anim.anim_intro_image)
//
        binding.teamTv.startAnimation(animTeam)
        binding.versionTv.startAnimation(animVersion)
//        binding.image.startAnimation(animImage)


    }
}