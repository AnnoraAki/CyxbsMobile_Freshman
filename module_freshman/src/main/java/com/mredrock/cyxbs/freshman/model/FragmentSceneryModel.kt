package com.mredrock.cyxbs.freshman.model

import com.mredrock.cyxbs.freshman.base.BaseModel
import com.mredrock.cyxbs.freshman.bean.Photo
import com.mredrock.cyxbs.freshman.bean.Scenery
import com.mredrock.cyxbs.freshman.interfaces.model.IFragmentSceneryModel
import com.mredrock.cyxbs.freshman.interfaces.model.SceneryCallback

/**
 * Create by roger
 * on 2019/8/5
 */
class FragmentSceneryModel : BaseModel(), IFragmentSceneryModel {
    override fun getData(callback: SceneryCallback) {
        val photo = Photo("这是标题", "https://user-gold-cdn.xitu.io/2017/3/8/caece74a7a1545d9b9ade34fb9662ed0?imageView2/0/w/1280/h/960/format/webp/ignore-error/1")
        val list = listOf<Photo>(photo, photo, photo, photo, photo, photo, photo, photo, photo, photo, photo)
        val scenery = Scenery("这是大标题", "https://data.chinatravel.com/images/focus/water-town/head.jpg", list)
        callback.onSuccess(scenery)

    }
}