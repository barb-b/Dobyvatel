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
//    public lateinit var sunBoolean: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPlanetsMapBinding.inflate(layoutInflater)
        setContentView(binding.root)


        //TODO urobit to so vsetkymi planetami, ak je level done, obrazok je odmknuty
        if(MilkyWayDone.sun == true){
            binding.mercury.setImageResource(R.drawable.milkyway_mercury)
        }

        //        SLNKO
        binding.sun.setOnClickListener{

//            val intent = Intent(this, ImageGame::class.java)
////            startActivity(intent)
//            startActivityForResult(intent,0)

            if(MilkyWayDone.sun == false){

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

            if(MilkyWayDone.mercury == true){
                ///TODO nic sa neotvara
            }else{
                ///TODO otvori sa hraci level
            }


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

        binding.chest.setOnClickListener{
            //TODO presmerovanie na stranku, kde budu ulozene karticky

            binding.mercury.setImageResource(R.drawable.milkyway_mercury)
            binding.venus.setImageResource(R.drawable.milkyway_venus)
            binding.mars.setImageResource(R.drawable.milkyway_mars)
            binding.earth.setImageResource(R.drawable.milkyway_earth)
            binding.jupiter.setImageResource(R.drawable.milkyway_jupiter)
            binding.saturn.setImageResource(R.drawable.milkyway_saturn)
            binding.neptune.setImageResource(R.drawable.milkyway_neptune)
            binding.uranus.setImageResource(R.drawable.milkyway_uran)
        }
    }

    var resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            // There are no request codes
            val data: Intent? = result.data

            MilkyWayDone.sun = data?.getBooleanExtra("boolSun",false) == true
            MilkyWayDone.mercury = data?.getBooleanExtra("boolMerc",false) == true
            if(MilkyWayDone.sun == true){
                binding.mercury.setImageResource(R.drawable.milkyway_mercury)
            }

        }
    }
}