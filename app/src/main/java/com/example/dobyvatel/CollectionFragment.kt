package com.example.dobyvatel

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.example.dobyvatel.objects.Constants
import com.example.dobyvatel.objects.MilkyWayPlanets


class CollectionFragment : Fragment(R.layout.fragment_collection) {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_collection, container, false)
//        val image = view.findViewById<ImageView>(R.id.goldemImage)

//        if (Constants.isTrue){
//            image.visibility = View.VISIBLE
//        }

        return  view
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_collection, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {


        val sunCard = view.findViewById<ImageView>(R.id.sunCard)
        val merkuryCard = view.findViewById<ImageView>(R.id.merkuryCard)
        val venusCard = view.findViewById<ImageView>(R.id.venusCard)
        val earthCard = view.findViewById<ImageView>(R.id.earthCard)
        val marsCard = view.findViewById<ImageView>(R.id.marsCard)
        val jupiterCard = view.findViewById<ImageView>(R.id.jupiterCard)
        val saturnCard = view.findViewById<ImageView>(R.id.saturnCard)
        val uranCard = view.findViewById<ImageView>(R.id.uranCard)
        val neptuneCard = view.findViewById<ImageView>(R.id.neptuneCard)

        if(MilkyWayPlanets.sunDone){
            sunCard.visibility = View.VISIBLE
        }
        if(MilkyWayPlanets.mercuryDone){
            merkuryCard.visibility = View.VISIBLE
        }
        if(MilkyWayPlanets.venusDone){
            venusCard.visibility = View.VISIBLE
        }
        if(MilkyWayPlanets.earthDone){
            earthCard.visibility = View.VISIBLE
        }
        if(MilkyWayPlanets.marsDone){
            marsCard.visibility = View.VISIBLE
        }
        if(MilkyWayPlanets.jupiterDone){
            jupiterCard.visibility = View.VISIBLE
        }
        if(MilkyWayPlanets.saturnDone){
            saturnCard.visibility = View.VISIBLE
        }
        if(MilkyWayPlanets.uranusDone){
            uranCard.visibility = View.VISIBLE
        }
        if(MilkyWayPlanets.neptuneDone){
            neptuneCard.visibility = View.VISIBLE
        }

        super.onViewCreated(view, savedInstanceState)
    }

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//
//
//    }

}