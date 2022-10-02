package com.example.dobyvatel

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.ImageView
import com.example.dobyvatel.databinding.ActivityImageGameBinding
import kotlin.random.Random

class ImageGame : AppCompatActivity() {

    private lateinit var binding: ActivityImageGameBinding
    private lateinit var timer: CountDownTimer
    private lateinit var timerGame: CountDownTimer

    var score = 0
    var endOfGame = false
    var endOfTimer = true
    var endScore = 3
    var listOfImageAlien = arrayListOf<ImageView>()
    var listOfImageBomb = arrayListOf<ImageView>()
    var startNumber = 1
    var endNumber = 14

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


        for (image in listOfImageAlien){
            image.visibility = View.INVISIBLE
        }

        timerGame = object : CountDownTimer(30000, 1000) {

            // Callback function, fired on regular interval
            override fun onTick(millisUntilFinished: Long) {
                binding.countdown.setText("seconds remaining: " + millisUntilFinished / 1000)

            }

            // Callback function, fired
            // when the time is up
            // TODO END GAME
            // TODO : koniec hry, vsetky obrazky zmizny
            override fun onFinish() {
                endOfGame = true
                binding.countdown.setText("done!")

                for (image in listOfImageAlien){
                    image.visibility = View.INVISIBLE
                }

                val intent = Intent()
                intent.putExtra("boolSun", endOfGame)
                setResult(Activity.RESULT_OK, intent)
                finish()
            }
        }.start()



        ///TODO randomgenerator number -> switch -> visibility obrazka -> bude to vo while slucke
        ///TODO -> while dokym neskonci timer
        game(Random.nextInt(startNumber,endNumber))

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

    fun setGame(imageView: ImageView){

        // Ak je obrazok Aliena pripocitava sa skore
        // Inaksie je Bomb a to skore odpocitava

        if(imageView.getTag(R.id.KEY) == getString(R.string.ALIEN)){
            score++
            playGameAgain(imageView)

        }else{

            if(endScore == 1){
                /// Do tejto slucky sa vojde vtedy, ked hrac prehra vsetky zivoty
                // Hra sa ukoncuje
                scoreEnd(endScore)
                score--
            }else{
                scoreEnd(endScore)
                endScore--
                score--
                playGameAgain(imageView)
            }
        }
    }

    fun playGameAgain(imageView: ImageView){
        imageView.setTag(R.id.KEY,null)
        timer.cancel()

        //TODO
        binding.score.text = "Score: " + score
        imageView.visibility = View.INVISIBLE
        game(Random.nextInt(startNumber,endNumber))
    }

    fun scoreEnd(score: Int){
        when(score){
            1->{
                endOfTimer = false
                timerGame.cancel()
                timer.cancel()

                binding.redx1.visibility = View.INVISIBLE
                //TODO skonci sa timer, hru nie je mozne hrat

                for (image in listOfImageAlien){
                    image.visibility = View.INVISIBLE
                }

                binding.countdown.setText("YOU LOOSE!")


                Handler(Looper.getMainLooper()).postDelayed({
                    val intent = Intent()
                    intent.putExtra("boolSun", endOfGame)
                    setResult(Activity.RESULT_OK, intent)
                    finish()
                }, 10000)

            }
            2->{
                binding.redx2.visibility = View.INVISIBLE
            }
            3->{
                binding.redx3.visibility = View.INVISIBLE
            }
        }
    }

    fun game(randomNumber: Int){
        when (randomNumber) {
            1 -> {
                setImageAlien(binding.alien1,getString(R.string.ALIEN))
                endImage(1)
            }

            2 -> {
                setImageAlien(binding.alien2,getString(R.string.ALIEN))
                endImage(2)
            }

            3 -> {
                setImageAlien(binding.alien3,getString(R.string.ALIEN))
                endImage(3)
            }

            4 -> {
                setImageAlien(binding.alien4,getString(R.string.ALIEN))
                endImage(4)
            }

            5 -> {
                setImageAlien(binding.alien5,getString(R.string.ALIEN))
                endImage(5)
            }

            6 -> {
                setImageAlien(binding.alien6,getString(R.string.ALIEN))
                endImage(6)
            }

            7 -> {
                setImageAlien(binding.alien7,getString(R.string.ALIEN))
                endImage(7)
            }

            8 -> {
                setImageAlien(binding.alien8,getString(R.string.ALIEN))
                endImage(8)
            }

            9 -> {
                setImageAlien(binding.alien9,getString(R.string.ALIEN))
                endImage(9)
            }

            10->{
                val randomNumber = Random.nextInt(1,10)
                setBombImage(randomNumber)
            }

            11->{
                val randomNumber = Random.nextInt(1,10)
                setBombImage(randomNumber)
            }

            12->{
                val randomNumber = Random.nextInt(1,10)
                setBombImage(randomNumber)
            }

            13->{
                val randomNumber = Random.nextInt(1,10)
                setBombImage(randomNumber)
            }
        }
    }

