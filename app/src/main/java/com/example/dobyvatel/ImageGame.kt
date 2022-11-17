package com.example.dobyvatel

import android.animation.ObjectAnimator
import android.app.Activity
import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.os.Looper
import android.view.View
import android.webkit.RenderProcessGoneDetail
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.dobyvatel.databinding.ActivityImageGameBinding
import com.example.dobyvatel.objects.MilkyWayPlanets
import kotlin.random.Random

class ImageGame : AppCompatActivity() {

    private lateinit var binding: ActivityImageGameBinding
    private lateinit var timer: CountDownTimer
    private lateinit var timerGame: CountDownTimer

    //variables
    var score = 0
    var endOfGame = false
    var endOfTimer = true
    var endScore = 3
    var listOfImageAlien = arrayListOf<ImageView>()
    var listOfX = arrayListOf<ImageView>()
    var listOfTextObjects = arrayListOf<TextView>()
    var startNumber = 1
    var endNumber = 14
    var timerIsRunning = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityImageGameBinding.inflate(layoutInflater)
        setContentView(binding.root)

        listOfImageAlien = arrayListOf<ImageView>(
            binding.alien1,
            binding.alien2,
            binding.alien3,
            binding.alien4,
            binding.alien5,
            binding.alien6,
            binding.alien7,
            binding.alien8,
            binding.alien9
        )

        listOfTextObjects = arrayListOf(
            binding.score,
            binding.numberScore
        )

        listOfX = arrayListOf(
            binding.redx1,
            binding.redx2,
            binding.redx3
        )

        timerGame = object : CountDownTimer(30000, 1000) {

            // Callback function, fired on regular interval
            override fun onTick(millisUntilFinished: Long) {
//                binding.countdown.setText("Zostávajúci čas: " + millisUntilFinished / 1000)

//                ObjectAnimator.ofInt(binding.progressBar2,"progress", (millisUntilFinished / 1000).toInt())
//                    .start()
                progressBarTimeScore(millisUntilFinished)
            }
            //koniec casu: End game
            override fun onFinish() {

                timer.cancel()

                if (score >= 20) {
                    //HAPPY PATH -> hrac vyhral
                    endOfGame = true
                    winOrLoose("win")

                    // Aplikacia pocka niekolko sekund a potom sa vypne
                    Handler(Looper.getMainLooper()).postDelayed({
                        val intent = Intent()
                        ///TODO ako sledovat planety
                        if (MilkyWayPlanets.sunIsPlaying) {
                            MilkyWayPlanets.planetIsDone("sun")
                        } else if (MilkyWayPlanets.mercuryIsPlaying) {
                            MilkyWayPlanets.planetIsDone("mercury")
                        } else if (MilkyWayPlanets.venusIsPlaying) {
                            MilkyWayPlanets.planetIsDone("venus")
                        } else if (MilkyWayPlanets.earthIsPlaying) {
                            MilkyWayPlanets.planetIsDone("earth")
                        } else if (MilkyWayPlanets.marsIsPlaying) {
                            MilkyWayPlanets.planetIsDone("mars")
                        } else if (MilkyWayPlanets.jupiterIsPlaying) {
                            MilkyWayPlanets.planetIsDone("jupiter")
                        } else if (MilkyWayPlanets.saturnIsPlaying) {
                            MilkyWayPlanets.planetIsDone("saturn")
                        } else if (MilkyWayPlanets.uranusIsPlaying) {
                            MilkyWayPlanets.planetIsDone("uranus")
                        } else if (MilkyWayPlanets.neptuneIsPlaying) {
                            MilkyWayPlanets.planetIsDone("neptune")
                        }

//                    intent.putExtra("boolSun", endOfGame)
                        setResult(Activity.RESULT_OK, intent)
                        finish()
                    }, 5000)
                } else {
                    //UNHAPPY PATH -> hrac prehral
                    winOrLoose("loose")

                    Handler(Looper.getMainLooper()).postDelayed({
                        val intent = Intent()
//                    intent.putExtra("boolSun", endOfGame)
                        setResult(Activity.RESULT_OK, intent)
                        finish()
                    }, 5000)
                }


            }
        }.start()


        // na zaciatku vsetky obrazky zneviditelny
        for (image in listOfImageAlien) {
            image.setTag(R.id.KEY, null)
            image.visibility = View.INVISIBLE
        }

        //spustenie hry
        game(Random.nextInt(startNumber, endNumber))

