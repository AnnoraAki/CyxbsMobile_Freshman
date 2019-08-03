package com.mredrock.cyxbs.freshman.bean

/**
 * Create by yuanbing
 * on 2019/8/3
 */
data class OnlineActivityBean(
    val code: Int,
    val info: String,
    val text: List<OnlineActivityText>
)

data class OnlineActivityText(
    val QR: String,
    val message: String,
    val name: String,
    val photo: String
)