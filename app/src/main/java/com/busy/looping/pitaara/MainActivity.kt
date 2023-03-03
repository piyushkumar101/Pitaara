package com.busy.looping.pitaara

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.DisplayMetrics
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.inputmethod.EditorInfo
import android.widget.TextView.OnEditorActionListener
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.GravityCompat
import com.busy.looping.pitaara.Activities.CartScreen
import com.busy.looping.pitaara.Adpter.Categories
import com.busy.looping.pitaara.Adpter.CategoriesSingleItem
import com.busy.looping.pitaara.Adpter.SilderApter
import com.busy.looping.pitaara.baseactivity.BaseActivity
import com.busy.looping.pitaara.databinding.ActivityMainBinding
import com.busy.looping.pitaara.gobal.Constance
import com.busy.looping.pitaara.models.CategoryModel
import com.busy.looping.pitaara.models.GetProdcutModel
import com.busy.looping.pitaara.models.SingleCategory
import com.busy.looping.pitaara.retrofit.RetrofitResponse
import com.busy.looping.pitaara.retrofit.URL
import com.google.gson.Gson
import com.google.gson.JsonObject


class MainActivity : BaseActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var toogle: ActionBarDrawerToggle
    lateinit var categoryAdpter: CategoriesSingleItem;
    lateinit var  bannerSilderAdpter: SilderApter
    lateinit var mostPopularAdpter:Categories;
    lateinit var topOfferAdpter:Categories;
    lateinit var  limitedOfferAdpter:Categories;
     var categoriesList= ArrayList<CategoryModel>()
    var mostPopularList= ArrayList<CategoryModel>()
    var topOffersList=ArrayList<CategoryModel>()
    var limtedOfferList=ArrayList<CategoryModel>()
    @RequiresApi(Build.VERSION_CODES.S)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        binding = ActivityMainBinding.inflate(layoutInflater)
        val displayMetrics = DisplayMetrics()
        setSupportActionBar(binding.topAppBar)
        supportActionBar?.elevation= 0F
        setContentView(binding.root)
        toogle = ActionBarDrawerToggle(
            this,
            binding.drawLayout,
            binding.topAppBar,
            R.string.app_name,
            R.string.app_name
        )

        binding.drawLayout.addDrawerListener(toogle)
        toogle.syncState()
        binding.drawLayout.closeDrawer(GravityCompat.START)
       supportFragmentManager.beginTransaction().replace(R.id.framentContainer,HomeFrgement()).commitNow()
        var jsonObject=JsonObject()
        callWb(this,Constance.BASE_URL+URL.GET_ALLPRODUCTSBYCATEGORY,Constance.GET,jsonObject,object :RetrofitResponse{
            override fun onResponse(response: String?, methodName: String?, responseCode: Int) {
                var jsonlist=Gson().fromJson(response,Array<SingleCategory>::class.java).asList()
                var model=Gson().toJson(response,SingleCategory::class.java)
                Toast.makeText(this@MainActivity,response.toString(),Toast.LENGTH_SHORT).show()

//                var infoitemList = Gson().fromJson(response,Array<GetProdcutModel>::class.java).asList()
                Log.d("TESTMODELISTTT====",response.toString())


            }

            override fun onResponseFail(methodName: String?, responseCode: Int) {

            }

        })
        binding.etSearch.setOnEditorActionListener(OnEditorActionListener { v, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                var jsonObject=JsonObject()
               callWb(this,Constance.BASE_URL+URL.GET_PRODUCTBYTAG+binding.etSearch.toString(),Constance.GET,jsonObject,
               object :RetrofitResponse{
                   override fun onResponse(
                       response: String?,
                       methodName: String?,
                       responseCode: Int
                   ) {
                       Log.d("seachResponse=====",response.toString())
                   }

                   override fun onResponseFail(methodName: String?, responseCode: Int) {
                       TODO("Not yet implemented")
                   }

               })
                return@OnEditorActionListener true
            }
            false
        })
