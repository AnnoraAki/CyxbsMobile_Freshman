package com.mredrock.cyxbs.freshman.view.activity

import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.Request
import com.bumptech.glide.request.target.CustomViewTarget
import com.bumptech.glide.request.target.SimpleTarget
import com.bumptech.glide.request.target.SizeReadyCallback
import com.bumptech.glide.request.target.Target
import com.bumptech.glide.request.transition.Transition
import com.mredrock.cyxbs.common.BaseApp
import com.mredrock.cyxbs.common.BaseApp.Companion.context
import com.mredrock.cyxbs.common.component.PhotoViewerActivity
import com.mredrock.cyxbs.common.utils.encrypt.Encryptor
import com.mredrock.cyxbs.common.utils.encrypt.SerialAESEncryptor
import com.mredrock.cyxbs.common.utils.encrypt.md5Encoding
import com.mredrock.cyxbs.common.utils.extensions.doPermissionAction
import com.mredrock.cyxbs.freshman.R
import com.tbruyelle.rxpermissions2.RxPermissions
import org.jetbrains.anko.find
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast
import java.io.File
import java.io.FileOutputStream
import java.text.SimpleDateFormat
import java.util.*

/**
 * Create by roger
 * on 2019/8/7
 */
fun showPhotosToMap(context: Context, photoList: List<String>, pos: Int = 0) {
    context.startActivity<PhotoMapActivity>("photos" to photoList.toTypedArray(), "position" to pos)
}

class PhotoMapActivity : PhotoViewerActivity() {


    private var btnDownload: ImageView? = null
    private var url: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        addFloatView(R.layout.freshman_activity_photo_map)
        url = intent.extras?.getStringArray("photos")?.toList()?.get(0)
        if (this.resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
            btnDownload = find(R.id.iv_download) as ImageView
            btnDownload?.setOnClickListener {
                (this as AppCompatActivity).doPermissionAction(Manifest.permission.WRITE_EXTERNAL_STORAGE) {
                    doAfterGranted {
                        Glide.with(context).asBitmap().load(url).into(object : SimpleTarget<Bitmap>() {
                            override fun onResourceReady(resource: Bitmap, transition: Transition<in Bitmap>?) {
                                com.mredrock.cyxbs.freshman.view.widget.saveImage(resource)
                            }
                        }
                        )
                    }
                }
            }
        }
    }
}
