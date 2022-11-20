package uz.hamroev.smartland.fragment.daromad

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import uz.hamroev.smartland.R
import uz.hamroev.smartland.adapter.DaromadAdapter
import uz.hamroev.smartland.databinding.FragmentDaromadHisoblashBinding
import uz.hamroev.smartland.db.ProductEntity
import uz.hamroev.smartland.db.daromad.DaromadEntity
import uz.hamroev.smartland.model.Selected
import uz.hamroev.smartland.model.daromad.DaromadHisobla
import uz.hamroev.smartland.utils.toast

class DaromadHisoblashFragment : Fragment() {

    lateinit var binding: FragmentDaromadHisoblashBinding
    private val TAG = "DaromadHisoblashFragmen"
    lateinit var listDaromadHisobla: ArrayList<DaromadHisobla>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDaromadHisoblashBinding.inflate(layoutInflater)

        binding.backIv.setOnClickListener {
            findNavController().popBackStack()
        }

        listDaromadHisobla = ArrayList()
        val listSelected = arguments?.getSerializable("select") as ArrayList<DaromadEntity>
        for (daromadEntity in listSelected) {
            Log.d(
                TAG,
                "onCreateView: ${daromadEntity.ekin_nomi} - ${daromadEntity.sof_foyda} - Foizi = ${daromadEntity.maydoni}\n"
            )
        }

        binding.saveButton.setOnClickListener {
            val sotix = binding.modelEditText.text.toString().trim()
            if (sotix.isEmpty()) {
                toast("Maydonni kiriting m2 ?")
            } else {
                checkProductSize(listSelected, sotix)
            }

        }









