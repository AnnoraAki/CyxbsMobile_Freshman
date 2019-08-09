package com.mredrock.cyxbs.freshman.bean

import com.mredrock.cyxbs.common.bean.RedrockApiStatus

/**
 * Create by yuanbing
 * on 2019/8/3
 */
data class OnlineActivityBean(
    val code: Int,
    val text: List<OnlineActivityText>
) : RedrockApiStatus()

data class OnlineActivityText(
    val QR: String,
    val message: String,
    val name: String,
    val photo: String
)