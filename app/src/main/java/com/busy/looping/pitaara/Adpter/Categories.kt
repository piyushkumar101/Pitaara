package com.busy.looping.pitaara.Adpter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.busy.looping.pitaara.R
import com.busy.looping.pitaara.databinding.CategoryItemBinding
import com.busy.looping.pitaara.models.CategoryModel

class Categories(var contex:Context,
                 var categoriesList:ArrayList<CategoryModel>,
                 var clickListener: ItemClickListener): RecyclerView.Adapter<CategoriesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriesViewHolder {
      val binding=CategoryItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return  CategoriesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CategoriesViewHolder, position: Int) {
        var categoriesitem=categoriesList[position]
        Glide.with(contex).load(categoriesitem.ImageUrl)
            .into(holder.binding.ivCategoryimage)
        //holder.binding.ivCategoryimage.setImageResource(R.drawable.banner_sample)
        holder.binding.tvCategoryName.setText(categoriesitem.CategoryItemName)

        holder.binding.ivCategoryimage.setOnClickListener {
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
class CategoriesViewHolder(val binding:CategoryItemBinding) : RecyclerView.ViewHolder(binding.root)
{

}