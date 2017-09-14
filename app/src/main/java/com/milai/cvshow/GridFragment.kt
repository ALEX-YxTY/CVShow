package com.milai.cvshow

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridLayout


class GridFragment : Fragment() {

    private var mListener: OnFragmentInteractionListener? = null
    private var fragView: View? = null


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        if (fragView == null) {
            fragView = inflater!!.inflate(R.layout.fragment_grid, container, false)
            val recyclerView = fragView?.findViewById<RecyclerView>(R.id.grid)
            val gridLayout = GridLayoutManager(this.activity, 3, GridLayout.HORIZONTAL, false)

            recyclerView?.layoutManager = gridLayout
            val picList = listOf<AdNews>(AdNews("1","http://b.milaipay.com/Public/Uploads/applet/59b645d5d0cd6.jpg")
                    , AdNews("2","http://b.milaipay.com/Public/Uploads/applet/59b7830e72aeb.jpg")
                    , AdNews("3","http://b.milaipay.com/Public/Uploads/applet/59b24dd04bdc4.jpg")
                    , AdNews("4","http://b.milaipay.com/Public/Uploads/applet/59ae3c29b9543.jpg")
                    , AdNews("5","http://b.milaipay.com/Public/Uploads/applet/59a90a0052471.png")
                    , AdNews("6","http://b.milaipay.com/Public/Uploads/applet/59a8f6bc238a1.png")
                    , AdNews("7","http://b.milaipay.com/Public/Uploads/applet/59a1843d7f7cc.png")
                    , AdNews("8","http://b.milaipay.com/Public/Uploads/applet/598ec8658c5f9.jpg")
                    , AdNews("9","http://b.milaipay.com/Public/Uploads/applet/598c06df8d30b.png"))
            val myGridAdapter = MyGridAdapter(this.activity, picList)
            recyclerView?.adapter = myGridAdapter
        }

        return fragView
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is OnFragmentInteractionListener) {
            mListener = context
        } else {
            throw RuntimeException(context!!.toString() + " must implement OnFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        mListener = null
    }
}
