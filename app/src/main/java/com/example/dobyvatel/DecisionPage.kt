package com.example.dobyvatel

import android.animation.ObjectAnimator
import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.models.SlideModel
import com.example.dobyvatel.databinding.ActivityDecisionPageBinding
import com.example.dobyvatel.objects.MilkyWayPlanets
import kotlin.random.Random


class DecisionPage : AppCompatActivity() {

    private lateinit var binding: ActivityDecisionPageBinding

    var howManyTimes = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDecisionPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val imageSlider = binding.imageSlider
        val imageList = ArrayList<SlideModel>()

        //tlacitka nebudu enable dokym si uzivatel neprecita vsetko
        binding.fight.isEnabled = false
        binding.fight.setBackgroundColor(Color.GRAY)
        binding.peace.isEnabled = false
        binding.peace.setBackgroundColor(Color.GRAY)

        //TODO hlavny obrazok podla toho aka planeta je otvorena
        // text podla toho aka planeta je otvorena

        // nastavy sa text a hlavny obrazok podla toho, co sa hra
        if (MilkyWayPlanets.sunIsPlaying) {

            imageList.clear()
            imageList.add(SlideModel("https://i.ibb.co/52DwRgn/slnkoblizko.jpg","Slnko z blizka"))
            imageList.add(SlideModel("https://i.ibb.co/2c1sx1G/povrch-slnka.jpg","Povrch slnka"))
            imageSlider.setImageList(imageList,ScaleTypes.CENTER_CROP)
            binding.textAboutPlanet.text = "Slnko opis bla bla bla bla bla "

        } else if (MilkyWayPlanets.mercuryIsPlaying) {

            imageList.clear()
            imageList.add(SlideModel("https://i.ibb.co/bB64gtk/povrch-merkuru.jpg","Povrch Merkuru"))
            imageList.add(SlideModel("https://i.ibb.co/KVn8zM7/mineralyapovrchoveprocesy.jpg","Stopy minerálov a povrchových procesoch"))
            imageSlider.setImageList(imageList,ScaleTypes.CENTER_CROP)
            binding.textAboutPlanet.text = "Merkus opis"

        } else if (MilkyWayPlanets.venusIsPlaying) {
            imageList.clear()
            imageList.add(SlideModel("https://i.ibb.co/hVwCrVW/venusapovrh.jpg","Povrch Venuse"))
            imageList.add(SlideModel("https://i.ibb.co/SvdhFCX/19-SCI-OUTTHERE-VENUS1-video-Sixteen-By-Nine3000.jpg","Venusa zabalena v hustej vrstve toxických mrakov"))
            imageSlider.setImageList(imageList,ScaleTypes.CENTER_CROP)
//            binding.textAboutPlanet.text = ""
        } else if (MilkyWayPlanets.earthIsPlaying) {

            imageList.clear()
            imageList.add(SlideModel("https://i.ibb.co/XjsdTqG/tornadozem.jpg","Tornado"))
            imageList.add(SlideModel("https://i.ibb.co/qYTTRc7/detailnezem.jpg","Detail zeme"))
            imageSlider.setImageList(imageList,ScaleTypes.CENTER_CROP)
            binding.textAboutPlanet.text = "Venusa opis"

        } else if (MilkyWayPlanets.marsIsPlaying) {

            imageList.clear()
            imageList.add(SlideModel("https://i.ibb.co/F4ZRQ7W/mars.jpg","Mars"))
            imageList.add(SlideModel("https://i.ibb.co/pKBSRjm/marsrover.jpg","Rover"))
            imageSlider.setImageList(imageList,ScaleTypes.CENTER_CROP)
            binding.textAboutPlanet.text = "Mars opis"

        } else if (MilkyWayPlanets.jupiterIsPlaying) {

            imageList.clear()
            imageList.add(SlideModel("https://i.ibb.co/fqGNmPX/jupiterzblizka.jpg","Jupiter z blizka"))
            imageList.add(SlideModel("https://i.ibb.co/QKLNtH9/jupiter.jpg","Jupiter"))
            imageSlider.setImageList(imageList,ScaleTypes.CENTER_CROP)
            binding.textAboutPlanet.text = "Jupiter opis"

        } else if (MilkyWayPlanets.saturnIsPlaying) {
            imageList.clear()
            imageList.add(SlideModel("https://i.ibb.co/cbgXJmK/saturn.jpg","Saturn"))
            imageList.add(SlideModel("https://i.ibb.co/bdf82LL/saturnvortex.jpg","Saturn"))
            imageSlider.setImageList(imageList,ScaleTypes.CENTER_CROP)
            binding.textAboutPlanet.text = "Saturn opis"

        } else if (MilkyWayPlanets.uranusIsPlaying) {
            imageList.clear()
            imageList.add(SlideModel("https://i.ibb.co/drm6CRd/uranus.jpg","Uran"))
            imageList.add(SlideModel("https://i.ibb.co/1TNfRBt/uranusfalsecolor.jpg","Uran"))
            imageSlider.setImageList(imageList,ScaleTypes.CENTER_CROP)
            binding.textAboutPlanet.text = "Uran opis"

        } else if (MilkyWayPlanets.neptuneIsPlaying) {
            imageList.clear()
            imageList.add(SlideModel("https://i.ibb.co/LzjM54b/neptuneclouds.jpg","Neptun"))
            imageList.add(SlideModel("https://i.ibb.co/LJSn02y/neptunevertical.jpg","Neptun"))
            imageSlider.setImageList(imageList,ScaleTypes.CENTER_CROP)
            binding.textAboutPlanet.text = "Neptune opis"
        }



