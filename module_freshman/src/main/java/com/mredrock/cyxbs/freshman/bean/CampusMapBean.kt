package com.mredrock.cyxbs.freshman.bean

import com.google.gson.annotations.SerializedName
import com.mredrock.cyxbs.common.bean.RedrockApiStatus
import java.io.Serializable

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

        @SerializedName("route")
        val routes: List<String>
)

data class RecommendRoute(
        val title: String,
        val message: List<Route>
)

//接口返回的数据bean类
data class BusRoute(
        var code: Int,
        var info: String? = null,
        var text_1: CampusAddress? = null,
        var text_2: RecommendRoute? = null
) : Serializable
