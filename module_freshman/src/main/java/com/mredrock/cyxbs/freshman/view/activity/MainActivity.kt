package com.mredrock.cyxbs.freshman.view.activity

import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mredrock.cyxbs.common.BaseApp.Companion.context
import com.mredrock.cyxbs.common.ui.BaseActivity
import com.mredrock.cyxbs.common.utils.LogUtils
import com.mredrock.cyxbs.common.utils.extensions.defaultSharedPreferences
import com.mredrock.cyxbs.common.utils.extensions.editor
import com.mredrock.cyxbs.common.utils.extensions.sharedPreferences
import com.mredrock.cyxbs.freshman.view.adapter.FreshAdapter
import com.mredrock.cyxbs.freshman.R
import com.mredrock.cyxbs.freshman.view.adapter.OnItemClickListener
import com.mredrock.cyxbs.freshman.view.dialog.EnvelopDialog
import com.mredrock.cyxbs.freshman.view.widget.RotateBanner
import org.jetbrains.anko.find

class MainActivity : BaseActivity() {

    override val isFragmentActivity: Boolean
        get() = false
    private lateinit var banner: RotateBanner

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.freshman_activity_main)
        val rv = find<RecyclerView>(R.id.rv_fresh_item)
        banner = find(R.id.banner)
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
//        val shared = context.sharedPreferences("HasEnvelop")
//        if (!shared.getBoolean("envelop", false)) {
            showDialog()
//        }


    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        banner.openAnimation()
    }

    private fun showDialog() {
        val dialog = EnvelopDialog(this, R.style.FreshmanDialog_Dialog)
        dialog.show()
        context.sharedPreferences("HasEnvelop").editor {
            putBoolean("envelop", true)
        }
    }
}
