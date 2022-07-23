package uz.hamroev.smartland.fragment.section.avtomatic

import android.content.Context
import android.os.Bundle
import android.provider.Settings.Global.getString
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.findNavController
import uz.hamroev.smartland.R
import uz.hamroev.smartland.adapter.CheckBoxAdapter
import uz.hamroev.smartland.databinding.FragmentAvtomaticSolveBinding
import uz.hamroev.smartland.db.ProductDatabase
import uz.hamroev.smartland.db.ProductEntity
import uz.hamroev.smartland.firebase.model.Product
import uz.hamroev.smartland.utils.toast

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [AvtomaticSolveFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AvtomaticSolveFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: Int? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getInt(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    lateinit var binding: FragmentAvtomaticSolveBinding
    private val TAG = "AvtomaticSolveFragment"
    lateinit var listProduct: ArrayList<ProductEntity>
    lateinit var checkBoxAdapter: CheckBoxAdapter

    lateinit var productDatabase: ProductDatabase

    lateinit var listSelected: ArrayList<Product>


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAvtomaticSolveBinding.inflate(layoutInflater, container, false)

        productDatabase = ProductDatabase.getInstance(binding.root.context)
        listSelected = ArrayList()
        checkSeasons()

        checkBoxAdapter = CheckBoxAdapter(
            binding.root.context,
            listProduct,
            object : CheckBoxAdapter.OnCheckChangeListener {
                override fun onCheck(productEntity: ProductEntity, position: Int) {
                    listSelected.add(
                        Product(
                            productEntity.product_name,
                            productEntity.product_percentage
                        )
                    )
                }

                override fun onCheckDelete(productEntity: ProductEntity, position: Int) {

                }
            })
        binding.rvSeason.adapter = checkBoxAdapter

        binding.calculateBtn.setOnClickListener {
            val bundle = Bundle()
            bundle.putSerializable("select", listSelected)
            findNavController().navigate(R.id.avtomaticCalculateFragment, bundle)
        }


        return binding.root
    }

    private fun checkSeasons() {
        val position = arguments?.getInt("position")
        when (position) {
            0 -> {
                binding.titleSeason.text = resources.getString(R.string.spring)
                loadSpringProducts()
            }
            1 -> {
                binding.titleSeason.text = resources.getString(R.string.autumn)
                loadAutumnProducts()
            }
        }

    }

    private fun loadAutumnProducts() {
        /* autumn products */
        listProduct = ArrayList()
        listProduct.clear()
        listProduct.add(ProductEntity(resources.getString(R.string.onion_autumn), 16, "autumn"))
        listProduct.add(ProductEntity(resources.getString(R.string.garlic), 14, "autumn"))
        listProduct.add(ProductEntity(resources.getString(R.string.turnip), 14, "autumn"))
        listProduct.add(ProductEntity(resources.getString(R.string.radish), 14, "autumn"))
        listProduct.add(ProductEntity(resources.getString(R.string.spinach), 14, "autumn"))
        listProduct.add(ProductEntity(resources.getString(R.string.cilantro), 14, "autumn"))
        listProduct.add(ProductEntity(resources.getString(R.string.dill), 14, "autumn"))

    }

    private fun loadSpringProducts() {
        /* spring products */
        listProduct = ArrayList()
        listProduct.clear()
        listProduct.add(ProductEntity(resources.getString(R.string.potatoes), 29, "spring"))
        listProduct.add(ProductEntity(resources.getString(R.string.carrot), 28, "spring"))
        listProduct.add(ProductEntity(resources.getString(R.string.tomato), 19, "spring"))
        listProduct.add(ProductEntity(resources.getString(R.string.onion), 11, "spring"))
        listProduct.add(ProductEntity(resources.getString(R.string.cucumber), 8, "spring"))
        listProduct.add(ProductEntity(resources.getString(R.string.eggplant), 2, "spring"))
        listProduct.add(ProductEntity(resources.getString(R.string.Pepper), 2, "spring"))
        listProduct.add(ProductEntity(resources.getString(R.string.bean), 1, "spring"))
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment AvtomaticSolveFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: Int) =
            AvtomaticSolveFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_PARAM1, param1)
                }
            }
    }
}