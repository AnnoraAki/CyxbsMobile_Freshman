package com.mredrock.cyxbs.freshman.view.activity

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mredrock.cyxbs.common.ui.BaseActivity
import com.mredrock.cyxbs.freshman.R
import com.mredrock.cyxbs.freshman.view.adapter.MoreAdapter
import org.jetbrains.anko.find


/**
 * Create by roger
 * on 2019/8/3
 */
class MoreActivity : BaseActivity() {
    override val isFragmentActivity: Boolean
        get() = false

    private lateinit var recyclerView: RecyclerView

    private fun initToolbar() {
        common_toolbar.init(
                title = resources.getString(R.string.freshman_more),
                listener = View.OnClickListener { finish() }
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.freshman_activity_more)
        initToolbar()
        recyclerView = find(R.id.rv_more)
        val adapter = MoreAdapter()
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
    }
}