package com.example.dobyvatel

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.Button
import android.widget.Spinner
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.dobyvatel.objects.Constants
import com.example.dobyvatel.objects.MilkyWayPlanets


class Settings : Fragment(R.layout.fragment_settings) {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_settings, container, false)

        val saveButton = view.findViewById<Button>(R.id.saveThis)
        val difficultyButton = view.findViewById<Button>(R.id.difficultyButton)
        val spinner = view.findViewById<Spinner>(R.id.spinner)

        saveButton.setOnClickListener {

            //Ulozenie dat
            Constants.isSaved = true

            val sharedPreferences =
                this.activity?.getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)

            val editor = sharedPreferences?.edit()
            editor?.apply {
                putBoolean("SUN_DONE", MilkyWayPlanets.sunDone)
                putBoolean("MERCURY_DONE", MilkyWayPlanets.mercuryDone)
                putBoolean("VENUS_DONE", MilkyWayPlanets.venusDone)
                putBoolean("EARTH_DONE", MilkyWayPlanets.earthDone)
                putBoolean("MARS_DONE", MilkyWayPlanets.marsDone)
                putBoolean("JUPITER_DONE", MilkyWayPlanets.jupiterDone)
                putBoolean("SATURN_DONE", MilkyWayPlanets.saturnDone)
                putBoolean("URANUS_DONE", MilkyWayPlanets.uranusDone)
                putBoolean("NEPTUNE_DONE", MilkyWayPlanets.neptuneDone)
                putBoolean("SUN_IS_PLAYING", MilkyWayPlanets.sunIsPlaying)
                putBoolean("MERCURY_IS_PLAYING", MilkyWayPlanets.mercuryIsPlaying)
                putBoolean("VENUS_IS_PLAYING", MilkyWayPlanets.venusIsPlaying)
                putBoolean("EARTH_IS_PLAYING", MilkyWayPlanets.earthIsPlaying)
                putBoolean("MARS_IS_PLAYING", MilkyWayPlanets.marsIsPlaying)
                putBoolean("JUPITER_IS_PLAYING", MilkyWayPlanets.jupiterIsPlaying)
                putBoolean("SATURN_IS_PLAYING", MilkyWayPlanets.saturnIsPlaying)
                putBoolean("URANUS_IS_PLAYING", MilkyWayPlanets.uranusIsPlaying)
                putBoolean("NEPTUNE_IS_PLAYING", MilkyWayPlanets.neptuneIsPlaying)

                putBoolean("IS_SAVED", Constants.isSaved)
            }?.apply()

            Toast.makeText(activity, "Hra uložená", Toast.LENGTH_SHORT).show()
        }

        difficultyButton.setOnClickListener {
            spinner.performClick()
        }

        //Moznost nastavenia obtiaznosti
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

            //vzdy da najprv Obtiaznost ako text
            override fun onNothingSelected(parent: AdapterView<*>?) {
                difficultyButton.text = "Obtiaznost"
            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                difficultyButton.text = spinner.selectedItem.toString()
                val difficulty = spinner.selectedItem.toString()

                if (difficulty == "Ľahká") {
                    Constants.milisinFuture = Constants.easymilisinFuture
                    Constants.countDownInterval = Constants.easycountDownInterval
                    Toast.makeText(
                        activity,
                        "Obťiažnosť nastavená na " + difficulty.lowercase(),
                        Toast.LENGTH_SHORT
                    ).show()
                } else if (difficulty == "Stredná") {
                    Constants.milisinFuture = Constants.mediummilisinFuture
                    Constants.countDownInterval = Constants.mediumcountDownInterval
                    Toast.makeText(
                        activity,
                        "Obťiažnosť nastavená na " + difficulty.lowercase(),
                        Toast.LENGTH_SHORT
                    ).show()
                } else if (difficulty == "Ťažká") {
                    Constants.milisinFuture = Constants.hardmilisinFuture
                    Constants.countDownInterval = Constants.hardcountDownInterval
                    Toast.makeText(
                        activity,
                        "Obťiažnosť nastavená na " + difficulty.lowercase(),
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
        return view
    }
}