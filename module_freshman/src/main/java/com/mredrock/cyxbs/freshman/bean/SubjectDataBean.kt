package com.mredrock.cyxbs.freshman.bean

import com.mredrock.cyxbs.common.bean.RedrockApiStatus

/**
 * Create by yuanbing
 * on 2019/8/7
 */
data class SubjectDataBean(
        val code: Int,
        val text: List<SubjectDataText>,
        val title: String
) : RedrockApiStatus()

data class SubjectDataText(
        val message: List<SubjectDataMessage>,
        val name: String
)

data class SubjectDataMessage(
    val `data`: String,
    val subject: String
)