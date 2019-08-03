package com.mredrock.cyxbs.freshman.util.network

import com.umeng.socialize.common.SocializeConstants.BASE_URL
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Create by yuanbing
 * on 2019/8/3
 */

private val RETROFIT_BUILDER = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())

fun <S> createService(serviceClass: Class<S>): S {
    return RETROFIT_BUILDER.build().create(serviceClass)
}