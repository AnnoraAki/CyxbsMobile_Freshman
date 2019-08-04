package com.mredrock.cyxbs.freshman.interfaces.view

import com.mredrock.cyxbs.freshman.base.IBaseView
import com.mredrock.cyxbs.freshman.bean.CampusAddress
import com.mredrock.cyxbs.freshman.bean.Route

/**
 * Create by roger
 * on 2019/8/3
 */
interface IFragmentRouteView : IBaseView {
    fun setCampusAddress(address: CampusAddress)
    fun setRoute(routeList: List<Route>)
    fun showError()
}