package uz.hamroev.smartland.fragment.section.avtomatic

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import uz.hamroev.smartland.R
import uz.hamroev.smartland.databinding.FragmentAvtomaticCalculateBinding
import uz.hamroev.smartland.firebase.model.Product

class AvtomaticCalculateFragment : Fragment() {

    lateinit var binding: FragmentAvtomaticCalculateBinding
    private val TAG = "AvtomaticCalculateFragm"
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAvtomaticCalculateBinding.inflate(layoutInflater, container, false)

        val listSelected = arguments?.getSerializable("select") as ArrayList<Product>
        for (product in listSelected) {
            Log.d(TAG, "onCreateView: ${product.product_name} - ${product.product_percentage}")
        }

        return binding.root
    }


}