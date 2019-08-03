package com.mredrock.cyxbs.freshman.view.activity

import android.os.Bundle
import android.view.View
import com.mredrock.cyxbs.common.ui.BaseActivity
import com.mredrock.cyxbs.freshman.R

/**
 * Create by yuanbing
 * on 2019/8/2
 */
class CampusGuidelinesActivity : BaseActivity() {
    override val isFragmentActivity: Boolean
        get() = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.freshman_activity_campus_guidelines)

        initToolbar()
    }

    private fun initToolbar() {
        common_toolbar.init(
                title = resources.getString(R.string.freshman_data_disclosure),
                listener = View.OnClickListener { finish() }
        )
    }
}