package com.example.dobyvatel

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.dobyvatel.databinding.ActivityMilkywayMapBinding
import com.example.dobyvatel.objects.Constants
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

        binding.saveButton.setOnClickListener{
            saveData()
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

    fun saveData(){

        Constants.isSaved = true

        val sharedPreferences = getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.apply{
            putBoolean("SUN_DONE",MilkyWayPlanets.sunDone)
            putBoolean("MERCURY_DONE",MilkyWayPlanets.mercuryDone)
            putBoolean("VENUS_DONE",MilkyWayPlanets.venusDone)
            putBoolean("EARTH_DONE",MilkyWayPlanets.earthDone)
            putBoolean("MARS_DONE",MilkyWayPlanets.marsDone)
            putBoolean("JUPITER_DONE",MilkyWayPlanets.jupiterDone)
            putBoolean("SATURN_DONE",MilkyWayPlanets.saturnDone)
            putBoolean("URANUS_DONE",MilkyWayPlanets.uranusDone)
            putBoolean("NEPTUNE_DONE",MilkyWayPlanets.neptuneDone)
            putBoolean("SUN_IS_PLAYING",MilkyWayPlanets.sunIsPlaying)
            putBoolean("MERCURY_IS_PLAYING",MilkyWayPlanets.mercuryIsPlaying)
            putBoolean("VENUS_IS_PLAYING",MilkyWayPlanets.venusIsPlaying)
            putBoolean("EARTH_IS_PLAYING",MilkyWayPlanets.earthIsPlaying)
            putBoolean("MARS_IS_PLAYING",MilkyWayPlanets.marsIsPlaying)
            putBoolean("JUPITER_IS_PLAYING",MilkyWayPlanets.jupiterIsPlaying)
            putBoolean("SATURN_IS_PLAYING",MilkyWayPlanets.saturnIsPlaying)
            putBoolean("URANUS_IS_PLAYING",MilkyWayPlanets.uranusIsPlaying)
            putBoolean("NEPTUNE_IS_PLAYING",MilkyWayPlanets.neptuneIsPlaying)

            putBoolean("IS_SAVED",Constants.isSaved)
        }.apply()

        Toast.makeText(this,"Data saved", Toast.LENGTH_SHORT).show()
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