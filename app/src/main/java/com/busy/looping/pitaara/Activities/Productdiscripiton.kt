package com.busy.looping.pitaara.Activities
import android.R
import android.content.SharedPreferences
import android.graphics.Paint
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.busy.looping.pitaara.Adpter.Categories
import com.busy.looping.pitaara.databinding.ActivityProductdiscripitonBinding
import com.busy.looping.pitaara.models.CartItemModel
import com.busy.looping.pitaara.models.CategoryModel

class Productdiscripiton : AppCompatActivity() {
    lateinit var binding:ActivityProductdiscripitonBinding
    lateinit var moreLikeAdpter:Categories;
    lateinit var goeswithLikeAdpter:Categories;
    var size= arrayOf("L","XXL","XXXL")
    var morelikeList=ArrayList<CategoryModel>()
    var goeswithlikeList=ArrayList<CategoryModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityProductdiscripitonBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var intent=intent
        var name= intent.getStringExtra("name")
      var imageUrl=  intent.getStringExtra("imageUrl")
        var productdec=intent.getStringExtra("descripation")
        var rating=intent.getStringExtra("rating")
        var price=intent.getStringExtra("price")
        var MRP=intent.getStringExtra("MRP")
        binding.tvRating.text=rating.toString()
        binding.tvDesc.text=productdec.toString()
        binding.tvDolar.text="₹"+price.toString()
        binding.tvMrp.text="₹"+MRP.toString()
        binding.tvMrp.paintFlags= binding.tvMrp.getPaintFlags() or Paint.STRIKE_THRU_TEXT_FLAG
        Toast.makeText(this,productdec.toString(),Toast.LENGTH_SHORT).show()

        val adapter = ArrayAdapter(this,
            R.layout.simple_spinner_item, size)
        binding.selectSize.adapter=adapter
        setGoeswithLikerecyclview()
        setMoreLikerecycleview()

        binding.btnAddtocart.setOnClickListener {
            CartScreen.cartlist.add(
                CartItemModel("https://i.pinimg.com/564x/b3/f2/6b/b3f26b0f5b2484cbbd6dd656faf09757.jpg",
                name.toString(),"subheading",productdec.toString() ,price.toString())
            )


//            var intent= Intent(this,CartScreen::class.java)
//            intent.putExtra("name",name)
//            intent.putExtra("imageUrl",imageUrl)
//            intent.putExtra("productdec",productdec)
//            intent.putExtra("rating",rating)
//            intent.putExtra("price",price)
//            startActivity(intent)
        }

    }
    fun setGoeswithLikerecyclview()
    {
        Toast.makeText(applicationContext,"GOT",Toast.LENGTH_SHORT).show()
        goeswithlikeList.add(
            CategoryModel(
                "https://i.pinimg.com/564x/b3/f2/6b/b3f26b0f5b2484cbbd6dd656faf09757.jpg",
                "Category Name"
            )
        )
        goeswithlikeList.add(
            CategoryModel(
                "https://cdn.shopify.com/s/files/1/2542/7564/products/14_d1dc6190-bafc-4ef5-b032-254782583c94_1800x1800.jpg?v=1669029849",
                "Category Name"
            )
        )
        goeswithlikeList.add(
            CategoryModel(
                "https://cdn.shopify.com/s/files/1/2542/7564/products/45_6b968612-50af-4dd8-83f2-fa7b696f3f7d_1800x1800.png?v=1646997769",
                "Category Name"
            )
        )
        goeswithlikeList.add(
            CategoryModel(
                "https://cdn.shopify.com/s/files/1/2542/7564/products/64_ce480047-8bd9-400a-976f-0f0127fe7b79_1800x1800.jpg?v=1669029515",
                "Category Name"
            )
        )
        goeswithLikeAdpter = Categories(this, goeswithlikeList, object : Categories.ItemClickListener {
            override fun onItemListener(tag: Int) {
                super.onItemListener(tag)
                //Toast.makeText(applicationContext,tag.toString(),Toast.LENGTH_SHORT).show()
            }
        })
        binding.goeswithwith.layoutManager = LinearLayoutManager(this,
            LinearLayoutManager.HORIZONTAL,true)
        binding.goeswithwith.adapter = goeswithLikeAdpter
    }
    fun setMoreLikerecycleview()
    {
        Toast.makeText(applicationContext,"Liked",Toast.LENGTH_SHORT).show()
        morelikeList.add(
            CategoryModel(
                "https://i.pinimg.com/564x/b3/f2/6b/b3f26b0f5b2484cbbd6dd656faf09757.jpg",
                "Category Name"
            )
        )
        morelikeList.add(
            CategoryModel(
                "https://cdn.shopify.com/s/files/1/2542/7564/products/14_d1dc6190-bafc-4ef5-b032-254782583c94_1800x1800.jpg?v=1669029849",
                "Category Name"
            )
        )
        morelikeList.add(
            CategoryModel(
                "https://cdn.shopify.com/s/files/1/2542/7564/products/45_6b968612-50af-4dd8-83f2-fa7b696f3f7d_1800x1800.png?v=1646997769",
                "Category Name"
            )
        )
        morelikeList.add(
            CategoryModel(
                "https://cdn.shopify.com/s/files/1/2542/7564/products/64_ce480047-8bd9-400a-976f-0f0127fe7b79_1800x1800.jpg?v=1669029515",
                "Category Name"
            )
        )
        moreLikeAdpter = Categories(this, morelikeList, object : Categories.ItemClickListener {
            override fun onItemListener(tag: Int) {
                super.onItemListener(tag)
                //Toast.makeText(applicationContext,tag.toString(),Toast.LENGTH_SHORT).show()
            }
        })
        Toast.makeText(applicationContext,"Passed==",Toast.LENGTH_SHORT).show()
        binding.morelikesthis.layoutManager = LinearLayoutManager(this,
            LinearLayoutManager.HORIZONTAL,true)
        binding.morelikesthis.adapter = moreLikeAdpter
    }
}