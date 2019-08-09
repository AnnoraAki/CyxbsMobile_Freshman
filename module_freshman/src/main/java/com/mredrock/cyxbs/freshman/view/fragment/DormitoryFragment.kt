package com.mredrock.cyxbs.freshman.view.fragment

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.tabs.TabLayout
import com.mredrock.cyxbs.freshman.R
import com.mredrock.cyxbs.freshman.base.BaseFragment
import com.mredrock.cyxbs.freshman.bean.DormitoryAndCanteenMessage
import com.mredrock.cyxbs.freshman.interfaces.model.IFragmentDormitoryModel
import com.mredrock.cyxbs.freshman.interfaces.presenter.IFragmentDormitoryPresenter
import com.mredrock.cyxbs.freshman.interfaces.view.IFragmentDormitoryView
import com.mredrock.cyxbs.freshman.view.adapter.DormitoryAndCanteenAdapter
import com.mredrock.cyxbs.freshman.presenter.FragmentDormitoryPresenter

/**
 * Create by yuanbing
 * on 2019/8/7
 */
class DormitoryFragment :
        BaseFragment<IFragmentDormitoryView, IFragmentDormitoryPresenter, IFragmentDormitoryModel>(),
        IFragmentDormitoryView {
    private lateinit var mDormitory: RecyclerView
    private lateinit var mAdapter: DormitoryAndCanteenAdapter
    private lateinit var mDormitoryTab: TabLayout

    override fun onCreateView(view: View, savedInstanceState: Bundle?) {
        mDormitory = view.findViewById(R.id.scroll_enable_view_pager_campus_guidelines_second)
        mDormitory.layoutManager = LinearLayoutManager(context)
        mAdapter = DormitoryAndCanteenAdapter()
        mDormitory.adapter = mAdapter
        mDormitoryTab = view.findViewById(R.id.tl_campus_guidelines_second)
    }

    override fun getLayoutRes() = R.layout.freshman_fragment_campus_guidelines

    override fun getViewToAttach() = this

    override fun createPresenter() = FragmentDormitoryPresenter()

    override fun showDormitory(dormitory: List<String>) {

    }

    override fun showDormitoryInfo(info: List<DormitoryAndCanteenMessage>) {
//        mAdapter.refreshData(info)
    }
}