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
            val gridLayout = GridLayoutManager(this.activity, 3, GridLayout.VERTICAL, false)

            recyclerView?.layoutManager = gridLayout
            val picList = listOf(
                    AdNews("657", R.drawable.zx, "周学", R.drawable.zx_code)
                    , AdNews("665", R.drawable.qk, "钱琨", R.drawable.qk_code)
                    , AdNews("900", R.drawable.zw, "张武", R.drawable.zw_code)
                    , AdNews("1105", R.drawable.sjd, "沈敬东", R.drawable.sjd_code)
                    , AdNews("1104", R.drawable.mc, "马聪", R.drawable.mc_code)
                    , AdNews("867", R.drawable.lad, "鲁安东", R.drawable.lad_code)
                    , AdNews("1066", R.drawable.zhuangw, "庄炜", R.drawable.zhuangw_code)
                    , AdNews("773", R.drawable.`as`, "阿束", R.drawable.as_code)
                    , AdNews("628", R.drawable.wayelee, "WAYE LEE", R.drawable.wayelee_code))
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
