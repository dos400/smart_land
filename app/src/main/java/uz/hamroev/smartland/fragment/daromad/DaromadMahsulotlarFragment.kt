package uz.hamroev.smartland.fragment.daromad

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import uz.hamroev.smartland.R
import uz.hamroev.smartland.adapter.CheckBoxDaromadAdapter
import uz.hamroev.smartland.databinding.FragmentDaromadMahsulotlarBinding
import uz.hamroev.smartland.db.daromad.DaromadDatabase
import uz.hamroev.smartland.db.daromad.DaromadEntity
import uz.hamroev.smartland.utils.toast

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [DaromadMahsulotlarFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DaromadMahsulotlarFragment : Fragment() {
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

    lateinit var binding: FragmentDaromadMahsulotlarBinding
    lateinit var listProduct: ArrayList<DaromadEntity>
    lateinit var listSelected: ArrayList<DaromadEntity>
    lateinit var checkBoxDaromadAdapter: CheckBoxDaromadAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDaromadMahsulotlarBinding.inflate(layoutInflater)

        binding.backIv.setOnClickListener {
            findNavController().popBackStack()
        }
        listProduct = ArrayList()
        listSelected = ArrayList()
        checkSeasons()
        checkBoxDaromadAdapter = CheckBoxDaromadAdapter(
            requireContext(),
            listProduct,
            object : CheckBoxDaromadAdapter.OnCheckChangeListener {
                override fun onCheck(daromadEntity: DaromadEntity, position: Int) {
                    listSelected.add(daromadEntity)
                }

                override fun onCheckDelete(daromadEntity: DaromadEntity, position: Int) {
                    listSelected.remove(daromadEntity)
                }
            })
        binding.rvSeason.adapter = checkBoxDaromadAdapter

        binding.calculateBtn.setOnClickListener {
            if (listSelected.isNotEmpty()) {
                val bundle = Bundle()
                bundle.putSerializable("select", listSelected)
                findNavController().navigate(R.id.daromadHisoblashFragment, bundle)
            } else {
                toast(getString(R.string.mahsulot_tanlang))
            }
        }





        return binding.root
    }

    private fun checkSeasons() {
        val position = arguments?.getInt("position")
        when (position) {
            0 -> {
                binding.titleSeason.text = activity?.resources?.getString(R.string.spring)
                listProduct = ArrayList()
                listProduct.clear()
                val list =
                    DaromadDatabase.GET.getDaromadDatabase().daromadDao().getSeasonsProduct("bahor")
                for (daromadEntity in list) {
                    when (daromadEntity.ekin_nomi) {
                        "kartoshka" -> {
                            listProduct.add(
                                DaromadEntity(
                                    activity?.resources!!.getString(R.string.potatoes),
                                    daromadEntity.xarajat,
                                    daromadEntity.daromad,
                                    daromadEntity.sof_foyda,
                                    daromadEntity.maydoni,
                                    daromadEntity.fasl
                                )
                            )
                        }
                        "sabzi" -> {
                            listProduct.add(
                                DaromadEntity(
                                    activity?.resources!!.getString(R.string.carrot),
                                    daromadEntity.xarajat,
                                    daromadEntity.daromad,
                                    daromadEntity.sof_foyda,
                                    daromadEntity.maydoni,
                                    daromadEntity.fasl
                                )
                            )
                        }
                        "pomidor" -> {
                            listProduct.add(
                                DaromadEntity(
                                    activity?.resources!!.getString(R.string.tomato),
                                    daromadEntity.xarajat,
                                    daromadEntity.daromad,
                                    daromadEntity.sof_foyda,
                                    daromadEntity.maydoni,
                                    daromadEntity.fasl
                                )
                            )
                        }
                        "piyoz" -> {
                            listProduct.add(
                                DaromadEntity(
                                    activity?.resources!!.getString(R.string.onion),
                                    daromadEntity.xarajat,
                                    daromadEntity.daromad,
                                    daromadEntity.sof_foyda,
                                    daromadEntity.maydoni,
                                    daromadEntity.fasl
                                )
                            )
                        }
                        "bodring" -> {
                            listProduct.add(
                                DaromadEntity(
                                    activity?.resources!!.getString(R.string.cucumber),
                                    daromadEntity.xarajat,
                                    daromadEntity.daromad,
                                    daromadEntity.sof_foyda,
                                    daromadEntity.maydoni,
                                    daromadEntity.fasl
                                )
                            )
                        }
                        "baqlajon" -> {
                            listProduct.add(
                                DaromadEntity(
                                    activity?.resources!!.getString(R.string.eggplant),
                                    daromadEntity.xarajat,
                                    daromadEntity.daromad,
                                    daromadEntity.sof_foyda,
                                    daromadEntity.maydoni,
                                    daromadEntity.fasl
                                )
                            )
                        }
                        "qalampir" -> {
                            listProduct.add(
                                DaromadEntity(
                                    activity?.resources!!.getString(R.string.Pepper),
                                    daromadEntity.xarajat,
                                    daromadEntity.daromad,
                                    daromadEntity.sof_foyda,
                                    daromadEntity.maydoni,
                                    daromadEntity.fasl
                                )
                            )
                        }
                        "loviya" -> {
                            listProduct.add(
                                DaromadEntity(
                                    activity?.resources!!.getString(R.string.bean),
                                    daromadEntity.xarajat,
                                    daromadEntity.daromad,
                                    daromadEntity.sof_foyda,
                                    daromadEntity.maydoni,
                                    daromadEntity.fasl
                                )
                            )
                        }
                    }
                }
            }
            1 -> {
                binding.titleSeason.text = activity?.resources?.getString(R.string.autumn)
                listProduct = ArrayList()
                listProduct.clear()
                val list =
                    DaromadDatabase.GET.getDaromadDatabase().daromadDao().getSeasonsProduct("kuz")
                for (daromadEntity in list) {
                    when (daromadEntity.ekin_nomi) {
                        "piyoz" -> {
                            listProduct.add(
                                DaromadEntity(
                                    activity?.resources!!.getString(R.string.onion_autumn),
                                    daromadEntity.xarajat,
                                    daromadEntity.daromad,
                                    daromadEntity.sof_foyda,
                                    daromadEntity.maydoni,
                                    daromadEntity.fasl
                                )
                            )
                        }
                        "sarimsoq" -> {
                            listProduct.add(
                                DaromadEntity(
                                    activity?.resources!!.getString(R.string.garlic),
                                    daromadEntity.xarajat,
                                    daromadEntity.daromad,
                                    daromadEntity.sof_foyda,
                                    daromadEntity.maydoni,
                                    daromadEntity.fasl
                                )
                            )
                        }
                        "sholgom" -> {
                            listProduct.add(
                                DaromadEntity(
                                    activity?.resources!!.getString(R.string.turnip),
                                    daromadEntity.xarajat,
                                    daromadEntity.daromad,
                                    daromadEntity.sof_foyda,
                                    daromadEntity.maydoni,
                                    daromadEntity.fasl
                                )
                            )
                        }
                        "turp" -> {
                            listProduct.add(
                                DaromadEntity(
                                    activity?.resources!!.getString(R.string.radish),
                                    daromadEntity.xarajat,
                                    daromadEntity.daromad,
                                    daromadEntity.sof_foyda,
                                    daromadEntity.maydoni,
                                    daromadEntity.fasl
                                )
                            )
                        }
                        "ismaloq" -> {
                            listProduct.add(
                                DaromadEntity(
                                    activity?.resources!!.getString(R.string.spinach),
                                    daromadEntity.xarajat,
                                    daromadEntity.daromad,
                                    daromadEntity.sof_foyda,
                                    daromadEntity.maydoni,
                                    daromadEntity.fasl
                                )
                            )
                        }
                        "kashnich" -> {
                            listProduct.add(
                                DaromadEntity(
                                    activity?.resources!!.getString(R.string.cilantro),
                                    daromadEntity.xarajat,
                                    daromadEntity.daromad,
                                    daromadEntity.sof_foyda,
                                    daromadEntity.maydoni,
                                    daromadEntity.fasl
                                )
                            )
                        }
                        "ukrop" -> {
                            listProduct.add(
                                DaromadEntity(
                                    activity?.resources!!.getString(R.string.dill),
                                    daromadEntity.xarajat,
                                    daromadEntity.daromad,
                                    daromadEntity.sof_foyda,
                                    daromadEntity.maydoni,
                                    daromadEntity.fasl
                                )
                            )
                        }
                    }
                }
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
         * @return A new instance of fragment DaromadMahsulotlarFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            DaromadMahsulotlarFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}