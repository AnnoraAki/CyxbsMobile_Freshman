package com.mredrock.cyxbs.freshman.model

import android.util.Log
import com.mredrock.cyxbs.common.utils.LogUtils
import com.mredrock.cyxbs.freshman.base.BaseModel
import com.mredrock.cyxbs.freshman.bean.BusRoute
import com.mredrock.cyxbs.freshman.bean.CampusAddress
import com.mredrock.cyxbs.freshman.bean.RecommendRoute
import com.mredrock.cyxbs.freshman.bean.Route
import com.mredrock.cyxbs.freshman.interfaces.model.Callback
import com.mredrock.cyxbs.freshman.interfaces.model.IFragmentRouteModel

/**
 * Create by roger
 * on 2019/8/3
 */
class FragmentRouteModel : BaseModel(),  IFragmentRouteModel{
    override fun getData(call: Callback) {
        val address = CampusAddress("重邮", "崇文路。。。。。。")
        val route = Route("标题1", "内容1111111111111111111111111111111111111111111111111111111111111111111111111111111111111")
        val route2 = Route("标题2", "内容2")
        val route3 = Route("标题3", "内容3")
        val route4 = Route("标题3", "内容311111111111111111111111111111111111111111111111111111111111111111111111111111111111111111")

        val list = listOf<Route>(route, route, route2, route3, route4)
        val recommend = RecommendRoute("大标题", list)
        val busRoute = BusRoute(200, "ok", address, recommend)
        call.onSuccess(busRoute)
        LogUtils.d("FragmentRouteModel", "start")

    }
}