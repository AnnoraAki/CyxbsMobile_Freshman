package com.mredrock.cyxbs.freshman.bean

import com.mredrock.cyxbs.common.bean.RedrockApiStatus

/**
 * Create by yuanbing
 * on 2019/8/4
 */
data class CollegeGroupBean (
    val code: Int,
    val text: List<CollegeGroupText>
) : RedrockApiStatus()

data class CollegeGroupText(
    val `data`: String,
    val name: String
)