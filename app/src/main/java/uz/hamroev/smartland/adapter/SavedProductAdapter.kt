package uz.hamroev.smartland.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import uz.hamroev.smartland.R
import uz.hamroev.smartland.databinding.ItemSaqlanganBinding
import uz.hamroev.smartland.db.savedResultat.SavedResutatEntity

class SavedProductAdapter(var context: Context, var list: List<SavedResutatEntity>) :
    RecyclerView.Adapter<SavedProductAdapter.VhSavedResultant>() {

    inner class VhSavedResultant(var itemSaqlanganBinding: ItemSaqlanganBinding) :
        RecyclerView.ViewHolder(itemSaqlanganBinding.root) {
        fun onBind(savedResutatEntity: SavedResutatEntity, position: Int) {
            itemSaqlanganBinding.kiritilganMaydon.text =
                "${context.resources.getString(R.string.kiritilgan_maydon)} - ${savedResutatEntity.area} m2"
            itemSaqlanganBinding.fasl.text = savedResutatEntity.seasons
            itemSaqlanganBinding.productsWithPercentage.text = savedResutatEntity.allProductAbout
            itemSaqlanganBinding.vaqt.text = savedResutatEntity.time
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VhSavedResultant {
        return VhSavedResultant(
            ItemSaqlanganBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: VhSavedResultant, position: Int) {
        return holder.onBind(list[position], position)
    }

    override fun getItemCount(): Int {
        return list.size
    }
}