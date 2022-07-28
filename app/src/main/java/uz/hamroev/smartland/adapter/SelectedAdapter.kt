package uz.hamroev.smartland.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import uz.hamroev.smartland.R
import uz.hamroev.smartland.databinding.ItemSelectedBinding
import uz.hamroev.smartland.model.Selected

class SelectedAdapter(var context: Context, var list: List<Selected>) :
    RecyclerView.Adapter<SelectedAdapter.VHSelected>() {

    inner class VHSelected(var itemSelectedBinding: ItemSelectedBinding) :
        RecyclerView.ViewHolder(itemSelectedBinding.root) {

        fun onBind(selected: Selected, position: Int) {
            itemSelectedBinding.productName.text = selected.productName
            itemSelectedBinding.productAcres.text = selected.productAcres.toString().trim()

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VHSelected {
        return VHSelected(
            ItemSelectedBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: VHSelected, position: Int) {
        return holder.onBind(list[position], position)
    }

    override fun getItemCount(): Int = list.size


}