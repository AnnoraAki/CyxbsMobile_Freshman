package com.mredrock.cyxbs.freshman.view.fragment

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mredrock.cyxbs.common.utils.extensions.gone
import com.mredrock.cyxbs.common.utils.extensions.visible
import com.mredrock.cyxbs.freshman.R
import com.mredrock.cyxbs.freshman.base.BaseFragment
import com.mredrock.cyxbs.freshman.bean.CollegeGroupText
import com.mredrock.cyxbs.freshman.interfaces.model.IFragmentCollegeGroupModel
import com.mredrock.cyxbs.freshman.interfaces.presenter.IFragmentCollegeGroupPresenter
import com.mredrock.cyxbs.freshman.interfaces.view.IFragmentCollegeGroupView
import com.mredrock.cyxbs.freshman.presenter.FragmentCollegeGroupPresenter
import com.mredrock.cyxbs.freshman.view.adapter.CollegeGroupAdapter
import com.mredrock.cyxbs.freshman.view.adapter.SearchResultCollegeGroupAdapter

/**
 * Create by yuanbing
 * on 2019/8/3
 */
class CollegeGroupFragment : BaseFragment<IFragmentCollegeGroupView, IFragmentCollegeGroupPresenter,
        IFragmentCollegeGroupModel>(), IFragmentCollegeGroupView {
    private lateinit var mCollegeGroup: RecyclerView
    private lateinit var mAdapter: CollegeGroupAdapter
    private lateinit var mSearchResultAdapter: SearchResultCollegeGroupAdapter
    private lateinit var mSearchResult: RecyclerView

    override fun onCreateView(view: View, savedInstanceState: Bundle?) {
        mCollegeGroup = view.findViewById(R.id.rv_online_communication_group)
        mCollegeGroup.layoutManager = LinearLayoutManager(context)
        mAdapter = CollegeGroupAdapter()
        mCollegeGroup.adapter = mAdapter

        mSearchResult = view.findViewById(R.id.rv_online_communication_online_activity_search_result)
        mSearchResult.layoutManager = LinearLayoutManager(context)
        mSearchResultAdapter = SearchResultCollegeGroupAdapter()
        mSearchResult.adapter = mSearchResultAdapter

        val editText: EditText = view.findViewById(R.id.et_recycle_item_online_communication_group_search)
        editText.hint = resources.getString(R.string.freshman_hint_not_found_college_group)
        editText.setOnEditorActionListener { _, i, _ ->
            if (i == EditorInfo.IME_ACTION_SEARCH) {
                presenter?.search()
                true
            } else {
                false
            }
        }
        editText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
                mSearchResult.gone()
            }
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
        })
        editText.onFocusChangeListener = View.OnFocusChangeListener { _, _ -> mSearchResult.gone() }

        presenter?.getCollegeGroup()
    }

    override fun getLayoutRes() = R.layout.freshman_fragment_online_communication_group

    override fun getViewToAttach() = this

    override fun createPresenter() = FragmentCollegeGroupPresenter()

    override fun showCollegeGroup(collegeGroup: List<CollegeGroupText>) {
        mAdapter.refreshData(collegeGroup)
    }

    override fun showSearchResult(collegeFroup: List<CollegeGroupText>) {
        mSearchResult.visible()
        mSearchResultAdapter.refreshData(collegeFroup)
    }
}