package com.mredrock.cyxbs.freshman.interfaces.view

import com.mredrock.cyxbs.freshman.base.IBaseView
import com.mredrock.cyxbs.freshman.bean.DormitoryAndCanteenMessage

/**
 * Create by yuanbing
 * on 2019/8/7
 */
interface IFragmentDormitoryView : IBaseView {
    fun showDormitory(dormitory: List<String>)
    fun showDormitoryInfo(info: List<DormitoryAndCanteenMessage>)
}