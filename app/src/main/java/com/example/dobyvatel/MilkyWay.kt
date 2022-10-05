package com.example.dobyvatel

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.dobyvatel.databinding.ActivityMilkywayMapBinding
import com.example.dobyvatel.objects.MilkyWayPlanets

class MilkyWay : AppCompatActivity() {

    private lateinit var binding: ActivityMilkywayMapBinding
//    public lateinit var sunBoolean: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMilkywayMapBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //TODO urobit to so vsetkymi planetami, ak je level done, obrazok je odmknuty
        setImages()

        //        SLNKO
        binding.sun.setOnClickListener{
//            val intent = Intent(this, ImageGame::class.java)
////            startActivity(intent)
//            startActivityForResult(intent,0)

            if(MilkyWayPlanets.sunDone == false){

                MilkyWayPlanets.sunIsPlaying = true

                val intent = Intent(this, DecisionPage::class.java)
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

            if(MilkyWayPlanets.mercuryIsPlaying){
                MilkyWayPlanets.mercuryIsPlaying = true
                ///TODO slnko je zvladnute takze sa ide do hry
                val intent = Intent(this, DecisionPage::class.java)
                resultLauncher.launch(intent)
//                val intent = Intent(this, DecisionPage::class.java)
//                startActivity(intent)

            }else{
                ///TODO neotvori sa nic button je neaktivny
            }
        }

        //        VENUSA
        binding.venus.setOnClickListener{

            if(MilkyWayPlanets.venusIsPlaying){

                ///TODO slnko je zvladnute takze sa ide do hry
                val intent = Intent(this, DecisionPage::class.java)
                resultLauncher.launch(intent)
//                val intent = Intent(this, DecisionPage::class.java)
//                startActivity(intent)

            }else{
                ///TODO neotvori sa nic button je neaktivny
            }
        }

        //        ZEM
        binding.earth.setOnClickListener{

            if(MilkyWayPlanets.earthIsPlaying){
                ///TODO slnko je zvladnute takze sa ide do hry
                val intent = Intent(this, DecisionPage::class.java)
                resultLauncher.launch(intent)
//                val intent = Intent(this, DecisionPage::class.java)
//                startActivity(intent)

            }else{
                ///TODO neotvori sa nic button je neaktivny
            }
        }

        //        MARS
        binding.mars.setOnClickListener{

            if(MilkyWayPlanets.marsIsPlaying){
                ///TODO slnko je zvladnute takze sa ide do hry
                val intent = Intent(this, DecisionPage::class.java)
                resultLauncher.launch(intent)
//                val intent = Intent(this, DecisionPage::class.java)
//                startActivity(intent)

            }else{
                ///TODO neotvori sa nic button je neaktivny
            }

        }

        //        JUPITER
        binding.jupiter.setOnClickListener{

            if(MilkyWayPlanets.jupiterIsPlaying){

                ///TODO slnko je zvladnute takze sa ide do hry
                val intent = Intent(this, DecisionPage::class.java)
                resultLauncher.launch(intent)
//                val intent = Intent(this, DecisionPage::class.java)
//                startActivity(intent)

            }else{
                ///TODO neotvori sa nic button je neaktivny
            }
        }

        //        SATURN
        binding.saturn.setOnClickListener{

            if(MilkyWayPlanets.saturnIsPlaying){

                ///TODO slnko je zvladnute takze sa ide do hry
                val intent = Intent(this, DecisionPage::class.java)
                resultLauncher.launch(intent)
//                val intent = Intent(this, DecisionPage::class.java)
//                startActivity(intent)

            }else{
                ///TODO neotvori sa nic button je neaktivny
            }
        }

        //        URAN
        binding.uranus.setOnClickListener{

            if(MilkyWayPlanets.uranusIsPlaying){

                ///TODO slnko je zvladnute takze sa ide do hry
                val intent = Intent(this, DecisionPage::class.java)
                resultLauncher.launch(intent)
//                val intent = Intent(this, DecisionPage::class.java)
//                startActivity(intent)

            }else{
                ///TODO neotvori sa nic button je neaktivny
            }
        }

        //        NEPTUN
        binding.neptune.setOnClickListener{

            if(MilkyWayPlanets.neptuneIsPlaying){

                ///TODO slnko je zvladnute takze sa ide do hry
                val intent = Intent(this, DecisionPage::class.java)
                resultLauncher.launch(intent)
//                val intent = Intent(this, DecisionPage::class.java)
//                startActivity(intent)

            }else{
                ///TODO neotvori sa nic button je neaktivny
            }

            //TODO otvorenie suhvezdi
        }

        binding.chest.setOnClickListener{
            //TODO presmerovanie na stranku, kde budu ulozene karticky

            val intent = Intent(this, Testadebug::class.java)
            startActivity(intent)


//            binding.mercury.setImageResource(R.drawable.milkyway_mercury)
//            binding.venus.setImageResource(R.drawable.milkyway_venus)
//            binding.mars.setImageResource(R.drawable.milkyway_mars)
//            binding.earth.setImageResource(R.drawable.milkyway_earth)
//            binding.jupiter.setImageResource(R.drawable.milkyway_jupiter)
//            binding.saturn.setImageResource(R.drawable.milkyway_saturn)
//            binding.neptune.setImageResource(R.drawable.milkyway_neptune)
//            binding.uranus.setImageResource(R.drawable.milkyway_uran)
        }
    }

    fun setImages(){
        if(MilkyWayPlanets.sunDone){
            binding.mercury.setImageResource(R.drawable.milkyway_mercury)
        }
        if(MilkyWayPlanets.mercuryDone){
            binding.venus.setImageResource(R.drawable.milkyway_venus)
        }
        if(MilkyWayPlanets.venusDone){
            binding.earth.setImageResource(R.drawable.milkyway_earth)
        }
        if(MilkyWayPlanets.earthDone){
            binding.mars.setImageResource(R.drawable.milkyway_mars)
        }
        if(MilkyWayPlanets.marsDone){
            binding.jupiter.setImageResource(R.drawable.milkyway_jupiter)
        }
        if(MilkyWayPlanets.jupiterDone){
            binding.saturn.setImageResource(R.drawable.milkyway_saturn)
        }
        if(MilkyWayPlanets.saturnDone){
            binding.uranus.setImageResource(R.drawable.milkyway_uran)
        }
        if(MilkyWayPlanets.uranusDone){
            binding.neptune.setImageResource(R.drawable.milkyway_neptune)
        }
    }

    var resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            // There are no request codes
            val data: Intent? = result.data

            //TODO nastavit to priamo v

//            MilkyWayDone.sun = data?.getBooleanExtra("boolSun",false) == true
//            MilkyWayDone.mercury = data?.getBooleanExtra("boolMerc",false) == true
            setImages()
            binding.ufoText.text = "data sa poslali"
        }
    }
}