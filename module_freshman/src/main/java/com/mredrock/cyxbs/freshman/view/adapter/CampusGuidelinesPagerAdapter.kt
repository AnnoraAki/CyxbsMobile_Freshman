package com.mredrock.cyxbs.freshman.view.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.mredrock.cyxbs.freshman.view.fragment.DataDisclosureFragment

class CampusGuidelinesPagerAdapter(manager: FragmentManager) : FragmentPagerAdapter(manager) {
    private val mFragments: List<Fragment> = listOf(
            DataDisclosureFragment()
    )

    override fun getItem(position: Int) = mFragments[position]

    override fun getCount() = mFragments.size
}