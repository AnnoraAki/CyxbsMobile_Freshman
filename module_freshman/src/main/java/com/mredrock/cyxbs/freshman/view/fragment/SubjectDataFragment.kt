package com.mredrock.cyxbs.freshman.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mredrock.cyxbs.common.ui.BaseFragment
import com.mredrock.cyxbs.freshman.R
import com.mredrock.cyxbs.freshman.util.event.SubjectDataEvent
import com.mredrock.cyxbs.freshman.view.widget.Histogram
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

/**
 * Create by yuanbing
 * on 2019/8/5
 */
class SubjectDataFragment : BaseFragment() {
    private lateinit var mHistogram: Histogram

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.freshman_fragment_data_disclosure_subject_data, container, false)
        mHistogram = view.findViewById(R.id.histogram_data_disclosure_subject_data)
        return view
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun playAnimation(subjectDataEvent: SubjectDataEvent) {
        mHistogram.mAnimation?.start()
    }
}