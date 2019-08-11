package com.mredrock.cyxbs.freshman.view.activity

import android.graphics.Typeface
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.mredrock.cyxbs.common.ui.BaseActivity
import com.mredrock.cyxbs.freshman.R
import com.mredrock.cyxbs.freshman.util.event.SexRatoEvent
import com.mredrock.cyxbs.freshman.util.event.SubjectDataEvent
import com.mredrock.cyxbs.freshman.util.listener.FreshManOnTabSelectedListener
import com.mredrock.cyxbs.freshman.view.adapter.DataDisclosurePagerAdapter
import kotlinx.android.synthetic.main.freshman_activity_data_disclosure.*
import org.greenrobot.eventbus.EventBus
import org.jetbrains.anko.textColor

/**
 * Create by yuanbing
 * on 2019/8/2
 * 数据揭秘
 */
class DataDisclosureActivity: BaseActivity() {
    override val isFragmentActivity: Boolean
        get() = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.freshman_activity_data_disclosure)

        initToolbar()
        initViewPager()
        initTabLayout()
    }

    private fun initViewPager() {
        vp_data_disclosure.adapter = DataDisclosurePagerAdapter(supportFragmentManager)
        vp_data_disclosure.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {}
            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {}
            override fun onPageSelected(position: Int) {
                tl_data_disclosure.getTabAt(position)?.select()
                when(position) {
                    0 -> {
                        EventBus.getDefault().post(SubjectDataEvent(true))
                        EventBus.getDefault().post(SexRatoEvent(false))
                    }
                    1 -> {
                        EventBus.getDefault().post(SexRatoEvent(true))
                        EventBus.getDefault().post(SubjectDataEvent(false))
                    }
                }
            }
        })
    }

    private fun initTabLayout() {
        tl_data_disclosure.addOnTabSelectedListener(
                object : FreshManOnTabSelectedListener() {
                    override fun doOnTabSelected(p0: TabLayout.Tab) {
                        vp_data_disclosure.currentItem = p0.position
                        when(p0.position) {
                            0 -> {
                                EventBus.getDefault().post(SubjectDataEvent(true))
                                EventBus.getDefault().post(SexRatoEvent(false))
                            }
                            1 -> {
                                EventBus.getDefault().post(SexRatoEvent(true))
                                EventBus.getDefault().post(SubjectDataEvent(false))
                            }
                        }
                    }
                }
        )
        tl_data_disclosure.getTabAt(0)?.select()
    }

    private fun initToolbar() {
        common_toolbar.init(
                title = resources.getString(R.string.freshman_data_disclosure),
                listener = View.OnClickListener { finish() }
        )
    }
}