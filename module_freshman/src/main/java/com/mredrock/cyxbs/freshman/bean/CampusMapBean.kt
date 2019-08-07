package com.mredrock.cyxbs.freshman.bean

/**
 * Create by roger
 * on 2019/8/4
 */
data class CampusAddress(
        val title: String,
        val message: String
)
data class Route(
        val name: String,
        val route: String
)
data class BusRoute (
        val code: Int,
        val info: String,
        val text_1: CampusAddress,
        val text_2: RecommendRoute
)
data class RecommendRoute (
        val title: String,
        val message: List<Route>
)