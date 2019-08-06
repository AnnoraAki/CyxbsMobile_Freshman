package com.mredrock.cyxbs.freshman.bean

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
        val photos: List<Photo>

)
data class SchoolScenery (
        val code: Int,
        val info: String,
        val text: Scenery
)