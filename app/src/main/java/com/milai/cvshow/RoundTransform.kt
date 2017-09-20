package com.milai.cvshow

import android.content.Context
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation
import android.graphics.*

/**
 * Created by Administrator on 2017/9/18.
 *
 * 主要功能：
 */
class RoundTransform(ctx:Context):BitmapTransformation(ctx) {

    override fun getId(): String {
        return javaClass.name
    }

    override fun transform(pool: BitmapPool?, toTransform: Bitmap?, outWidth: Int, outHeight: Int): Bitmap? {
        return roundCrop(pool, toTransform,outWidth,outHeight)
    }

    private fun roundCrop(pool: BitmapPool?, toTransform: Bitmap?, width:Int, height:Int): Bitmap? {
        if (toTransform == null) return null

        var result = pool?.get(toTransform.width, toTransform.height, Bitmap.Config.ARGB_8888)
        if (result == null) {
            result = Bitmap.createBitmap(toTransform.width, toTransform.height, Bitmap.Config.ARGB_8888)
        }

        val canvas = Canvas(result)
        val paint = Paint()
        paint.shader = BitmapShader(toTransform, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP)
        paint.isAntiAlias = true
        val rectF = RectF(0f, 0f, toTransform.width.toFloat(), toTransform.height.toFloat())
        canvas.drawRoundRect(rectF, minOf(width,height).toFloat(), minOf(width,height).toFloat(), paint)
        return result
    }
}