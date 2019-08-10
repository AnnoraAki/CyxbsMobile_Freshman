package com.mredrock.cyxbs.freshman.bean

import com.mredrock.cyxbs.common.bean.RedrockApiStatus

/**
 * Create by yuanbing
 * on 2019/8/2
 */
data class DataClosureBean(
    val code: Int,
    val text: List<DataClosureText>
) : RedrockApiStatus()

data class DataClosureText(
    val message: List<DataClosureMessage>,
    val name: String
)

data class DataClosureMessage(
    val `data`: List<DataClosureData>,
    val boy: String,
    val girl: String,
    val title: String
)

data class DataClosureData(
    val `data`: String,
    val subject_1: String,
    val subject_2: String
)