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
import com.mredrock.cyxbs.freshman.bean.FellowTownsmanGroupText
import com.mredrock.cyxbs.freshman.interfaces.model.IFragmentFellowTownsmanGroupModel
import com.mredrock.cyxbs.freshman.interfaces.presenter.IFragmentFellowTownsmanGroupPresenter
import com.mredrock.cyxbs.freshman.interfaces.view.IFragmentFellowTownsmanGroupView
import com.mredrock.cyxbs.freshman.presenter.FragmentFellowTownsmanGroupPresenter
import com.mredrock.cyxbs.freshman.util.event.OnFellowTownsmanSearchResultClickEvent
import com.mredrock.cyxbs.freshman.view.adapter.FellowTownsmanGroupAdapter
import com.mredrock.cyxbs.freshman.view.adapter.SearchResultFellowTownsmanAdapter
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

/**
 * Create by yuanbing
 * on 2019/8/4
 */
class FellowTownsmanGroupFragment : BaseFragment<IFragmentFellowTownsmanGroupView,
        IFragmentFellowTownsmanGroupPresenter, IFragmentFellowTownsmanGroupModel>(),
        IFragmentFellowTownsmanGroupView {
    private lateinit var mAdapter: FellowTownsmanGroupAdapter
    private lateinit var mFellowTownsmanGroup: RecyclerView
    private lateinit var mSearchResult: RecyclerView
    private lateinit var mEditText: EditText
    private lateinit var mSearchResultAdapter: SearchResultFellowTownsmanAdapter

    override fun onCreateView(view: View, savedInstanceState: Bundle?) {
        mFellowTownsmanGroup = view.findViewById(R.id.rv_online_communication_group)
        mAdapter = FellowTownsmanGroupAdapter()
        mFellowTownsmanGroup.adapter = mAdapter
        mFellowTownsmanGroup.layoutManager = LinearLayoutManager(context)
        mEditText = view.findViewById(R.id.et_recycle_item_online_communication_group_search)
        mSearchResult = view.findViewById(R.id.rv_online_communication_online_activity_search_result)
        mSearchResultAdapter = SearchResultFellowTownsmanAdapter()
        mSearchResult.adapter = mSearchResultAdapter
        mSearchResult.layoutManager = LinearLayoutManager(context)

        initEditText()

        presenter?.getFellowTownsmanGroup()
    }

    private fun initEditText() {
        mEditText.hint = resources.getString(R.string.freshman_hint_not_found_fellow_townsman_group)
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

    override fun createPresenter() = FragmentFellowTownsmanGroupPresenter()

    override fun showFellowTownsmanGroup(fellowTownsmanGroup: List<FellowTownsmanGroupText>) {
        mAdapter.mFellowTownsmanGroup = fellowTownsmanGroup
    }

    override fun showSearchResult(fellowTownsmanGroup: List<FellowTownsmanGroupText>) {
        mSearchResult.visible()
        mSearchResultAdapter.refreshData(fellowTownsmanGroup)
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun scrollTo(event: OnFellowTownsmanSearchResultClickEvent) {
        mSearchResult.gone()
        mEditText.clearFocus()

        for (index in 0 until mAdapter.itemCount - 1) {
            if (event.name == mAdapter.mFellowTownsmanGroup[index].name) {
                mFellowTownsmanGroup.layoutManager?.scrollToPosition(index)
            }
        }
    }
}