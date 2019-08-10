package com.mredrock.cyxbs.freshman.view.activity

import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mredrock.cyxbs.common.ui.BaseActivity
import com.mredrock.cyxbs.freshman.view.adapter.FreshAdapter
import com.mredrock.cyxbs.freshman.R
import com.mredrock.cyxbs.freshman.view.adapter.OnItemClickListener
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

        adapter.setOnItemClickListener(object : OnItemClickListener {
            override fun onItemClick(position: Int) {
                when (position) {

                    1 -> {
                        val intent = Intent(this@MainActivity, EnrollmentRequirementsActivity::class.java)
                        startActivity(intent)
                    }
                    2 -> {
                        val intent = Intent(this@MainActivity, CampusMapActivity::class.java)
                        startActivity(intent)
                    }
                    3 -> {
                        val intent = Intent(this@MainActivity, EnrollmentProcessActivity::class.java)
                        startActivity(intent)
                    }
                    4 -> {
                        val intent = Intent(this@MainActivity, CampusGuidelinesActivity::class.java)
                        startActivity(intent)
                    }
                    5 -> {
                        val intent = Intent(this@MainActivity, OnlineCommunicationActivity::class.java)
                        startActivity(intent)
                    }
                    6 -> {
                        val intent = Intent(this@MainActivity, MoreActivity::class.java)
                        startActivity(intent)
                    }
                }
            }
        })
        rv.adapter = adapter
    }
}
