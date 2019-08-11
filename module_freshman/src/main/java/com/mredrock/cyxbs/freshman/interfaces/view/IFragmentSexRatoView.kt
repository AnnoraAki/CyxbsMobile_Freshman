package com.mredrock.cyxbs.freshman.interfaces.view

import com.mredrock.cyxbs.freshman.base.IBaseView
import com.mredrock.cyxbs.freshman.bean.SexRatoText

interface IFragmentSexRatoView : IBaseView {
    fun showSexRato(text: SexRatoText)
    fun getSexRatoFaild()
}