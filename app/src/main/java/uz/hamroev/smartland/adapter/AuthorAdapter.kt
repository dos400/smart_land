package uz.hamroev.smartland.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import uz.hamroev.smartland.databinding.ItemAuthorBinding
import uz.hamroev.smartland.model.Author

class AuthorAdapter(var context: Context, var list: ArrayList<Author>) :
    RecyclerView.Adapter<AuthorAdapter.VH>() {

    inner class VH(var itemAuthorBinding: ItemAuthorBinding) :
        RecyclerView.ViewHolder(itemAuthorBinding.root) {


        fun onBind(author: Author, position: Int) {
            itemAuthorBinding.name.text = author.name
            itemAuthorBinding.info.text = author.info
            itemAuthorBinding.img.setImageResource(author.img)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return VH(ItemAuthorBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        return holder.onBind(list[position], position)
    }

    override fun getItemCount(): Int = list.size
}