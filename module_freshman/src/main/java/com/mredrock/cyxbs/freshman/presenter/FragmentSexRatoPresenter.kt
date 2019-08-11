package com.mredrock.cyxbs.freshman.presenter

import com.mredrock.cyxbs.freshman.base.BasePresenter
import com.mredrock.cyxbs.freshman.bean.SexRatoText
import com.mredrock.cyxbs.freshman.interfaces.model.IFragmentSexRatoModel
import com.mredrock.cyxbs.freshman.interfaces.presenter.IFragmentSexRatoPresenter
import com.mredrock.cyxbs.freshman.interfaces.view.IFragmentSexRatoView
import com.mredrock.cyxbs.freshman.model.FragmentSexRatoModel

class FragmentSexRatoPresenter : BasePresenter<IFragmentSexRatoView, IFragmentSexRatoModel>(),
        IFragmentSexRatoPresenter {
    override fun attachModel() = FragmentSexRatoModel()

    override fun getSexRato(college: String) {
        model?.requestSexRato(college,
                object : IFragmentSexRatoModel.Callback {
                    override fun requestSexRatoFaild() {
                        view?.getSexRatoFaild()
                    }

                    override fun requestSexRatoSuccess(text: SexRatoText) {
                        view?.showSexRato(text)
                    }
                }
        )
    }
}