package com.mredrock.cyxbs.freshman.view.activity

import android.os.Bundle
import android.view.View
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.tabs.TabLayout
import com.mredrock.cyxbs.common.ui.BaseActivity
import com.mredrock.cyxbs.common.utils.LogUtils
import com.mredrock.cyxbs.freshman.R
import com.mredrock.cyxbs.freshman.view.fragment.RouteFragment
import com.mredrock.cyxbs.freshman.view.fragment.SceneryFragment
import org.jetbrains.anko.find

/**
 * Create by roger
 * 指路重邮
 * on 2019/8/3
 */
class CampusMapActivity : BaseActivity() {
    private lateinit var tabLayout: TabLayout
    private var routeFragment: RouteFragment? = null
    private var sceneryFragment: SceneryFragment? = null
    private var position: Int = 0
    override val isFragmentActivity: Boolean
        get() = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.freshman_activity_campus_map)
        initToolbar()
        tabLayout = find(R.id.tl_campus_map_activity)
        initData(savedInstanceState)
        showFragment(0)
    }




    private fun initToolbar() {
        common_toolbar.init(
                title = resources.getString(R.string.freshman_campus_map),
                listener = View.OnClickListener { finish() }
        )
    }

    private fun showFragment(index: Int) {
        val ft = supportFragmentManager.beginTransaction()
        position = index
        hideFragment(ft)
        when (index) {
            0 -> {
                LogUtils.d("CampusMap", "showFragment():" + index  )
                if (routeFragment == null) {
                    routeFragment = RouteFragment()
                    ft.add(R.id.fl_campus_map_container, routeFragment!!, RouteFragment::class.java.name)
                } else {
                    ft.show(routeFragment!!)
                }
            }
            1 -> {
                if (sceneryFragment == null) {
                    sceneryFragment = SceneryFragment()
                    ft.add(R.id.fl_campus_map_container, sceneryFragment!!, SceneryFragment::class.java.name)
                } else {
                    ft.show(sceneryFragment!!)
                }
            }
            else -> throw Exception("不支持")
        }
        ft.commit()
    }

    private fun hideFragment(ft: FragmentTransaction) {
        routeFragment?.let { ft.hide(it) }
        sceneryFragment?.let { ft.hide(it) }
    }

    private fun initData(savedInstanceState: Bundle?) {
        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabReselected(p0: TabLayout.Tab?) {
            }

            override fun onTabUnselected(p0: TabLayout.Tab?) {
            }

            override fun onTabSelected(p0: TabLayout.Tab?) {
                p0?.let {showFragment(it.position)}
            }

        })

    }
}