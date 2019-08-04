package com.mredrock.cyxbs.freshman.view.fragment

import android.os.Bundle
import android.view.View
import com.mredrock.cyxbs.common.utils.LogUtils
import com.mredrock.cyxbs.freshman.R
import com.mredrock.cyxbs.freshman.base.BaseFragment
import com.mredrock.cyxbs.freshman.bean.CampusAddress
import com.mredrock.cyxbs.freshman.bean.Route
import com.mredrock.cyxbs.freshman.interfaces.model.IFragmentRouteModel
import com.mredrock.cyxbs.freshman.interfaces.presenter.IFragmentRoutePresenter
import com.mredrock.cyxbs.freshman.interfaces.view.IFragmentRouteView
import com.mredrock.cyxbs.freshman.presenter.FragmentRoutePresenter

/**
 * Create by roger
 * on 2019/8/3
 */
class RouteFragment :
    BaseFragment<IFragmentRouteView, IFragmentRoutePresenter, IFragmentRouteModel>(), IFragmentRouteView{
    override fun setCampusAddress(address: CampusAddress) {
        LogUtils.d("RouteFragment", address.toString())

    }

    override fun setRoute(routeList: List<Route>) {
        LogUtils.d("RouteFragment", routeList.get(0).toString())

    }

    override fun showError() {
    }

    override fun onCreateView(view: View, savedInstanceState: Bundle?) {
        presenter?.start()
    }

    override fun getLayoutRes(): Int {
        return R.layout.freshman_recycle_item_footer
    }

    override fun getViewToAttach(): IFragmentRouteView {
        return this
    }

    override fun createPresenter(): IFragmentRoutePresenter {
        return FragmentRoutePresenter()
    }
}