package com.mredrock.cyxbs.freshman.view.fragment

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Rect
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View
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
import com.mredrock.cyxbs.freshman.util.decoration.SearchResultItemDecoration
import com.mredrock.cyxbs.freshman.view.adapter.CollegeGroupAdapter
import com.mredrock.cyxbs.freshman.view.adapter.SearchResultCollegeGroupAdapter
import org.jetbrains.anko.hintTextColor
import org.jetbrains.anko.support.v4.dip

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
    private lateinit var mManager: InputMethodManager
    private var mSearchResultMaxHeight = 0

    override fun onCreateView(view: View, savedInstanceState: Bundle?) {
        mCollegeGroup = view.findViewById(R.id.rv_online_communication_group)
        mCollegeGroup.layoutManager = LinearLayoutManager(context)
        mAdapter = CollegeGroupAdapter()
        mCollegeGroup.adapter = mAdapter

        mSearchResult = view.findViewById(R.id.rv_online_communication_online_activity_search_result)
        mSearchResult.layoutManager = LinearLayoutManager(context)
        mSearchResultAdapter = SearchResultCollegeGroupAdapter()
        mSearchResult.adapter = mSearchResultAdapter
        mSearchResult.addItemDecoration(SearchResultItemDecoration(1,
                R.color.freshman_recycle_item_online_communication_group_search_result_border_color))
        mSearchResult.gone()

        mEditText = view.findViewById(R.id.et_recycle_item_online_communication_group_search)
        mManager = context?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        initEditText()
        initSearchResult()

        presenter?.getCollegeGroup()
    }

    @SuppressLint("ClickableViewAccessibility")
    private fun initSearchResult() {
        val detector = GestureDetector(
                object : GestureDetector.SimpleOnGestureListener() {
                    override fun onScroll(e1: MotionEvent?, e2: MotionEvent?, distanceX: Float, distanceY: Float): Boolean {
                        hideIME(view!!)
                        return false
                    }
                }
        )
        mSearchResult.setOnTouchListener { _, motionEvent -> detector.onTouchEvent(motionEvent) }
    }

    private fun initEditText() {
        resetHint()
        mEditText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
                if (mManager.isAcceptingText) presenter?.search(mEditText.text.toString())
            }
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
        })
        mEditText.onFocusChangeListener = View.OnFocusChangeListener { view, isFocus ->
            if (!isFocus) {
                hideIME(view)
            } else { resetHint() }
        }
        calculateKeyboardHeight(mEditText)
    }

    override fun getLayoutRes() = R.layout.freshman_fragment_online_communication_group

    override fun getViewToAttach() = this

    override fun createPresenter() = FragmentCollegeGroupPresenter()

    override fun showCollegeGroup(collegeGroup: List<CollegeGroupText>) {
        mAdapter.mCollegeGroup = collegeGroup
    }

    override fun showSearchResult(collegeGroup: List<CollegeGroupText>) {
        val totalHeight = dip(53) * collegeGroup.size
        val layoutParam  = mSearchResult.layoutParams
        if (mSearchResultMaxHeight != 0 && mSearchResultMaxHeight < totalHeight) {
            layoutParam.height = mSearchResultMaxHeight
        } else {
            layoutParam.height = totalHeight
        }
        mSearchResult.visible()
        mSearchResultAdapter.refreshData(collegeGroup)
    }

    private fun hideIME(view: View) {
        mEditText.clearFocus()
        mManager.hideSoftInputFromWindow(view.windowToken, InputMethodManager.HIDE_NOT_ALWAYS)
    }

    private fun resetHint() {
        mEditText.hint = resources.getString(R.string.freshman_hint_not_found_college_group)
        mEditText.hintTextColor = resources.getColor(
                R.color.freshman_recycle_item_online_communication_group_search_hint_text_color)
    }

    private fun calculateKeyboardHeight(view: View) {
        view.viewTreeObserver.addOnGlobalLayoutListener {
            val rect = Rect()
            val point = IntArray(2)
            view.getLocationOnScreen(point)
            view.getWindowVisibleDisplayFrame(rect)
            mSearchResultMaxHeight = rect.bottom - point[1] - mEditText.height - dip(20)
        }
    }
}