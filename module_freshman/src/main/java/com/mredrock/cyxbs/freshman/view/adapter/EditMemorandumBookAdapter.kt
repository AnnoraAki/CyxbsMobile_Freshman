package com.mredrock.cyxbs.freshman.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mredrock.cyxbs.common.utils.extensions.gone
import com.mredrock.cyxbs.freshman.R
import com.mredrock.cyxbs.freshman.bean.EnrollmentRequirementsItemBean
import com.mredrock.cyxbs.freshman.bean.EnrollmentRequirementsTitleBean
import com.mredrock.cyxbs.freshman.bean.STATUS_FALSE_CUSTOM
import com.mredrock.cyxbs.freshman.bean.STATUS_TRUE_CUSTOM
import com.mredrock.cyxbs.freshman.interfaces.ParseBean
import com.mredrock.cyxbs.freshman.util.event.MemorandumBookItemSelectedEvent
import com.mredrock.cyxbs.freshman.util.event.MemorandumBookItemUnSelectedEvent
import org.greenrobot.eventbus.EventBus

/**
 * Create by yuanbing
 * on 2019/8/10
 */
class EditMemorandumBookAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var mMemorandumBook: List<ParseBean> = listOf()
    private val header = 0
    private val item = 1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == header) {
            val view = LayoutInflater.from(parent.context).inflate(
                    R.layout.freshman_recycle_item_enrollment_requirements_title, parent, false)
            EnrollmentRequirementsTitleViewHolder(view)
        } else {
            val view = LayoutInflater.from(parent.context).inflate(
                    R.layout.freshman_recycle_item_enrollment_requirements_item, parent, false)
            EnrollmentRequirementsItemViewHolder(view)
        }
    }

    override fun getItemCount() = mMemorandumBook.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (getItemViewType(position) == header) {
            holder as EnrollmentRequirementsTitleViewHolder
            val memorandumBook = mMemorandumBook[position] as EnrollmentRequirementsTitleBean
            holder.mTitle.text = memorandumBook.title
        } else {
            holder as EnrollmentRequirementsItemViewHolder
            val memorandumBook = mMemorandumBook[position] as EnrollmentRequirementsItemBean
            holder.mDescription.gone()
            holder.mSwitch.gone()
            holder.mName.text = memorandumBook.name
            val status = memorandumBook.status
            when (status) {
                STATUS_TRUE_CUSTOM -> {
                    holder.mTag.setImageResource(
                            R.drawable.freshman_recycle_item_enrollment_requirements_todo)
                }
                STATUS_FALSE_CUSTOM -> {
                    holder.mTag.setImageResource(
                            R.drawable.freshman_recycle_item_edit_memorandum_book_selected)
                }
            }
            holder.itemView.setOnClickListener {
                if (status == STATUS_FALSE_CUSTOM) {
                    EventBus.getDefault().post(MemorandumBookItemUnSelectedEvent(memorandumBook.name))
                } else {
                    EventBus.getDefault().post(MemorandumBookItemSelectedEvent(memorandumBook.name))
                }
                memorandumBook.status = -status
                notifyItemChanged(position)
            }
        }
    }

    override fun getItemViewType(position: Int) =
            if (mMemorandumBook[position] is EnrollmentRequirementsTitleBean) header else item

    fun refreshData(memorandumBook: List<ParseBean>) {
        mMemorandumBook = memorandumBook
        notifyDataSetChanged()
    }
}