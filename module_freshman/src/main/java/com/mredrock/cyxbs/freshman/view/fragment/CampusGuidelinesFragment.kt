package com.mredrock.cyxbs.freshman.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.mredrock.cyxbs.common.ui.BaseFragment
import com.mredrock.cyxbs.freshman.R
import com.mredrock.cyxbs.freshman.bean.DormitoryAndCanteenText
import com.mredrock.cyxbs.freshman.util.listener.FreshmanOnSecondTabSelectedListener
import com.mredrock.cyxbs.freshman.view.adapter.CampusGuidelinesPagerAdapter

class CampusGuidelinesFragment(val data: DormitoryAndCanteenText) : BaseFragment() {
    private lateinit var mTab: TabLayout
    private lateinit var mViewPager: ViewPager
    private lateinit var mAdapter: CampusGuidelinesPagerAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.freshman_fragment_campus_guidelines, container, false)
        mTab = view.findViewById(R.id.tl_campus_guidelines_second)
        mViewPager = view.findViewById(R.id.vp_campus_guidelines_second)
        initTabLayout()
        initViewPager()
        return view
    }

    private fun initTabLayout() {
        if (data.message.size > 4) mTab.tabMode = TabLayout.MODE_SCROLLABLE
        for (message in data.message) {
            val tab = mTab.newTab()
            tab.text = message.name
            mTab.addTab(tab)
        }
        mTab.addOnTabSelectedListener(
                object : FreshmanOnSecondTabSelectedListener() {
                    override fun doOnTabSelected(p0: TabLayout.Tab) {
                        mViewPager.currentItem = p0.position
                    }
                }
        )
        mTab.getTabAt(0)?.select()
    }

    private fun initViewPager() {
        mAdapter = CampusGuidelinesPagerAdapter(childFragmentManager)
        mViewPager.adapter = mAdapter
        mAdapter.refreshData(List(data.message.size) { DormitoryAndCanteenFragment(data.message[it]) })
        mViewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {}
            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {}
            override fun onPageSelected(position: Int) {
                mTab.getTabAt(position)?.select()
            }
        })
    }
}