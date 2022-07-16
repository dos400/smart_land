package uz.hamroev.smartland.fragment.section

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import uz.hamroev.smartland.R
import uz.hamroev.smartland.adapter.SectionAdapter
import uz.hamroev.smartland.databinding.FragmentAvtomatikBinding
import uz.hamroev.smartland.fragment.section.avtomatic.AvtomaticSolveFragment
import uz.hamroev.smartland.model.Section

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [AvtomatikFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AvtomatikFragment : Fragment() {
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

    lateinit var binding: FragmentAvtomatikBinding
    lateinit var list: ArrayList<Section>
    lateinit var sectionAdapter: SectionAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAvtomatikBinding.inflate(layoutInflater, container, false)


        binding.backIv.setOnClickListener {
            findNavController().popBackStack()
        }

        loadSections()
        sectionAdapter = SectionAdapter(
            binding.root.context,
            list,
            object : SectionAdapter.OnSectionClickListener {
                override fun onClick(section: Section, position: Int) {
                    val bundle = Bundle()
                    bundle.putInt("position", position)
                    findNavController().navigate(R.id.avtomaticSolveFragment, bundle)
                }
            })
        binding.rvSeason.adapter = sectionAdapter

        return binding.root
    }

    private fun loadSections() {
        list = ArrayList()
        list.add(Section(resources.getString(R.string.spring), R.drawable.ic_spring))
        list.add(Section(resources.getString(R.string.autumn), R.drawable.ic_autumn))
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment AvtomatikFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            AvtomatikFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}