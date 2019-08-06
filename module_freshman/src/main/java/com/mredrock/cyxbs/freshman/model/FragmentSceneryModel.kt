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
        val photo = Photo("这是标题ddddddd", "https://data.chinatravel.com/images/focus/water-town/head.jpg")
        val list = listOf<Photo>(photo, photo, photo, photo, photo, photo, photo, photo, photo, photo, photo)
        val scenery = Scenery("这是大标题", "https://data.chinatravel.com/images/focus/water-town/head.jpg", list)
        callback.onSuccess(scenery)
    }
}