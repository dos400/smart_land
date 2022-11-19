package uz.hamroev.smartland.fragment.section.avtomatic

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.navigation.fragment.findNavController
import uz.hamroev.smartland.R
import uz.hamroev.smartland.activity.HomeActivity
import uz.hamroev.smartland.adapter.SelectedAdapter
import uz.hamroev.smartland.databinding.FragmentAvtomaticCalculateBinding
import uz.hamroev.smartland.db.ProductEntity
import uz.hamroev.smartland.db.savedResultat.SavedResutatDatabase
import uz.hamroev.smartland.db.savedResultat.SavedResutatEntity
import uz.hamroev.smartland.firebase.model.Product
import uz.hamroev.smartland.model.Selected
import uz.hamroev.smartland.utils.getCurrentDateAndTime
import uz.hamroev.smartland.utils.roundTo
import uz.hamroev.smartland.utils.toast
import java.math.RoundingMode
import java.text.DecimalFormat
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class AvtomaticCalculateFragment : Fragment() {

    lateinit var binding: FragmentAvtomaticCalculateBinding
    private val TAG = "AvtomaticCalculateFragm"
    lateinit var listCalculate: ArrayList<Selected>
    lateinit var selectedAdapter: SelectedAdapter
    var isCalculate: Boolean = false
    lateinit var savedResutatDatabase: SavedResutatDatabase

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAvtomaticCalculateBinding.inflate(layoutInflater, container, false)

        savedResutatDatabase = SavedResutatDatabase.getInstance(requireContext())

        binding.backIv.setOnClickListener {
            findNavController().popBackStack()
        }

        listCalculate = ArrayList()

        val listSelected = arguments?.getSerializable("select") as ArrayList<ProductEntity>
        for (product in listSelected) {
            Log.d(TAG, "onCreateView: ${product.product_name} - ${product.product_percentage}\n")
        }

        binding.calculateButton.setOnClickListener {
            val sotix2 = binding.modelEditText.text.toString().trim()
            if (sotix2.isEmpty()) {
                toast("Maydonni kiriting m2 ?")
            } else {
                isCalculate = true
                val sotix = binding.modelEditText.text.toString().trim().toFloat()
                listCalculate = ArrayList()
                listCalculate.clear()
                checkProductSize(listSelected, sotix)
            }

        }

        binding.saveButton.setOnClickListener {
            val sotix = binding.modelEditText.text.toString().trim()
            if (sotix.isEmpty()) {
                toast("Maydonni kiriting m2 ?")
            } else if (isCalculate) {
                var savedResutatEntity = SavedResutatEntity()
                var allProductData: String = ""
                when (listCalculate.size) {
                    1 -> {
                        allProductData =
                            "${listCalculate[0].productName} - ${listCalculate[0].productAcres} m2\n"
                    }
                    2 -> {
                        allProductData =
                            "${listCalculate[0].productName} - ${listCalculate[0].productAcres} m2\n" +
                                    "${listCalculate[1].productName} - ${listCalculate[1].productAcres} m2\n"
                    }
                    3 -> {
                        allProductData =
                            "${listCalculate[0].productName} - ${listCalculate[0].productAcres} m2\n" +
                                    "${listCalculate[1].productName} - ${listCalculate[1].productAcres} m2\n"
                        "${listCalculate[2].productName} - ${listCalculate[2].productAcres} m2\n"
                    }
                    4 -> {
                        allProductData =
                            "${listCalculate[0].productName} - ${listCalculate[0].productAcres} m2\n" +
                                    "${listCalculate[1].productName} - ${listCalculate[1].productAcres} m2\n"
                        "${listCalculate[2].productName} - ${listCalculate[2].productAcres} m2\n"
                        "${listCalculate[3].productName} - ${listCalculate[3].productAcres} m2\n"
                    }
                    5 -> {
                        allProductData =
                            "${listCalculate[0].productName} - ${listCalculate[0].productAcres} m2\n" +
                                    "${listCalculate[1].productName} - ${listCalculate[1].productAcres} m2\n"
                        "${listCalculate[2].productName} - ${listCalculate[2].productAcres} m2\n"
                        "${listCalculate[3].productName} - ${listCalculate[3].productAcres} m2\n"
                        "${listCalculate[4].productName} - ${listCalculate[4].productAcres} m2\n"
                    }
                    6 -> {
                        allProductData =
                            "${listCalculate[0].productName} - ${listCalculate[0].productAcres} m2\n" +
                                    "${listCalculate[1].productName} - ${listCalculate[1].productAcres} m2\n"
                        "${listCalculate[2].productName} - ${listCalculate[2].productAcres} m2\n"
                        "${listCalculate[3].productName} - ${listCalculate[3].productAcres} m2\n"
                        "${listCalculate[4].productName} - ${listCalculate[4].productAcres} m2\n"
                        "${listCalculate[5].productName} - ${listCalculate[5].productAcres} m2\n"
                    }
                    7 -> {
                        allProductData =
                            "${listCalculate[0].productName} - ${listCalculate[0].productAcres} m2\n" +
                                    "${listCalculate[1].productName} - ${listCalculate[1].productAcres} m2\n"
                        "${listCalculate[2].productName} - ${listCalculate[2].productAcres} m2\n"
                        "${listCalculate[3].productName} - ${listCalculate[3].productAcres} m2\n"
                        "${listCalculate[4].productName} - ${listCalculate[4].productAcres} m2\n"
                        "${listCalculate[5].productName} - ${listCalculate[5].productAcres} m2\n"
                        "${listCalculate[6].productName} - ${listCalculate[6].productAcres} m2\n"
                    }
                    8 -> {
                        allProductData =
                            "${listCalculate[0].productName} - ${listCalculate[0].productAcres} m2\n" +
                                    "${listCalculate[1].productName} - ${listCalculate[1].productAcres} m2\n"
                        "${listCalculate[2].productName} - ${listCalculate[2].productAcres} m2\n"
                        "${listCalculate[3].productName} - ${listCalculate[3].productAcres} m2\n"
                        "${listCalculate[4].productName} - ${listCalculate[4].productAcres} m2\n"
                        "${listCalculate[5].productName} - ${listCalculate[5].productAcres} m2\n"
                        "${listCalculate[6].productName} - ${listCalculate[6].productAcres} m2\n"
                        "${listCalculate[7].productName} - ${listCalculate[7].productAcres} m2\n"
                    }
                }

                savedResutatEntity = SavedResutatEntity(
                    sotix,
                    allProductData,
                    listSelected[0].seasons.toString(),
                    getCurrentDateAndTime()
                )
                SavedResutatDatabase.getInstance(requireContext()).savedResutatDao()
                    .addSavedProduct(savedResutatEntity)
                toast("Saqlandi!")
                activity?.finish()
                startActivity(Intent(requireContext(), HomeActivity::class.java))
            } else {
                toast("Hisoblashni bosing !🙂")
            }

        }


        return binding.root
    }

    private fun checkProductSize(listSelected: ArrayList<ProductEntity>, sotix: Float) {
        when (listSelected.size) {
            1 -> {
                Log.d(TAG, "checkProductSize: 1 ga kirdi")
                var p1: Float = listSelected[0].product_percentage!!.toFloat()
                listCalculate.clear()
                listCalculate.add(
                    Selected(
                        listSelected[0].product_name,
                        (sotix).toInt().toString()
                    )
                )
                selectedAdapter = SelectedAdapter(binding.root.context, listCalculate)
                binding.rvSelectedProduct.adapter = selectedAdapter
            }
            2 -> {
                Log.d(TAG, "checkProductSize: 2 ga kirdi")
                var p1: Float = listSelected[0].product_percentage!!.toFloat()
                var p2: Float = listSelected[1].product_percentage!!.toFloat()
                var x: Float = sotix / (p1 + p2)
                listCalculate.clear()
                listCalculate.add(
                    Selected(
                        listSelected[0].product_name,
                        (p1 * x).toInt().toString()
                    )
                )
                listCalculate.add(
                    Selected(
                        listSelected[1].product_name,
                        (p2 * x).toInt().toString()
                    )
                )
                selectedAdapter = SelectedAdapter(binding.root.context, listCalculate)
                binding.rvSelectedProduct.adapter = selectedAdapter


            }
            3 -> {
                Log.d(TAG, "checkProductSize: 3 ga kirdi")
                var p1: Float = listSelected[0].product_percentage!!.toFloat()
                var p2: Float = listSelected[1].product_percentage!!.toFloat()
                var p3: Float = listSelected[2].product_percentage!!.toFloat()
                var x: Float = sotix / (p1 + p2 + p3)
                listCalculate.clear()
                listCalculate.add(
                    Selected(
                        listSelected[0].product_name,
                        (p1 * x).toInt().toString()
                    )
                )
                listCalculate.add(
                    Selected(
                        listSelected[1].product_name,
                        (p2 * x).toInt().toString()
                    )
                )
                listCalculate.add(
                    Selected(
                        listSelected[2].product_name,
                        (p3 * x).toInt().toString()
                    )
                )
                selectedAdapter = SelectedAdapter(binding.root.context, listCalculate)
                binding.rvSelectedProduct.adapter = selectedAdapter
            }
            4 -> {
                Log.d(TAG, "checkProductSize: 4 ga kirdi")
                var p1: Float = listSelected[0].product_percentage!!.toFloat()
                var p2: Float = listSelected[1].product_percentage!!.toFloat()
                var p3: Float = listSelected[2].product_percentage!!.toFloat()
                var p4: Float = listSelected[3].product_percentage!!.toFloat()
                var x: Float = sotix / (p1 + p2 + p3 + p4)
                listCalculate.clear()
                listCalculate.add(
                    Selected(
                        listSelected[0].product_name,
                        (p1 * x).toInt().toString()
                    )
                )
                listCalculate.add(
                    Selected(
                        listSelected[1].product_name,
                        (p2 * x).toInt().toString()
                    )
                )
                listCalculate.add(
                    Selected(
                        listSelected[2].product_name,
                        (p3 * x).toInt().toString()
                    )
                )
                listCalculate.add(
                    Selected(
                        listSelected[3].product_name,
                        (p4 * x).toInt().toString()
                    )
                )
                selectedAdapter = SelectedAdapter(binding.root.context, listCalculate)
                binding.rvSelectedProduct.adapter = selectedAdapter
            }
            5 -> {
                Log.d(TAG, "checkProductSize: 5 ga kirdi")
                var p1: Float = listSelected[0].product_percentage!!.toFloat()
                var p2: Float = listSelected[1].product_percentage!!.toFloat()
                var p3: Float = listSelected[2].product_percentage!!.toFloat()
                var p4: Float = listSelected[3].product_percentage!!.toFloat()
                var p5: Float = listSelected[4].product_percentage!!.toFloat()
                var x: Float = sotix / (p1 + p2 + p3 + p4 + p5)
                listCalculate.clear()
                listCalculate.add(
                    Selected(
                        listSelected[0].product_name,
                        (p1 * x).toInt().toString()
                    )
                )
                listCalculate.add(
                    Selected(
                        listSelected[1].product_name,
                        (p2 * x).toInt().toString()
                    )
                )
                listCalculate.add(
                    Selected(
                        listSelected[2].product_name,
                        (p3 * x).toInt().toString()
                    )
                )
                listCalculate.add(
                    Selected(
                        listSelected[3].product_name,
                        (p4 * x).toInt().toString()
                    )
                )
                listCalculate.add(
                    Selected(
                        listSelected[4].product_name,
                        (p5 * x).toInt().toString()
                    )
                )
                selectedAdapter = SelectedAdapter(binding.root.context, listCalculate)
                binding.rvSelectedProduct.adapter = selectedAdapter
            }
            6 -> {
                Log.d(TAG, "checkProductSize: 6 ga kirdi")
                var p1: Float = listSelected[0].product_percentage!!.toFloat()
                var p2: Float = listSelected[1].product_percentage!!.toFloat()
                var p3: Float = listSelected[2].product_percentage!!.toFloat()
                var p4: Float = listSelected[3].product_percentage!!.toFloat()
                var p5: Float = listSelected[4].product_percentage!!.toFloat()
                var p6: Float = listSelected[5].product_percentage!!.toFloat()
                var x: Float = sotix / (p1 + p2 + p3 + p4 + p5 + p6)
                listCalculate.clear()
                listCalculate.add(
                    Selected(
                        listSelected[0].product_name,
                        (p1 * x).toInt().toString()
                    )
                )
                listCalculate.add(
                    Selected(
                        listSelected[1].product_name,
                        (p2 * x).toInt().toString()
                    )
                )
                listCalculate.add(
                    Selected(
                        listSelected[2].product_name,
                        (p3 * x).toInt().toString()
                    )
                )
                listCalculate.add(
                    Selected(
                        listSelected[3].product_name,
                        (p4 * x).toInt().toString()
                    )
                )
                listCalculate.add(
                    Selected(
                        listSelected[4].product_name,
                        (p5 * x).toInt().toString()
                    )
                )
                listCalculate.add(
                    Selected(
                        listSelected[5].product_name,
                        (p6 * x).toInt().toString()
                    )
                )
                selectedAdapter = SelectedAdapter(binding.root.context, listCalculate)
                binding.rvSelectedProduct.adapter = selectedAdapter
            }
            7 -> {
                Log.d(TAG, "checkProductSize: 7 ga kirdi")
                var p1: Float = listSelected[0].product_percentage!!.toFloat()
                var p2: Float = listSelected[1].product_percentage!!.toFloat()
                var p3: Float = listSelected[2].product_percentage!!.toFloat()
                var p4: Float = listSelected[3].product_percentage!!.toFloat()
                var p5: Float = listSelected[4].product_percentage!!.toFloat()
                var p6: Float = listSelected[5].product_percentage!!.toFloat()
                var p7: Float = listSelected[6].product_percentage!!.toFloat()
                var x: Float = sotix / (p1 + p2 + p3 + p4 + p5 + p6 + p7)
                listCalculate.clear()
                listCalculate.add(
                    Selected(
                        listSelected[0].product_name,
                        (p1 * x).toInt().toString()
                    )
                )
                listCalculate.add(
                    Selected(
                        listSelected[1].product_name,
                        (p2 * x).toInt().toString()
                    )
                )
                listCalculate.add(
                    Selected(
                        listSelected[2].product_name,
                        (p3 * x).toInt().toString()
                    )
                )
                listCalculate.add(
                    Selected(
                        listSelected[3].product_name,
                        (p4 * x).toInt().toString()
                    )
                )
                listCalculate.add(
                    Selected(
                        listSelected[4].product_name,
                        (p5 * x).toInt().toString()
                    )
                )
                listCalculate.add(
                    Selected(
                        listSelected[5].product_name,
                        (p6 * x).toInt().toString()
                    )
                )
                listCalculate.add(
                    Selected(
                        listSelected[6].product_name,
                        (p7 * x).toInt().toString()
                    )
                )
                selectedAdapter = SelectedAdapter(binding.root.context, listCalculate)
                binding.rvSelectedProduct.adapter = selectedAdapter
            }
            8 -> {
                Log.d(TAG, "checkProductSize: 8 ga kirdi")
                var p1: Float = listSelected[0].product_percentage!!.toFloat()
                var p2: Float = listSelected[1].product_percentage!!.toFloat()
                var p3: Float = listSelected[2].product_percentage!!.toFloat()
                var p4: Float = listSelected[3].product_percentage!!.toFloat()
                var p5: Float = listSelected[4].product_percentage!!.toFloat()
                var p6: Float = listSelected[5].product_percentage!!.toFloat()
                var p7: Float = listSelected[6].product_percentage!!.toFloat()
                var p8: Float = listSelected[7].product_percentage!!.toFloat()
                var x: Float = sotix / (p1 + p2 + p3 + p4 + p5 + p6 + p7 + p8)
                listCalculate.clear()
                listCalculate.add(
                    Selected(
                        listSelected[0].product_name,
                        (p1 * x).toInt().toString()
                    )
                )
                listCalculate.add(
                    Selected(
                        listSelected[1].product_name,
                        (p2 * x).toInt().toString()
                    )
                )
                listCalculate.add(
                    Selected(
                        listSelected[2].product_name,
                        (p3 * x).toInt().toString()
                    )
                )
                listCalculate.add(
                    Selected(
                        listSelected[3].product_name,
                        (p4 * x).toInt().toString()
                    )
                )
                listCalculate.add(
                    Selected(
                        listSelected[4].product_name,
                        (p5 * x).toInt().toString()
                    )
                )
                listCalculate.add(
                    Selected(
                        listSelected[5].product_name,
                        (p6 * x).toInt().toString()
                    )
                )
                listCalculate.add(
                    Selected(
                        listSelected[6].product_name,
                        (p7 * x).toInt().toString()
                    )
                )
                listCalculate.add(
                    Selected(
                        listSelected[7].product_name,
                        (p8 * x).toInt().toString()
                    )
                )
                selectedAdapter = SelectedAdapter(binding.root.context, listCalculate)
                binding.rvSelectedProduct.adapter = selectedAdapter
            }
        }


    }


    private fun roundOffDecimal(number: Float): String {
        val df = DecimalFormat("#.##")
        df.roundingMode = RoundingMode.CEILING
        return df.format(number).toFloat().toString()
    }

    private fun roundNumber1By(number: Float): String {
        val to = number.roundTo(1)
        return to.toString()
    }


}