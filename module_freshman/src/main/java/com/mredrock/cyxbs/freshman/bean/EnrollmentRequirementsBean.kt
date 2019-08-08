package com.mredrock.cyxbs.freshman.bean

/**
 * Create by yuanbing
 * on 2019/8/8
 */
data class EnrollmentRequirementsBean(
    val code: Int,
    val info: String,
    val text: List<EnrollmentRequirementsText>
)

data class EnrollmentRequirementsText(
        val `data`: List<EnrollmentRequirementsData>,
        val title: String
)

data class EnrollmentRequirementsData(
    val detail: String,
    val name: String
)