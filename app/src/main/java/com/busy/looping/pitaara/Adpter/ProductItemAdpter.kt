package com.busy.looping.pitaara.Adpter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.busy.looping.pitaara.databinding.CategoryItemBinding
import com.busy.looping.pitaara.databinding.ProductItemBinding

class ProductItemAdpter(
    var context: Context,
    var itemList:ArrayList<ProductItemModel>,
    var clickListener:ClickListener
):RecyclerView.Adapter<ProductItemViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductItemViewHolder {
        val binding= ProductItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return  ProductItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductItemViewHolder, position: Int) {
        var items=itemList[position]
      Glide.with(context).load(items.imageUrl).into(holder.binding.productImg)
        holder.binding.productHeading.text=items.producttitle
        holder.binding.ratingTxt.text=items.rating
        holder.binding.productPrice.text="$${items.price}"
        holder.binding.productDesc.text=items.dec
        holder.binding.productDesc.maxLines=2
    }

    override fun getItemCount(): Int {
      return  itemList.size;
    }
    interface  ClickListener
    {
          fun itemListener( position: Int)
        {

        }
    }
}
class ProductItemViewHolder(var binding:ProductItemBinding) :RecyclerView.ViewHolder(binding.root)
{

}