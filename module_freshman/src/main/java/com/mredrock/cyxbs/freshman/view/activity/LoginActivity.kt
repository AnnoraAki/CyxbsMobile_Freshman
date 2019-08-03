package com.mredrock.cyxbs.freshman.view.activity

import com.mredrock.cyxbs.freshman.base.BaseActivity
import com.mredrock.cyxbs.freshman.interfaces.model.ILoginModel
import com.mredrock.cyxbs.freshman.interfaces.presenter.ILoginPresntter
import com.mredrock.cyxbs.freshman.interfaces.view.ILoginView
import com.mredrock.cyxbs.freshman.presenter.LoginPresenter

/**
 * Create by yuanbing
 * on 2019/8/3
 */
class LoginActivity : BaseActivity<ILoginView, ILoginPresntter, ILoginModel>(), ILoginView {
    override fun getViewToAttach() = this

    override fun createPresenter() = LoginPresenter()

    override val isFragmentActivity: Boolean
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.

    override fun showData(string: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun test() {
        presenter?.login()
    }
}