        ///LISTENERS
        binding.fight.setOnClickListener {
            //TODO presmerovanie na imageGame stranku
            // algoritmus -> ci sa akceptuje boj alebo nie
            // prepocitavanie -> zmizne druhy button -> zmizne text -> odpocitavanie, potom sa objavi vysledok
            // a bude presmerovany na stranku ktora zvitazi
            // mozno nejaka statistika, ze kolko krat si vybral hrac boj a mier
            // vyhodnocovanie -> vypnut scrollview, zmena textu atd

            binding.scrollPlanet.visibility = View.GONE
            binding.textAboutPlanet.visibility = View.GONE
            binding.peace.visibility = View.GONE
            binding.fight.visibility = View.GONE

            binding.progressDecision.visibility = View.VISIBLE

            //najprv je loading a potom je vypisana decission
            Handler(Looper.getMainLooper()).postDelayed({
                binding.progressDecision.visibility = View.GONE
                acceptedOrNot(1)
            }, 5000)
        }

        binding.peace.setOnClickListener {
            //TODO mierova dohoda?? kam to bude
            // detto algoritmus ci sa rozhodnu to schvalit
            binding.scrollPlanet.visibility = View.GONE
            binding.textAboutPlanet.visibility = View.GONE
            binding.peace.visibility = View.GONE
            binding.fight.visibility = View.GONE

            binding.progressDecision.visibility = View.VISIBLE

            //najprv je loading a potom je vypisana decission
            Handler(Looper.getMainLooper()).postDelayed({
                binding.progressDecision.visibility = View.GONE
                acceptedOrNot(0)
            }, 5000)
        }


        ///LISTENERS QUESTION
        binding.question1.setOnClickListener {
            howManyTimes++
            if(howManyTimes == 3){
                //Ak su uz vsetky otazky zodpovedane
                binding.fight.isEnabled = true
                binding.peace.isEnabled = true
                binding.fight.setBackgroundColor(resources.getColor(R.color.neon_green))
                binding.peace.setBackgroundColor(resources.getColor(R.color.neon_green))

                val actualText = binding.textAboutPlanet.text.toString()
                val question = returnQuestion(1)
                binding.textAboutPlanet.text = actualText + question

            }else{

                val actualText = binding.textAboutPlanet.text.toString()
                val question = returnQuestion(1)
                binding.textAboutPlanet.text = actualText + question
            }

            //zmiznutie otazky
            binding.question1.visibility = View.INVISIBLE
        }

        binding.question2.setOnClickListener {

            howManyTimes++
            if(howManyTimes == 3){
                //Ak su uz vsetky otazky zodpovedane
                binding.fight.isEnabled = true
                binding.peace.isEnabled = true
                binding.fight.setBackgroundColor(resources.getColor(R.color.neon_green))
                binding.peace.setBackgroundColor(resources.getColor(R.color.neon_green))

                val actualText = binding.textAboutPlanet.text.toString()
                val question = returnQuestion(2)
                binding.textAboutPlanet.text = actualText + question

            }else{

                val actualText = binding.textAboutPlanet.text.toString()
                val question = returnQuestion(2)
                binding.textAboutPlanet.text = actualText + question
            }

            //zmiznutie otazky
            binding.question2.visibility = View.INVISIBLE
        }

