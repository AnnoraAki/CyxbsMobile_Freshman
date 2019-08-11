package com.mredrock.cyxbs.freshman.view.fragment

import android.os.Bundle
import android.view.View
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.mredrock.cyxbs.freshman.R
import com.mredrock.cyxbs.freshman.base.BaseFragment
import com.mredrock.cyxbs.freshman.bean.ExpressText
import com.mredrock.cyxbs.freshman.interfaces.model.IFragmentExpressModel
import com.mredrock.cyxbs.freshman.interfaces.presenter.IFragmentExpressPresenter
import com.mredrock.cyxbs.freshman.interfaces.view.IFragmentExpressView
import com.mredrock.cyxbs.freshman.presenter.FragmentExpressPresenter
import com.mredrock.cyxbs.freshman.util.listener.FreshmanOnSecondTabSelectedListener
import com.mredrock.cyxbs.freshman.view.adapter.CampusGuidelinesPagerAdapter

class ExpressFragment :
        BaseFragment<IFragmentExpressView, IFragmentExpressPresenter, IFragmentExpressModel>(),
        IFragmentExpressView {
    private lateinit var mTab: TabLayout
    private lateinit var mViewPager: ViewPager
    private lateinit var mData: List<ExpressText>
    private lateinit var mAdapter: CampusGuidelinesPagerAdapter

    override fun onCreateView(view: View, savedInstanceState: Bundle?) {
        mTab = view.findViewById(R.id.tl_campus_guidelines_second_express)
        mViewPager = view.findViewById(R.id.vp_campus_guidelines_express)
        initViewPager()
        presenter?.getExpress()
    }

    override fun getLayoutRes() = R.layout.freshman_fragment_campus_guidelines_express

    override fun getViewToAttach() = this

    override fun createPresenter() = FragmentExpressPresenter()

    override fun showExpress(express: List<ExpressText>) {
        mData = express
        initTabLayout()
        mAdapter.refreshData(List(mData.size) { ExpressDetailFragment(mData[it]) })
    }

    private fun initTabLayout() {
        for (text in mData) {
            val tab = mTab.newTab()
            tab.text = text.name
            mTab.addTab(tab)
        }
        mTab.addOnTabSelectedListener(
                object : FreshmanOnSecondTabSelectedListener() {
                    override fun doOnTabSelected(p0: TabLayout.Tab) {
                        mViewPager.currentItem = p0.position
                    }
                }
        )
        mTab.getTabAt(0)?.select()
    }

    private fun initViewPager() {
        mAdapter = CampusGuidelinesPagerAdapter(childFragmentManager)
        mViewPager.adapter = mAdapter
        mViewPager.addOnPageChangeListener(
                object : ViewPager.OnPageChangeListener {
                    override fun onPageScrollStateChanged(state: Int) {  }
                    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {  }
                    override fun onPageSelected(position: Int) {
                        mTab.getTabAt(position)?.select()
                    }
                }
        )
    }
}