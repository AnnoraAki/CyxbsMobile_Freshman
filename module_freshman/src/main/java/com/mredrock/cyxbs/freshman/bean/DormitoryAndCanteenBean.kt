package com.mredrock.cyxbs.freshman.bean

import com.mredrock.cyxbs.common.bean.RedrockApiStatus

/**
 * Create by yuanbing
 * on 2019/8/7
 */
data class DormitoryAndCanteenBean(
    val code: Int,
    val text: List<DormitoryAndCanteenText>
) : RedrockApiStatus()

data class DormitoryAndCanteenText(
        val message: List<DormitoryAndCanteenMessage>,
        val title: String
)

data class DormitoryAndCanteenMessage(
    val detail: String,
    val name: String,
    var photo: List<String>
)