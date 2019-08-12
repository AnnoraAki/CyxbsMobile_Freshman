package com.mredrock.cyxbs.freshman.model

import com.mredrock.cyxbs.common.utils.LogUtils
import com.mredrock.cyxbs.common.utils.extensions.safeSubscribeBy
import com.mredrock.cyxbs.common.utils.extensions.setSchedulers
import com.mredrock.cyxbs.freshman.base.BaseModel
import com.mredrock.cyxbs.freshman.bean.Photo
import com.mredrock.cyxbs.freshman.bean.Scenery
import com.mredrock.cyxbs.freshman.interfaces.model.IFragmentSceneryModel
import com.mredrock.cyxbs.freshman.interfaces.model.SceneryCallback
import com.mredrock.cyxbs.freshman.interfaces.network.CampusService
import com.mredrock.cyxbs.freshman.interfaces.network.SceneryService
import com.mredrock.cyxbs.freshman.util.network.ApiGenerator

/**
 * Create by roger
 * on 2019/8/5
 */
class FragmentSceneryModel : BaseModel(), IFragmentSceneryModel {
    override fun getData(callback: SceneryCallback) {

//        val photo = Photo("这是标题ddddddd", "https://data.chinatravel.com/images/focus/water-town/head.jpg")
//        val list = listOf<Photo>(photo, photo, photo, photo, photo, photo, photo, photo, photo, photo, photo)
//        val scenery = Scenery("这是大标题", "https://data.chinatravel.com/images/focus/water-town/head.jpg", list)
//        callback.onSuccess(scenery)

        ApiGenerator.getApiService(SceneryService::class.java)
                .getPhotos()
                .setSchedulers()
                .safeSubscribeBy (
                        onError = {
                        },
                        onComplete = {
                        },
                        onNext = {
                            callback.onSuccess(it.text)
                            //没数据
                            LogUtils.d("roger", it.toString())
                        }
                )
    }
}