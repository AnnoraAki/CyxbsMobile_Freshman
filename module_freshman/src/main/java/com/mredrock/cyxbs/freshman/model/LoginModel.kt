package com.mredrock.cyxbs.freshman.model

import com.mredrock.cyxbs.freshman.base.BaseModel
import com.mredrock.cyxbs.freshman.base.IBaseModel
import com.mredrock.cyxbs.freshman.interfaces.model.ILoginModel

/**
 * Create by yuanbing
 * on 2019/8/3
 */
class LoginModel : BaseModel(), ILoginModel {
    override fun login(callback: ILoginModel.Callback) {
        callback.onSuccess("")
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}