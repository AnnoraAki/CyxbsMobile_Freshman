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
        val address = CampusAddress("重邮", "崇文路。。。。。。")
        val route = Route("标题1", listOf("1111111111111111111111111111111111111111111111111111111111111111111111111111111111111", "1111111111111111111111111111111111111111111111111111111111111111111111111111111111111"))
        val route2 = Route("标题2", listOf("内容2"))
        val route3 = Route("标题4", listOf("内容3"))
        val route4 = Route("标题5", listOf("内容311111111111111111111111111111111111111111111111111111111111111111111111111111111111111111"))

        val list = listOf<Route>(route, route2, route3, route4, route4)
        val recommend = RecommendRoute("大标题", list)
        val busRoute = BusRoute(200,"0k", address, recommend)
        call.onSuccess(busRoute)

//        ApiGenerator2.getApiService(CampusService::class.java)
//                .getRoutes()
//                .setSchedulers()
//                .safeSubscribeBy (
//                        onError = {
//                            LogUtils.d("roger", "onError")
//                        },
//                        onComplete = {
//                            LogUtils.d("roger", "onComplete")
//                        },
//                        onNext = {
//                            LogUtils.d("roger", "it = " + it.toString())
//                            call.onSuccess(it)}
//                )
//
    }
}