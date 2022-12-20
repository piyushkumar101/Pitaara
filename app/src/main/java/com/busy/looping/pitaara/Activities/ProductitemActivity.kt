package com.busy.looping.pitaara.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.busy.looping.pitaara.Adpter.ProductItemAdpter
import com.busy.looping.pitaara.Adpter.ProductItemModel
import com.busy.looping.pitaara.R
import com.busy.looping.pitaara.databinding.ActivityProductitemBinding

class ProductitemActivity : AppCompatActivity() {
   lateinit var binding:ActivityProductitemBinding
   lateinit var  itemAdpter: ProductItemAdpter;
    var itemList=ArrayList<ProductItemModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityProductitemBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setItemRecyclviewAdpter()
    }
    fun setItemRecyclviewAdpter()
    {
       itemList.add(ProductItemModel("https://i.pinimg.com/564x/b3/f2/6b/b3f26b0f5b2484cbbd6dd656faf09757.jpg",
       "Product Name","4.5","10","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua"))
        itemList.add(ProductItemModel("https://i.pinimg.com/564x/b3/f2/6b/b3f26b0f5b2484cbbd6dd656faf09757.jpg",
            "Product Name","4.5","10","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua"))
        itemList.add(ProductItemModel("https://i.pinimg.com/564x/b3/f2/6b/b3f26b0f5b2484cbbd6dd656faf09757.jpg",
            "Product Name","4.5","10","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua"))
        itemList.add(ProductItemModel("https://i.pinimg.com/564x/b3/f2/6b/b3f26b0f5b2484cbbd6dd656faf09757.jpg",
            "Product Name","4.5","10","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua"))
        itemList.add(ProductItemModel("https://i.pinimg.com/564x/b3/f2/6b/b3f26b0f5b2484cbbd6dd656faf09757.jpg",
            "Product Name","4.5","10","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua"))
        itemAdpter= ProductItemAdpter(this,itemList,object:ProductItemAdpter.ClickListener{
            override fun itemListener(position: Int) {
                super.itemListener(position)
            }
        })
        val dividerItemDecoration = DividerItemDecoration(
            this,
            LinearLayoutManager.HORIZONTAL
        )
        dividerItemDecoration.setDrawable(resources.getDrawable(R.drawable.recyclview_divider))

        binding.recyclerViewItems.layoutManager=GridLayoutManager(this,2)
        binding.recyclerViewItems.addItemDecoration(dividerItemDecoration)
        binding.recyclerViewItems.adapter=itemAdpter
    }
}