        //button listener
        binding.alien1.setOnClickListener {
            setGame(binding.alien1)
        }

        binding.alien2.setOnClickListener {
            setGame(binding.alien2)
        }

        binding.alien3.setOnClickListener {
            setGame(binding.alien3)
        }

        binding.alien4.setOnClickListener {
            setGame(binding.alien4)
        }

        binding.alien5.setOnClickListener {
            setGame(binding.alien5)
        }

        binding.alien6.setOnClickListener {
            setGame(binding.alien6)
        }

        binding.alien7.setOnClickListener {
            setGame(binding.alien7)
        }


        binding.alien8.setOnClickListener {
            setGame(binding.alien8)
        }

        binding.alien9.setOnClickListener {
            setGame(binding.alien9)
        }
    }

    fun setGame(imageView: ImageView) {
        if (timerIsRunning == true) {
            timer.cancel()
        }

        // Ak je obrazok Aliena pripocitava sa skore
        // Inaksie je Bomb a to skore odpocitava
        if (imageView.getTag(R.id.KEY) == getString(R.string.ALIEN)) {
            scoreSetNull("plus")
            playGameAgain(imageView)

        } else {
            if (endScore == 1) {
                /// Do tejto slucky sa vojde vtedy, ked hrac prehra vsetky zivoty
                // Hra sa ukoncuje
                scoreEnd(endScore)
                scoreSetNull("minus")
            } else {
                scoreEnd(endScore)
                endScore--
                scoreSetNull("minus")
                playGameAgain(imageView)
            }
        }
    }

    fun playGameAgain(imageView: ImageView) {

        for (image in listOfImageAlien) {
            image.setTag(R.id.KEY, null)
            image.visibility = View.INVISIBLE
        }
        //TODO
//        binding.score.text = "Score: " + score

        binding.numberScore.text = score.toString()

        game(Random.nextInt(startNumber, endNumber))
    }

    fun progressBarTimeScore(time: Long){
        if(time/ 1000>= 20){
            binding.progressBarTime.progressTintList = ColorStateList.valueOf(Color.GREEN)
        }else if (time/ 1000>=8){
            binding.progressBarTime.progressTintList = ColorStateList.valueOf(Color.parseColor("#FF6F00"))
        }else{
            binding.progressBarTime.progressTintList = ColorStateList.valueOf(Color.RED)
        }

        ObjectAnimator.ofInt(binding.progressBarTime,"progress",(time / 1000).toInt())
            .start()
    }

    fun scoreSetNull (symbol:String){

        if(symbol == "plus"){
            score++
        }else{
            if(score==0){
                score = 0
            }else{
                score--
            }
        }
    }

    // metoda ak sa stlaci bomba, odpocitavaju sa Xka
    fun scoreEnd(score: Int) {
        when (score) {
            1 -> {
                //TODO
                endOfTimer = false

                //TODO nadpis a aj farby ... vytvorit metodu na ukoncenie co sa spravi rovnako aj ked sa vyhra
                winOrLoose("loose")

                //hra sa ukoncuje: End game
                Handler(Looper.getMainLooper()).postDelayed({
                    val intent = Intent()
                    setResult(Activity.RESULT_OK, intent)
                    finish()
                }, 5000)
            }
            2 -> {
                binding.redx2.visibility = View.INVISIBLE
            }
            3 -> {
                binding.redx3.visibility = View.INVISIBLE
            }
        }
    }

    // HRA
    fun game(randomNumber: Int) {
        when (randomNumber) {
            1 -> {
                setImageAlien(binding.alien1,getString(R.string.ALIEN))
                endImage()
            }

            2 -> {
                setImageAlien(binding.alien2, getString(R.string.ALIEN))
                endImage()
            }

            3 -> {
                setImageAlien(binding.alien3, getString(R.string.ALIEN))
                endImage()
            }

            4 -> {
                setImageAlien(binding.alien4, getString(R.string.ALIEN))
                endImage()
            }

            5 -> {
                setImageAlien(binding.alien5, getString(R.string.ALIEN))
                endImage()
            }

            6 -> {
                setImageAlien(binding.alien6, getString(R.string.ALIEN))
                endImage()
            }

            7 -> {
                setImageAlien(binding.alien7, getString(R.string.ALIEN))
                endImage()
            }

            8 -> {
                setImageAlien(binding.alien8, getString(R.string.ALIEN))
                endImage()
            }

            9 -> {
                setImageAlien(binding.alien9, getString(R.string.ALIEN))
                endImage()
            }

            10 -> {
                val randomNumber = Random.nextInt(1, 10)
                setBombImage(randomNumber)
            }

            11 -> {
                val randomNumber = Random.nextInt(1, 10)
                setBombImage(randomNumber)
            }

            12 -> {
                val randomNumber = Random.nextInt(1, 10)
                setBombImage(randomNumber)
            }

            13 -> {
                val randomNumber = Random.nextInt(1, 10)
                setBombImage(randomNumber)
            }
        }
    }


    //metoda na random nastavenia miesta pre bombu
    fun setBombImage(randomNumber: Int) {
        when (randomNumber) {
            1 -> {
                setImageBomb(binding.alien1, getString(R.string.BOMB))
                endImage(1)
            }

            2 -> {
                setImageBomb(binding.alien2, getString(R.string.BOMB))
                endImage(1)
            }

            3 -> {
                setImageBomb(binding.alien3, getString(R.string.BOMB))
                endImage(1)
            }

            4 -> {
                setImageBomb(binding.alien4, getString(R.string.BOMB))
                endImage(1)
            }

            5 -> {
                setImageBomb(binding.alien5, getString(R.string.BOMB))
                endImage(1)
            }

            6 -> {
                setImageBomb(binding.alien6, getString(R.string.BOMB))
                endImage(1)
            }

            7 -> {
                setImageBomb(binding.alien7, getString(R.string.BOMB))
                endImage( 1)
            }

            8 -> {
                setImageBomb(binding.alien8, getString(R.string.BOMB))
                endImage(1)
            }

            9 -> {
                setImageBomb(binding.alien9, getString(R.string.BOMB))
                endImage( 1)
            }
        }
    }

    // nastavy alien ako obrazok
    fun setImageAlien(imageView: ImageView, tag: String) {
        if (timerIsRunning == true) {
            timer.cancel()
        }
        for (image in listOfImageAlien) {
            image.visibility = View.INVISIBLE
        }
        imageView.setImageResource(R.drawable.imagegame_alien)
        imageView.setTag(R.id.KEY, null)
        imageView.setTag(R.id.KEY, tag)
        imageView.visibility = View.VISIBLE
    }

    // nastavy bomb ako obrazok
    fun setImageBomb(imageView: ImageView, tag: String) {
        if (timerIsRunning == true) {
            timer.cancel()
        }
        for (image in listOfImageAlien) {
            image.visibility = View.INVISIBLE
        }
        imageView.setTag(R.id.KEY, null)
        imageView.setTag(R.id.KEY, tag)
        imageView.setImageResource(R.drawable.imagegame_bomb)
        imageView.visibility = View.VISIBLE
    }

    // casomiera na prepinanie obrazkov
    fun endImage(bomb: Int = 0) {

        timer = object : CountDownTimer(700, 500) {

            // Callback function, fired on regular interval
            override fun onTick(millisUntilFinished: Long) {
//                binding.countdown.setText("seconds remaining: " + millisUntilFinished / 1000)
                ///TODO
                timerIsRunning = true
            }

            // Callback function, fired
            // when the time is up
            override fun onFinish() {

                timerIsRunning = false

                for (image in listOfImageAlien) {
                    image.visibility = View.INVISIBLE
                }

                when (bomb) {
                    1 -> {
                        for (image in listOfImageAlien) {
                            image.setImageResource(R.drawable.imagegame_alien)
                        }
                    }
                }
                game(Random.nextInt(startNumber, endNumber))
            }
        }.start()
    }

    // metoda ktora vypise ci si vyhral alebo prehral
    fun winOrLoose(state: String) {

        timer.cancel()
        timerGame.cancel()
        when (state) {
            "win" -> {
                binding.mainHeader.text = "Vyhral si!"
            }
            "loose" -> {
                binding.mainHeader.text = "Prehral si!"
            }
        }

        //TODO rovnako aj Xka su invisible
        // Vsetky obrazky a text fields su invisible
        // zarovnat napis do stredu
        for (image in listOfImageAlien) {
            image.visibility = View.GONE
        }
        for (text in listOfTextObjects) {
            text.visibility = View.GONE
        }
        for (x in listOfX){
            x.visibility = View.GONE
        }

        binding.progressBarTime.visibility = View.GONE

        binding.tabulkamimozenstanov.background = null

    }

}