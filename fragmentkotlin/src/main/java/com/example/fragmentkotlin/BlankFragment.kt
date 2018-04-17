package com.example.fragmentkotlin


import android.os.Bundle
//import android.support.v4.app.Fragment
import android.app.Fragment
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class BlankFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        val rtVw=inflater.inflate(R.layout.fragment_blank, container, false)
        rtVw.findViewById<Button>(R.id.btnMob).setOnClickListener {
//            (activity as MainActivity).loadFrag(Mobile())

            (activity as MainActivity).loadFrag(SimpleFragment.create(Color.DKGRAY))
        }
        rtVw.findViewById<Button>(R.id.btnLaptop).setOnClickListener {
//            (activity as MainActivity).loadFrag(Laptop())

            (activity as MainActivity).loadFrag(SimpleFragment.create(Color.LTGRAY))
        }
        rtVw.findViewById<Button>(R.id.btnTv).setOnClickListener {
//            (activity as MainActivity).loadFrag(TV())

            (activity as MainActivity).loadFrag(SimpleFragment.create(Color.YELLOW))
        }
        return rtVw
    }


}
