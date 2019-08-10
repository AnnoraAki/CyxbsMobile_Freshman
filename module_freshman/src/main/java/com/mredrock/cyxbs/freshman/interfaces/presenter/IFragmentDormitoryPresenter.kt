package com.mredrock.cyxbs.freshman.interfaces.presenter

import com.mredrock.cyxbs.freshman.base.IBasePresenter
import com.mredrock.cyxbs.freshman.interfaces.model.IFragmentDormitoryModel
import com.mredrock.cyxbs.freshman.interfaces.view.IFragmentDormitoryView

/**
 * Create by yuanbing
 * on 2019/8/7
 */
interface IFragmentDormitoryPresenter : IBasePresenter<IFragmentDormitoryView, IFragmentDormitoryModel> {
    fun getDormitory()
    fun getDormitoryInfo(position: Int)
}