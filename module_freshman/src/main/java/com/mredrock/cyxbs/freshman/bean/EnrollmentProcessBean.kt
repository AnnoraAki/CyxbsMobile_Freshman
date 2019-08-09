package com.mredrock.cyxbs.freshman.bean

import com.mredrock.cyxbs.common.bean.RedrockApiStatus

/**
 * Create by yuanbing
 * on 2019/8/3
 */
data class EnrollmentProcessBean(
    val code: Int,
    val text: List<EnrollmentProcessText>
) : RedrockApiStatus()

data class EnrollmentProcessText(
    val detail: String,
    val message: String,
    val photo: String,
    val title: String
)