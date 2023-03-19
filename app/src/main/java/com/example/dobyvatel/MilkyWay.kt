package com.example.dobyvatel

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.LifecycleObserver

import com.example.dobyvatel.databinding.ActivityMilkywayMapBinding
import com.example.dobyvatel.objects.Constants
import com.example.dobyvatel.objects.MilkyWayPlanets

class MilkyWay : AppCompatActivity() {

    private lateinit var binding: ActivityMilkywayMapBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMilkywayMapBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Funkcia pozrie, ktora planeta je hotova a ktora nie
        setImages()

        // animation
        val slideIn = AnimationUtils.loadAnimation(this, R.anim.slidein)
        binding.chest.startAnimation(slideIn)

        binding.settings.animate().rotationBy(200F).setDuration(2000)

        //        SLNKO
        binding.sun.setOnClickListener {

            if (MilkyWayPlanets.sunDone == false) {

                MilkyWayPlanets.sunIsPlaying = true

                val intent = Intent(this, DecisionPage::class.java)
                resultLauncher.launch(intent)
            }
        }

        //        MERKUR
        binding.mercury.setOnClickListener {

            if (MilkyWayPlanets.mercuryIsPlaying) {
                MilkyWayPlanets.mercuryIsPlaying = true
                val intent = Intent(this, DecisionPage::class.java)
                resultLauncher.launch(intent)
            }
        }

        //        VENUSA
        binding.venus.setOnClickListener {

            if (MilkyWayPlanets.venusIsPlaying) {
                val intent = Intent(this, DecisionPage::class.java)
                resultLauncher.launch(intent)
            }
        }

        //        ZEM
        binding.earth.setOnClickListener {

            if (MilkyWayPlanets.earthIsPlaying) {
                val intent = Intent(this, DecisionPage::class.java)
                resultLauncher.launch(intent)
            }
        }

        //        MARS
        binding.mars.setOnClickListener {

            if (MilkyWayPlanets.marsIsPlaying) {
                val intent = Intent(this, DecisionPage::class.java)
                resultLauncher.launch(intent)
            }
        }

        //        JUPITER
        binding.jupiter.setOnClickListener {

            if (MilkyWayPlanets.jupiterIsPlaying) {
                val intent = Intent(this, DecisionPage::class.java)
                resultLauncher.launch(intent)
            }
        }

        //        SATURN
        binding.saturn.setOnClickListener {

            if (MilkyWayPlanets.saturnIsPlaying) {
                val intent = Intent(this, DecisionPage::class.java)
                resultLauncher.launch(intent)
            }
        }

        //        URAN
        binding.uranus.setOnClickListener {

            if (MilkyWayPlanets.uranusIsPlaying) {
                val intent = Intent(this, DecisionPage::class.java)
                resultLauncher.launch(intent)
            }
        }

        //        NEPTUN
        binding.neptune.setOnClickListener {

            if (MilkyWayPlanets.neptuneIsPlaying) {
                val intent = Intent(this, DecisionPage::class.java)
                resultLauncher.launch(intent)
            }
        }

        binding.chest.setOnClickListener {

            // zakazdim sa aktualizuje a pozrie sa, ktore planety su hotove
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.collectionfragment, CollectionFragment())
                commit()
            }

            if (binding.collectionfragment.isVisible) {
                binding.collectionfragment.visibility = View.GONE
            } else {
                binding.collectionfragment.visibility = View.VISIBLE
            }
        }

        binding.settings.setOnClickListener {

            binding.settings.animate().rotationBy(200F).setDuration(2000)

            supportFragmentManager.beginTransaction().apply {
                replace(R.id.settingFragment, Settings())
                commit()
            }
            if (binding.settingFragment.isVisible) {
                binding.settingFragment.visibility = View.GONE
            } else {
                binding.settingFragment.visibility = View.VISIBLE
            }
        }
    }


    fun setImages() {
        if (MilkyWayPlanets.sunDone) {
            binding.mercury.setImageResource(R.drawable.milkyway_mercury)
        }
        if (MilkyWayPlanets.mercuryDone) {
            binding.venus.setImageResource(R.drawable.milkyway_venus)
        }
        if (MilkyWayPlanets.venusDone) {
            binding.earth.setImageResource(R.drawable.milkyway_earth)
        }
        if (MilkyWayPlanets.earthDone) {
            binding.mars.setImageResource(R.drawable.milkyway_mars)
        }
        if (MilkyWayPlanets.marsDone) {
            binding.jupiter.setImageResource(R.drawable.milkyway_jupiter)
        }
        if (MilkyWayPlanets.jupiterDone) {
            binding.saturn.setImageResource(R.drawable.milkyway_saturn)
        }
        if (MilkyWayPlanets.saturnDone) {
            binding.uranus.setImageResource(R.drawable.milkyway_uran)
        }
        if (MilkyWayPlanets.uranusDone) {
            binding.neptune.setImageResource(R.drawable.milkyway_neptune)
        }
    }

    var resultLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {

                //ked sa vrati z planety aktualizuje co je hotove a co nie
                val data: Intent? = result.data
                setImages()
            }
        }
}