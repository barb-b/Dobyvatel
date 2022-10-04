package com.example.dobyvatel

import android.animation.ObjectAnimator
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.dobyvatel.databinding.ActivityDecisionPageBinding
import com.example.dobyvatel.objects.MilkyWayPlanets
import kotlin.random.Random


class DecisionPage : AppCompatActivity() {

    private lateinit var binding: ActivityDecisionPageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDecisionPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //TODO hlavny obrazok podla toho aka planeta je otvorena
        // text podla toho aka planeta je otvorena

        // nastavy sa text a hlavny obrazok podla toho, co sa hra
        if (MilkyWayPlanets.sunIsPlaying) {

            binding.mainPicture.setImageResource(R.drawable.decision_sun)
//            binding.textAboutPlanet.text = ""
        } else if (MilkyWayPlanets.mercuryIsPlaying) {

//            binding.mainPicture.setImageResource(R.drawable.decision_sun)
//            binding.textAboutPlanet.text = ""
        } else if (MilkyWayPlanets.venusIsPlaying) {
//            binding.mainPicture.setImageResource(R.drawable.decision_sun)
//            binding.textAboutPlanet.text = ""
        } else if (MilkyWayPlanets.earthIsPlaying) {
//            binding.mainPicture.setImageResource(R.drawable.decision_sun)
//            binding.textAboutPlanet.text = ""
        } else if (MilkyWayPlanets.marsIsPlaying) {
//            binding.mainPicture.setImageResource(R.drawable.decision_sun)
//            binding.textAboutPlanet.text = ""
        } else if (MilkyWayPlanets.jupiterIsPlaying) {
//            binding.mainPicture.setImageResource(R.drawable.decision_sun)
//            binding.textAboutPlanet.text = ""
        } else if (MilkyWayPlanets.saturnIsPlaying) {
//            binding.mainPicture.setImageResource(R.drawable.decision_sun)
//            binding.textAboutPlanet.text = ""
        } else if (MilkyWayPlanets.uranusIsPlaying) {
//            binding.mainPicture.setImageResource(R.drawable.decision_sun)
//            binding.textAboutPlanet.text = ""
        } else if (MilkyWayPlanets.neptuneIsPlaying) {
//            binding.mainPicture.setImageResource(R.drawable.decision_sun)
//            binding.textAboutPlanet.text = ""
        }


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
        }


    }

    fun acceptedOrNot(fightOrPeace: Int) {

        var yesOrNo = Random.nextInt(0, 1)

        ///TODO 0 je pre mier 1 je pre boj
        if (fightOrPeace == 0) {
            if (fightOrPeace == yesOrNo) {
                //TODO mimozenstania akceptovali
                // presmeruje sa na peace stranku
            } else {
                //TODO neakceptovali, mimozenstania chcu bojovat
            }

        } else if (fightOrPeace == 1) {
            yesOrNo = 1
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