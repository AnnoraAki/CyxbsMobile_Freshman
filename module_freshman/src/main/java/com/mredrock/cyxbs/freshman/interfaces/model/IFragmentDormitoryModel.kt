package com.mredrock.cyxbs.freshman.interfaces.model

import com.mredrock.cyxbs.freshman.base.IBaseModel
import com.mredrock.cyxbs.freshman.bean.DormitoryAndCanteenMessage

/**
 * Create by yuanbing
 * on 2019/8/7
 */
interface IFragmentDormitoryModel : IBaseModel {
    fun requestDormitory(callback: (List<String>) -> Unit)
    fun getDormitoryInfo(position: Int, callback: (DormitoryAndCanteenMessage) -> Unit)
}