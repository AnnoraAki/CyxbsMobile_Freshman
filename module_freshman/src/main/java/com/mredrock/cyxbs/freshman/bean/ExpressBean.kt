package com.mredrock.cyxbs.freshman.bean

import com.mredrock.cyxbs.common.bean.RedrockApiStatus

data class ExpressBean(
    val code: Int,
    val text: List<ExpressText>
) : RedrockApiStatus()

data class ExpressText(
    val message: List<ExpressMessage>,
    val name: String
)

data class ExpressMessage(
    var detail: String,
    var photo: String,
    val title: String
)