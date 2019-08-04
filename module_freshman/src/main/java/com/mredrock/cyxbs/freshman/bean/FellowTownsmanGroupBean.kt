package com.mredrock.cyxbs.freshman.bean

/**
 * Create by yuanbing
 * on 2019/8/4
 */
data class FellowTownsmanGroupBean(
    val code: Int,
    val info: String,
    val text: List<FellowTownsmanGroupText>
)

data class FellowTownsmanGroupText(
    val `data`: String,
    val name: String
)