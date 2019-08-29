package com.mredrock.cyxbs.freshman.bean

/**
 * Create by roger
 * on 2019/8/4
 */
data class GroupData(
        val title: String,
        val list: MutableList<String>
)
interface Callback {
    fun onSuccess(route: BusRoute)
    fun onFailed()
}