    fun setBombImage (randomNumber: Int){
        when (randomNumber) {
            1 -> {
                setImageBomb(binding.alien1,getString(R.string.BOMB))
                endImage(10,1)
            }

            2 -> {
                setImageBomb(binding.alien2,getString(R.string.BOMB))
                endImage(10,2)
            }

            3 -> {
                setImageBomb(binding.alien3,getString(R.string.BOMB))
                endImage(10,3)
            }

            4 -> {
                setImageBomb(binding.alien4,getString(R.string.BOMB))
                endImage(10,4)
            }

            5 -> {
                setImageBomb(binding.alien5,getString(R.string.BOMB))
                endImage(10,5)
            }

            6 -> {
                setImageBomb(binding.alien6,getString(R.string.BOMB))
                endImage(10,6)
            }

            7 -> {
                setImageBomb(binding.alien7,getString(R.string.BOMB))
                endImage(10,7)
            }

            8 -> {
                setImageBomb(binding.alien8,getString(R.string.BOMB))
                endImage(10,8)
            }

            9 -> {
                setImageBomb(binding.alien9,getString(R.string.BOMB))
                endImage(10,9)
            }
        }

    }

    fun setImageAlien(imageView: ImageView, tag: String){
        imageView.setImageResource(R.drawable.imagegame_alien)
        imageView.setTag(R.id.KEY,null)
        imageView.setTag(R.id.KEY,tag)
        imageView.visibility = View.VISIBLE
    }

    fun setImageBomb (imageView: ImageView, tag: String){
        imageView.setTag(R.id.KEY,null)
        imageView.setTag(R.id.KEY,tag)
        imageView.setImageResource(R.drawable.imagegame_bomb)
        imageView.visibility = View.VISIBLE
    }

    fun endImage(alien: Int, bomb : Int = 0){
        timer = object : CountDownTimer(2000, 1000) {

            // Callback function, fired on regular interval
            override fun onTick(millisUntilFinished: Long) {
//                binding.countdown.setText("seconds remaining: " + millisUntilFinished / 1000)
                ///TODO
            }

            // Callback function, fired
            // when the time is up
            override fun onFinish() {




                when (alien) {
                    1 -> {
                        binding.alien1.visibility = View.INVISIBLE
                    }

                    2 -> {
                        binding.alien2.visibility = View.INVISIBLE
                    }

                    3 -> {
                        binding.alien3.visibility = View.INVISIBLE
                    }

                    4 -> {
                        binding.alien4.visibility = View.INVISIBLE
                    }

                    5 -> {
                        binding.alien5.visibility = View.INVISIBLE
                    }

                    6 -> {
                        binding.alien6.visibility = View.INVISIBLE
                    }

                    7 -> {
                        binding.alien7.visibility = View.INVISIBLE
                    }

                    8 -> {
                        binding.alien8.visibility = View.INVISIBLE

                    }

                    9 -> {
                        binding.alien9.visibility = View.INVISIBLE
                    }

                    10 -> {
                        when (bomb) {
                            1 -> {
                                binding.alien1.visibility = View.INVISIBLE
                                binding.alien1.setImageResource(R.drawable.imagegame_alien)
                            }

                            2 -> {
                                binding.alien2.visibility = View.INVISIBLE
                                binding.alien2.setImageResource(R.drawable.imagegame_alien)
                            }

                            3 -> {
                                binding.alien3.visibility = View.INVISIBLE
                                binding.alien3.setImageResource(R.drawable.imagegame_alien)
                            }

                            4 -> {
                                binding.alien4.visibility = View.INVISIBLE
                                binding.alien4.setImageResource(R.drawable.imagegame_alien)
                            }

                            5 -> {
                                binding.alien5.visibility = View.INVISIBLE
                                binding.alien5.setImageResource(R.drawable.imagegame_alien)
                            }

                            6 -> {
                                binding.alien6.visibility = View.INVISIBLE
                                binding.alien6.setImageResource(R.drawable.imagegame_alien)
                            }

                            7 -> {
                                binding.alien7.visibility = View.INVISIBLE
                                binding.alien7.setImageResource(R.drawable.imagegame_alien)
                            }

                            8 -> {
                                binding.alien8.visibility = View.INVISIBLE
                                binding.alien8.setImageResource(R.drawable.imagegame_alien)
                            }

                            9 -> {
                                binding.alien9.visibility = View.INVISIBLE
                                binding.alien9.setImageResource(R.drawable.imagegame_alien)
                            }
                        }
                    }
                }
                game(Random.nextInt(startNumber,endNumber))
            }
        }.start()
    }

}