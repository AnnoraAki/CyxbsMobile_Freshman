package com.mredrock.cyxbs.freshman.view.fragment

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mredrock.cyxbs.common.utils.LogUtils
import com.mredrock.cyxbs.freshman.R
import com.mredrock.cyxbs.freshman.base.BaseFragment
import com.mredrock.cyxbs.freshman.bean.Photo
import com.mredrock.cyxbs.freshman.bean.Scenery
import com.mredrock.cyxbs.freshman.interfaces.model.IFragmentSceneryModel
import com.mredrock.cyxbs.freshman.interfaces.presenter.IFragmentSceneryPresenter
import com.mredrock.cyxbs.freshman.interfaces.view.IFragmentSceneryView
import com.mredrock.cyxbs.freshman.presenter.FragmentSceneryPresenter
import com.mredrock.cyxbs.freshman.view.activity.PhotoSceneryActivity
import com.mredrock.cyxbs.freshman.view.adapter.OnItemClickListener
import com.mredrock.cyxbs.freshman.view.adapter.SceneryRecyclerViewAdapter
import org.jetbrains.anko.find

/**
 * Create by roger
 * on 2019/8/3
 */
class SceneryFragment :
        BaseFragment<IFragmentSceneryView, IFragmentSceneryPresenter, IFragmentSceneryModel>(), IFragmentSceneryView{
    private lateinit var recycleview: RecyclerView

    override fun setPhotos(scenery: Scenery) {
        val list = mutableListOf<Photo>()
        list.add(Photo(scenery.title, scenery.photo))
        list.addAll(scenery.photos)
        val adapter = SceneryRecyclerViewAdapter(context!!, list)
        recycleview.adapter = adapter
        adapter.setOnItemClickListener(object : OnItemClickListener {
            override fun onItemClick(position: Int) {
                if (position > 0) {
                    val list2 = ArrayList<String>()
                    for (x in scenery.photos) {
                        list2.add(x.photo)
                    }

                    val intent: Intent = Intent(activity, PhotoSceneryActivity::class.java)
                    intent.putExtra("position", position - 1)
                    intent.putStringArrayListExtra("info", list2)
                    startActivity(intent)
                }
            }

        })
    }

    override fun showError() {
    }

    override fun onCreateView(view: View, savedInstanceState: Bundle?) {
        recycleview = view.find(R.id.rv_scenery)
        val grid = GridLayoutManager(context, 2)
        grid.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
            override fun getSpanSize(position: Int): Int {
                if (position == 0) {
                    return 2
                } else {
                    return 1
                }
            }
        }
        recycleview.layoutManager =grid

        presenter?.start()
    }

    override fun getLayoutRes(): Int {
        return R.layout.freshman_fragment_scenery
    }

    override fun getViewToAttach(): IFragmentSceneryView {
        return this

    }

    override fun createPresenter(): IFragmentSceneryPresenter {
        return FragmentSceneryPresenter()
    }
}