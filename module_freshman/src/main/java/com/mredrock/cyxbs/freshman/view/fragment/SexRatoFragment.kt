package com.mredrock.cyxbs.freshman.view.fragment


import android.os.Bundle
import android.view.View
import com.mredrock.cyxbs.common.utils.extensions.gone
import com.mredrock.cyxbs.common.utils.extensions.visible
import com.mredrock.cyxbs.freshman.R
import com.mredrock.cyxbs.freshman.base.BaseFragment
import com.mredrock.cyxbs.freshman.bean.SexRatoText
import com.mredrock.cyxbs.freshman.interfaces.model.IFragmentSexRatoModel
import com.mredrock.cyxbs.freshman.interfaces.presenter.IFragmentSexRatoPresenter
import com.mredrock.cyxbs.freshman.interfaces.view.IFragmentSexRatoView
import com.mredrock.cyxbs.freshman.presenter.FragmentSexRatoPresenter
import com.mredrock.cyxbs.freshman.util.event.SexRatoEvent
import com.mredrock.cyxbs.freshman.view.widget.PieChart
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import kotlin.math.max
import kotlin.math.min

/**
 * Create by yuanbing
 * on 2019/8/6
 */
class SexRatoFragment(val college: String) : BaseFragment<IFragmentSexRatoView,
        IFragmentSexRatoPresenter, IFragmentSexRatoModel>(), IFragmentSexRatoView {
    private lateinit var mPieChart: PieChart

    override fun onCreateView(view: View, savedInstanceState: Bundle?) {
        mPieChart = view.findViewById(R.id.pie_chart_data_disclosure_sex_rato)
        mPieChart.gone()
        presenter?.getSexRato(college)
    }

    override fun getLayoutRes() = R.layout.freshman_fragment_data_disclosure_sex_rato

    override fun getViewToAttach() = this

    override fun createPresenter() = FragmentSexRatoPresenter()

    override fun showSexRato(text: SexRatoText) {
        val boy = text.boy.split("%")[0].toFloat() / 100
        val girl = text.girl.split("%")[0].toFloat() / 100
        mPieChart.mFirstGraphWeight = max(boy, girl)
        mPieChart.mSecondGraphWeight = min(boy, girl)
        mPieChart.visible()
        mPieChart.mAnimation?.start()
    }

    override fun getSexRatoFaild() {
        mPieChart.gone()
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun playAnimation(sexRatoEvent: SexRatoEvent) {
        if (sexRatoEvent.token) {
            mPieChart.mAnimation?.start()
        } else {
            mPieChart.mAnimation?.cancel()
        }
    }


}