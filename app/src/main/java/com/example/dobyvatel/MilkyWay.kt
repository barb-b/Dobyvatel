package com.example.dobyvatel

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import com.example.dobyvatel.databinding.ActivityMainBinding
import com.example.dobyvatel.databinding.ActivityPlanetsMapBinding

class MilkyWay : AppCompatActivity() {

    private lateinit var binding: ActivityPlanetsMapBinding
    var sunBoolean = false
    var mercBoolean = false



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPlanetsMapBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if(sunBoolean == true){
            binding.mercury.visibility = View.VISIBLE
            binding.mercuryBlack.visibility = View.GONE
        }


        //        SLNKO
        binding.sun.setOnClickListener{

//            val intent = Intent(this, ImageGame::class.java)
////            startActivity(intent)
//            startActivityForResult(intent,0)

            val intent = Intent(this, ImageGame::class.java)
            resultLauncher.launch(intent)


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
//
//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//
//        if (requestCode == 0) {
//            if (resultCode == RESULT_OK) {
//                // Get the result from intent
//
//                val res = data?.getStringExtra("result")
//
//                var bzl = data?.getBooleanExtra("game",false)
//
//
//                val result = intent.getStringExtra("result")
//                // set the result to the text view
//                findViewById<TextView>(R.id.ufoText).text = "Odblokoval si $res. Vela stastia!"
//            }
//        } else if (requestCode == 1){
//
//            val res = data?.getStringExtra("result")
//
//
//            // set the result to the text view
//            findViewById<TextView>(R.id.ufoText).text = res
//        }
//    }



    var resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            // There are no request codes
            val data: Intent? = result.data

            sunBoolean = data?.getBooleanExtra("boolSun",false) == true
            mercBoolean = data?.getBooleanExtra("boolMerc",false) == true
            if(sunBoolean == true){
                binding.mercury.visibility = View.VISIBLE
                binding.mercuryBlack.visibility = View.GONE
            }

        }
    }
}