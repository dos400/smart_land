package uz.hamroev.smartland.fragment.section.agroTechnical

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import uz.hamroev.smartland.R
import uz.hamroev.smartland.adapter.ProductUzbAdapter
import uz.hamroev.smartland.databinding.FragmentAgroTechnicalProductsBinding
import uz.hamroev.smartland.db.agrotexnikaUZB.ProductUzbDatabase
import uz.hamroev.smartland.db.agrotexnikaUZB.ProductUzbEntity
import uz.hamroev.smartland.model.agrotexnika.Agrotexnika
import uz.hamroev.smartland.model.image.Img
import java.util.Observable
import java.util.Observer

class AgroTechnicalProductsFragment : Fragment() {


    lateinit var binding: FragmentAgroTechnicalProductsBinding
    private val TAG = "AgroTechnicalProductsFr"
    lateinit var productUzbAdapter: ProductUzbAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAgroTechnicalProductsBinding.inflate(layoutInflater, container, false)

        binding.backIv.setOnClickListener {
            findNavController().popBackStack()
        }

        val bundleSeason = Bundle()
        var a =
            "https://stackoverflow.com/questions/70898269/room-pre-packaged-database-has-an-invalid-schema-error-of-expect-type-integer-fo"

        val position: Int = arguments?.getInt("season") as Int



