package com.mredrock.cyxbs.freshman.model

import android.util.Log
import com.mredrock.cyxbs.common.utils.LogUtils
import com.mredrock.cyxbs.common.utils.extensions.safeSubscribeBy
import com.mredrock.cyxbs.common.utils.extensions.setSchedulers
import com.mredrock.cyxbs.freshman.base.BaseModel
import com.mredrock.cyxbs.freshman.bean.BusRoute
import com.mredrock.cyxbs.freshman.bean.CampusAddress
import com.mredrock.cyxbs.freshman.bean.RecommendRoute
import com.mredrock.cyxbs.freshman.bean.Route
import com.mredrock.cyxbs.freshman.interfaces.model.Callback
import com.mredrock.cyxbs.freshman.interfaces.model.IFragmentRouteModel
import com.mredrock.cyxbs.freshman.interfaces.network.CampusService
import com.mredrock.cyxbs.freshman.util.network.ApiGenerator2

/**
 * Create by roger
 * on 2019/8/3
 */
class FragmentRouteModel : BaseModel(),  IFragmentRouteModel{
    override fun getData(call: Callback) {

        ApiGenerator2.getApiService(CampusService::class.java)
                .getRoutes()
                .setSchedulers()
                .safeSubscribeBy (
                        onError = {
                        },
                        onComplete = {
                        },
                        onNext = {
                            call.onSuccess(it)}
                )

    }
}