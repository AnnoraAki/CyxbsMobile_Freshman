package com.mredrock.cyxbs.freshman.interfaces.network

import io.reactivex.Observable
import retrofit2.http.GET

/**
 * Create by yuanbing
 * on 2019/8/7
 */
interface TestService {
    @GET()
    fun get()
}