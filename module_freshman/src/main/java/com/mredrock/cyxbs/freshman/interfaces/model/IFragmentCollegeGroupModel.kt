package com.mredrock.cyxbs.freshman.interfaces.model

import com.mredrock.cyxbs.freshman.base.IBaseModel
import com.mredrock.cyxbs.freshman.bean.CollegeGroupText

/**
 * Create by yuanbing
 * on 2019/8/3
 */
interface IFragmentCollegeGroupModel : IBaseModel {
    fun requestCollegeGroup(callback: (List<CollegeGroupText>) -> Unit)
    fun searchCollegeGroup(callback: (List<CollegeGroupText>) -> Unit)
}