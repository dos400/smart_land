package uz.hamroev.smartland.fragment.section.agroTechnical

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import uz.hamroev.smartland.R
import uz.hamroev.smartland.databinding.FragmentAgroTechnicalProductsInfoBinding
import uz.hamroev.smartland.db.agrotexnikaUZB.ProductUzbDatabase
import uz.hamroev.smartland.model.image.Img
import uz.hamroev.smartland.utils.gone
import uz.hamroev.smartland.utils.invisible

class AgroTechnicalProductsInfoFragment : Fragment() {


    lateinit var binding: FragmentAgroTechnicalProductsInfoBinding
    private val TAG = "AgroTechnicalProductsIn"
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAgroTechnicalProductsInfoBinding.inflate(layoutInflater, container, false)

        binding.backIv.setOnClickListener {
            findNavController().popBackStack()
        }

        val productName1: String = arguments?.getString("product_name")!!
        val seasonPosition = arguments?.getInt("seasonposition")!!
        val productPosition = arguments?.getInt("productposition")!!

        val list = ProductUzbDatabase.GET.getProductUzbDatabase().getProductUzbDao()
            .getByProductName(productName1)

        if (seasonPosition == 0) {
            val imgList = ArrayList<Img>()
            imgList.add(Img(R.drawable.kartoshka))
            imgList.add(Img(R.drawable.sabzi))
            imgList.add(Img(R.drawable.oqpiyoz))
            imgList.add(Img(R.drawable.pomidor))
            imgList.add(Img(R.drawable.bodring))
            imgList.add(Img(R.drawable.baqlajon))
            imgList.add(Img(R.drawable.bulgorqalampiri))
            imgList.add(Img(R.drawable.loviya))
            binding.productImage.setImageResource(imgList[productPosition].img)
        } else if (seasonPosition == 1) {
            val imgList = ArrayList<Img>()
            imgList.add(Img(R.drawable.kuzgipiyoz))
            imgList.add(Img(R.drawable.sarimsoq))
            imgList.add(Img(R.drawable.sholgom))
            imgList.add(Img(R.drawable.turp))
            imgList.add(Img(R.drawable.ismaloq))
            imgList.add(Img(R.drawable.ukrop))
            imgList.add(Img(R.drawable.kashnich))
            binding.productImage.setImageResource(imgList[productPosition].img)
        }

        list.forEach { productUzbEntity ->
            binding.apply {
                productName.text = productUzbEntity.product_name

                ekilishiInfo.text = productUzbEntity.ekilishi
                parvarishiInfo.text = productUzbEntity.parvarishi
                ogitlashInfo.text = productUzbEntity.ogitlash
                sugorishInfo.text = productUzbEntity.sugorish
                qarshiKurashInfo.text = productUzbEntity.qarshi_kurash

                if (productUzbEntity.harorat == "0") {
                    binding.haroratCard.gone()
                } else {
                    haroratInfo.text = productUzbEntity.harorat
                }

                if (productUzbEntity.davri == "0") {
                    binding.davriCard.gone()
                } else {
                    davriInfo.text = productUzbEntity.davri
                }


            }
        }


        return binding.root
    }


}