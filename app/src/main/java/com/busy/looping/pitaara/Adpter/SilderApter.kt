package com.busy.looping.pitaara.Adpter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.viewpager.widget.PagerAdapter
import com.busy.looping.pitaara.R
import java.util.*

class SilderApter:PagerAdapter() {
    override fun getCount(): Int {
        return 4
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return  view==`object`
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        var itemView = LayoutInflater.from(container.context)
            .inflate(R.layout.bannerviewpage_item, container, false)
        val imageView: ImageView = itemView.findViewById<View>(R.id.sider_image) as ImageView
        imageView.setImageResource(R.drawable.banner_sample)
        Objects.requireNonNull(container).addView(itemView)
        return itemView

    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View?)
    }
}