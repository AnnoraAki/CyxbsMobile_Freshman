package com.mredrock.cyxbs.freshman.view.activity

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.mredrock.cyxbs.common.ui.BaseActivity
import com.mredrock.cyxbs.common.utils.LogUtils
import com.mredrock.cyxbs.freshman.R
import com.mredrock.cyxbs.freshman.util.listener.FreshManOnTabSelectedListener
import com.mredrock.cyxbs.freshman.view.adapter.CampusMapPagerAdapter
import com.mredrock.cyxbs.freshman.view.fragment.RouteFragment
import com.mredrock.cyxbs.freshman.view.fragment.SceneryFragment
import kotlinx.android.synthetic.main.freshman_activity_online_communication.*
import org.jetbrains.anko.find
import org.jetbrains.anko.tableLayout

/**
 * Create by roger
 * 指路重邮
 * on 2019/8/3
 */
class CampusMapActivity : BaseActivity() {
    private lateinit var tabLayout: TabLayout
    private lateinit var viewPager: ViewPager
    override val isFragmentActivity: Boolean
        get() = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.freshman_activity_campus_map)
        initToolbar()
        tabLayout = find(R.id.tl_campus_map_activity)
        viewPager = find(R.id.vp_campus_map)
        initViewPager()
    }


    private fun initToolbar() {
        common_toolbar.init(
                title = resources.getString(R.string.freshman_campus_map),
                listener = View.OnClickListener { finish() }
        )
    }

    private fun initViewPager() {
        val adapter = CampusMapPagerAdapter(supportFragmentManager)
        viewPager.adapter = adapter
        tabLayout.setupWithViewPager(viewPager)
        tabLayout.addOnTabSelectedListener(object : FreshManOnTabSelectedListener() {
            override fun doOnTabSelected(p0: TabLayout.Tab) {
            }
        })
    }
}