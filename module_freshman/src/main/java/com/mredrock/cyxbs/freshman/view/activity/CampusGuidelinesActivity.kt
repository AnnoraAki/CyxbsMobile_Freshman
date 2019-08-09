package com.mredrock.cyxbs.freshman.view.activity

import android.graphics.Typeface
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.google.android.material.tabs.TabLayout
import com.mredrock.cyxbs.common.ui.BaseActivity
import com.mredrock.cyxbs.freshman.R
import com.mredrock.cyxbs.freshman.util.listener.FreshManOnTabSelectedListener
import kotlinx.android.synthetic.main.freshman_activity_campus_guidelines.*
import org.jetbrains.anko.textColor

/**
 * Create by yuanbing
 * on 2019/8/2
 * 学校指引
 */
class CampusGuidelinesActivity : BaseActivity() {
    override val isFragmentActivity: Boolean
        get() = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.freshman_activity_campus_guidelines)

        initToolbar()
        initTabLayout()
    }

    private fun initTabLayout() {
        tl_campus_guidelines.addOnTabSelectedListener(
                object : FreshManOnTabSelectedListener() {
                    override fun doOnTabSelected(p0: TabLayout.Tab) {
                        vp_campus_guidelines.currentItem = p0.position
                    }
                }
        )
        tl_campus_guidelines.getTabAt(0)?.select()
    }

    private fun initToolbar() {
        common_toolbar.init(
                title = resources.getString(R.string.freshman_campus_guidelines),
                listener = View.OnClickListener { finish() }
        )
    }
}