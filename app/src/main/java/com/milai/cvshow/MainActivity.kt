package com.milai.cvshow

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.FragmentManager
import android.widget.FrameLayout
import android.widget.GridLayout
import android.widget.Toast

class MainActivity : AppCompatActivity(),OnFragmentInteractionListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initFragment()
    }

    private fun initFragment() {
        val fragmentManager = this.supportFragmentManager
        val gridFragment = GridFragment()
        val beginTransaction = fragmentManager.beginTransaction()
        beginTransaction.add(R.id.frame, gridFragment, "grid")
        beginTransaction.commit()
    }

    override fun onitemClick(id: String) {
        Toast.makeText(this,"item click $id",Toast.LENGTH_SHORT).show()
    }
}
