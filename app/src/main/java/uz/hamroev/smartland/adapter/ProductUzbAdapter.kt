package uz.hamroev.smartland.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import uz.hamroev.smartland.databinding.ItemProductUzbBinding
import uz.hamroev.smartland.db.agrotexnikaUZB.ProductUzbEntity
import uz.hamroev.smartland.model.agrotexnika.Agrotexnika
import uz.hamroev.smartland.model.image.Img

class ProductUzbAdapter(
    var context: Context,
    var listAgrotexnika: ArrayList<Agrotexnika>,
    var onProductUzbClickListener: OnProductUzbClickListener
) : RecyclerView.Adapter<ProductUzbAdapter.VhProductUzb>() {

    inner class VhProductUzb(var itemProductUzbBinding: ItemProductUzbBinding) :
        RecyclerView.ViewHolder(itemProductUzbBinding.root) {


        fun onBind(agrotexnika: Agrotexnika, position: Int) {
            itemProductUzbBinding.productName.text = agrotexnika.productName
//            itemProductUzbBinding.productImg.setImageResource(agrotexnika.img)

            itemProductUzbBinding.card.setOnClickListener {
                onProductUzbClickListener.onClick(agrotexnika, position)
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
        holder.onBind(listAgrotexnika[position], position)
    }

    override fun getItemCount(): Int = listAgrotexnika.size

    interface OnProductUzbClickListener {
        fun onClick(agrotexnika: Agrotexnika, position: Int)
    }
}