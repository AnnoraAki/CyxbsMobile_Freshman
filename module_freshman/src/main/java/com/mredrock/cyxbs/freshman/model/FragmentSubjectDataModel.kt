package com.mredrock.cyxbs.freshman.model

import com.mredrock.cyxbs.common.network.ApiGenerator
import com.mredrock.cyxbs.common.utils.extensions.safeSubscribeBy
import com.mredrock.cyxbs.freshman.base.BaseModel
import com.mredrock.cyxbs.freshman.bean.SubjectDataMessage
import com.mredrock.cyxbs.freshman.interfaces.model.IFragmentSubjectDataModel
import com.mredrock.cyxbs.freshman.interfaces.network.SubjectDataService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class FragmentSubjectDataModel : BaseModel(), IFragmentSubjectDataModel {
    override fun requestSubjectData(college: String, callback: (List<SubjectDataMessage>) -> Unit) {
        val service = ApiGenerator.getApiService(SubjectDataService::class.java)
        service.requestSubjectData()
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .map { subjectDataBean ->
                    subjectDataBean.text.first { it.name == college }.message
                }
                .observeOn(AndroidSchedulers.mainThread())
                .safeSubscribeBy { callback(it) }
    }
}