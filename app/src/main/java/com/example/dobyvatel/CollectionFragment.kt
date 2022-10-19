package com.example.dobyvatel

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.example.dobyvatel.objects.Constants


class CollectionFragment : Fragment(R.layout.fragment_collection) {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_collection, container, false)
        val image = view.findViewById<ImageView>(R.id.goldemImage)

                if (Constants.isTrue){
            image.visibility = View.VISIBLE
        }

        return  view
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_collection, container, false)
    }

//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//
//
//        val v = view.findViewById<ImageView>(R.id.imageView2)
//
//        if (Constants.isTrue){
//            v.visibility = View.VISIBLE
//        }
//
//        super.onViewCreated(view, savedInstanceState)
//    }

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//
//
//    }

}