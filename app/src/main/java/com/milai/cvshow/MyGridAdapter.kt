package com.milai.cvshow

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.bumptech.glide.Glide

/**
 * Created by Administrator on 2017/9/14.
 *
 * 主要功能：
 */
class MyGridAdapter(private val ctx: Context, private val picList:List<AdNews>): RecyclerView.Adapter<PicViewHolder>() {

    val glide = Glide.with(ctx)

    override fun getItemCount(): Int {
        return picList.size
    }

    override fun onBindViewHolder(holder: PicViewHolder?, position: Int) {
        val adNews = picList[position]
        glide.load(adNews.pic).transform(RoundTransform(ctx)).into(holder?.ivHead)
        holder?.name?.text = adNews.name
        holder?.itemView?.setOnClickListener{
            (ctx as OnFragmentInteractionListener).onitemClick(adNews.id, adNews.code)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): PicViewHolder {
        return PicViewHolder(LayoutInflater.from(ctx).inflate(R.layout.item_grid, parent, false))
    }
}