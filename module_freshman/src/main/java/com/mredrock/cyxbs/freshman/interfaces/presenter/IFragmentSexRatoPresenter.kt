package com.mredrock.cyxbs.freshman.interfaces.presenter

import com.mredrock.cyxbs.freshman.base.IBasePresenter
import com.mredrock.cyxbs.freshman.interfaces.model.IFragmentSexRatoModel
import com.mredrock.cyxbs.freshman.interfaces.view.IFragmentSexRatoView

interface IFragmentSexRatoPresenter : IBasePresenter<IFragmentSexRatoView, IFragmentSexRatoModel> {
    fun getSexRato(college: String)
}