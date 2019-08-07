package com.mredrock.cyxbs.freshman.model

import android.annotation.SuppressLint
import com.mredrock.cyxbs.freshman.base.BaseModel
import com.mredrock.cyxbs.freshman.bean.OnlineActivityText
import com.mredrock.cyxbs.freshman.config.RESULT_OK
import com.mredrock.cyxbs.freshman.interfaces.model.IFragmentOnlineActivityModel
import com.mredrock.cyxbs.freshman.interfaces.network.OnlineActivityService
import com.mredrock.cyxbs.freshman.util.network.createService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Create by yuanbing
 * on 2019/8/3
 */
class FragmentOnlineActivityModel : BaseModel(), IFragmentOnlineActivityModel {
    @SuppressLint("CheckResult")
    override fun request(callback: (List<OnlineActivityText>) -> Unit) {

        val data = ArrayList<OnlineActivityText>()
        for (i in 1..10) {
            data.add(OnlineActivityText("https://f12.baidu.com/it/u=3405894939,1324349563&fm=72", "关注“重邮小帮手”微信公众号，参与学长学姐帮帮忙。", "学长学姐帮帮忙", "https://f12.baidu.com/it/u=3405894939,1324349563&fm=72"))
        }
        callback(data)
        return

        val service = createService(OnlineActivityService::class.java)
        service.requestOnlineActivityActivity()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    if (it.code == RESULT_OK) callback(it.text)
                }, {})
    }
}