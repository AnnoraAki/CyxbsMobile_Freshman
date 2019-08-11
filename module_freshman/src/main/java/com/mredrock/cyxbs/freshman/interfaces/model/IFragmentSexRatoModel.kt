package com.mredrock.cyxbs.freshman.interfaces.model

import com.mredrock.cyxbs.freshman.base.IBaseModel
import com.mredrock.cyxbs.freshman.bean.SexRatoText

interface IFragmentSexRatoModel : IBaseModel {
    fun requestSexRato(college: String, callback: Callback)

    interface Callback {
        fun requestSexRatoFaild()
        fun requestSexRatoSuccess(text: SexRatoText)
    }
}