package com.mredrock.cyxbs.freshman.interfaces.presenter

import com.mredrock.cyxbs.freshman.base.IBasePresenter
import com.mredrock.cyxbs.freshman.interfaces.model.ILoginModel
import com.mredrock.cyxbs.freshman.interfaces.view.ILoginView

/**
 * Create by yuanbing
 * on 2019/8/3
 */
interface ILoginPresntter : IBasePresenter<ILoginView, ILoginModel> {
    fun login()
}