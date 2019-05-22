package com.example.myapplication.kotin

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * create by xujixiao on 2019-05-22 16:27
 */
class MyFragment : Fragment() {
    companion object {
        fun newInstance(): MyFragment {
            val args = Bundle()

            val fragment = MyFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        return view
    }

}
