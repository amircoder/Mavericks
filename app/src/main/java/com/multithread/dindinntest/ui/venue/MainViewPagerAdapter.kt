package com.multithread.dindinntest.ui.venue

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import com.multithread.dindinntest.R
import com.multithread.dindinntest.util.ImageLoader

class MainViewPagerAdapter(private val context: Context,
                           private val imageLoader: ImageLoader) : PagerAdapter() {

    var itemList: List<String> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        return LayoutInflater.from(context).run {
            inflate(R.layout.item_main_viewpager_cover, container, false).apply {
                container.addView(this)
                imageLoader.loadImage(
                    this.findViewById(R.id.item_view_pager_cover_image_view),0,0,
                    itemList[position],

                )
            }
        }
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
//        super.destroyItem(container, position, `object`)
    }

    override fun getCount(): Int = itemList.size

    override fun isViewFromObject(view: View, `object`: Any): Boolean = view == `object`

}