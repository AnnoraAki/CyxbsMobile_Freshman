package com.mredrock.cyxbs.freshman.interfaces.network

import com.mredrock.cyxbs.freshman.bean.SubjectDataBean
import com.mredrock.cyxbs.freshman.bean.DormitoryAndCanteenBean
import com.mredrock.cyxbs.freshman.config.API_COLLEGE_DATA
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

interface SubjectDataService {
    @GET(API_COLLEGE_DATA)
    fun requestCollegeData(): Observable<SubjectDataBean>
}