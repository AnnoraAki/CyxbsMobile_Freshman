package com.mredrock.cyxbs.freshman.interfaces.model

import com.mredrock.cyxbs.freshman.base.IBaseModel

/**
 * Create by yuanbing
 * on 2019/8/3
 */
interface ILoginModel : IBaseModel {
    fun login(callback: Callback)

    interface Callback {
        fun onSuccess(message: String)
        fun onFailed()
    }
}