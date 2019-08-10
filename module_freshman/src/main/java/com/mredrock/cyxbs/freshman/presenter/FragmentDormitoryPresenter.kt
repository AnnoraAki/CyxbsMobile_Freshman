package com.mredrock.cyxbs.freshman.presenter

import com.mredrock.cyxbs.freshman.base.BasePresenter
import com.mredrock.cyxbs.freshman.interfaces.model.IFragmentDormitoryModel
import com.mredrock.cyxbs.freshman.interfaces.presenter.IFragmentDormitoryPresenter
import com.mredrock.cyxbs.freshman.interfaces.view.IFragmentDormitoryView
import com.mredrock.cyxbs.freshman.model.FragmentDormitoryModel

/**
 * Create by yuanbing
 * on 2019/8/7
 */
class FragmentDormitoryPresenter : BasePresenter<IFragmentDormitoryView, IFragmentDormitoryModel>(), IFragmentDormitoryPresenter {
    override fun getDormitoryInfo(position: Int) {
//        model?.getDormitoryInfo(position) { view?.showDormitoryInfo(it) }
    }

    override fun attachModel() = FragmentDormitoryModel()

    override fun getDormitory() {
        model?.requestDormitory { view?.showDormitory(it) }
    }
}