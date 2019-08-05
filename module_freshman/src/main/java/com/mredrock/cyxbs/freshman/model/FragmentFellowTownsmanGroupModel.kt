package com.mredrock.cyxbs.freshman.model

import android.annotation.SuppressLint
import com.mredrock.cyxbs.freshman.base.BaseModel
import com.mredrock.cyxbs.freshman.bean.FellowTownsmanGroupText
import com.mredrock.cyxbs.freshman.config.RESULT_OK
import com.mredrock.cyxbs.freshman.interfaces.model.IFragmentFellowTownsmanGroupModel
import com.mredrock.cyxbs.freshman.interfaces.network.FellowTownsmanGroupService
import com.mredrock.cyxbs.freshman.util.network.createService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Create by yuanbing
 * on 2019/8/4
 */
class FragmentFellowTownsmanGroupModel : BaseModel(), IFragmentFellowTownsmanGroupModel {
    override fun searchFellowTownsmanGroup(callback: (List<FellowTownsmanGroupText>) -> Unit) {
        val data = ArrayList<FellowTownsmanGroupText>()
        for (i in 1..3) {
            data.add(FellowTownsmanGroupText("1234567890", "重庆"))
        }
        callback(data)
    }

    @SuppressLint("CheckResult")
    override fun requestFellowTownsmanGroup(callback: (List<FellowTownsmanGroupText>) -> Unit) {

        val data = ArrayList<FellowTownsmanGroupText>()
        for (i in 1..10) {
            data.add(FellowTownsmanGroupText("1234567890", "重庆"))
        }
        callback(data)
        return

        val service = createService(FellowTownsmanGroupService::class.java)
        service.requestFellowTownsmanGroupService()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    if (it.code == RESULT_OK) callback(it.text)
                }, {})
    }
}