package uz.hamroev.smartland.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import uz.hamroev.smartland.databinding.ItemProductUzbBinding
import uz.hamroev.smartland.db.agrotexnikaUZB.ProductUzbEntity
import uz.hamroev.smartland.model.image.Img

class ProductUzbAdapter(
    var context: Context,
    var listProduct: List<ProductUzbEntity>,
    var listImage: ArrayList<Img>,
    var onProductUzbClickListener: OnProductUzbClickListener
) : RecyclerView.Adapter<ProductUzbAdapter.VhProductUzb>() {

    inner class VhProductUzb(var itemProductUzbBinding: ItemProductUzbBinding) :
        RecyclerView.ViewHolder(itemProductUzbBinding.root) {


        fun onBind(productUzbEntity: ProductUzbEntity, imgPosition: Img, position: Int) {
            itemProductUzbBinding.productName.text = productUzbEntity.product_name
            itemProductUzbBinding.productImg.setImageResource(imgPosition.img)

            itemProductUzbBinding.card.setOnClickListener {
                onProductUzbClickListener.onClick(productUzbEntity, imgPosition, position)
            }


        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VhProductUzb {
        return VhProductUzb(
            ItemProductUzbBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: VhProductUzb, position: Int) {
        holder.onBind(listProduct[position], listImage[position], position)
    }

    override fun getItemCount(): Int = listProduct.size

    interface OnProductUzbClickListener {
        fun onClick(productUzbEntity: ProductUzbEntity, imgPosition: Img, position: Int)
    }
}