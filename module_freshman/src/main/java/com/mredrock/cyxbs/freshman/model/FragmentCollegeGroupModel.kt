package com.mredrock.cyxbs.freshman.model

import android.annotation.SuppressLint
import com.mredrock.cyxbs.freshman.base.BaseModel
import com.mredrock.cyxbs.freshman.bean.CollegeGroupText
import com.mredrock.cyxbs.freshman.config.RESULT_OK
import com.mredrock.cyxbs.freshman.interfaces.model.IFragmentCollegeGroupModel
import com.mredrock.cyxbs.freshman.interfaces.network.CollegeGroupService
import com.mredrock.cyxbs.freshman.util.network.createService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Create by yuanbing
 * on 2019/8/4
 */
class FragmentCollegeGroupModel : BaseModel(), IFragmentCollegeGroupModel {
    override fun searchCollegeGroup(callback: (List<CollegeGroupText>) -> Unit) {
        val data = ArrayList<CollegeGroupText>()
        for (i in 1..3) {
            data.add(CollegeGroupText("1234567890", "网络空间安全与信息法学院"))
        }
        callback(data)
    }

    @SuppressLint("CheckResult")
    override fun requestCollegeGroup(callback: (List<CollegeGroupText>) -> Unit) {

        val data = ArrayList<CollegeGroupText>()
        for (i in 1..10) {
            data.add(CollegeGroupText("1234567890", "网络空间安全与信息法学院"))
        }
        callback(data)
        return

        val service = createService(CollegeGroupService::class.java)
        service.requestCollegeGroup()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    if (it.code == RESULT_OK) callback(it.text)
                }, {})
    }
}