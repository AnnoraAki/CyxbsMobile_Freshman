package com.mredrock.cyxbs.freshman.view.activity

import android.content.Intent
import android.os.Bundle
import com.mredrock.cyxbs.common.ui.BaseActivity
import com.mredrock.cyxbs.freshman.R

class MainActivity : BaseActivity() {
    override val isFragmentActivity: Boolean
        get() = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.freshman_activity_main)
        val intent = Intent(this, CampusGuidelinesActivity::class.java)
        startActivity(intent)
    }
}
