package com.mredrock.cyxbs.freshman.presenter

import com.mredrock.cyxbs.freshman.base.BasePresenter
import com.mredrock.cyxbs.freshman.base.IBasePresenter
import com.mredrock.cyxbs.freshman.interfaces.model.IFragmentRouteModel
import com.mredrock.cyxbs.freshman.interfaces.presenter.IFragmentRoutePresenter
import com.mredrock.cyxbs.freshman.interfaces.view.IFragmentRouteView
import com.mredrock.cyxbs.freshman.model.RouteModel

/**
 * Create by roger
 * on 2019/8/3
 */
class RoutePresenter :
        BasePresenter<IFragmentRouteView, IFragmentRouteModel>(),
        IFragmentRoutePresenter{
    override fun attachModel(): IFragmentRouteModel {
        return RouteModel()
    }
}