//        setViewPagerBanners()
//        setCategoryRecyclview()
//        setMostPopularRecycleview()
//        setTopofferRecycleview()
//        setLimitedOfferRecycleview()





//        call.enqueue(object :Callback<ResponseBody?>{
//            override fun onResponse(call: Call<ResponseBody?>, response: Response<ResponseBody?>) {
//               Log.d("API=====",response.body().toString())
//            }
//
//            override fun onFailure(call: Call<ResponseBody?>, t: Throwable) {
//                Log.d("ERRORAPI=====",t.toString())
//            }
//
//        })


        // categoriesList = ArrayList<CategoryModel>()

    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }

//    fun setViewPagerBanners()
//    {
//       bannerSilderAdpter=SilderApter()
//        Toast.makeText(this,"CALLED",Toast.LENGTH_SHORT).show()
//        binding.bannerViewPager.adapter=bannerSilderAdpter
//        binding.dotIndicator.setViewPager(binding.bannerViewPager)
//    }
//    fun setTopofferRecycleview()
//    {
//        topOffersList.add(
//            CategoryModel(
//                "https://i.pinimg.com/564x/b3/f2/6b/b3f26b0f5b2484cbbd6dd656faf09757.jpg",
//                "Category Name"
//            )
//        )
//        topOffersList.add(
//            CategoryModel(
//                "https://cdn.shopify.com/s/files/1/2542/7564/products/14_d1dc6190-bafc-4ef5-b032-254782583c94_1800x1800.jpg?v=1669029849",
//                "Category Name"
//            )
//        )
//        topOffersList.add(
//            CategoryModel(
//                "https://i.pinimg.com/564x/b3/f2/6b/b3f26b0f5b2484cbbd6dd656faf09757.jpg",
//                "Category Name"
//            )
//        )
//        topOffersList.add(
//            CategoryModel(
//                "https://cdn.shopify.com/s/files/1/2542/7564/products/64_ce480047-8bd9-400a-976f-0f0127fe7b79_1800x1800.jpg?v=1669029515",
//                "Category Name"
//            )
//        )
//        topOfferAdpter = Categories(this, topOffersList, object : Categories.ItemClickListener {
//            override fun onItemListener(tag: Int) {
//                super.onItemListener(tag)
//                //Toast.makeText(applicationContext,tag.toString(),Toast.LENGTH_SHORT).show()
//            }
//        })
//        binding.topOffersRecyclerView.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
//        binding.topOffersRecyclerView.adapter = topOfferAdpter
//
//    }
//    fun setLimitedOfferRecycleview()
//    {
//        limtedOfferList.add(
//            CategoryModel(
//                "https://i.pinimg.com/564x/b3/f2/6b/b3f26b0f5b2484cbbd6dd656faf09757.jpg",
//                "Category Name"
//            )
//        )
//        limtedOfferList.add(
//            CategoryModel(
//                "https://cdn.shopify.com/s/files/1/2542/7564/products/14_d1dc6190-bafc-4ef5-b032-254782583c94_1800x1800.jpg?v=1669029849",
//                "Category Name"
//            )
//        )
//        limtedOfferList.add(
//            CategoryModel(
//                "https://i.pinimg.com/564x/b3/f2/6b/b3f26b0f5b2484cbbd6dd656faf09757.jpg",
//                "Category Name"
//            )
//        )
//        limtedOfferList.add(
//            CategoryModel(
//                "https://cdn.shopify.com/s/files/1/2542/7564/products/64_ce480047-8bd9-400a-976f-0f0127fe7b79_1800x1800.jpg?v=1669029515",
//                "Category Name"
//            )
//        )
//        limitedOfferAdpter = Categories(this, limtedOfferList, object : Categories.ItemClickListener {
//            override fun onItemListener(tag: Int) {
//                super.onItemListener(tag)
//                var intent=Intent(applicationContext,ProductitemActivity::class.java)
//                startActivity(intent)
//                //Toast.makeText(applicationContext,tag.toString(),Toast.LENGTH_SHORT).show()
//            }
//        })
//        binding.limitedTimeRecyclerView.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
//        binding.limitedTimeRecyclerView.adapter = limitedOfferAdpter
//
//
//    }
//    fun setCategoryRecyclview()
//    {
//        categoriesList.add(
//            CategoryModel(
//                "https://i.pinimg.com/564x/b3/f2/6b/b3f26b0f5b2484cbbd6dd656faf09757.jpg",
//                "Category Name"
//            )
//        )
//        categoriesList.add(
//            CategoryModel(
//                "https://cdn.shopify.com/s/files/1/2542/7564/products/14_d1dc6190-bafc-4ef5-b032-254782583c94_1800x1800.jpg?v=1669029849",
//                "Category Name"
//            )
//        )
//        categoriesList.add(
//            CategoryModel(
//                "https://i.pinimg.com/564x/b3/f2/6b/b3f26b0f5b2484cbbd6dd656faf09757.jpg",
//                "Category Name"
//            )
//        )
//        categoriesList.add(
//            CategoryModel(
//                "https://cdn.shopify.com/s/files/1/2542/7564/products/64_ce480047-8bd9-400a-976f-0f0127fe7b79_1800x1800.jpg?v=1669029515",
//                "Category Name"
//            )
//        )
//        categoryAdpter = CategoriesSingleItem(this, categoriesList, object : CategoriesSingleItem.ItemClickListener {
//            override fun onItemListener(tag: Int) {
//                super.onItemListener(tag)
//                var intent=Intent(applicationContext,ProductitemActivity::class.java)
//                startActivity(intent)
//                Toast.makeText(applicationContext,tag.toString(),Toast.LENGTH_SHORT).show()
//            }
//        })
//
//        binding.categoriesRecyclerView.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
//        val dividerItemDecoration = DividerItemDecoration(
//            this,
//            LinearLayoutManager.HORIZONTAL
//        )
//        dividerItemDecoration.setDrawable(resources.getDrawable(R.drawable.recyclview_divider))
//        binding.categoriesRecyclerView.addItemDecoration(dividerItemDecoration)
//       binding.categoriesRecyclerView.adapter = categoryAdpter
//
//
//    }
//    fun setMostPopularRecycleview()
//    {
//
//        mostPopularList.add(
//            CategoryModel(
//                "https://i.pinimg.com/564x/b3/f2/6b/b3f26b0f5b2484cbbd6dd656faf09757.jpg",
//                "Category Name"
//            )
//        )
//        mostPopularList.add(
//            CategoryModel(
//                "https://cdn.shopify.com/s/files/1/2542/7564/products/14_d1dc6190-bafc-4ef5-b032-254782583c94_1800x1800.jpg?v=1669029849",
//                "Category Name"
//            )
//        )
//        mostPopularList.add(
//            CategoryModel(
//                "https://cdn.shopify.com/s/files/1/2542/7564/products/45_6b968612-50af-4dd8-83f2-fa7b696f3f7d_1800x1800.png?v=1646997769",
//                "Category Name"
//            )
//        )
//        mostPopularList.add(
//            CategoryModel(
//                "https://cdn.shopify.com/s/files/1/2542/7564/products/64_ce480047-8bd9-400a-976f-0f0127fe7b79_1800x1800.jpg?v=1669029515",
//                "Category Name"
//            )
//        )
//        mostPopularAdpter = Categories(this, mostPopularList, object : Categories.ItemClickListener {
//            override fun onItemListener(tag: Int) {
//                super.onItemListener(tag)
//                //Toast.makeText(applicationContext,tag.toString(),Toast.LENGTH_SHORT).show()
//            }
//        })
//        binding.mostPopularRecyclerView.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,true)
//        binding.mostPopularRecyclerView.adapter = mostPopularAdpter
//
//    }
//
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        super.onCreateOptionsMenu(menu)
        getMenuInflater().inflate(R.menu.appbarmenu, menu);
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
         super.onOptionsItemSelected(item)
        if(item.itemId==R.id.appbar_bag)
        {
            var intent=Intent(this,CartScreen::class.java)
            startActivity(intent)
        }
        return  true
    }
}