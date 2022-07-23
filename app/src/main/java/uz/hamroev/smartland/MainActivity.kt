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
import uz.hamroev.smartland.db.ProductDatabase
import uz.hamroev.smartland.db.ProductEntity
import uz.hamroev.smartland.firebase.UpdateData
import uz.hamroev.smartland.firebase.model.Product
import uz.hamroev.smartland.shadow.RenderScriptBlur
import uz.hamroev.smartland.shadow.RenderScriptProvider
import uz.hamroev.smartland.utils.network.NetworkHelper
import uz.hamroev.smartland.utils.showToast

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private val TAG = "MainActivity"
    lateinit var networkHelper: NetworkHelper
    lateinit var productDatabase: ProductDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        setContentView(binding.root)

        Cache.init(this)
        productDatabase = ProductDatabase.getInstance(this)
        networkHelper = NetworkHelper(this)
        createData()
        isHaveInternet()

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




        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this, HomeActivity::class.java))
            finish()
        }, 2200)

        startAnimation()

    }

    private fun createData() {

        if (Cache.createDATAoffline == true) {

            val listProduct = ArrayList<ProductEntity>()
            listProduct.add(ProductEntity("Kartoshka", 29, "spring"))
            listProduct.add(ProductEntity("Sabzi", 28, "spring"))
            listProduct.add(ProductEntity("Pomidor", 19, "spring"))
            listProduct.add(ProductEntity("Piyoz", 11, "spring"))
            listProduct.add(ProductEntity("Bodring", 8, "spring"))
            listProduct.add(ProductEntity("Baqlajon", 2, "spring"))
            listProduct.add(ProductEntity("Qalampir", 2, "spring"))
            listProduct.add(ProductEntity("Loviya", 1, "spring"))

            listProduct.add(ProductEntity("Piyoz", 16, "autumn"))
            listProduct.add(ProductEntity("Sarimsoq", 14, "autumn"))
            listProduct.add(ProductEntity("Sholgom", 14, "autumn"))
            listProduct.add(ProductEntity("Turp", 14, "autumn"))
            listProduct.add(ProductEntity("Ismaloq", 14, "autumn"))
            listProduct.add(ProductEntity("Kashnich", 14, "autumn"))
            listProduct.add(ProductEntity("Ukrop", 14, "autumn"))

            isHaveInternet()

            //TODO(" Create DATABASE")
            for (product in listProduct) {
                productDatabase.productDao().addProduct(product)
            }
            Cache.createDATAoffline = false
        }
    }

    private fun isHaveInternet() {
        if (networkHelper.isNetworkConnected()) {
            if (Cache.createDATAonline == true) {
                val listProduct = ArrayList<ProductEntity>()
                listProduct.add(ProductEntity("Kartoshka", 29, "spring"))
                listProduct.add(ProductEntity("Sabzi", 28, "spring"))
                listProduct.add(ProductEntity("Pomidor", 19, "spring"))
                listProduct.add(ProductEntity("Piyoz", 11, "spring"))
                listProduct.add(ProductEntity("Bodring", 8, "spring"))
                listProduct.add(ProductEntity("Baqlajon", 2, "spring"))
                listProduct.add(ProductEntity("Qalampir", 2, "spring"))
                listProduct.add(ProductEntity("Loviya", 1, "spring"))

                listProduct.add(ProductEntity("Piyoz", 16, "autumn"))
                listProduct.add(ProductEntity("Sarimsoq", 14, "autumn"))
                listProduct.add(ProductEntity("Sholgom", 14, "autumn"))
                listProduct.add(ProductEntity("Turp", 14, "autumn"))
                listProduct.add(ProductEntity("Ismaloq", 14, "autumn"))
                listProduct.add(ProductEntity("Kashnich", 14, "autumn"))
                listProduct.add(ProductEntity("Ukrop", 14, "autumn"))

                try {
                    val db = Firebase.firestore
                    for (product in listProduct) {
                        db.collection("product")
                            .add(product)
                            .addOnSuccessListener { }
                            .addOnFailureListener { }
                    }
                } catch (e: Exception) {

                }
                Cache.createDATAonline = false
            }
        }
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