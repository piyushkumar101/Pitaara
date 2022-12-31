package com.busy.looping.pitaara.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.busy.looping.pitaara.Adpter.CartItem
import com.busy.looping.pitaara.databinding.ActivityCartScreenBinding
import com.busy.looping.pitaara.models.CartItemModel

class CartScreen : AppCompatActivity() {
    companion object{
        var cartlist=ArrayList<CartItemModel>()
    }
    lateinit var binding:ActivityCartScreenBinding
    lateinit var cartAdpter:CartItem;
    var name:String ?=null;
    var imageUrl:String?=null;
    var productdec:String?=null;
    var rating:String?=null;
    var price:String?=null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityCartScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var intent =getIntent()
        imageUrl=intent.getStringExtra("name")
        productdec=intent.getStringExtra("imageUrl")
        price=intent.getStringExtra("price")
        productdec=intent.getStringExtra("productdec")

        setCartItems()
        binding.checkOutBtn.setOnClickListener {
            var intent= Intent(this,QrActivity::class.java)
            startActivity(intent)
        }
        binding.AddAddress.setOnClickListener {
            var intent= Intent(this,AddaddressActivtiy::class.java)
            startActivity(intent)
        }
    }
    fun setCartItems()
    {
//        cartlist.add(CartItemModel("https://i.pinimg.com/564x/b3/f2/6b/b3f26b0f5b2484cbbd6dd656faf09757.jpg",
//            "Heading","subheading","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident," +
//                    " sunt in culpa qui officia deserunt mollit anim id est laborum","5"))
//        cartlist.add(CartItemModel("https://i.pinimg.com/564x/b3/f2/6b/b3f26b0f5b2484cbbd6dd656faf09757.jpg",
//            "Heading","subheading","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident," +
//                    " sunt in culpa qui officia deserunt mollit anim id est laborum","5"))
//        cartlist.add(CartItemModel("https://i.pinimg.com/564x/b3/f2/6b/b3f26b0f5b2484cbbd6dd656faf09757.jpg",
//            "Heading","subheading","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident," +
//                    " sunt in culpa qui officia deserunt mollit anim id est laborum","5"))

        cartAdpter= CartItem(this,cartlist,object:CartItem.ItemClickListener{
            override fun onItemListener(tag: Int) {
                super.onItemListener(tag)


            }
        })

        binding.rvCartItem.layoutManager = LinearLayoutManager(this,
            LinearLayoutManager.VERTICAL,false)
        binding.rvCartItem.adapter = cartAdpter

    }


}