package uz.hamroev.smartland.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import androidx.navigation.Navigation
import uz.hamroev.smartland.R
import uz.hamroev.smartland.cache.Cache
import uz.hamroev.smartland.databinding.ActivityHomeBinding
import uz.hamroev.smartland.db.ProductDatabase
import uz.hamroev.smartland.firebase.model.Product
import uz.hamroev.smartland.onDataPass.OnDataPass

class HomeActivity : AppCompatActivity(), OnDataPass {
    lateinit var binding: ActivityHomeBinding
    lateinit var productDatabase: ProductDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        setContentView(binding.root)

        Cache.init(this)
        productDatabase = ProductDatabase.getInstance(this)
        isUpdateHave(Cache.isHaveUpdate)

    }

    private fun isUpdateHave(haveUpdate: Boolean?) {
        when (haveUpdate) {
            true -> {
                loadNewData()
            }
            false -> {
                loadOldData()
            }
            else -> {}
        }
    }

    private fun loadOldData() {
        try {
            val listProduct = ArrayList<Product>()
            /* spring products */
            listProduct.add(Product(resources.getString(R.string.potatoes), 29, "spring"))
            listProduct.add(Product(resources.getString(R.string.carrot), 28, "spring"))
            listProduct.add(Product(resources.getString(R.string.tomato), 19, "spring"))
            listProduct.add(Product(resources.getString(R.string.onion), 11, "spring"))
            listProduct.add(Product(resources.getString(R.string.cucumber), 8, "spring"))
            listProduct.add(Product(resources.getString(R.string.eggplant), 2, "spring"))
            listProduct.add(Product(resources.getString(R.string.Pepper), 2, "spring"))
            listProduct.add(Product(resources.getString(R.string.bean), 1, "spring"))
            /* autumn products */
            listProduct.add(Product(resources.getString(R.string.onion_autumn), 16, "autumn"))
            listProduct.add(Product(resources.getString(R.string.garlic), 14, "autumn"))
            listProduct.add(Product(resources.getString(R.string.turnip), 14, "autumn"))
            listProduct.add(Product(resources.getString(R.string.radish), 14, "autumn"))
            listProduct.add(Product(resources.getString(R.string.spinach), 14, "autumn"))
            listProduct.add(Product(resources.getString(R.string.cilantro), 14, "autumn"))
            listProduct.add(Product(resources.getString(R.string.dill), 14, "autumn"))





        } catch (e: Exception) {

        }


    }

    private fun loadNewData() {

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