package com.mredrock.cyxbs.freshman.bean

import com.mredrock.cyxbs.freshman.interfaces.ParseBean

/**
 * Create by yuanbing
 * on 2019/8/8
 */
data class EnrollmentRequirementsParseBean(val beans: List<ParseBean>)

data class EnrollmentRequirementsTitleBean(
        val title: String
) : ParseBean

data class EnrollmentRequirementsItemBean(
        val name: String,
        val detail: String
) : ParseBean