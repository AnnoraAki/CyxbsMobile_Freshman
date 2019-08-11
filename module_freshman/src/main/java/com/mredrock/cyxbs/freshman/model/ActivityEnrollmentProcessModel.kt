package com.mredrock.cyxbs.freshman.model

import android.annotation.SuppressLint
import com.mredrock.cyxbs.common.utils.extensions.safeSubscribeBy
import com.mredrock.cyxbs.freshman.base.BaseModel
import com.mredrock.cyxbs.freshman.bean.EnrollmentProcessText
import com.mredrock.cyxbs.freshman.interfaces.model.IActivityEnrollmentProcessModel
import com.mredrock.cyxbs.freshman.interfaces.network.EnrollmentProcessService
import com.mredrock.cyxbs.freshman.util.network.ApiGenerator
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Create by yuanbing
 * on 2019/8/3
 */
class ActivityEnrollmentProcessModel : BaseModel(), IActivityEnrollmentProcessModel {
    @SuppressLint("CheckResult")
    override fun requestErollmentProcess(callback: (List<EnrollmentProcessText>) -> Unit) {
        val service = ApiGenerator.getApiService(EnrollmentProcessService::class.java)
        service.requestEnrollmentProcess()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .safeSubscribeBy { callback(it.text) }
    }
}