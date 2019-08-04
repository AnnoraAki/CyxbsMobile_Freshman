package com.mredrock.cyxbs.freshman.view.fragment

import android.os.Bundle
import android.view.View
import android.widget.ExpandableListView
import android.widget.TextView
import com.mredrock.cyxbs.common.utils.LogUtils
import com.mredrock.cyxbs.freshman.R
import com.mredrock.cyxbs.freshman.base.BaseFragment
import com.mredrock.cyxbs.freshman.bean.CampusAddress
import com.mredrock.cyxbs.freshman.bean.GroupData
import com.mredrock.cyxbs.freshman.bean.Route
import com.mredrock.cyxbs.freshman.interfaces.model.IFragmentRouteModel
import com.mredrock.cyxbs.freshman.interfaces.presenter.IFragmentRoutePresenter
import com.mredrock.cyxbs.freshman.interfaces.view.IFragmentRouteView
import com.mredrock.cyxbs.freshman.presenter.FragmentRoutePresenter
import com.mredrock.cyxbs.freshman.view.adapter.RouteExpandableAdapter
import org.jetbrains.anko.find
import org.jetbrains.anko.support.v4.find

/**
 * Create by roger
 * on 2019/8/3
 */
class RouteFragment :
    BaseFragment<IFragmentRouteView, IFragmentRoutePresenter, IFragmentRouteModel>(), IFragmentRouteView{
    private lateinit var exListView: ExpandableListView
    private lateinit var schoolName: TextView
    private lateinit var address: TextView
    private lateinit var copy: TextView

    override fun setCampusAddress(address: CampusAddress) {
        schoolName.text = address.title
        this.address.text = address.message

    }

    override fun setRoute(routeList: List<Route>) {
        val list: MutableList<GroupData> = mutableListOf()
        for ((index, value) in routeList.withIndex()) {

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
        exListView.setAdapter(RouteExpandableAdapter(this.context!!, list))


    }

    override fun showError() {
    }

    override fun onCreateView(view: View, savedInstanceState: Bundle?) {
        exListView = view.findViewById(R.id.exlv_campus_map)
        schoolName = view.findViewById(R.id.tv_school_name)
        address = view.findViewById(R.id.tv_school_address)
        copy = view.findViewById(R.id.tv_copy)
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