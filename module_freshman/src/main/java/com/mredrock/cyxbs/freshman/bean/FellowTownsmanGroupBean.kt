package com.mredrock.cyxbs.freshman.bean

import com.mredrock.cyxbs.common.bean.RedrockApiStatus

/**
 * Create by yuanbing
 * on 2019/8/4
 */
data class FellowTownsmanGroupBean(
    val code: Int,
    val text: List<FellowTownsmanGroupText>
) : RedrockApiStatus()

data class FellowTownsmanGroupText(
    val `data`: String,
    val name: String
)