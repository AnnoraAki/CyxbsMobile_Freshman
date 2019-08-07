package com.mredrock.cyxbs.freshman.view.activity

import android.os.Bundle
import android.widget.TextView
import androidx.viewpager.widget.ViewPager
import com.mredrock.cyxbs.common.ui.BaseActivity
import com.mredrock.cyxbs.freshman.R
import com.mredrock.cyxbs.freshman.view.adapter.PhotoSceneryPagerAdapter
import org.jetbrains.anko.find
import java.lang.StringBuilder

/**
 * Create by roger
 * on 2019/8/6
 */
class PhotoSceneryActivity : BaseActivity() {
    private lateinit var viewPager: ViewPager
    private lateinit var list: List<String>
    private lateinit var tv: TextView
    private var currentPosition: Int = 1
    override val isFragmentActivity: Boolean
        get() = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.freshman_activity_photo_scenery)
        tv = find(R.id.tv_photo_scenery)
        val intent = intent
        if (intent != null) {
            val b = intent.extras
            if (b != null) {
                if (b.containsKey("info")) {
                    list = b.getStringArrayList("info")!!
                }
                if (b.containsKey("position")) {
                    currentPosition = b.getInt("position")
                }
            }
        }
        tv.text = StringBuilder().append(currentPosition).append("/").append(list.size)
        viewPager = find(R.id.vp_photo_scenery)
        viewPager.adapter = PhotoSceneryPagerAdapter(list, this)
        viewPager.setCurrentItem(currentPosition)
        viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {

            }

            override fun onPageSelected(position: Int) {
            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
                currentPosition = position
                tv.text = StringBuilder().append(currentPosition + 1).append("/").append(list.size)

            }

        })
    }
}