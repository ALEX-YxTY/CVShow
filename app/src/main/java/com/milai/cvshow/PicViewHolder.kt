package com.milai.cvshow

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView

/**
 * Created by Administrator on 2017/9/14.
 *
 * 主要功能：
 */
class PicViewHolder(view: View): RecyclerView.ViewHolder(view) {
    val ivHead = view.findViewById<ImageView>(R.id.iv_head)!!
    val name = view.findViewById<TextView>(R.id.tv_name)
}