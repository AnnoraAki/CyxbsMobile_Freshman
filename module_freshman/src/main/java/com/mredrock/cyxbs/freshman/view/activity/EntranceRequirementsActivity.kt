package com.mredrock.cyxbs.freshman.view.activity

import android.os.Bundle
import android.view.View
import com.mredrock.cyxbs.common.ui.BaseActivity
import com.mredrock.cyxbs.freshman.R

/**
 * Create by yuanbing
 * on 2019/8/3
 * 入学必备
 */
class EntranceRequirementsActivity : BaseActivity() {
    override val isFragmentActivity: Boolean
        get() = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.freshman_activity_entrance_requirements)

        initToolbar()
    }

    private fun initToolbar() {
        common_toolbar.init(
                title = applicationContext.resources.getString(R.string.freshman_enrollment_requirement),
                listener = View.OnClickListener { finish() }
        )
    }
}