package com.milai.cvshow

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.squareup.picasso.Picasso

/**
 * Created by Administrator on 2017/9/14.
 *
 * 主要功能：
 */
class MyGridAdapter(private val ctx: Context, private val picList:List<AdNews>): RecyclerView.Adapter<PicViewHolder>() {

    val picasso = Picasso.with(ctx)

    override fun getItemCount(): Int {
        return picList.size
    }

    override fun onBindViewHolder(holder: PicViewHolder?, position: Int) {
        picasso.load("http://b.milaipay.com/Public/Uploads/applet/59b7830e72aeb.jpg").into(holder?.ivHead)
        holder?.itemView?.setOnClickListener{
            (ctx as OnFragmentInteractionListener).onitemClick("$position")
//            val intent = Intent(ctx, NewsDetailActivity::class.java)
//            intent.putExtra("id", picList[position].id)
//            ctx.startActivity(intent)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): PicViewHolder {
        return PicViewHolder(LayoutInflater.from(ctx).inflate(R.layout.item_grid, parent, false))
    }
}