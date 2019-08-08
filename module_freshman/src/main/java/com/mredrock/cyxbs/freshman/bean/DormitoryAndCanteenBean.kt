package com.mredrock.cyxbs.freshman.bean

/**
 * Create by yuanbing
 * on 2019/8/7
 */
data class DormitoryAndCanteenBean(
    val code: Int,
    val info: String,
    val text: List<DormitoryAndCanteenText>
)

data class DormitoryAndCanteenText(
        val message: List<DormitoryAndCanteenMessage>,
        val title: String
)

data class DormitoryAndCanteenMessage(
    val detail: String,
    val name: String,
    val photos: List<String>
)