package com.busy.looping.pitaara.Adpter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.busy.looping.pitaara.databinding.CartRecyclerItemBinding
import com.busy.looping.pitaara.models.CartItemModel

class CartItem(
    val context: Context,
    var list: ArrayList<CartItemModel>,
    var clickListener: ItemClickListener

): RecyclerView.Adapter<CartItemViewholder>() {
       var item=1;
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartItemViewholder {
        val binding= CartRecyclerItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return  CartItemViewholder(binding)
    }

    override fun onBindViewHolder(holder: CartItemViewholder, position: Int) {
      var cartItem=list[position]
        Glide.with(context).load(cartItem.imageUrl).into(holder.binding.ivCartImage)
        holder.binding.headingTxt.text=cartItem.heading
        holder.binding.subHeadingTxt.text=cartItem.subheading
        holder.binding.desc.text=cartItem.decripition
        holder.binding.amountTxt.text="$${cartItem.price}"
        holder.binding.noItemsTxt.text=item.toString()
        holder.binding.incrementBtn.setOnClickListener {
            item=item+1;
            cartItem.price=(cartItem.price.toInt() *item.toInt()).toString()
            holder.binding.noItemsTxt.text=item.toString()
            holder.binding.amountTxt.text="$${cartItem.price}"
        }

        holder.binding.decrementBtn.setOnClickListener {
            if(item==0)
            {
                list.removeAt(position)
                notifyItemRemoved(position);
                notifyItemRangeChanged(position, list.size)
            }
            else{
                item=item-1;
                holder.binding.noItemsTxt.text=item.toString()
            }

        }
        holder.binding.cartitems.setOnClickListener{
          clickListener.onItemListener(position)
        }
    }

    override fun getItemCount(): Int {
       return list.size
    }
    interface  ItemClickListener
    {
        fun onItemListener(tag: Int) {
        }
    }
}
class CartItemViewholder(val binding: CartRecyclerItemBinding) : RecyclerView.ViewHolder(binding.root)
{

}