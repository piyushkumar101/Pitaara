package com.busy.looping.pitaara.Adpter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.busy.looping.pitaara.databinding.ProductItemBinding
import com.busy.looping.pitaara.models.ProductItemModel
import com.busy.looping.pitaara.models.SingleCategory

class ProductItemAdpter(
    var context: Context,
    var itemList:List<SingleCategory>,
    var clickListener:ItemClickListener
):RecyclerView.Adapter<ProductItemViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductItemViewHolder {
        val binding= ProductItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return  ProductItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductItemViewHolder, position: Int) {
        var items=itemList[position]
      Glide.with(context).load("https://i.pinimg.com/564x/b3/f2/6b/b3f26b0f5b2484cbbd6dd656faf09757.jpg").into(holder.binding.productImg)
        holder.binding.productHeading.text=items.name.toString()
        holder.binding.ratingTxt.text=items.rating.toString()
        holder.binding.productPrice.text="₹${items.price.toString()}"
        holder.binding.productDesc.text=items.des.toString()
        holder.binding.productDesc.maxLines=2
        holder.binding.cardItem.setOnClickListener {
            clickListener.onItemListener(position)
        }
    }

    override fun getItemCount(): Int {
      return  itemList.size;
    }
    interface  ItemClickListener
    {
        fun onItemListener(tag: Int) {

        }
    }
}
class ProductItemViewHolder(var binding:ProductItemBinding) :RecyclerView.ViewHolder(binding.root)
{

}