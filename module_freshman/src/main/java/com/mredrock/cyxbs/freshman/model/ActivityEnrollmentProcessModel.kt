package com.mredrock.cyxbs.freshman.model

import android.annotation.SuppressLint
import com.mredrock.cyxbs.freshman.base.BaseModel
import com.mredrock.cyxbs.freshman.bean.EnrollmentProcessText
import com.mredrock.cyxbs.freshman.config.RESULT_OK
import com.mredrock.cyxbs.freshman.interfaces.model.IActivityEnrollmentProcessModel
import com.mredrock.cyxbs.freshman.interfaces.network.EnrollmentProcessService
import com.mredrock.cyxbs.freshman.util.network.createService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Create by yuanbing
 * on 2019/8/3
 */
class ActivityEnrollmentProcessModel : BaseModel(), IActivityEnrollmentProcessModel {
    @SuppressLint("CheckResult")
    override fun requestErollmentProcess(callback: (List<EnrollmentProcessText>) -> Unit) {

        val data = ArrayList<EnrollmentProcessText>(10)
        for (i in 1..10) {
            if (i == 1) data.add(EnrollmentProcessText("", "6月5-6月6", "", "报到时间"))
            else data.add(EnrollmentProcessText("好歹i花费工会的法规的", "ejwseiofhjiehf", "https://avatar.csdn.net/B/3/D/3_qq_23179075.jpg", "enenene"))
        }
        callback(data)
        return

        val service = createService(EnrollmentProcessService::class.java)
        service.requestEnrollmentProcess()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    if (it.code == RESULT_OK) callback(it.text)
                }, {})
    }
}