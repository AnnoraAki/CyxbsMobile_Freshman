package com.mredrock.cyxbs.freshman.interfaces.network

import com.mredrock.cyxbs.freshman.bean.DormitoryAndCanteenBean
import io.reactivex.Observable
import retrofit2.http.GET

/**
 * Create by yuanbing
 * on 2019/8/7
 */
interface DormitoryAndCanteenService {
    @GET()
    fun requestDormitoryAndCanteen(): Observable<DormitoryAndCanteenBean>
}