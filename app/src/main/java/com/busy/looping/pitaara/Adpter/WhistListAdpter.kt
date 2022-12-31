package com.busy.looping.pitaara.Adpter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.busy.looping.pitaara.databinding.ProductItemBinding
import com.busy.looping.pitaara.databinding.WishlistItemBinding

class WhistListAdpter: RecyclerView.Adapter<WhistListViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WhistListViewHolder {
        val binding= WishlistItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return  WhistListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: WhistListViewHolder, position: Int) {
         holder.binding.buyNowBtn.setOnClickListener {
           
         }
    }

    override fun getItemCount(): Int {
       return  5;
    }
}
class WhistListViewHolder(val  binding: WishlistItemBinding) : RecyclerView.ViewHolder(binding.root)
{

}