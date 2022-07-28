package uz.hamroev.smartland.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import uz.hamroev.smartland.databinding.ItemCheckboxBinding
import uz.hamroev.smartland.db.ProductEntity
import uz.hamroev.smartland.firebase.model.Product

class CheckBoxAdapter(
    var context: Context,
    var list: ArrayList<ProductEntity>,
    var onCheckChangeListener: OnCheckChangeListener
) :
    RecyclerView.Adapter<CheckBoxAdapter.VHCheckBox>() {

    inner class VHCheckBox(var itemCheckboxBinding: ItemCheckboxBinding) :
        RecyclerView.ViewHolder(itemCheckboxBinding.root) {


        fun onBind(productEntity: ProductEntity, position: Int) {
            itemCheckboxBinding.productName.text = productEntity.product_name

            itemCheckboxBinding.checkbox.setOnCheckedChangeListener { buttonView, isChecked ->
                if (isChecked) {
                    onCheckChangeListener.onCheck(productEntity, position)
                } else {
                    onCheckChangeListener.onCheckDelete(productEntity, position)
                }
            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VHCheckBox {
        return VHCheckBox(
            ItemCheckboxBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: VHCheckBox, position: Int) {
        return holder.onBind(list[position], position)
    }

    override fun getItemCount(): Int = list.size

    interface OnCheckChangeListener {
        fun onCheck(productEntity: ProductEntity, position: Int)
        fun onCheckDelete(productEntity: ProductEntity, position: Int)
    }
}