        when (position) {

            0 -> {
//                val listProductUzbBahor =
//                    ProductUzbDatabase.GET.getProductUzbDatabase().getProductUzbDao()
//                        .getSeasonsProduct("bahor")
//                Log.d(TAG, "onCreateView: Bahor")
////
//                val listProductUzbBahor2 = ArrayList<ProductUzbEntity>()
//                listProductUzbBahor2.add(ProductUzbEntity("${activity?.resources?.getString(R.string.potatoes)}", "", "", "", "", "", "", "", ""))
//                listProductUzbBahor2.add(ProductUzbEntity("${activity?.resources?.getString(R.string.carrot)}", "", "", "", "", "", "", "", ""))
//                listProductUzbBahor2.add(ProductUzbEntity("${activity?.resources?.getString(R.string.onion)}", "", "", "", "", "", "", "", ""))
//                listProductUzbBahor2.add(ProductUzbEntity("${activity?.resources?.getString(R.string.tomato)}", "", "", "", "", "", "", "", ""))
//                listProductUzbBahor2.add(ProductUzbEntity("${activity?.resources?.getString(R.string.cucumber)}", "", "", "", "", "", "", "", ""))
//                listProductUzbBahor2.add(ProductUzbEntity("${activity?.resources?.getString(R.string.eggplant)}", "", "", "", "", "", "", "", ""))
//                listProductUzbBahor2.add(ProductUzbEntity("${activity?.resources?.getString(R.string.garlic)}", "", "", "", "", "", "", "", ""))
//                listProductUzbBahor2.add(ProductUzbEntity("${activity?.resources?.getString(R.string.bean)}", "", "", "", "", "", "", "", ""))

//
//                val imgList = ArrayList<Img>()
//                imgList.add(Img(R.drawable.kartoshka))
//                imgList.add(Img(R.drawable.sabzi))
//                imgList.add(Img(R.drawable.oqpiyoz))
//                imgList.add(Img(R.drawable.pomidor))
//                imgList.add(Img(R.drawable.bodring))
//                imgList.add(Img(R.drawable.baqlajon))
//                imgList.add(Img(R.drawable.bulgorqalampiri))
//                imgList.add(Img(R.drawable.loviya))

                val listAgrotexnika = ArrayList<Agrotexnika>()
                listAgrotexnika.add(
                    Agrotexnika(
                        "${activity?.resources?.getString(R.string.potatoes)}",
                        R.drawable.kartoshka,
                        "bahor"
                    )
                )
                listAgrotexnika.add(
                    Agrotexnika(
                        "${activity?.resources?.getString(R.string.carrot)}",
                        R.drawable.sabzi,
                        "bahor"
                    )
                )
                listAgrotexnika.add(
                    Agrotexnika(
                        "${activity?.resources?.getString(R.string.onion)}",
                        R.drawable.oqpiyoz,
                        "bahor"
                    )
                )
                listAgrotexnika.add(
                    Agrotexnika(
                        "${activity?.resources?.getString(R.string.tomato)}",
                        R.drawable.pomidor,
                        "bahor"
                    )
                )
                listAgrotexnika.add(
                    Agrotexnika(
                        "${activity?.resources?.getString(R.string.cucumber)}",
                        R.drawable.bodring,
                        "bahor"
                    )
                )
                listAgrotexnika.add(
                    Agrotexnika(
                        "${activity?.resources?.getString(R.string.eggplant)}",
                        R.drawable.baqlajon,
                        "bahor"
                    )
                )
                listAgrotexnika.add(
                    Agrotexnika(
                        "${activity?.resources?.getString(R.string.Pepper)}",
                        R.drawable.bulgorqalampiri,
                        "bahor"
                    )
                )
                listAgrotexnika.add(
                    Agrotexnika(
                        "${activity?.resources?.getString(R.string.bean)}",
                        R.drawable.loviya,
                        "bahor"
                    )
                )

                loadData(listAgrotexnika, position)
            }
            1 -> {

//                val listProductUzbKuz =
//                    ProductUzbDatabase.GET.getProductUzbDatabase().getProductUzbDao()
//                        .getSeasonsProduct("kuz")
//                Log.d(TAG, "onCreateView: Kuz")
//
//                val listProductUzbKuz2 = ArrayList<ProductUzbEntity>()
//                listProductUzbKuz2.add(ProductUzbEntity("${activity?.resources?.getString(R.string.onion_autumn)}", "", "", "", "", "", "", "", ""))
//                listProductUzbKuz2.add(ProductUzbEntity("${activity?.resources?.getString(R.string.garlic)}", "", "", "", "", "", "", "", ""))
//                listProductUzbKuz2.add(ProductUzbEntity("${activity?.resources?.getString(R.string.turnip)}", "", "", "", "", "", "", "", ""))
//                listProductUzbKuz2.add(ProductUzbEntity("${activity?.resources?.getString(R.string.radish)}", "", "", "", "", "", "", "", ""))
//                listProductUzbKuz2.add(ProductUzbEntity("${activity?.resources?.getString(R.string.spinach)}", "", "", "", "", "", "", "", ""))
//                listProductUzbKuz2.add(ProductUzbEntity("${activity?.resources?.getString(R.string.cilantro)}", "", "", "", "", "", "", "", ""))
//                listProductUzbKuz2.add(ProductUzbEntity("${activity?.resources?.getString(R.string.dill)}", "", "", "", "", "", "", "", ""))
//
//                val imgList = ArrayList<Img>()
//                imgList.add(Img(R.drawable.kuzgipiyoz))
//                imgList.add(Img(R.drawable.sarimsoq))
//                imgList.add(Img(R.drawable.sholgom))
//                imgList.add(Img(R.drawable.turp))
//                imgList.add(Img(R.drawable.ismaloq))
//                imgList.add(Img(R.drawable.ukrop))
//                imgList.add(Img(R.drawable.kashnich))

                val listAgrotexnika = ArrayList<Agrotexnika>()
                listAgrotexnika.add(
                    Agrotexnika(
                        "${activity?.resources?.getString(R.string.onion_autumn)}",
                        R.drawable.kuzgipiyoz,
                        "kuz"
                    )
                )
                listAgrotexnika.add(
                    Agrotexnika(
                        "${activity?.resources?.getString(R.string.garlic)}",
                        R.drawable.sarimsoq,
                        "kuz"
                    )
                )
                listAgrotexnika.add(
                    Agrotexnika(
                        "${activity?.resources?.getString(R.string.turnip)}",
                        R.drawable.sholgom,
                        "kuz"
                    )
                )
                listAgrotexnika.add(
                    Agrotexnika(
                        "${activity?.resources?.getString(R.string.radish)}",
                        R.drawable.turp,
                        "kuz"
                    )
                )
                listAgrotexnika.add(
                    Agrotexnika(
                        "${activity?.resources?.getString(R.string.spinach)}",
                        R.drawable.ismaloq,
                        "kuz"
                    )
                )
                listAgrotexnika.add(
                    Agrotexnika(
                        "${activity?.resources?.getString(R.string.cilantro)}",
                        R.drawable.ukrop,
                        "kuz"
                    )
                )
                listAgrotexnika.add(
                    Agrotexnika(
                        "${activity?.resources?.getString(R.string.dill)}",
                        R.drawable.kashnich,
                        "kuz"
                    )
                )

                loadData(listAgrotexnika, position)
            }
        }







        return binding.root
    }

    private fun loadData(list: ArrayList<Agrotexnika>, season: Int) {
        val bundle = Bundle()

        productUzbAdapter = ProductUzbAdapter(
            binding.root.context,
            list,
            object : ProductUzbAdapter.OnProductUzbClickListener {
                override fun onClick(agrotexnika: Agrotexnika, position: Int) {
                    bundle.putString("product_name", "${list[position].productName}")
                    bundle.putInt("seasonposition", season)
                    bundle.putInt("productposition", position)
                    findNavController().navigate(R.id.agroTechnicalProductsInfoFragment, bundle)
                }
            })
        binding.rvProduct.adapter = productUzbAdapter
    }


}