        binding.question3.setOnClickListener {
            howManyTimes++

            if(howManyTimes == 3){
                //Ak su uz vsetky otazky zodpovedane
                binding.fight.isEnabled = true
                binding.peace.isEnabled = true
                binding.fight.setBackgroundColor(resources.getColor(R.color.neon_green))
                binding.peace.setBackgroundColor(resources.getColor(R.color.neon_green))

                val actualText = binding.textAboutPlanet.text.toString()
                val question = returnQuestion(3)
                binding.textAboutPlanet.text = actualText + question

            }else{

                val actualText = binding.textAboutPlanet.text.toString()
                val question = returnQuestion(3)
                binding.textAboutPlanet.text = actualText + question
            }

            //zmiznutie otazky
            binding.question3.visibility = View.INVISIBLE
        }

    }

    fun returnQuestion (numberOfQuestion:Int) :String{
        if (MilkyWayPlanets.sunIsPlaying) {
            when(numberOfQuestion){
                1 -> return "\n TED: bla bla bla bla bla bla otazka1 \n DOMORODEC: bla bla bla bla bla odpoved \n"
                2 -> return "\n TED: bla bla bla bla bla bla otazka2 \n DOMORODEC: bla bla bla bla bla odpoved \n"
                3-> return "\n TED: bla bla bla bla bla bla otazka3 \n DOMORODEC: bla bla bla bla bla odpoved \n"
            }
        } else if (MilkyWayPlanets.mercuryIsPlaying) {
            when(numberOfQuestion){
                1 -> return "\n TED: bla bla bla bla bla bla otazka1 \n DOMORODEC: bla bla bla bla bla odpoved \n"
                2 -> return "\n TED: bla bla bla bla bla bla otazka2 \n DOMORODEC: bla bla bla bla bla odpoved \n"
                3-> return "\n TED: bla bla bla bla bla bla otazka3 \n DOMORODEC: bla bla bla bla bla odpoved \n"
            }
        } else if (MilkyWayPlanets.venusIsPlaying) {
            when(numberOfQuestion){
                1 -> return "\n TED: bla bla bla bla bla bla otazka1 \n DOMORODEC: bla bla bla bla bla odpoved \n"
                2 -> return "\n TED: bla bla bla bla bla bla otazka2 \n DOMORODEC: bla bla bla bla bla odpoved \n"
                3-> return "\n TED: bla bla bla bla bla bla otazka3 \n DOMORODEC: bla bla bla bla bla odpoved \n"
            }
        } else if (MilkyWayPlanets.earthIsPlaying) {
            when(numberOfQuestion){
                1 -> return "\n TED: bla bla bla bla bla bla otazka1 \n DOMORODEC: bla bla bla bla bla odpoved \n"
                2 -> return "\n TED: bla bla bla bla bla bla otazka2 \n DOMORODEC: bla bla bla bla bla odpoved \n"
                3-> return "\n TED: bla bla bla bla bla bla otazka3 \n DOMORODEC: bla bla bla bla bla odpoved \n"
            }
        } else if (MilkyWayPlanets.marsIsPlaying) {
            when(numberOfQuestion){
                1 -> return "\n TED: bla bla bla bla bla bla otazka1 \n DOMORODEC: bla bla bla bla bla odpoved \n"
                2 -> return "\n TED: bla bla bla bla bla bla otazka2 \n DOMORODEC: bla bla bla bla bla odpoved \n"
                3-> return "\n TED: bla bla bla bla bla bla otazka3 \n DOMORODEC: bla bla bla bla bla odpoved \n"
            }
        } else if (MilkyWayPlanets.jupiterIsPlaying) {
            when(numberOfQuestion){
                1 -> return "\n TED: bla bla bla bla bla bla otazka1 \n DOMORODEC: bla bla bla bla bla odpoved \n"
                2 -> return "\n TED: bla bla bla bla bla bla otazka2 \n DOMORODEC: bla bla bla bla bla odpoved \n"
                3-> return "\n TED: bla bla bla bla bla bla otazka3 \n DOMORODEC: bla bla bla bla bla odpoved \n"
            }
        } else if (MilkyWayPlanets.saturnIsPlaying) {
            when(numberOfQuestion){
                1 -> return "\n TED: bla bla bla bla bla bla otazka1 \n DOMORODEC: bla bla bla bla bla odpoved \n"
                2 -> return "\n TED: bla bla bla bla bla bla otazka2 \n DOMORODEC: bla bla bla bla bla odpoved \n"
                3-> return "\n TED: bla bla bla bla bla bla otazka3 \n DOMORODEC: bla bla bla bla bla odpoved \n"
            }
        } else if (MilkyWayPlanets.uranusIsPlaying) {
            when(numberOfQuestion){
                1 -> return "\n TED: bla bla bla bla bla bla otazka1 \n DOMORODEC: bla bla bla bla bla odpoved \n"
                2 -> return "\n TED: bla bla bla bla bla bla otazka2 \n DOMORODEC: bla bla bla bla bla odpoved \n"
                3-> return "\n TED: bla bla bla bla bla bla otazka3 \n DOMORODEC: bla bla bla bla bla odpoved \n"
            }
        } else if (MilkyWayPlanets.neptuneIsPlaying) {
            when(numberOfQuestion){
                1 -> return "\n TED: bla bla bla bla bla bla otazka1 \n DOMORODEC: bla bla bla bla bla odpoved \n"
                2 -> return "\n TED: bla bla bla bla bla bla otazka2 \n DOMORODEC: bla bla bla bla bla odpoved \n"
                3-> return "\n TED: bla bla bla bla bla bla otazka3 \n DOMORODEC: bla bla bla bla bla odpoved \n"
            }
        }
        return ""
    }

    fun acceptedOrNot(fightOrPeace: Int) {

        var yesOrNo = Random.nextInt(0, 2)

        ///TODO 0 je pre mier 1 je pre boj
        if (fightOrPeace == 0) {
            if (fightOrPeace == yesOrNo) {
                //TODO mimozenstania akceptovali
                // presmeruje sa na peace stranku

                binding.decisionMade.visibility = View.VISIBLE
                binding.decisionMade.text = "MIER sa akceptoval"

                Handler(Looper.getMainLooper()).postDelayed({

//                    val intent = Intent(this, ImageGame::class.java)
//                    startActivity(intent)
//                    finish()

                    val intent = Intent(this, Quizz::class.java)
                    resultLauncher.launch(intent)
                }, 5000)

            } else {
                //TODO neakceptovali, mimozenstania chcu bojovat
                //TODO mimozenstania chcu bojovat
                // presmerovanie na fight stranku
                // zmizne button peace

                binding.decisionMade.visibility = View.VISIBLE
                binding.decisionMade.text = "MIER SA NEAKCEPTUJE. BOJ!!!!"

                Handler(Looper.getMainLooper()).postDelayed({

//                    val intent = Intent(this, ImageGame::class.java)
//                    startActivity(intent)
//                    finish()

                    val intent = Intent(this, ImageGame::class.java)
                    resultLauncher.launch(intent)
                }, 5000)


            }

        } else if (fightOrPeace == 1) {
            if (fightOrPeace == yesOrNo) {
                //TODO mimozenstania chcu bojovat
                // presmerovanie na fight stranku
                // zmizne button peace

                binding.decisionMade.visibility = View.VISIBLE
                binding.decisionMade.text = "Boj sa akceptoval"

                Handler(Looper.getMainLooper()).postDelayed({

//                    val intent = Intent(this, ImageGame::class.java)
//                    startActivity(intent)
//                    finish()

                    val intent = Intent(this, ImageGame::class.java)
                    resultLauncher.launch(intent)
                }, 5000)


            } else {
                //TODO mimozenstania sa vzdavaju

                binding.decisionMade.visibility = View.VISIBLE
                binding.decisionMade.text = "NECHCEME BOJOVAT. Je to MIER!"

                Handler(Looper.getMainLooper()).postDelayed({

//                    val intent = Intent(this, ImageGame::class.java)
//                    startActivity(intent)
//                    finish()

                    val intent = Intent(this, Quizz::class.java)
                    resultLauncher.launch(intent)
                }, 5000)
            }
        }

    }


    var resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            // There are no request codes

            //aplikacia zasle data a zavrie sa... mozno nieco na statistiku??
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
    }
}