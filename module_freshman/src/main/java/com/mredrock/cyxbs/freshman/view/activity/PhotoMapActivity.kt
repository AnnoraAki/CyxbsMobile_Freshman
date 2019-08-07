package com.mredrock.cyxbs.freshman.view.activity

import android.os.Bundle
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.mredrock.cyxbs.common.ui.BaseActivity
import com.mredrock.cyxbs.freshman.R
import org.jetbrains.anko.find

/**
 * Create by roger
 * on 2019/8/7
 */
class PhotoMapActivity : BaseActivity() {
    private  var url: String? = null
    private lateinit var iv: ImageView
    override val isFragmentActivity: Boolean
        get() = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.freshman_activity_photo_map)
        if (intent != null) {
            val b = intent.extras
            if (b != null) {
                if (b.containsKey("photo")) {
                    url = b.getString("photo")
                }
            }
        }
        iv = find(R.id.iv_photo_map)
        val options = RequestOptions().centerCrop()
        Glide.with(this).load(url).apply(options).into(iv)
    }
}