package com.example.dobyvatel

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
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

        binding.question1.text = "Profil"
        binding.question2.text = "Dráha"
        binding.question3.text = "Atmosfera"

        // nastavy sa text a hlavny obrazok podla toho, co sa hra
        if (MilkyWayPlanets.sunIsPlaying) {

            imageList.clear()
            imageList.add(SlideModel("https://i.ibb.co/52DwRgn/slnkoblizko.jpg", "Slnečné erupcie"))
            imageList.add(
                SlideModel(
                    "https://i.ibb.co/BrDtv21/slnecna-korona.jpg",
                    "Koronu možno vidieť pri zatmení Slnka"
                )
            )
            imageList.add(
                SlideModel(
                    "https://i.ibb.co/0CgP6FK/slnecne-skvrny.jpg",
                    "Slnečné škvrny"
                )
            )
            imageSlider.setImageList(imageList, ScaleTypes.CENTER_CROP)
            binding.textAboutPlanet.text = getString(R.string.sun_info)

            binding.question2.text = "Povrch"
        } else if (MilkyWayPlanets.mercuryIsPlaying) {

            imageList.clear()
            imageList.add(
                SlideModel(
                    "https://i.ibb.co/bB64gtk/povrch-merkuru.jpg",
                    "Povrch Merkúra"
                )
            )
            imageList.add(SlideModel("https://i.ibb.co/xzLXXmQ/obezna-draha.jpg", "Obežná dráha"))
            imageSlider.setImageList(imageList, ScaleTypes.CENTER_CROP)
            binding.textAboutPlanet.text = getString(R.string.merkur_info)

        } else if (MilkyWayPlanets.venusIsPlaying) {

            imageList.clear()
            imageList.add(SlideModel("https://i.ibb.co/hVwCrVW/venusapovrh.jpg", "Povrch Venuše"))
            imageList.add(
                SlideModel(
                    "https://i.ibb.co/SvdhFCX/19-SCI-OUTTHERE-VENUS1-video-Sixteen-By-Nine3000.jpg",
                    "Venusa zabalena v hustej vrstve toxických mrakov"
                )
            )
            imageSlider.setImageList(imageList, ScaleTypes.CENTER_CROP)
            binding.textAboutPlanet.text = getString(R.string.venus_info)

        } else if (MilkyWayPlanets.earthIsPlaying) {

            imageList.clear()
            imageList.add(
                SlideModel(
                    "https://i.ibb.co/wC3m3n1/magneticke-pole.jpg",
                    "Magnetické pole"
                )
            )
            imageList.add(SlideModel("https://i.ibb.co/qYTTRc7/detailnezem.jpg", "Detail Zeme"))
            imageList.add(SlideModel("https://i.ibb.co/gjwJ1Y7/atmosfera.jpg", "Atmosféra"))
            imageSlider.setImageList(imageList, ScaleTypes.CENTER_CROP)
            binding.textAboutPlanet.text = getString(R.string.earth_info)
            binding.question2.text = "Magnetické pole"

        } else if (MilkyWayPlanets.marsIsPlaying) {

            imageList.clear()
            imageList.add(SlideModel("https://i.ibb.co/F4ZRQ7W/mars.jpg", "Mars"))
            imageList.add(SlideModel("https://i.ibb.co/fSdmyBF/ve-k-pohoria.jpg", "Veľké pohoria"))
            imageSlider.setImageList(imageList, ScaleTypes.CENTER_CROP)
            binding.textAboutPlanet.text = getString(R.string.mars_info)

        } else if (MilkyWayPlanets.jupiterIsPlaying) {

            imageList.clear()
            imageList.add(SlideModel("https://i.ibb.co/fqGNmPX/jupiterzblizka.jpg", "Plynné mraky"))
            imageList.add(SlideModel("https://i.ibb.co/QKLNtH9/jupiter.jpg", "Jupiter"))
            imageList.add(
                SlideModel(
                    "https://i.ibb.co/cJ8Nd3k/hs-2016-24-a-print-new-2.jpg",
                    "Polárna žiara"
                )
            )
            imageSlider.setImageList(imageList, ScaleTypes.CENTER_CROP)
            binding.textAboutPlanet.text = getString(R.string.jupiter_info)
            binding.question2.text = "Magnetické pole"

        } else if (MilkyWayPlanets.saturnIsPlaying) {
            imageList.clear()
            imageList.add(SlideModel("https://i.ibb.co/cbgXJmK/saturn.jpg", "Saturn"))
            imageList.add(
                SlideModel(
                    "https://i.ibb.co/Zfsb3hM/Saturn-s-rainbow-rings-pillars.jpg",
                    "Ultrafialová snímka prstenca."
                )
            )
            imageSlider.setImageList(imageList, ScaleTypes.CENTER_CROP)
            binding.textAboutPlanet.text = getString(R.string.saturn_info)
            binding.question2.text = "Prstence"

        } else if (MilkyWayPlanets.uranusIsPlaying) {
            imageList.clear()
            imageList.add(SlideModel("https://i.ibb.co/drm6CRd/uranus.jpg", "Mraky na Uráne"))
            imageList.add(
                SlideModel(
                    "https://i.ibb.co/1TNfRBt/uranusfalsecolor.jpg",
                    "Urán v nepravých farbách"
                )
            )
            imageSlider.setImageList(imageList, ScaleTypes.CENTER_CROP)
            binding.textAboutPlanet.text = getString(R.string.uranus_info)
            binding.question2.text = "Prstence"

        } else if (MilkyWayPlanets.neptuneIsPlaying) {
            imageList.clear()
            imageList.add(
                SlideModel(
                    "https://i.ibb.co/LzjM54b/neptuneclouds.jpg",
                    "Oblaky nad Neptúnom"
                )
            )
            imageList.add(SlideModel("https://i.ibb.co/LJSn02y/neptunevertical.jpg", "Neptun"))
            imageSlider.setImageList(imageList, ScaleTypes.CENTER_CROP)
            binding.textAboutPlanet.text = getString(R.string.neptune_info)
            binding.question2.text = "Prstence"
        }

        ///LISTENERS
        binding.fight.setOnClickListener {

            binding.scrollPlanet.visibility = View.GONE
            binding.textAboutPlanet.visibility = View.GONE
            binding.peace.visibility = View.GONE
            binding.fight.visibility = View.GONE

            binding.progressDecision.visibility = View.VISIBLE

            //najprv je loading a potom je vypisana decision
            Handler(Looper.getMainLooper()).postDelayed({
                binding.progressDecision.visibility = View.GONE
                acceptedOrNot(1)
            }, 5000)
        }

        binding.peace.setOnClickListener {

            binding.scrollPlanet.visibility = View.GONE
            binding.textAboutPlanet.visibility = View.GONE
            binding.peace.visibility = View.GONE
            binding.fight.visibility = View.GONE

            binding.progressDecision.visibility = View.VISIBLE

            //najprv je loading a potom je vypisana decision
            Handler(Looper.getMainLooper()).postDelayed({
                binding.progressDecision.visibility = View.GONE
                acceptedOrNot(0)
            }, 5000)
        }

        ///LISTENERS QUESTION
        binding.question1.setOnClickListener {
            howManyTimes++
            if (howManyTimes == 3) {
                //Ak su uz vsetky otazky zodpovedane
                binding.fight.isEnabled = true
                binding.peace.isEnabled = true
                binding.fight.setBackgroundColor(resources.getColor(R.color.neon_green))
                binding.peace.setBackgroundColor(resources.getColor(R.color.neon_green))

                val actualText = binding.textAboutPlanet.text.toString()
                val question = returnQuestion(1)
                binding.textAboutPlanet.text = actualText + question

            } else {

                val actualText = binding.textAboutPlanet.text.toString()
                val question = returnQuestion(1)
                binding.textAboutPlanet.text = actualText + question
            }

            //zmiznutie otazky
            binding.question1.visibility = View.INVISIBLE
        }

        binding.question2.setOnClickListener {

            howManyTimes++
            if (howManyTimes == 3) {
                //Ak su uz vsetky otazky zodpovedane
                binding.fight.isEnabled = true
                binding.peace.isEnabled = true
                binding.fight.setBackgroundColor(resources.getColor(R.color.neon_green))
                binding.peace.setBackgroundColor(resources.getColor(R.color.neon_green))

                val actualText = binding.textAboutPlanet.text.toString()
                val question = returnQuestion(2)
                binding.textAboutPlanet.text = actualText + question

            } else {

                val actualText = binding.textAboutPlanet.text.toString()
                val question = returnQuestion(2)
                binding.textAboutPlanet.text = actualText + question
            }

            //zmiznutie otazky
            binding.question2.visibility = View.INVISIBLE
        }

        binding.question3.setOnClickListener {
            howManyTimes++

            if (howManyTimes == 3) {
                //Ak su uz vsetky otazky zodpovedane
                binding.fight.isEnabled = true
                binding.peace.isEnabled = true
                binding.fight.setBackgroundColor(resources.getColor(R.color.neon_green))
                binding.peace.setBackgroundColor(resources.getColor(R.color.neon_green))

                val actualText = binding.textAboutPlanet.text.toString()
                val question = returnQuestion(3)
                binding.textAboutPlanet.text = actualText + question

            } else {

                val actualText = binding.textAboutPlanet.text.toString()
                val question = returnQuestion(3)
                binding.textAboutPlanet.text = actualText + question
            }

            //zmiznutie otazky
            binding.question3.visibility = View.INVISIBLE
        }

    }

    fun returnQuestion(numberOfQuestion: Int): String {

//        Profil / Draha / Atmosfera
        if (MilkyWayPlanets.sunIsPlaying) {
            when (numberOfQuestion) {
                1 -> return getString(R.string.sun_first)
                2 -> return getString(R.string.sun_second)
                3 -> return getString(R.string.sun_third)
            }
        } else if (MilkyWayPlanets.mercuryIsPlaying) {
            when (numberOfQuestion) {
                1 -> return getString(R.string.merkur_first)
                2 -> return getString(R.string.merkur_second)
                3 -> return getString(R.string.merkur_third)
            }
        } else if (MilkyWayPlanets.venusIsPlaying) {
            when (numberOfQuestion) {
                1 -> return getString(R.string.venus_info)
                2 -> return getString(R.string.venus_second)
                3 -> return getString(R.string.venus_third)
            }
        } else if (MilkyWayPlanets.earthIsPlaying) {
            when (numberOfQuestion) {
                1 -> return getString(R.string.earth_first)
                2 -> return getString(R.string.earth_second)
                3 -> return getString(R.string.earth_third)
            }
        } else if (MilkyWayPlanets.marsIsPlaying) {
            when (numberOfQuestion) {
                1 -> return getString(R.string.mars_first)
                2 -> return getString(R.string.mars_second)
                3 -> return getString(R.string.mars_third)
            }
        } else if (MilkyWayPlanets.jupiterIsPlaying) {
            when (numberOfQuestion) {
                1 -> return getString(R.string.jupiter_first)
                2 -> return getString(R.string.jupiter_second)
                3 -> return getString(R.string.jupiter_third)
            }
        } else if (MilkyWayPlanets.saturnIsPlaying) {
            when (numberOfQuestion) {
                1 -> return getString(R.string.saturn_first)
                2 -> return getString(R.string.saturn_second)
                3 -> return getString(R.string.saturn_third)
            }
        } else if (MilkyWayPlanets.uranusIsPlaying) {
            when (numberOfQuestion) {
                1 -> return getString(R.string.uranus_first)
                2 -> return getString(R.string.uranus_second)
                3 -> return getString(R.string.uranus_third)
            }
        } else if (MilkyWayPlanets.neptuneIsPlaying) {
            when (numberOfQuestion) {
                1 -> return getString(R.string.neptune_first)
                2 -> return getString(R.string.neptune_second)
                3 -> return getString(R.string.neptune_third)
            }
        }
        return ""
    }

    fun acceptedOrNot(fightOrPeace: Int) {

        val yesOrNo = next()

        ///0 je pre mier 1 je pre boj
        if (fightOrPeace == 0) {
            if (fightOrPeace == yesOrNo) {

                binding.decisionMade.visibility = View.VISIBLE
                binding.decisionMade.text = "MIER sa akceptoval"

                Handler(Looper.getMainLooper()).postDelayed({
                    val intent = Intent(this, Quizz::class.java)
                    resultLauncher.launch(intent)
                }, 5000)

            } else {
                //MIER SA NEAKCEPTOVAL - boj
                binding.decisionMade.visibility = View.VISIBLE
                binding.decisionMade.text = "MIER SA NEAKCEPTUJE. BOJ!!!!"

                Handler(Looper.getMainLooper()).postDelayed({
                    val intent = Intent(this, ImageGame::class.java)
                    resultLauncher.launch(intent)
                }, 5000)
            }

        } else if (fightOrPeace == 1) {
            if (fightOrPeace == yesOrNo) {
                //BOJ
                binding.decisionMade.visibility = View.VISIBLE
                binding.decisionMade.text = "Boj sa akceptoval"

                Handler(Looper.getMainLooper()).postDelayed({
                    val intent = Intent(this, ImageGame::class.java)
                    resultLauncher.launch(intent)
                }, 5000)


            } else {
                //Mimozenstania sa vzdali - mier

                binding.decisionMade.visibility = View.VISIBLE
                binding.decisionMade.text = "NECHCEME BOJOVAT. Je to MIER!"

                Handler(Looper.getMainLooper()).postDelayed({
                    val intent = Intent(this, Quizz::class.java)
                    resultLauncher.launch(intent)
                }, 5000)
            }
        }
    }

    private operator fun next(): Int {

        val random = Random
        return if (random.nextBoolean()) {
            0
        } else {
            1
        }
    }

    var resultLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                //aplikacia zasle data a zavrie sa...
                setResult(Activity.RESULT_OK, intent)
                finish()
            }
        }
}