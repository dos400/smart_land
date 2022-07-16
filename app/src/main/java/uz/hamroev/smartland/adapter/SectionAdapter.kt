package uz.hamroev.smartland.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.RecyclerView
import uz.hamroev.smartland.R
import uz.hamroev.smartland.databinding.ItemSectionBinding
import uz.hamroev.smartland.model.Section

class SectionAdapter(
    var context: Context,
    var list: ArrayList<Section>,
    var onSectionClickListener: OnSectionClickListener
) :
    RecyclerView.Adapter<SectionAdapter.VhSection>() {


    inner class VhSection(var itemSectionBinding: ItemSectionBinding) :
        RecyclerView.ViewHolder(itemSectionBinding.root) {


        fun onBind(section: Section, position: Int) {

            val anim_arrow = AnimationUtils.loadAnimation(context, R.anim.anim_arrow)
            itemSectionBinding.title.text = section.title
            itemSectionBinding.imageLayout.setBackgroundResource(section.image)

            itemSectionBinding.main.setOnClickListener {
                onSectionClickListener.onClick(section, position)
            }
            itemSectionBinding.main.setOnLongClickListener {
                itemSectionBinding.arrowIv.startAnimation(anim_arrow)
                true
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VhSection {
        return VhSection(
            ItemSectionBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: VhSection, position: Int) {
        return holder.onBind(list[position], position)
    }

    override fun getItemCount(): Int = list.size


    interface OnSectionClickListener {
        fun onClick(section: Section, position: Int)
    }
}