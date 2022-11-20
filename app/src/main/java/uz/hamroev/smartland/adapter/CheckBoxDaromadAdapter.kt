package uz.hamroev.smartland.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import uz.hamroev.smartland.databinding.ItemCheckboxBinding
import uz.hamroev.smartland.db.ProductEntity
import uz.hamroev.smartland.db.daromad.DaromadEntity
import uz.hamroev.smartland.firebase.model.Product

class CheckBoxDaromadAdapter(
    var context: Context,
    var list: ArrayList<DaromadEntity>,
    var onCheckChangeListener: OnCheckChangeListener
) :
    RecyclerView.Adapter<CheckBoxDaromadAdapter.VHCheckBox>() {

    inner class VHCheckBox(var itemCheckboxBinding: ItemCheckboxBinding) :
        RecyclerView.ViewHolder(itemCheckboxBinding.root) {


        fun onBind(daromadEntity: DaromadEntity, position: Int) {
            itemCheckboxBinding.productName.text = daromadEntity.ekin_nomi

            itemCheckboxBinding.checkbox.setOnCheckedChangeListener { buttonView, isChecked ->
                if (isChecked) {
                    onCheckChangeListener.onCheck(daromadEntity, position)
                } else {
                    onCheckChangeListener.onCheckDelete(daromadEntity, position)
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
        fun onCheck(daromadEntity: DaromadEntity, position: Int)
        fun onCheckDelete(daromadEntity: DaromadEntity, position: Int)
    }
}