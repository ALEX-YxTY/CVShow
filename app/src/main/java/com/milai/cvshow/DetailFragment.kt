package com.milai.cvshow

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient

class DetailFragment: Fragment() {

    private var mListener: OnFragmentInteractionListener? = null
    private var fragView:View?=null
    private var web:WebView?=null
    private var url: String? = null

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        if (fragView == null) {
            fragView = inflater!!.inflate(R.layout.fragment_detail, container, false)
            fragView?.findViewById<View>(R.id.bt_back)?.setOnClickListener{
                if (mListener != null) {
                    mListener!!.onBackPresee()
                }
            }
        }
        initWebView()
        return fragView
    }


    fun changeUrl(newUrl: String) {
        web?.loadUrl("")
        url = newUrl
    }

    private fun initWebView() {
        if (web == null) {
            web = fragView?.findViewById(R.id.web)
            val settings = web?.settings
            settings?.javaScriptEnabled = true
            settings?.domStorageEnabled = true
            settings?.javaScriptCanOpenWindowsAutomatically = true
            settings?.allowFileAccess = true// 设置允许访问文件数据
            web?.isVerticalScrollBarEnabled = false
            web?.webViewClient = WebViewClient()
            web?.webChromeClient = WebChromeClient()

        }
        web?.loadUrl("http://a.milaipay.com/Home/Index/thenews?id=$url&show=false")
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
