package com.multithread.dindinntest.ui.venue

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.multithread.dindinntest.domain.entity.CategoryEntity

class VenueCategoryViewPagerAdapter(fragmentManager: FragmentManager) : FragmentPagerAdapter(
    fragmentManager, FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    private var listItem: List<CategoryEntity> = emptyList()

    override fun getCount(): Int = listItem.size

    override fun getItem(position: Int): Fragment {
        TODO("Not yet implemented")
    }

}