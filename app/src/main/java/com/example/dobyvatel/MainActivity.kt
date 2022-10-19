package com.example.dobyvatel

import android.content.Context
import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.example.dobyvatel.databinding.ActivityMainBinding
import com.example.dobyvatel.objects.Constants
import com.example.dobyvatel.objects.MilkyWayPlanets

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        gameIsSaved()

        setSupportActionBar(binding.toolbar)

        if(Constants.isSaved ==false){
//            binding.savegame.setBackgroundColor(Color.GRAY)
            binding.savegame.isEnabled = false
        }


        setContentView(binding.root)

        binding.novahra.setOnClickListener {

            val intent = Intent(this, LevelsPage::class.java)
            startActivity(intent)
            finish()
        }

        binding.savegame.setOnClickListener {
            if(Constants.isSaved){
                loadData()
            }
            // load saved game
        }

        binding.debug.setOnClickListener {
            val intent = Intent(this, Quizz::class.java)
            startActivity(intent)
            finish()
        }

    }

    fun loadData(){
        val sharedPreferences = getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)

        val sunDone = sharedPreferences.getBoolean("SUN_DONE",false)
        val mercuryDone = sharedPreferences.getBoolean("MERCURY_DONE",false)
        val venusDone = sharedPreferences.getBoolean("VENUS_DONE",false)
        val earthDone = sharedPreferences.getBoolean("EARTH_DONE",false)
        val marsDone = sharedPreferences.getBoolean("MARS_DONE",false)
        val jupiterDone = sharedPreferences.getBoolean("JUPITER_DONE",false)
        val saturnDone = sharedPreferences.getBoolean("SATURN_DONE",false)
        val uranusDone = sharedPreferences.getBoolean("URANUS_DONE",false)
        val neptuneDone = sharedPreferences.getBoolean("NEPTUNE_DONE",false)

        val sunIsPlaying = sharedPreferences.getBoolean("SUN_IS_PLAYING",false)
        val mercuryIsPlaying = sharedPreferences.getBoolean("MERCURY_IS_PLAYING",false)
        val venusIsPlaying = sharedPreferences.getBoolean("VENUS_IS_PLAYING",false)
        val earthIsPlaying = sharedPreferences.getBoolean("EARTH_IS_PLAYING",false)
        val marsIsPlaying = sharedPreferences.getBoolean("MARS_IS_PLAYING",false)
        val jupiterIsPlaying = sharedPreferences.getBoolean("JUPITER_IS_PLAYING",false)
        val saturnIsPlaying = sharedPreferences.getBoolean("SATURN_IS_PLAYING",false)
        val uranusIsPlaying = sharedPreferences.getBoolean("URANUS_IS_PLAYING",false)
        val neptuneIsPlaying = sharedPreferences.getBoolean("NEPTUNE_IS_PLAYING",false)

        MilkyWayPlanets.sunDone = sunDone
        MilkyWayPlanets.mercuryDone = mercuryDone
        MilkyWayPlanets.venusDone = venusDone
        MilkyWayPlanets.earthDone = earthDone
        MilkyWayPlanets.marsDone = marsDone
        MilkyWayPlanets.jupiterDone = jupiterDone
        MilkyWayPlanets.saturnDone = saturnDone
        MilkyWayPlanets.uranusDone = uranusDone
        MilkyWayPlanets.neptuneDone = neptuneDone

        MilkyWayPlanets.sunIsPlaying = sunIsPlaying
        MilkyWayPlanets.mercuryIsPlaying = mercuryIsPlaying
        MilkyWayPlanets.venusIsPlaying = venusIsPlaying
        MilkyWayPlanets.earthIsPlaying = earthIsPlaying
        MilkyWayPlanets.marsIsPlaying = marsIsPlaying
        MilkyWayPlanets.jupiterIsPlaying = jupiterIsPlaying
        MilkyWayPlanets.saturnIsPlaying = saturnIsPlaying
        MilkyWayPlanets.uranusIsPlaying = uranusIsPlaying
        MilkyWayPlanets.neptuneIsPlaying = neptuneIsPlaying

        val intent = Intent(this, LevelsPage::class.java)
        startActivity(intent)
        finish()
    }

    fun gameIsSaved(){
        val sharedPreferences = getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)
        Constants.isSaved = sharedPreferences.getBoolean("IS_SAVED",false)
    }


    /// TODO
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.cleardata -> {
                val sharedPreferences = getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)
                sharedPreferences.edit().clear().commit()
            }
        }
        return super.onOptionsItemSelected(item)
    }
}

