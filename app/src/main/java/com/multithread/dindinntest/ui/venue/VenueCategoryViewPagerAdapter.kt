package com.multithread.dindinntest.ui.venue

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.multithread.dindinntest.data.dto.CategoryDTO
import com.multithread.dindinntest.domain.entity.CategoryEntity
import com.multithread.dindinntest.ui.venue.category.CategoryFragment

class VenueCategoryViewPagerAdapter(fragmentManager: FragmentManager) : FragmentPagerAdapter(
        fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    var itemList: List<CategoryEntity> = emptyList()
        set(value) {
            field = value
            if (field.isNotEmpty())
                notifyDataSetChanged()
        }

    override fun getCount(): Int = itemList.size

    override fun getItem(position: Int): Fragment = CategoryFragment.createsInstance(itemList[position])

    override fun getPageTitle(position: Int): CharSequence? {
        return itemList[position].name
    }

}