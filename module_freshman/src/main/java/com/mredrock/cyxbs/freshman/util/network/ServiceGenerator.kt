package com.mredrock.cyxbs.freshman.util.network

import com.mredrock.cyxbs.freshman.config.API_BASE_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Create by yuanbing
 * on 2019/8/3
 */

private val RETROFIT_BUILDER = Retrofit.Builder()
        .client(
                OkHttpClient.Builder()
                .addInterceptor(HttpLoggingInterceptor().let {
                    it.level = HttpLoggingInterceptor.Level.BASIC
                    it
                })
                .build()
        )
        .baseUrl(API_BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()

fun <S> createService(serviceClass: Class<S>): S {
    return RETROFIT_BUILDER.create(serviceClass)
}