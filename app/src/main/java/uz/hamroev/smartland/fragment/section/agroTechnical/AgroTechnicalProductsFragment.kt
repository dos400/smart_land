package uz.hamroev.smartland.fragment.section.agroTechnical

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import uz.hamroev.smartland.R
import uz.hamroev.smartland.adapter.ProductUzbAdapter
import uz.hamroev.smartland.databinding.FragmentAgroTechnicalProductsBinding
import uz.hamroev.smartland.db.agrotexnikaUZB.ProductUzbDatabase
import uz.hamroev.smartland.db.agrotexnikaUZB.ProductUzbEntity
import uz.hamroev.smartland.model.image.Img

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
                val listProductUzbBahor =
                    ProductUzbDatabase.GET.getProductUzbDatabase().getProductUzbDao()
                        .getSeasonsProduct("bahor")
                Log.d(TAG, "onCreateView: Bahor")

                val imgList = ArrayList<Img>()
                imgList.add(Img(R.drawable.kartoshka))
                imgList.add(Img(R.drawable.sabzi))
                imgList.add(Img(R.drawable.oqpiyoz))
                imgList.add(Img(R.drawable.pomidor))
                imgList.add(Img(R.drawable.bodring))
                imgList.add(Img(R.drawable.baqlajon))
                imgList.add(Img(R.drawable.bulgorqalampiri))
                imgList.add(Img(R.drawable.loviya))
                loadData(listProductUzbBahor, imgList, position)
            }
            1 -> {

                val listProductUzbKuz =
                    ProductUzbDatabase.GET.getProductUzbDatabase().getProductUzbDao()
                        .getSeasonsProduct("kuz")
                Log.d(TAG, "onCreateView: Kuz")
                val imgList = ArrayList<Img>()
                imgList.add(Img(R.drawable.kuzgipiyoz))
                imgList.add(Img(R.drawable.sarimsoq))
                imgList.add(Img(R.drawable.sholgom))
                imgList.add(Img(R.drawable.turp))
                imgList.add(Img(R.drawable.ismaloq))
                imgList.add(Img(R.drawable.ukrop))
                imgList.add(Img(R.drawable.kashnich))
                loadData(listProductUzbKuz, imgList, position)
            }
        }





        return binding.root
    }

    private fun loadData(list: List<ProductUzbEntity>, imgList: ArrayList<Img>, season: Int) {
        val bundle = Bundle()
        productUzbAdapter = ProductUzbAdapter(
            binding.root.context,
            list,
            imgList,
            object : ProductUzbAdapter.OnProductUzbClickListener {
                override fun onClick(
                    productUzbEntity: ProductUzbEntity,
                    imgPosition: Img,
                    position: Int
                ) {
                    bundle.putString("product_name", "${list[position].product_name}")
                    bundle.putInt("seasonposition", season)
                    bundle.putInt("productposition", position)
                    findNavController().navigate(R.id.agroTechnicalProductsInfoFragment, bundle)
                }
            })
        binding.rvProduct.adapter = productUzbAdapter
    }


}