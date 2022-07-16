package uz.hamroev.smartland.fragment.section.avtomatic

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import uz.hamroev.smartland.R
import uz.hamroev.smartland.databinding.FragmentAvtomaticSolveBinding
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
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAvtomaticSolveBinding.inflate(layoutInflater, container, false)

        checkSeasons()

        return binding.root
    }

    private fun checkSeasons() {
        val position = arguments?.getInt("position")
        when (position) {
            0 -> {

            }
            1 -> {

            }
        }

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