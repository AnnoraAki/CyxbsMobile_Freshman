package com.mredrock.cyxbs.freshman.bean

import com.mredrock.cyxbs.common.bean.RedrockApiStatus

data class SexRatoBean(
        val code: Int,
        val text: List<SexRatoText>,
        val title: String
) : RedrockApiStatus()

data class SexRatoText(
    val boy: String,
    val girl: String,
    val name: String
)