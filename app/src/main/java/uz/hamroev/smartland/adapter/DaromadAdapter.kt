package uz.hamroev.smartland.adapter

import android.content.Context
import android.os.Build
import android.text.Html
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import uz.hamroev.smartland.R
import uz.hamroev.smartland.databinding.ItemDaromadBinding
import uz.hamroev.smartland.model.daromad.DaromadHisobla
import uz.hamroev.smartland.utils.formatPrice
import java.util.*


class DaromadAdapter(var context: Context, var list: ArrayList<DaromadHisobla>) :
    RecyclerView.Adapter<DaromadAdapter.Vh>() {


    inner class Vh(var itemDaromadBinding: ItemDaromadBinding) :
        RecyclerView.ViewHolder(itemDaromadBinding.root) {

        fun onBind(daromadHisobla: DaromadHisobla, position: Int) {


            itemDaromadBinding.mahsulotNomiTv.text = daromadHisobla.mahsulotNomi + " - ${daromadHisobla.maydoni} ${context.resources.getString(R.string.m2)} "
            itemDaromadBinding.daromadTv.text = "${context.resources.getString(R.string.daromad)} - ${daromadHisobla.daromad.toString().formatPrice()} so'm"
            itemDaromadBinding.xarajatTv.text = "${context.resources.getString(R.string.xarajat)} - ${daromadHisobla.xarajat.toString().formatPrice()} so'm"
            itemDaromadBinding.sofFoydaTv.text = "${context.resources.getString(R.string.sof_foyda)} - ${daromadHisobla.sofFoyda.toString().formatPrice()} so'm"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(ItemDaromadBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
        return holder.onBind(list[position], position)
    }

    override fun getItemCount(): Int {
        return list.size
    }
}