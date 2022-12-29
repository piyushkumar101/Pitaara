package com.busy.looping.pitaara

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.busy.looping.pitaara.Activities.ProductitemActivity
import com.busy.looping.pitaara.Adpter.Categories
import com.busy.looping.pitaara.Adpter.CategoriesSingleItem
import com.busy.looping.pitaara.Adpter.SilderApter
import com.busy.looping.pitaara.databinding.ActivityMainBinding
import com.busy.looping.pitaara.databinding.FragmentHomeFrgementBinding
import com.busy.looping.pitaara.databinding.FragmentOnboardingFrag1Binding
import com.busy.looping.pitaara.models.CategoryModel


class HomeFrgement : Fragment() {
    var _binding: FragmentHomeFrgementBinding?=null
    val binding get() = _binding
   lateinit var con:Context
    lateinit var categoryAdpter: CategoriesSingleItem;
    lateinit var  bannerSilderAdpter: SilderApter
    lateinit var mostPopularAdpter: Categories;
    lateinit var topOfferAdpter: Categories;
    lateinit var  limitedOfferAdpter: Categories;
    var categoriesList= ArrayList<CategoryModel>()
    var mostPopularList= ArrayList<CategoryModel>()
    var topOffersList=ArrayList<CategoryModel>()
    var limtedOfferList=ArrayList<CategoryModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        con=context
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding=FragmentHomeFrgementBinding.inflate(layoutInflater, container, false)
        setViewPagerBanners()
        setCategoryRecyclview()
        setMostPopularRecycleview()
        setTopofferRecycleview()
        setLimitedOfferRecycleview()
        return binding?.root
    }

    fun setViewPagerBanners()
    {
        bannerSilderAdpter=SilderApter()
        binding?.bannerViewPager?.adapter=bannerSilderAdpter
        binding?.dotIndicator?.setViewPager(binding!!.bannerViewPager)
    }
    fun setTopofferRecycleview()
    {
        topOffersList.add(
            CategoryModel(
                "https://i.pinimg.com/564x/b3/f2/6b/b3f26b0f5b2484cbbd6dd656faf09757.jpg",
                "Category Name"
            )
        )
        topOffersList.add(
            CategoryModel(
                "https://cdn.shopify.com/s/files/1/2542/7564/products/14_d1dc6190-bafc-4ef5-b032-254782583c94_1800x1800.jpg?v=1669029849",
                "Category Name"
            )
        )
        topOffersList.add(
            CategoryModel(
                "https://i.pinimg.com/564x/b3/f2/6b/b3f26b0f5b2484cbbd6dd656faf09757.jpg",
                "Category Name"
            )
        )
        topOffersList.add(
            CategoryModel(
                "https://cdn.shopify.com/s/files/1/2542/7564/products/64_ce480047-8bd9-400a-976f-0f0127fe7b79_1800x1800.jpg?v=1669029515",
                "Category Name"
            )
        )
        topOfferAdpter = Categories(con, topOffersList, object : Categories.ItemClickListener {
            override fun onItemListener(tag: Int) {
                super.onItemListener(tag)
                //Toast.makeText(applicationContext,tag.toString(),Toast.LENGTH_SHORT).show()
            }
        })
        binding?.topOffersRecyclerView?.layoutManager = LinearLayoutManager(con,
            LinearLayoutManager.HORIZONTAL,false)
        binding?.topOffersRecyclerView?.adapter = topOfferAdpter

    }
    fun setLimitedOfferRecycleview()
    {
        limtedOfferList.add(
            CategoryModel(
                "https://i.pinimg.com/564x/b3/f2/6b/b3f26b0f5b2484cbbd6dd656faf09757.jpg",
                "Category Name"
            )
        )
        limtedOfferList.add(
            CategoryModel(
                "https://cdn.shopify.com/s/files/1/2542/7564/products/14_d1dc6190-bafc-4ef5-b032-254782583c94_1800x1800.jpg?v=1669029849",
                "Category Name"
            )
        )
        limtedOfferList.add(
            CategoryModel(
                "https://i.pinimg.com/564x/b3/f2/6b/b3f26b0f5b2484cbbd6dd656faf09757.jpg",
                "Category Name"
            )
        )
        limtedOfferList.add(
            CategoryModel(
                "https://cdn.shopify.com/s/files/1/2542/7564/products/64_ce480047-8bd9-400a-976f-0f0127fe7b79_1800x1800.jpg?v=1669029515",
                "Category Name"
            )
        )
        limitedOfferAdpter = Categories(con, limtedOfferList, object : Categories.ItemClickListener {
            override fun onItemListener(tag: Int) {
                super.onItemListener(tag)
                var intent= Intent(con, ProductitemActivity::class.java)
                startActivity(intent)
                //Toast.makeText(applicationContext,tag.toString(),Toast.LENGTH_SHORT).show()
            }
        })
        binding?.limitedTimeRecyclerView?.layoutManager = LinearLayoutManager(con,
            LinearLayoutManager.HORIZONTAL,false)
        binding?.limitedTimeRecyclerView?.adapter = limitedOfferAdpter


    }
    fun setCategoryRecyclview()
    {
        categoriesList.add(
            CategoryModel(
                "https://i.pinimg.com/564x/b3/f2/6b/b3f26b0f5b2484cbbd6dd656faf09757.jpg",
                "Category Name"
            )
        )
        categoriesList.add(
            CategoryModel(
                "https://cdn.shopify.com/s/files/1/2542/7564/products/14_d1dc6190-bafc-4ef5-b032-254782583c94_1800x1800.jpg?v=1669029849",
                "Category Name"
            )
        )
        categoriesList.add(
            CategoryModel(
                "https://i.pinimg.com/564x/b3/f2/6b/b3f26b0f5b2484cbbd6dd656faf09757.jpg",
                "Category Name"
            )
        )
        categoriesList.add(
            CategoryModel(
                "https://cdn.shopify.com/s/files/1/2542/7564/products/64_ce480047-8bd9-400a-976f-0f0127fe7b79_1800x1800.jpg?v=1669029515",
                "Category Name"
            )
        )
        categoryAdpter = CategoriesSingleItem(con, categoriesList, object : CategoriesSingleItem.ItemClickListener {
            override fun onItemListener(tag: Int) {
                super.onItemListener(tag)
                var intent= Intent(con, ProductitemActivity::class.java)
                startActivity(intent)
                Toast.makeText(con,tag.toString(),Toast.LENGTH_SHORT).show()
            }
        })

        binding?.categoriesRecyclerView?.layoutManager = LinearLayoutManager(con,
            LinearLayoutManager.HORIZONTAL,false)
        val dividerItemDecoration = DividerItemDecoration(
            con,
            LinearLayoutManager.HORIZONTAL
        )
        dividerItemDecoration.setDrawable(resources.getDrawable(R.drawable.recyclview_divider))
        binding?.categoriesRecyclerView?.addItemDecoration(dividerItemDecoration)
        binding?.categoriesRecyclerView?.adapter = categoryAdpter


    }
    fun setMostPopularRecycleview()
    {

        mostPopularList.add(
            CategoryModel(
                "https://i.pinimg.com/564x/b3/f2/6b/b3f26b0f5b2484cbbd6dd656faf09757.jpg",
                "Category Name"
            )
        )
        mostPopularList.add(
            CategoryModel(
                "https://cdn.shopify.com/s/files/1/2542/7564/products/14_d1dc6190-bafc-4ef5-b032-254782583c94_1800x1800.jpg?v=1669029849",
                "Category Name"
            )
        )
        mostPopularList.add(
            CategoryModel(
                "https://cdn.shopify.com/s/files/1/2542/7564/products/45_6b968612-50af-4dd8-83f2-fa7b696f3f7d_1800x1800.png?v=1646997769",
                "Category Name"
            )
        )
        mostPopularList.add(
            CategoryModel(
                "https://cdn.shopify.com/s/files/1/2542/7564/products/64_ce480047-8bd9-400a-976f-0f0127fe7b79_1800x1800.jpg?v=1669029515",
                "Category Name"
            )
        )
        mostPopularAdpter = Categories(con, mostPopularList, object : Categories.ItemClickListener {
            override fun onItemListener(tag: Int) {
                super.onItemListener(tag)
                //Toast.makeText(applicationContext,tag.toString(),Toast.LENGTH_SHORT).show()
            }
        })
        binding?.mostPopularRecyclerView?.layoutManager = LinearLayoutManager(con,
            LinearLayoutManager.HORIZONTAL,true)
        binding?.mostPopularRecyclerView?.adapter = mostPopularAdpter

    }



}