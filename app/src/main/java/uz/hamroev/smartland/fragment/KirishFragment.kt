package uz.hamroev.smartland.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.squareup.okhttp.Cache
import uz.hamroev.smartland.R
import uz.hamroev.smartland.databinding.FragmentKirishBinding
import uz.hamroev.smartland.db.daromad.DaromadDatabase

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [KirishFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class KirishFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    lateinit var binding: FragmentKirishBinding
    private  val TAG = "KirishFragment"
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentKirishBinding.inflate(layoutInflater)


        binding.backIv.setOnClickListener {
            findNavController().popBackStack()
        }
        when(uz.hamroev.smartland.cache.Cache.language){
            "uz"->{
                binding.info.text = """
                    
           """.trimIndent()
            }
            "ru"->{
                binding.info.text = """
                    
                """.trimIndent()
            }
            "en"->{
                binding.info.text = """
                    
                """.trimIndent()
            }
        }


        return binding.root
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment KirishFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            KirishFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}