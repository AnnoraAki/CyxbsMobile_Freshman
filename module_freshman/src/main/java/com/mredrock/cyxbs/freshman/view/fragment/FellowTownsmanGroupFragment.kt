package com.mredrock.cyxbs.freshman.view.fragment

import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mredrock.cyxbs.freshman.R
import com.mredrock.cyxbs.freshman.base.BaseFragment
import com.mredrock.cyxbs.freshman.bean.FellowTownsmanGroupText
import com.mredrock.cyxbs.freshman.interfaces.model.IFragmentFellowTownsmanGroupModel
import com.mredrock.cyxbs.freshman.interfaces.presenter.IFragmentFellowTownsmanGroupPresenter
import com.mredrock.cyxbs.freshman.interfaces.view.IFragmentFellowTownsmanGroupView
import com.mredrock.cyxbs.freshman.presenter.FragmentFellowTownsmanGroupPresenter
import com.mredrock.cyxbs.freshman.view.adapter.FellowTownsmanGroupAdapter

/**
 * Create by yuanbing
 * on 2019/8/4
 */
class FellowTownsmanGroupFragment : BaseFragment<IFragmentFellowTownsmanGroupView,
        IFragmentFellowTownsmanGroupPresenter, IFragmentFellowTownsmanGroupModel>(),
        IFragmentFellowTownsmanGroupView {
    override fun showSearchResult(fellowTownsmanGroup: List<FellowTownsmanGroupText>) {

    }

    private lateinit var mAdapter: FellowTownsmanGroupAdapter
    private lateinit var mFellowTownsmanGroup: RecyclerView

    override fun onCreateView(view: View, savedInstanceState: Bundle?) {
        mFellowTownsmanGroup = view.findViewById(R.id.rv_online_communication_group)
        mAdapter = FellowTownsmanGroupAdapter()
        mFellowTownsmanGroup.adapter = mAdapter
        mFellowTownsmanGroup.layoutManager = LinearLayoutManager(context)
        view.findViewById<EditText>(R.id.et_recycle_item_online_communication_group_search).hint =
                resources.getString(R.string.freshman_hint_not_found_fellow_townsman_group)

        presenter?.getFellowTownsmanGroup()
    }

    override fun getLayoutRes() = R.layout.freshman_fragment_online_communication_group

    override fun getViewToAttach() = this

    override fun createPresenter() = FragmentFellowTownsmanGroupPresenter()

    override fun showFellowTownsmanGroup(fellowTownsmanGroup: List<FellowTownsmanGroupText>) {
        mAdapter.refreshData(fellowTownsmanGroup)
    }
}