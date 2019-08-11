package com.mredrock.cyxbs.freshman.interfaces.network

import com.mredrock.cyxbs.freshman.bean.BusRoute
import io.reactivex.Observable
import retrofit2.http.GET

/**
 * Create by roger
 * on 2019/8/10
 */
interface CampusService {

    @GET("zsqy/json/5")
    fun getRoutes() : Observable<BusRoute>
}