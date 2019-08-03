package com.mredrock.cyxbs.freshman.presenter

import com.mredrock.cyxbs.freshman.base.BasePresenter
import com.mredrock.cyxbs.freshman.interfaces.model.ILoginModel
import com.mredrock.cyxbs.freshman.interfaces.presenter.ILoginPresntter
import com.mredrock.cyxbs.freshman.interfaces.view.ILoginView
import com.mredrock.cyxbs.freshman.model.LoginModel

/**
 * Create by yuanbing
 * on 2019/8/3
 */
class LoginPresenter : BasePresenter<ILoginView, ILoginModel>(), ILoginPresntter {
    override fun login() {
        model?.login(object : ILoginModel.Callback {
            override fun onSuccess(message: String) {
                view?.showData(message)
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onFailed() {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
        })
    }

    override fun attachModel() = LoginModel()
}