package uz.hamroev.smartland.activity

import android.Manifest
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatDelegate
import androidx.navigation.Navigation
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.karumi.dexter.Dexter
import com.karumi.dexter.MultiplePermissionsReport
import com.karumi.dexter.PermissionToken
import com.karumi.dexter.listener.PermissionRequest
import com.karumi.dexter.listener.multi.MultiplePermissionsListener
import uz.hamroev.smartland.R
import uz.hamroev.smartland.cache.Cache
import uz.hamroev.smartland.databinding.ActivityHomeBinding
import uz.hamroev.smartland.db.ProductDatabase
import uz.hamroev.smartland.db.ProductEntity
import uz.hamroev.smartland.firebase.model.Product
import uz.hamroev.smartland.onDataPass.OnDataPass
import uz.hamroev.smartland.utils.network.NetworkHelper

class HomeActivity : AppCompatActivity(), OnDataPass {
    lateinit var binding: ActivityHomeBinding
    lateinit var productDatabase: ProductDatabase
    lateinit var networkHelper: NetworkHelper
    private val TAG = "HomeActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        setContentView(binding.root)

        Cache.init(this)
        Dexter.withContext(binding.root.context)
            .withPermissions(
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION,
                Manifest.permission.INTERNET
            ).withListener(object : MultiplePermissionsListener {
                override fun onPermissionsChecked(report: MultiplePermissionsReport) {
                }

                override fun onPermissionRationaleShouldBeShown(
                    permissions: List<PermissionRequest>,
                    token: PermissionToken
                ) {
                }
            }).check()
        networkHelper = NetworkHelper(this)
        productDatabase = ProductDatabase.getInstance(this)
        //updateData()

    }


    private fun updateData() {
        if (networkHelper.isNetworkConnected()) {
            try {
                val db = Firebase.firestore
                db.collection("product")
                    .get()
                    .addOnSuccessListener { result ->
                        val productList = result.toObjects(ProductEntity::class.java)
                        for (productEntity in productList) {
                            productDatabase.productDao().updateProduct(productEntity)
                        }
                        Log.d(TAG, "updateData: Update done")

                    }
                    .addOnFailureListener { }
            } catch (e: Exception) {

            }
        }
    }


    override fun onSupportNavigateUp(): Boolean {
        return Navigation.findNavController(this, R.id.my_nav_host_fragment).navigateUp()
    }

    override fun onDataPass(data: Int) {
        when (data) {
            0 -> {}
            1 -> {}
        }
    }
}