package com.mredrock.cyxbs.freshman.bean

import com.google.gson.annotations.SerializedName
import com.mredrock.cyxbs.common.bean.RedrockApiStatus

/**
 * Create by roger
 * on 2019/8/5
 */
data class Photo (
        val name: String,
        val photo: String
)
data class Scenery (
        val title: String,
        val photo: String,
        @SerializedName("message")
        val photos: List<Photo>

)

//接口返回的数据bean类
data class SceneryPhoto(
        var code: Int,
        var update_date: String,
        var text: Scenery
) : RedrockApiStatus()