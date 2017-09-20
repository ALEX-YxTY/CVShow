package com.milai.cvshow

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.bumptech.glide.Glide

class MainActivity : AppCompatActivity(),OnFragmentInteractionListener {

    val gridFragment by lazy { GridFragment() }
    val detailFragment by lazy { DetailFragment() }
    val ivCode by lazy { findViewById<ImageView>(R.id.iv_code)}
    val glide by lazy { Glide.with(this)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initFragment()
    }

    private fun initFragment() {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.frame, gridFragment, "grid")
        transaction.commit()
    }

    override fun onitemClick(id: String, codePic:Int) {
        glide.load(codePic).error(R.drawable.main_code).into(ivCode)
        detailFragment.changeUrl(id)
        val transaction = supportFragmentManager.beginTransaction()
        transaction.setCustomAnimations(R.anim.frag_in,0)
        transaction.add(R.id.frame, detailFragment, "detail")
        transaction.commit()
    }

    override fun onBackPresee() {
        glide.load(R.drawable.main_code).into(ivCode)
        val transaction = supportFragmentManager.beginTransaction()
        transaction.setCustomAnimations(0,R.anim.frag_exit)
        transaction.remove(supportFragmentManager.findFragmentByTag("detail"))
        transaction.commit()
    }
}