        return binding.root
    }

    private fun checkProductSize(listSelected: ArrayList<DaromadEntity>, sotix: String) {
        when (listSelected.size) {
            1 -> {
                listDaromadHisobla = ArrayList()
                listDaromadHisobla.clear()
                listDaromadHisobla.add(DaromadHisobla(listSelected[0].ekin_nomi.toString(),
                sotix.toInt(),
                    ((listSelected[0].daromad / 100)*sotix.toInt()),
                    ((listSelected[0].xarajat / 100)*sotix.toInt()),
                    ((listSelected[0].sof_foyda / 100)*sotix.toInt()),

                    ))
                val daromadAdapter = DaromadAdapter(requireContext(), listDaromadHisobla)
                binding.rvDaromad.adapter = daromadAdapter
            }
            2 -> {
                listDaromadHisobla = ArrayList()
                listDaromadHisobla.clear()
                val p1 = listSelected[0].maydoni //29
                val p2 = listSelected[1].maydoni //28

                val x: Float = sotix.toFloat() / (p1 + p2).toFloat()

                val maydon1 = p1 * x
                val daromad1 = (listSelected[0].daromad / 100) * maydon1
                val xarajat1 = (listSelected[0].xarajat / 100) * maydon1
                val foyda1 = (listSelected[0].sof_foyda / 100) * maydon1

                val maydon2 = p2 * x
                val daromad2 = (listSelected[1].daromad / 100) * maydon2
                val xarajat2 = (listSelected[1].xarajat / 100) * maydon2
                val foyda2 = (listSelected[1].sof_foyda / 100) * maydon2

                listDaromadHisobla.add(DaromadHisobla(listSelected[0].ekin_nomi,maydon1.toInt(), daromad1.toInt(), xarajat1.toInt(), foyda1.toInt()))
                listDaromadHisobla.add(DaromadHisobla(listSelected[1].ekin_nomi,maydon2.toInt(), daromad2.toInt(), xarajat2.toInt(), foyda2.toInt()))
                val daromadAdapter = DaromadAdapter(requireContext(), listDaromadHisobla)
                binding.rvDaromad.adapter = daromadAdapter

            }
            3 -> {
                listDaromadHisobla = ArrayList()
                listDaromadHisobla.clear()
                val p1 = listSelected[0].maydoni //29
                val p2 = listSelected[1].maydoni //28
                val p3 = listSelected[2].maydoni //28

                val x: Float = sotix.toFloat() / (p1 + p2+ p3).toFloat()

                val maydon1 = p1 * x
                val daromad1 = (listSelected[0].daromad / 100) * maydon1
                val xarajat1 = (listSelected[0].xarajat / 100) * maydon1
                val foyda1 = (listSelected[0].sof_foyda / 100) * maydon1

                val maydon2 = p2 * x
                val daromad2 = (listSelected[1].daromad / 100) * maydon2
                val xarajat2 = (listSelected[1].xarajat / 100) * maydon2
                val foyda2 = (listSelected[1].sof_foyda / 100) * maydon2

                val maydon3 = p3 * x
                val daromad3 = (listSelected[2].daromad / 100) * maydon3
                val xarajat3 = (listSelected[2].xarajat / 100) * maydon3
                val foyda3 = (listSelected[2].sof_foyda / 100) * maydon3

                listDaromadHisobla.add(DaromadHisobla(listSelected[0].ekin_nomi,maydon1.toInt(), daromad1.toInt(), xarajat1.toInt(), foyda1.toInt()))
                listDaromadHisobla.add(DaromadHisobla(listSelected[1].ekin_nomi,maydon2.toInt(), daromad2.toInt(), xarajat2.toInt(), foyda2.toInt()))
                listDaromadHisobla.add(DaromadHisobla(listSelected[2].ekin_nomi,maydon3.toInt(), daromad3.toInt(), xarajat3.toInt(), foyda3.toInt()))
                val daromadAdapter = DaromadAdapter(requireContext(), listDaromadHisobla)
                binding.rvDaromad.adapter = daromadAdapter
            }
            4 -> {
                listDaromadHisobla = ArrayList()
                listDaromadHisobla.clear()
                val p1 = listSelected[0].maydoni //29
                val p2 = listSelected[1].maydoni //28
                val p3 = listSelected[2].maydoni //28
                val p4 = listSelected[3].maydoni //28

                val x: Float = sotix.toFloat() / (p1 + p2+ p3 +p4).toFloat()

                val maydon1 = p1 * x
                val daromad1 = (listSelected[0].daromad / 100) * maydon1
                val xarajat1 = (listSelected[0].xarajat / 100) * maydon1
                val foyda1 = (listSelected[0].sof_foyda / 100) * maydon1

                val maydon2 = p2 * x
                val daromad2 = (listSelected[1].daromad / 100) * maydon2
                val xarajat2 = (listSelected[1].xarajat / 100) * maydon2
                val foyda2 = (listSelected[1].sof_foyda / 100) * maydon2

                val maydon3 = p3 * x
                val daromad3 = (listSelected[2].daromad / 100) * maydon3
                val xarajat3 = (listSelected[2].xarajat / 100) * maydon3
                val foyda3 = (listSelected[2].sof_foyda / 100) * maydon3

                val maydon4 = p4 * x
                val daromad4 = (listSelected[3].daromad / 100) * maydon4
                val xarajat4 = (listSelected[3].xarajat / 100) * maydon4
                val foyda4 = (listSelected[3].sof_foyda / 100) * maydon4

                listDaromadHisobla.add(DaromadHisobla(listSelected[0].ekin_nomi,maydon1.toInt(), daromad1.toInt(), xarajat1.toInt(), foyda1.toInt()))
                listDaromadHisobla.add(DaromadHisobla(listSelected[1].ekin_nomi,maydon2.toInt(), daromad2.toInt(), xarajat2.toInt(), foyda2.toInt()))
                listDaromadHisobla.add(DaromadHisobla(listSelected[2].ekin_nomi,maydon3.toInt(), daromad3.toInt(), xarajat3.toInt(), foyda3.toInt()))
                listDaromadHisobla.add(DaromadHisobla(listSelected[3].ekin_nomi,maydon4.toInt(), daromad4.toInt(), xarajat4.toInt(), foyda4.toInt()))
                val daromadAdapter = DaromadAdapter(requireContext(), listDaromadHisobla)
                binding.rvDaromad.adapter = daromadAdapter
            }
            5 -> {
                listDaromadHisobla = ArrayList()
                listDaromadHisobla.clear()
                val p1 = listSelected[0].maydoni //29
                val p2 = listSelected[1].maydoni //28
                val p3 = listSelected[2].maydoni //28
                val p4 = listSelected[3].maydoni //28
                val p5 = listSelected[4].maydoni //28

                val x: Float = sotix.toFloat() / (p1 + p2+ p3 +p4 + p5).toFloat()

                val maydon1 = p1 * x
                val daromad1 = (listSelected[0].daromad / 100) * maydon1
                val xarajat1 = (listSelected[0].xarajat / 100) * maydon1
                val foyda1 = (listSelected[0].sof_foyda / 100) * maydon1

                val maydon2 = p2 * x
                val daromad2 = (listSelected[1].daromad / 100) * maydon2
                val xarajat2 = (listSelected[1].xarajat / 100) * maydon2
                val foyda2 = (listSelected[1].sof_foyda / 100) * maydon2

                val maydon3 = p3 * x
                val daromad3 = (listSelected[2].daromad / 100) * maydon3
                val xarajat3 = (listSelected[2].xarajat / 100) * maydon3
                val foyda3 = (listSelected[2].sof_foyda / 100) * maydon3

                val maydon4 = p4 * x
                val daromad4 = (listSelected[3].daromad / 100) * maydon4
                val xarajat4 = (listSelected[3].xarajat / 100) * maydon4
                val foyda4 = (listSelected[3].sof_foyda / 100) * maydon4

                val maydon5 = p5 * x
                val daromad5 = (listSelected[4].daromad / 100) * maydon5
                val xarajat5 = (listSelected[4].xarajat / 100) * maydon5
                val foyda5 = (listSelected[4].sof_foyda / 100) * maydon5


                listDaromadHisobla.add(DaromadHisobla(listSelected[0].ekin_nomi,maydon1.toInt(), daromad1.toInt(), xarajat1.toInt(), foyda1.toInt()))
                listDaromadHisobla.add(DaromadHisobla(listSelected[1].ekin_nomi,maydon2.toInt(), daromad2.toInt(), xarajat2.toInt(), foyda2.toInt()))
                listDaromadHisobla.add(DaromadHisobla(listSelected[2].ekin_nomi,maydon3.toInt(), daromad3.toInt(), xarajat3.toInt(), foyda3.toInt()))
                listDaromadHisobla.add(DaromadHisobla(listSelected[3].ekin_nomi,maydon4.toInt(), daromad4.toInt(), xarajat4.toInt(), foyda4.toInt()))
                listDaromadHisobla.add(DaromadHisobla(listSelected[4].ekin_nomi,maydon5.toInt(), daromad5.toInt(), xarajat5.toInt(), foyda5.toInt()))
                val daromadAdapter = DaromadAdapter(requireContext(), listDaromadHisobla)
                binding.rvDaromad.adapter = daromadAdapter
            }
            6 -> {
                listDaromadHisobla = ArrayList()
                listDaromadHisobla.clear()
                val p1 = listSelected[0].maydoni //29
                val p2 = listSelected[1].maydoni //28
                val p3 = listSelected[2].maydoni //28
                val p4 = listSelected[3].maydoni //28
                val p5 = listSelected[4].maydoni //28
                val p6 = listSelected[5].maydoni //28

                val x: Float = sotix.toFloat() / (p1 + p2+ p3 +p4 + p5 + p6).toFloat()

                val maydon1 = p1 * x
                val daromad1 = (listSelected[0].daromad / 100) * maydon1
                val xarajat1 = (listSelected[0].xarajat / 100) * maydon1
                val foyda1 = (listSelected[0].sof_foyda / 100) * maydon1

                val maydon2 = p2 * x
                val daromad2 = (listSelected[1].daromad / 100) * maydon2
                val xarajat2 = (listSelected[1].xarajat / 100) * maydon2
                val foyda2 = (listSelected[1].sof_foyda / 100) * maydon2

                val maydon3 = p3 * x
                val daromad3 = (listSelected[2].daromad / 100) * maydon3
                val xarajat3 = (listSelected[2].xarajat / 100) * maydon3
                val foyda3 = (listSelected[2].sof_foyda / 100) * maydon3

                val maydon4 = p4 * x
                val daromad4 = (listSelected[3].daromad / 100) * maydon4
                val xarajat4 = (listSelected[3].xarajat / 100) * maydon4
                val foyda4 = (listSelected[3].sof_foyda / 100) * maydon4

                val maydon5 = p5 * x
                val daromad5 = (listSelected[4].daromad / 100) * maydon5
                val xarajat5 = (listSelected[4].xarajat / 100) * maydon5
                val foyda5 = (listSelected[4].sof_foyda / 100) * maydon5


                val maydon6 = p6 * x
                val daromad6 = (listSelected[5].daromad / 100) * maydon6
                val xarajat6 = (listSelected[5].xarajat / 100) * maydon6
                val foyda6 = (listSelected[5].sof_foyda / 100) * maydon6


                listDaromadHisobla.add(DaromadHisobla(listSelected[0].ekin_nomi,maydon1.toInt(), daromad1.toInt(), xarajat1.toInt(), foyda1.toInt()))
                listDaromadHisobla.add(DaromadHisobla(listSelected[1].ekin_nomi,maydon2.toInt(), daromad2.toInt(), xarajat2.toInt(), foyda2.toInt()))
                listDaromadHisobla.add(DaromadHisobla(listSelected[2].ekin_nomi,maydon3.toInt(), daromad3.toInt(), xarajat3.toInt(), foyda3.toInt()))
                listDaromadHisobla.add(DaromadHisobla(listSelected[3].ekin_nomi,maydon4.toInt(), daromad4.toInt(), xarajat4.toInt(), foyda4.toInt()))
                listDaromadHisobla.add(DaromadHisobla(listSelected[4].ekin_nomi,maydon5.toInt(), daromad5.toInt(), xarajat5.toInt(), foyda5.toInt()))
                listDaromadHisobla.add(DaromadHisobla(listSelected[5].ekin_nomi,maydon6.toInt(), daromad6.toInt(), xarajat6.toInt(), foyda6.toInt()))
                val daromadAdapter = DaromadAdapter(requireContext(), listDaromadHisobla)
                binding.rvDaromad.adapter = daromadAdapter
            }
            7 -> {
                listDaromadHisobla = ArrayList()
                listDaromadHisobla.clear()
                val p1 = listSelected[0].maydoni //29
                val p2 = listSelected[1].maydoni //28
                val p3 = listSelected[2].maydoni //28
                val p4 = listSelected[3].maydoni //28
                val p5 = listSelected[4].maydoni //28
                val p6 = listSelected[5].maydoni //28
                val p7 = listSelected[6].maydoni //28

                val x: Float = sotix.toFloat() / (p1 + p2+ p3 +p4 + p5 + p6+p7).toFloat()

                val maydon1 = p1 * x
                val daromad1 = (listSelected[0].daromad / 100) * maydon1
                val xarajat1 = (listSelected[0].xarajat / 100) * maydon1
                val foyda1 = (listSelected[0].sof_foyda / 100) * maydon1

                val maydon2 = p2 * x
                val daromad2 = (listSelected[1].daromad / 100) * maydon2
                val xarajat2 = (listSelected[1].xarajat / 100) * maydon2
                val foyda2 = (listSelected[1].sof_foyda / 100) * maydon2

                val maydon3 = p3 * x
                val daromad3 = (listSelected[2].daromad / 100) * maydon3
                val xarajat3 = (listSelected[2].xarajat / 100) * maydon3
                val foyda3 = (listSelected[2].sof_foyda / 100) * maydon3

                val maydon4 = p4 * x
                val daromad4 = (listSelected[3].daromad / 100) * maydon4
                val xarajat4 = (listSelected[3].xarajat / 100) * maydon4
                val foyda4 = (listSelected[3].sof_foyda / 100) * maydon4

                val maydon5 = p5 * x
                val daromad5 = (listSelected[4].daromad / 100) * maydon5
                val xarajat5 = (listSelected[4].xarajat / 100) * maydon5
                val foyda5 = (listSelected[4].sof_foyda / 100) * maydon5


                val maydon6 = p6 * x
                val daromad6 = (listSelected[5].daromad / 100) * maydon6
                val xarajat6 = (listSelected[5].xarajat / 100) * maydon6
                val foyda6 = (listSelected[5].sof_foyda / 100) * maydon6

                val maydon7 = p7 * x
                val daromad7 = (listSelected[6].daromad / 100) * maydon7
                val xarajat7 = (listSelected[6].xarajat / 100) * maydon7
                val foyda7 = (listSelected[6].sof_foyda / 100) * maydon7


                listDaromadHisobla.add(DaromadHisobla(listSelected[0].ekin_nomi,maydon1.toInt(), daromad1.toInt(), xarajat1.toInt(), foyda1.toInt()))
                listDaromadHisobla.add(DaromadHisobla(listSelected[1].ekin_nomi,maydon2.toInt(), daromad2.toInt(), xarajat2.toInt(), foyda2.toInt()))
                listDaromadHisobla.add(DaromadHisobla(listSelected[2].ekin_nomi,maydon3.toInt(), daromad3.toInt(), xarajat3.toInt(), foyda3.toInt()))
                listDaromadHisobla.add(DaromadHisobla(listSelected[3].ekin_nomi,maydon4.toInt(), daromad4.toInt(), xarajat4.toInt(), foyda4.toInt()))
                listDaromadHisobla.add(DaromadHisobla(listSelected[4].ekin_nomi,maydon5.toInt(), daromad5.toInt(), xarajat5.toInt(), foyda5.toInt()))
                listDaromadHisobla.add(DaromadHisobla(listSelected[5].ekin_nomi,maydon6.toInt(), daromad6.toInt(), xarajat6.toInt(), foyda6.toInt()))
                listDaromadHisobla.add(DaromadHisobla(listSelected[6].ekin_nomi,maydon7.toInt(), daromad7.toInt(), xarajat7.toInt(), foyda7.toInt()))
                val daromadAdapter = DaromadAdapter(requireContext(), listDaromadHisobla)
                binding.rvDaromad.adapter = daromadAdapter
            }
            8 -> {
                listDaromadHisobla = ArrayList()
                listDaromadHisobla.clear()
                val p1 = listSelected[0].maydoni //29
                val p2 = listSelected[1].maydoni //28
                val p3 = listSelected[2].maydoni //28
                val p4 = listSelected[3].maydoni //28
                val p5 = listSelected[4].maydoni //28
                val p6 = listSelected[5].maydoni //28
                val p7 = listSelected[6].maydoni //28
                val p8 = listSelected[7].maydoni //28

                val x: Float = sotix.toFloat() / (p1 + p2+ p3 +p4 + p5 + p6+p7 + p8).toFloat()

                val maydon1 = p1 * x
                val daromad1 = (listSelected[0].daromad / 100) * maydon1
                val xarajat1 = (listSelected[0].xarajat / 100) * maydon1
                val foyda1 = (listSelected[0].sof_foyda / 100) * maydon1

                val maydon2 = p2 * x
                val daromad2 = (listSelected[1].daromad / 100) * maydon2
                val xarajat2 = (listSelected[1].xarajat / 100) * maydon2
                val foyda2 = (listSelected[1].sof_foyda / 100) * maydon2

                val maydon3 = p3 * x
                val daromad3 = (listSelected[2].daromad / 100) * maydon3
                val xarajat3 = (listSelected[2].xarajat / 100) * maydon3
                val foyda3 = (listSelected[2].sof_foyda / 100) * maydon3

                val maydon4 = p4 * x
                val daromad4 = (listSelected[3].daromad / 100) * maydon4
                val xarajat4 = (listSelected[3].xarajat / 100) * maydon4
                val foyda4 = (listSelected[3].sof_foyda / 100) * maydon4

                val maydon5 = p5 * x
                val daromad5 = (listSelected[4].daromad / 100) * maydon5
                val xarajat5 = (listSelected[4].xarajat / 100) * maydon5
                val foyda5 = (listSelected[4].sof_foyda / 100) * maydon5


                val maydon6 = p6 * x
                val daromad6 = (listSelected[5].daromad / 100) * maydon6
                val xarajat6 = (listSelected[5].xarajat / 100) * maydon6
                val foyda6 = (listSelected[5].sof_foyda / 100) * maydon6

                val maydon7 = p7 * x
                val daromad7 = (listSelected[6].daromad / 100) * maydon7
                val xarajat7 = (listSelected[6].xarajat / 100) * maydon7
                val foyda7 = (listSelected[6].sof_foyda / 100) * maydon7

                val maydon8 = p8 * x
                val daromad8 = (listSelected[7].daromad / 100) * maydon8
                val xarajat8 = (listSelected[7].xarajat / 100) * maydon8
                val foyda8 = (listSelected[7].sof_foyda / 100) * maydon8


                listDaromadHisobla.add(DaromadHisobla(listSelected[0].ekin_nomi,maydon1.toInt(), daromad1.toInt(), xarajat1.toInt(), foyda1.toInt()))
                listDaromadHisobla.add(DaromadHisobla(listSelected[1].ekin_nomi,maydon2.toInt(), daromad2.toInt(), xarajat2.toInt(), foyda2.toInt()))
                listDaromadHisobla.add(DaromadHisobla(listSelected[2].ekin_nomi,maydon3.toInt(), daromad3.toInt(), xarajat3.toInt(), foyda3.toInt()))
                listDaromadHisobla.add(DaromadHisobla(listSelected[3].ekin_nomi,maydon4.toInt(), daromad4.toInt(), xarajat4.toInt(), foyda4.toInt()))
                listDaromadHisobla.add(DaromadHisobla(listSelected[4].ekin_nomi,maydon5.toInt(), daromad5.toInt(), xarajat5.toInt(), foyda5.toInt()))
                listDaromadHisobla.add(DaromadHisobla(listSelected[5].ekin_nomi,maydon6.toInt(), daromad6.toInt(), xarajat6.toInt(), foyda6.toInt()))
                listDaromadHisobla.add(DaromadHisobla(listSelected[6].ekin_nomi,maydon7.toInt(), daromad7.toInt(), xarajat7.toInt(), foyda7.toInt()))
                listDaromadHisobla.add(DaromadHisobla(listSelected[7].ekin_nomi,maydon8.toInt(), daromad8.toInt(), xarajat8.toInt(), foyda8.toInt()))
                val daromadAdapter = DaromadAdapter(requireContext(), listDaromadHisobla)
                binding.rvDaromad.adapter = daromadAdapter
            }
        }
    }


}