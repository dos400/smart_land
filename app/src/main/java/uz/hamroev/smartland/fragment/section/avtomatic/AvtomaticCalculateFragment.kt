package uz.hamroev.smartland.fragment.section.avtomatic

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.navigation.fragment.findNavController
import uz.hamroev.smartland.R
import uz.hamroev.smartland.adapter.SelectedAdapter
import uz.hamroev.smartland.databinding.FragmentAvtomaticCalculateBinding
import uz.hamroev.smartland.db.ProductEntity
import uz.hamroev.smartland.firebase.model.Product
import uz.hamroev.smartland.model.Selected
import uz.hamroev.smartland.utils.toast

class AvtomaticCalculateFragment : Fragment() {

    lateinit var binding: FragmentAvtomaticCalculateBinding
    private val TAG = "AvtomaticCalculateFragm"
    lateinit var listCalculate: ArrayList<Selected>
    lateinit var selectedAdapter: SelectedAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAvtomaticCalculateBinding.inflate(layoutInflater, container, false)

        binding.backIv.setOnClickListener {
            findNavController().popBackStack()
        }

        listCalculate = ArrayList()

        val listSelected = arguments?.getSerializable("select") as ArrayList<ProductEntity>
        for (product in listSelected) {
            Log.d(TAG, "onCreateView: ${product.product_name} - ${product.product_percentage}\n")
        }

        binding.modelEditText.addTextChangedListener { number ->
            Log.d(TAG, "onCreateView: ${number.toString()}")
            for (productEntity in listSelected) {
                val s =
                    number.toString().trim().toInt() * (productEntity.product_percentage!! / 100)

                listCalculate.add(
                    Selected(
                        productEntity.product_name, s.toString()

                    )
                )
            }

            loadAdapter()
        }









        binding.saveButton.setOnClickListener {
            val sotix = binding.modelEditText.text.toString().trim()
            toast(sotix)
        }


        return binding.root
    }

    private fun loadAdapter() {
        selectedAdapter = SelectedAdapter(binding.root.context, listCalculate)
        binding.rvSelectedProduct.adapter = selectedAdapter
    }


}