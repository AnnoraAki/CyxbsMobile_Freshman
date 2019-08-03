package com.mredrock.cyxbs.freshman.bean

/**
 * Create by yuanbing
 * on 2019/8/3
 */
data class EnrollmentProcessBean(
    val code: Int,
    val info: String,
    val text: List<EnrollmentProcessText>
)

data class EnrollmentProcessText(
    val detail: String,
    val message: String,
    val photo: String,
    val title: String
)