package com.mredrock.cyxbs.freshman.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mredrock.cyxbs.common.ui.BaseFragment
import com.mredrock.cyxbs.freshman.R
import com.mredrock.cyxbs.freshman.util.event.SexRatoEvent
import com.mredrock.cyxbs.freshman.view.widget.PieChart
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

/**
 * Create by yuanbing
 * on 2019/8/6
 */
class SexRatoFragment(val college: String) : BaseFragment() {
    private lateinit var mPieChart: PieChart

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.freshman_fragment_data_disclosure_sex_rato, container, false)
        mPieChart = view.findViewById(R.id.pie_chart_data_disclosure_sex_rato)
        return view
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