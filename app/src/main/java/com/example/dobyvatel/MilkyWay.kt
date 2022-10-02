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



        //        SLNKO
        binding.sun.setOnClickListener{

//            val intent = Intent(this, ImageGame::class.java)
////            startActivity(intent)
//            startActivityForResult(intent,0)

            if(sunBoolean == false){

                val intent = Intent(this, ImageGame::class.java)
                resultLauncher.launch(intent)
            }else{

                //TODO level je splneny, malo by sa nieco vypisat
            }





            ///TODO urobit to takto, cez imageSource. Nechat len jeden obrazok
            ///TODO ktoremu sa bude nastavovat rozne source
//            binding.mercuryBlack.setImageResource(R.drawable.milkyway_mercury)
        }

        //        MERKUR
        binding.mercury.setOnClickListener{


        }

        //        VENUSA
        binding.venus.setOnClickListener{


        }

        //        ZEM
        binding.earth.setOnClickListener{


        }

        //        MARS
        binding.mars.setOnClickListener{


        }

        //        JUPITER
        binding.jupiter.setOnClickListener{


        }

        //        SATURN
        binding.saturn.setOnClickListener{


        }

        //        URAN
        binding.uranus.setOnClickListener{


        }

        //        NEPTUN
        binding.neptune.setOnClickListener{


            //TODO otvorenie suhvezdi
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
                binding.mercury.setImageResource(R.drawable.milkyway_mercury)
            }

        }
    }
}