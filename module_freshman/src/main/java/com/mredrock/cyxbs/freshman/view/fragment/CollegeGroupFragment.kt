package com.mredrock.cyxbs.freshman.view.fragment

import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
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
import com.mredrock.cyxbs.freshman.util.event.OnCollegeSearchResultClickEvent
import com.mredrock.cyxbs.freshman.view.adapter.CollegeGroupAdapter
import com.mredrock.cyxbs.freshman.view.adapter.SearchResultCollegeGroupAdapter
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

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
    private lateinit var mEditText: EditText

    override fun onCreateView(view: View, savedInstanceState: Bundle?) {
        mCollegeGroup = view.findViewById(R.id.rv_online_communication_group)
        mCollegeGroup.layoutManager = LinearLayoutManager(context)
        mAdapter = CollegeGroupAdapter()
        mCollegeGroup.adapter = mAdapter

        mSearchResult = view.findViewById(R.id.rv_online_communication_online_activity_search_result)
        mSearchResult.layoutManager = LinearLayoutManager(context)
        mSearchResultAdapter = SearchResultCollegeGroupAdapter()
        mSearchResult.adapter = mSearchResultAdapter

        mEditText = view.findViewById(R.id.et_recycle_item_online_communication_group_search)
        initEditText()

        presenter?.getCollegeGroup()
    }

    private fun initEditText() {
        mEditText.hint = resources.getString(R.string.freshman_hint_not_found_college_group)
        mEditText.setOnEditorActionListener { _, i, _ ->
            if (i == EditorInfo.IME_ACTION_SEARCH) {
                presenter?.search()
                true
            } else {
                false
            }
        }
        mEditText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
                presenter?.search()
            }
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
        })
        mEditText.onFocusChangeListener = View.OnFocusChangeListener { view, isFocus ->
            if (!isFocus) {
                val manager = context?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                manager.hideSoftInputFromWindow(view.windowToken, InputMethodManager.HIDE_NOT_ALWAYS)
            }
        }
    }

    override fun getLayoutRes() = R.layout.freshman_fragment_online_communication_group

    override fun getViewToAttach() = this

    override fun createPresenter() = FragmentCollegeGroupPresenter()

    override fun showCollegeGroup(collegeGroup: List<CollegeGroupText>) {
        mAdapter.mCollegeGroup = collegeGroup
    }

    override fun showSearchResult(collegeFroup: List<CollegeGroupText>) {
        mSearchResult.visible()
        mSearchResultAdapter.refreshData(collegeFroup)
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun scrollTo(event: OnCollegeSearchResultClickEvent) {
        mSearchResult.gone()
        mEditText.clearFocus()

        for (index in 0 until mAdapter.itemCount - 1) {
            if (event.name == mAdapter.mCollegeGroup[index].name) {
                mCollegeGroup.layoutManager?.scrollToPosition(index)
            }
        }
    }
}