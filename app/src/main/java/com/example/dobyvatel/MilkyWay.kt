package com.example.dobyvatel

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.dobyvatel.databinding.ActivityMainBinding
import com.example.dobyvatel.databinding.ActivityPlanetsMapBinding

class MilkyWay : AppCompatActivity() {

    private lateinit var binding: ActivityPlanetsMapBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPlanetsMapBinding.inflate(layoutInflater)
        setContentView(binding.root)


        //        SLNKO
        binding.sun.setOnClickListener{

            val intent = Intent(this, ImageGame::class.java)
            startActivity(intent)


//            binding.mercury.visibility = View.VISIBLE
//            binding.mercuryBlack.visibility = View.GONE

            ///TODO urobit to takto, cez imageSource. Nechat len jeden obrazok
            ///TODO ktoremu sa bude nastavovat rozne source
//            binding.mercuryBlack.setImageResource(R.drawable.milkyway_mercury)
        }

        //        MERKUR
        binding.mercury.setOnClickListener{

            binding.venus.visibility = View.VISIBLE
            binding.venusBlack.visibility = View.GONE
        }

        //        VENUSA
        binding.venus.setOnClickListener{

            binding.earth.visibility = View.VISIBLE
            binding.earthBlack.visibility = View.GONE
        }

        //        ZEM
        binding.earth.setOnClickListener{

            binding.mars.visibility = View.VISIBLE
            binding.marsBlack.visibility = View.GONE
        }

        //        MARS
        binding.mars.setOnClickListener{

            binding.jupiter.visibility = View.VISIBLE
            binding.jupiterBlack.visibility = View.GONE
        }

        //        JUPITER
        binding.jupiter.setOnClickListener{

            binding.saturn.visibility = View.VISIBLE
            binding.saturnBlack.visibility = View.GONE
        }

        //        SATURN
        binding.saturn.setOnClickListener{

            binding.uranus.visibility = View.VISIBLE
            binding.uranusBlack.visibility = View.GONE
        }

        //        URAN
        binding.uranus.setOnClickListener{

            binding.neptune.visibility = View.VISIBLE
            binding.neptuneBlack.visibility = View.GONE
        }

        //        NEPTUN
        binding.neptune.setOnClickListener{


        }








    }
}