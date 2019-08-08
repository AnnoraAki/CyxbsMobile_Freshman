package com.mredrock.cyxbs.freshman.model

import android.annotation.SuppressLint
import android.util.Log
import com.mredrock.cyxbs.common.BaseApp
import com.mredrock.cyxbs.common.utils.extensions.safeSubscribeBy
import com.mredrock.cyxbs.freshman.base.BaseModel
import com.mredrock.cyxbs.freshman.bean.EnrollmentProcessText
import com.mredrock.cyxbs.freshman.interfaces.model.IActivityEnrollmentProcessModel
import com.mredrock.cyxbs.freshman.interfaces.network.EnrollmentProcessService
import com.mredrock.cyxbs.freshman.interfaces.network.TestService
import com.mredrock.cyxbs.freshman.util.network.createService
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import org.jetbrains.anko.toast

/**
 * Create by yuanbing
 * on 2019/8/3
 */
class ActivityEnrollmentProcessModel : BaseModel(), IActivityEnrollmentProcessModel {
    @SuppressLint("CheckResult")
    override fun requestErollmentProcess(callback: (List<EnrollmentProcessText>) -> Unit) {
        val service = createService(EnrollmentProcessService::class.java)
        service.requestEnrollmentProcess()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ callback(it.text) }, {
                    Log.e("TAG", "TAG", it)
                })
    }
}