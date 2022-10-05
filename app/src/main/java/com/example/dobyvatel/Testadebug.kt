package com.example.dobyvatel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.dobyvatel.databinding.ActivityImageGameBinding
import com.example.dobyvatel.databinding.ActivityTestadebugBinding
import com.example.dobyvatel.objects.MilkyWayPlanets

class Testadebug : AppCompatActivity() {

    private lateinit var binding: ActivityTestadebugBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTestadebugBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.textView.text = "SunDone: " + MilkyWayPlanets.sunDone.toString() + "\n " +
                "mercuryDone: " + MilkyWayPlanets.mercuryDone.toString() + "\n " +
                "venusDone: " + MilkyWayPlanets.venusDone.toString() + "\n " +
                "earthDone: " + MilkyWayPlanets.earthDone.toString() + "\n " +
                "marsDone: " + MilkyWayPlanets.marsDone.toString() + "\n " +
                "jupiterDone: " + MilkyWayPlanets.jupiterDone.toString() + "\n " +
                "saturnDone: " + MilkyWayPlanets.saturnDone.toString() + "\n " +
                "uranusDone: " + MilkyWayPlanets.uranusDone.toString() + "\n " +
                "neptuneDone: " + MilkyWayPlanets.neptuneDone.toString() + "\n " +
                "sunIsPlaying: " + MilkyWayPlanets.sunIsPlaying.toString() + "\n " +
                "mercuryIsPlaying: " + MilkyWayPlanets.mercuryIsPlaying.toString() + "\n " +
                "venusIsPlaying: " + MilkyWayPlanets.venusIsPlaying.toString() + "\n " +
                "earthIsPlaying: " + MilkyWayPlanets.earthIsPlaying.toString() + "\n " +
                "marsIsPlaying: " + MilkyWayPlanets.marsIsPlaying.toString() + "\n " +
                "jupiterIsPlaying: " + MilkyWayPlanets.jupiterIsPlaying.toString() + "\n " +
                "saturnIsPlaying: " + MilkyWayPlanets.saturnIsPlaying.toString() + "\n " +
                "uranusIsPlaying: " + MilkyWayPlanets.uranusIsPlaying.toString() + "\n " +
                "neptuneIsPlaying: " + MilkyWayPlanets.neptuneIsPlaying.toString() + "\n "

    }
}