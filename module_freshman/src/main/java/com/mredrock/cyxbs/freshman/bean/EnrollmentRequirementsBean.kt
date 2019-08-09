package com.mredrock.cyxbs.freshman.bean

import com.mredrock.cyxbs.common.bean.RedrockApiStatus

/**
 * Create by yuanbing
 * on 2019/8/8
 */
data class EnrollmentRequirementsBean(
    val code: Int,
    val text: List<EnrollmentRequirementsText>
) : RedrockApiStatus()

data class EnrollmentRequirementsText(
        val `data`: List<EnrollmentRequirementsData>,
        val title: String
)

data class EnrollmentRequirementsData(
    val detail: String,
    val name: String
)