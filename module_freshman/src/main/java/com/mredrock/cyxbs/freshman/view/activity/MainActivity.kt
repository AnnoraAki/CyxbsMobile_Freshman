package com.mredrock.cyxbs.freshman.view.activity

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mredrock.cyxbs.common.ui.BaseActivity
import com.mredrock.cyxbs.freshman.view.adapter.FreshAdapter
import com.mredrock.cyxbs.freshman.R
import org.jetbrains.anko.find

class MainActivity : BaseActivity() {
    override val isFragmentActivity: Boolean
        get() = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.freshman_activity_main)
        val rv = find<RecyclerView>(R.id.rv_fresh_item)
        val layoutManager = LinearLayoutManager(this)
        rv.layoutManager = layoutManager
        val adapter = FreshAdapter()
        rv.adapter = adapter
    }
}
