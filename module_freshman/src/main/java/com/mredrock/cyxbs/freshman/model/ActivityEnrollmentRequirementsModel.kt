package com.mredrock.cyxbs.freshman.model

import android.annotation.SuppressLint
import com.mredrock.cyxbs.freshman.base.BaseModel
import com.mredrock.cyxbs.freshman.bean.EnrollmentRequirementsItemBean
import com.mredrock.cyxbs.freshman.bean.EnrollmentRequirementsTitleBean
import com.mredrock.cyxbs.freshman.interfaces.ParseBean
import com.mredrock.cyxbs.freshman.interfaces.model.IActivityEnrollmentRequirementsModel
import com.mredrock.cyxbs.freshman.interfaces.network.EnrollmentRequirementsService
import com.mredrock.cyxbs.freshman.util.network.createService
import io.reactivex.schedulers.Schedulers

/**
 * Create by yuanbing
 * on 2019/8/8
 */
class ActivityEnrollmentRequirementsModel : BaseModel(), IActivityEnrollmentRequirementsModel {
    @SuppressLint("CheckResult")
    override fun requestEnrollmentRequirements(callback: (List<ParseBean>) -> Unit) {
        val service = createService(EnrollmentRequirementsService::class.java)
        service.requestEnrollmentRequirments()
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .map {
                    callback(it.text.flatMap {
                        val data = mutableListOf<ParseBean>()
                        data.add(EnrollmentRequirementsTitleBean(it.title))
                        data.addAll(it.data.asSequence().map {
                            EnrollmentRequirementsItemBean(it.name, it.detail)
                        })
                        data
                    })
                }
    }
}