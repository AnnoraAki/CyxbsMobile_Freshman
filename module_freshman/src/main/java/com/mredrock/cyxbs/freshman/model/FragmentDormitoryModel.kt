package com.mredrock.cyxbs.freshman.model

import com.mredrock.cyxbs.common.network.ApiGenerator
import com.mredrock.cyxbs.common.utils.extensions.safeSubscribeBy
import com.mredrock.cyxbs.freshman.base.BaseModel
import com.mredrock.cyxbs.freshman.bean.DormitoryAndCanteenMessage
import com.mredrock.cyxbs.freshman.interfaces.model.IFragmentDormitoryModel
import com.mredrock.cyxbs.freshman.interfaces.network.DormitoryAndCanteenService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Create by yuanbing
 * on 2019/8/7
 */
class FragmentDormitoryModel : BaseModel(), IFragmentDormitoryModel {
    private lateinit var mDormitory: List<DormitoryAndCanteenMessage>

    override fun getDormitoryInfo(position: Int, callback: (DormitoryAndCanteenMessage) -> Unit) {
        callback(mDormitory[position])
    }

    override fun requestDormitory(callback: (List<String>) -> Unit) {

        val data = ArrayList<DormitoryAndCanteenMessage>()
        for (i in 1..3) {
            data.add(DormitoryAndCanteenMessage("这个是宿舍的详情这个是宿舍的详情这个是宿舍的详情" +
                    "这个是宿舍的详情这个是宿舍的详情这个是宿舍的详情这个是宿舍的详情", "明荔苑", listOf(
                    "https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=3661193673,787354491&fm=26&gp=0.jpg",
                    "https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=2530426348,3663665666&fm=26&gp=0.jpg",
                    "https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=4047396755,457452900&fm=26&gp=0.jpg"
            )))
        }
        mDormitory = data
        callback(listOf("明荔苑", "明荔苑", "明荔苑", "明荔苑"))
        return

        val service = ApiGenerator.getApiService(DormitoryAndCanteenService::class.java)
        service.requestDormitoryAndCanteen()
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .map { it.text[0].message.asSequence().map { it.name } }
                .observeOn(AndroidSchedulers.mainThread())
                .safeSubscribeBy { callback(it.toList()) }
    }
}