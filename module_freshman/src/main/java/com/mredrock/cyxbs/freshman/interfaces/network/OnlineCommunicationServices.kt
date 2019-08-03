package com.mredrock.cyxbs.freshman.interfaces.network

import com.mredrock.cyxbs.freshman.bean.OnlineActivityBean
import com.mredrock.cyxbs.freshman.config.API_ONLINE_COMMUNICATION_OMLINE_ACTIVITY
import io.reactivex.Observable
import retrofit2.http.GET

/**
 * Create by yuanbing
 * on 2019/8/3
 */
interface OnlineActivityService {
    @GET(API_ONLINE_COMMUNICATION_OMLINE_ACTIVITY)
    fun requestOnlineActivityActivity(): Observable<OnlineActivityBean>
}