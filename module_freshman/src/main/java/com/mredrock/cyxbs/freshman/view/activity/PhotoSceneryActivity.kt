package com.mredrock.cyxbs.freshman.view.activity

import android.Manifest
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.SimpleTarget
import com.bumptech.glide.request.transition.Transition
import com.mredrock.cyxbs.common.BaseApp
import com.mredrock.cyxbs.common.component.PhotoViewerActivity
import com.mredrock.cyxbs.common.utils.encrypt.md5Encoding
import com.mredrock.cyxbs.common.utils.extensions.doPermissionAction
import com.mredrock.cyxbs.freshman.R
import org.jetbrains.anko.find
import org.jetbrains.anko.startActivity
import java.io.File
import java.io.FileOutputStream
import java.util.*

/**
 * Create by roger
 * on 2019/8/6
 */
fun showPhotosToScenery(context: Context, photoList: List<String>, pos: Int = 0) {
    context.startActivity<PhotoSceneryActivity>("photos" to photoList.toTypedArray(), "position" to pos)
}

class PhotoSceneryActivity : PhotoViewerActivity() {
    private lateinit var list2: List<String>
    private var curPos2: Int = 0
    private lateinit var viewPager: ViewPager
    private var btnDownload: ImageView? = null

    private lateinit var tvPos: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        addFloatView(R.layout.freshman_activity_photo_scenery)
        viewPager = find(R.id.vp_photo)
        list2 = intent.extras?.getStringArray("photos")?.toList()!!
        curPos2 = intent.extras?.getInt("position")!!
        tvPos = find(R.id.tv_photo_scenery)
        tvPos.text = StringBuilder().append(curPos2 + 1).append("/").append(list2.size)
        btnDownload = find(R.id.iv_download_scenery) as ImageView
        btnDownload?.setOnClickListener {
            (this as AppCompatActivity).doPermissionAction(Manifest.permission.WRITE_EXTERNAL_STORAGE) {
                doAfterGranted {
                    Glide.with(BaseApp.context).asBitmap().load(list2[curPos2]).into(object : SimpleTarget<Bitmap>() {
                        override fun onResourceReady(resource: Bitmap, transition: Transition<in Bitmap>?) {
                            saveImage(resource)
                        }
                    }
                    )
                }
            }
        }
        viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {
            }

            override fun onPageSelected(position: Int) {
                curPos2 = position
                tvPos.text = StringBuilder().append(curPos2 + 1).append("/").append(list2.size)

            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
            }
        })
    }
}

private fun saveImage(resource: Bitmap) {
    val file = File(BaseApp.context.externalMediaDirs[0]?.absolutePath
            + File.separator
            + "Map"
            + File.separator
            + md5Encoding(Random(3).toString())
            + ".jpg")
    val parentDir = file.parentFile
    if (parentDir.exists()) parentDir.delete()
    parentDir.mkdir()
    file.createNewFile()
    val fos = FileOutputStream(file)
    resource.compress(Bitmap.CompressFormat.JPEG, 100, fos)
    fos.close()
    galleryAddPic(file.path);
    Toast.makeText(BaseApp.context, "图片已保存在" + file.name, Toast.LENGTH_LONG).show()
}

//更新相册
private fun galleryAddPic(imagePath: String) {
    val mediaScanIntent = Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE)
    val f = File(imagePath)
    val contentUri = Uri.fromFile(f)
    mediaScanIntent.setData(contentUri)
    BaseApp.context.sendBroadcast(mediaScanIntent)
}