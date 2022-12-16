package com.busy.looping.pitaara.Adpter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.marginLeft
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.busy.looping.pitaara.R
import com.busy.looping.pitaara.databinding.CategoryItemBinding
import com.busy.looping.pitaara.databinding.CategorySingleItemBinding
import com.busy.looping.pitaara.models.CategoryModel

class CategoriesSingleItem(
    val  context: Context,
    val  categoriesList: ArrayList<CategoryModel>,
    var clickListener: ItemClickListener
): RecyclerView.Adapter<CategoriesSingleItemViewholder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CategoriesSingleItemViewholder {
        val binding= CategorySingleItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return  CategoriesSingleItemViewholder(binding)
    }

    override fun onBindViewHolder(holder: CategoriesSingleItemViewholder, position: Int) {
        var categoriesList=categoriesList[position]
        Glide.with(context).load(categoriesList.ImageUrl)
            .into(holder.binding.ivBannerImage)
        holder.binding.tvCategoryName.setText("Products")
        holder.binding.ivBannerImage.setOnClickListener {
            clickListener.onItemListener(position)
        }
    }

    override fun getItemCount(): Int {
        return  categoriesList.size;
    }
    interface  ItemClickListener
    {
        fun onItemListener(tag: Int) {

        }
    }
}
class CategoriesSingleItemViewholder(val binding: CategorySingleItemBinding) :RecyclerView.ViewHolder(binding.root)

{

}