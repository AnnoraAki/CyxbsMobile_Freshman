package com.mredrock.cyxbs.freshman.view.activity

import android.os.Bundle
import android.view.View
import com.google.android.material.tabs.TabLayout
import com.mredrock.cyxbs.common.ui.BaseActivity
import com.mredrock.cyxbs.freshman.R
import kotlinx.android.synthetic.main.freshman_activity_online_communication.*

/**
 * Create by yuanbing
 * on 2019/8/3
 * 在线交流
 */
class OnlineCommunicationActivity : BaseActivity() {
    override val isFragmentActivity: Boolean
        get() = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.freshman_activity_online_communication)

        initToolbar()
        initViewPager()
        initTabLayout()
    }

    private fun initToolbar() {
        common_toolbar.init(
                title = resources.getString(R.string.freshman_online_communication),
                listener = View.OnClickListener { finish() }
        )
    }

    private fun initViewPager() {
        val manager = supportFragmentManager

    }

    private fun initTabLayout() {
        tl_online_communication.addOnTabSelectedListener(
            object : TabLayout.BaseOnTabSelectedListener<TabLayout.Tab>{
                override fun onTabReselected(p0: TabLayout.Tab?) {}

                override fun onTabUnselected(p0: TabLayout.Tab?) {}

                override fun onTabSelected(p0: TabLayout.Tab?) {
                    if (p0 == null) return
                    vp_online_communication.currentItem = p0.position
                }
            }
        )
    }
}