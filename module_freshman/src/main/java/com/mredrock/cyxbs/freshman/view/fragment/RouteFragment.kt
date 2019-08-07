package com.mredrock.cyxbs.freshman.view.fragment

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mredrock.cyxbs.freshman.R
import com.mredrock.cyxbs.freshman.base.BaseFragment
import com.mredrock.cyxbs.freshman.bean.CampusAddress
import com.mredrock.cyxbs.freshman.bean.GroupData
import com.mredrock.cyxbs.freshman.bean.Route
import com.mredrock.cyxbs.freshman.interfaces.model.IFragmentRouteModel
import com.mredrock.cyxbs.freshman.interfaces.presenter.IFragmentRoutePresenter
import com.mredrock.cyxbs.freshman.interfaces.view.IFragmentRouteView
import com.mredrock.cyxbs.freshman.presenter.FragmentRoutePresenter
import com.mredrock.cyxbs.freshman.view.adapter.BusRecyclerAdapter
import org.jetbrains.anko.find

/**
 * Create by roger
 * on 2019/8/3
 */
class RouteFragment :
        BaseFragment<IFragmentRouteView, IFragmentRoutePresenter, IFragmentRouteModel>(), IFragmentRouteView {
    private lateinit var recyclerView: RecyclerView

    override fun setRoute(routeList: List<Route>, address: CampusAddress) {
        val list: MutableList<GroupData> = mutableListOf()
        for (value in routeList) {

            var flag = 0
            for ((index2, value2) in list.withIndex()) {
                if (value2.title == value.name) {
                    list[index2].list.add(value.route)
                    flag = 1
                    break;
                }
            }
            val data = GroupData(value.name, mutableListOf(value.route))
            if (flag == 0) {
                list.add(data)
            }
        }
        recyclerView.adapter = BusRecyclerAdapter(list, address)


    }

    override fun showError() {
    }

    override fun onCreateView(view: View, savedInstanceState: Bundle?) {
        recyclerView = view.find(R.id.rv_campus_map)
        recyclerView.layoutManager = LinearLayoutManager(activity)
        presenter?.start()
    }

    override fun getLayoutRes(): Int {
        return R.layout.freshman_fragment_campus_map
    }

    override fun getViewToAttach(): IFragmentRouteView {
        return this
    }

    override fun createPresenter(): IFragmentRoutePresenter {
        return FragmentRoutePresenter()
    }
}