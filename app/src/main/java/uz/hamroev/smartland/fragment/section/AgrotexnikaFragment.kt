package uz.hamroev.smartland.fragment.section

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import uz.hamroev.smartland.R
import uz.hamroev.smartland.adapter.SectionAdapter
import uz.hamroev.smartland.databinding.FragmentAgrotexnikaBinding
import uz.hamroev.smartland.model.Section


class AgrotexnikaFragment : Fragment() {


    lateinit var binding: FragmentAgrotexnikaBinding
    lateinit var list: ArrayList<Section>
    lateinit var sectionAdapter: SectionAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAgrotexnikaBinding.inflate(layoutInflater, container, false)

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
                    bundle.putInt("season", position)
                    findNavController().navigate(R.id.agroTechnicalProductsFragment, bundle)
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


}