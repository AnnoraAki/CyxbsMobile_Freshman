package com.mredrock.cyxbs.freshman.model

import android.annotation.SuppressLint
import com.mredrock.cyxbs.freshman.base.BaseModel
import com.mredrock.cyxbs.freshman.interfaces.model.IFragmentSexRatoModel
import com.mredrock.cyxbs.freshman.interfaces.network.SexRatoService
import com.mredrock.cyxbs.freshman.util.network.ApiGenerator
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class FragmentSexRatoModel : BaseModel(), IFragmentSexRatoModel {
    @SuppressLint("CheckResult")
    override fun requestSexRato(college: String, callback: IFragmentSexRatoModel.Callback) {
        val service = ApiGenerator.getApiService(SexRatoService::class.java)
        service.requestSexRato()
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .map { sexRatoBean ->
                    sexRatoBean.text.first { it.name == college }
                }
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ callback.requestSexRatoSuccess(it) },
                        { callback.requestSexRatoFaild() })
    }
}