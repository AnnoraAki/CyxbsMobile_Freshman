package com.mredrock.cyxbs.freshman.view.activity

import android.os.Bundle
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
    }
}