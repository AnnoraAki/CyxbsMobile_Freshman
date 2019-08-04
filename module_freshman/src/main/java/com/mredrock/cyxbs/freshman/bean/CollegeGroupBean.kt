package com.mredrock.cyxbs.freshman.bean

/**
 * Create by yuanbing
 * on 2019/8/4
 */
data class CollegeGroupBean(
    val code: Int,
    val info: String,
    val text: List<CollegeGroupText>
)

data class CollegeGroupText(
    val `data`: String,
    val name: String
)