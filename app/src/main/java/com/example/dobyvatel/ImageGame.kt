package com.example.dobyvatel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import com.example.dobyvatel.databinding.ActivityImageGameBinding
import com.example.dobyvatel.databinding.ActivityPlanetsMapBinding
import kotlin.random.Random

class ImageGame : AppCompatActivity() {

    private lateinit var binding: ActivityImageGameBinding

    private lateinit var timer: CountDownTimer

    var score = 0
    var endOfGame = false

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityImageGameBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.alien1.visibility = View.INVISIBLE
        binding.alien2.visibility = View.INVISIBLE
        binding.alien3.visibility = View.INVISIBLE
        binding.alien4.visibility = View.INVISIBLE
        binding.alien5.visibility = View.INVISIBLE
        binding.alien6.visibility = View.INVISIBLE
        binding.alien7.visibility = View.INVISIBLE
        binding.alien8.visibility = View.INVISIBLE
        binding.alien9.visibility = View.INVISIBLE

        object : CountDownTimer(30000, 1000) {

            // Callback function, fired on regular interval
            override fun onTick(millisUntilFinished: Long) {
                binding.countdown.setText("seconds remaining: " + millisUntilFinished / 1000)
            }

            // Callback function, fired
            // when the time is up
            override fun onFinish() {
                endOfGame = true
                binding.countdown.setText("done!")
            }
        }.start()

        binding.alien1.setTag(R.id.KEY,"now")
        var b = binding.alien1.getTag(R.id.KEY)
        binding.alien1.setTag(R.id.KEY,"why")
        var c = binding.alien1.getTag(R.id.KEY)
        binding.alien1.setTag(R.id.KEY,null)
        var f = binding.alien1.getTag(R.id.KEY)

        var s = f






        ///TODO randomgenerator number -> switch -> visibility obrazka -> bude to vo while slucke
        ///TODO -> while dokym neskonci timer



        game(Random.nextInt(1,11))

        binding.alien1.setOnClickListener {

            var s = binding.alien1.getTag(R.id.KEY)

            if(binding.alien1.getTag(R.id.KEY) == "alien")    {

                score++
                timer.cancel()
                binding.score.text = "Score: " + score
                binding.alien1.visibility = View.INVISIBLE

                game(Random.nextInt(1,11))
            }else{
                score--
                binding.alien1.setTag(R.id.KEY,null)
                timer.cancel()
                binding.score.text = "Score: " + score
                binding.alien1.visibility = View.INVISIBLE
                game(Random.nextInt(1,11))
            }
        }

        binding.alien2.setOnClickListener {

            var s = binding.alien2.getTag(R.id.KEY)

            if(binding.alien2.getTag(R.id.KEY) == "alien")    {

                score++
                binding.alien2.setTag(R.id.KEY,null)
                timer.cancel()
                binding.score.text = "Score: " + score
                binding.alien2.visibility = View.INVISIBLE
                game(Random.nextInt(1,11))
            }else{
                score--
                binding.alien2.setTag(R.id.KEY,null)
                timer.cancel()
                binding.score.text = "Score: " + score
                binding.alien2.visibility = View.INVISIBLE
                game(Random.nextInt(1,11))
            }
        }

        binding.alien3.setOnClickListener {

            var s = binding.alien3.getTag(R.id.KEY)

            if(binding.alien3.getTag(R.id.KEY) == "alien")    {

                score++
                binding.alien3.setTag(R.id.KEY,null)
                timer.cancel()
                binding.score.text = "Score: " + score
                binding.alien3.visibility = View.INVISIBLE
                game(Random.nextInt(1,11))
            }else{
                score--
                binding.alien3.setTag(R.id.KEY,null)
                timer.cancel()
                binding.score.text = "Score: " + score
                binding.alien3.visibility = View.INVISIBLE
                game(Random.nextInt(1,11))
            }
        }



        binding.alien4.setOnClickListener {

            var s = binding.alien4.getTag(R.id.KEY)

            if(binding.alien4.getTag(R.id.KEY) == "alien")    {

                score++
                binding.alien4.setTag(R.id.KEY,null)
                timer.cancel()
                binding.score.text = "Score: " + score
                binding.alien4.visibility = View.INVISIBLE
                game(Random.nextInt(1,11))
            }else{
                score--
                binding.alien4.setTag(R.id.KEY,null)
                timer.cancel()
                binding.score.text = "Score: " + score
                binding.alien4.visibility = View.INVISIBLE
                game(Random.nextInt(1,11))
            }
        }

        binding.alien5.setOnClickListener {

            var s = binding.alien5.getTag(R.id.KEY)

            if(binding.alien5.getTag(R.id.KEY) == "alien")    {

                score++
                binding.alien5.setTag(R.id.KEY,null)
                timer.cancel()
                binding.score.text = "Score: " + score
                binding.alien5.visibility = View.INVISIBLE
                game(Random.nextInt(1,11))
            }else{
                score--
                binding.alien5.setTag(R.id.KEY,null)
                timer.cancel()
                binding.score.text = "Score: " + score
                binding.alien5.visibility = View.INVISIBLE
                game(Random.nextInt(1,11))
            }
        }

        binding.alien6.setOnClickListener {

            var s = binding.alien6.getTag(R.id.KEY)

            if(binding.alien6.getTag(R.id.KEY) == "alien")    {

                score++
                binding.alien6.setTag(R.id.KEY,null)
                timer.cancel()
                binding.score.text = "Score: " + score
                binding.alien6.visibility = View.INVISIBLE
                game(Random.nextInt(1,11))
            }else{

                score--
                binding.alien6.setTag(R.id.KEY,null)
                timer.cancel()
                binding.score.text = "Score: " + score
                binding.alien6.visibility = View.INVISIBLE
                game(Random.nextInt(1,11))
            }
        }

        binding.alien7.setOnClickListener {

            var s = binding.alien7.getTag(R.id.KEY)

            if(binding.alien7.getTag(R.id.KEY) == "alien")    {

                score++
                binding.alien7.setTag(R.id.KEY,null)
                timer.cancel()
                binding.score.text = "Score: " + score
                binding.alien7.visibility = View.INVISIBLE
                game(Random.nextInt(1,11))
            }else{

                score--
                binding.alien7.setTag(R.id.KEY,null)
                timer.cancel()
                binding.score.text = "Score: " + score
                binding.alien7.visibility = View.INVISIBLE
                game(Random.nextInt(1,11))
            }
        }


        binding.alien8.setOnClickListener {

            var s = binding.alien8.getTag(R.id.KEY)

            if(binding.alien8.getTag(R.id.KEY) == "alien")    {

                score++
                binding.alien8.setTag(R.id.KEY,null)
                timer.cancel()
                binding.score.text = "Score: " + score
                binding.alien8.visibility = View.INVISIBLE
                game(Random.nextInt(1,11))
            }else{

                score--
                binding.alien8.setTag(R.id.KEY,null)
                timer.cancel()
                binding.score.text = "Score: " + score
                binding.alien8.visibility = View.INVISIBLE
                game(Random.nextInt(1,11))
            }
        }
        binding.alien9.setOnClickListener {


            var s = binding.alien9.getTag(R.id.KEY)

            if(binding.alien9.getTag(R.id.KEY) == "alien")    {
                score++
                binding.alien9.setTag(R.id.KEY,null)
                timer.cancel()
                binding.score.text = "Score: " + score
                binding.alien9.visibility = View.INVISIBLE
                game(Random.nextInt(1,11))
            }else{
                score--
                binding.alien9.setTag(R.id.KEY,null)
                timer.cancel()
                binding.score.text = "Score: " + score
                binding.alien9.visibility = View.INVISIBLE
                game(Random.nextInt(1,11))
            }
        }
    }

    fun game(randomNumber: Int){
        when (randomNumber) {
            1 -> {
                binding.alien1.setImageResource(R.drawable.imagegame_alien)
                binding.alien1.setTag(R.id.KEY,null)
                binding.alien1.setTag(R.id.KEY,"alien")
                binding.alien1.visibility = View.VISIBLE
//                binding.alien1.setTag("alien")
                endImage(1)
            }

            2 -> {
                binding.alien2.setImageResource(R.drawable.imagegame_alien)
                binding.alien2.setTag(R.id.KEY,null)
                binding.alien2.setTag(R.id.KEY,"alien")
                binding.alien2.visibility = View.VISIBLE
//                binding.alien2.setTag("alien")
                endImage(2)
            }

            3 -> {
                binding.alien3.setImageResource(R.drawable.imagegame_alien)
                binding.alien3.setTag(R.id.KEY,null)
                binding.alien3.setTag(R.id.KEY,"alien")
                binding.alien3.visibility = View.VISIBLE
//                binding.alien3.setTag("alien")
                endImage(3)
            }

            4 -> {
                binding.alien4.setImageResource(R.drawable.imagegame_alien)
                binding.alien4.setTag(R.id.KEY,null)
                binding.alien4.setTag(R.id.KEY,"alien")
                binding.alien4.visibility = View.VISIBLE
//                binding.alien4.setTag("alien")
                endImage(4)
            }

            5 -> {
                binding.alien5.setImageResource(R.drawable.imagegame_alien)
                binding.alien5.setTag(R.id.KEY,null)
                binding.alien5.setTag(R.id.KEY,"alien")
                binding.alien5.visibility = View.VISIBLE
//                binding.alien5.setTag("alien")
                endImage(5)
            }

            6 -> {
                binding.alien6.setImageResource(R.drawable.imagegame_alien)
                binding.alien6.setTag(R.id.KEY,null)
                binding.alien6.setTag(R.id.KEY,"alien")
                binding.alien6.visibility = View.VISIBLE
//                binding.alien6.setTag("alien")
                endImage(6)
            }

            7 -> {
                binding.alien7.setImageResource(R.drawable.imagegame_alien)
                binding.alien7.setTag(R.id.KEY,null)
                binding.alien7.setTag(R.id.KEY,"alien")
                binding.alien7.visibility = View.VISIBLE
//                binding.alien7.setTag("alien")
                endImage(7)
            }

            8 -> {
                binding.alien8.setImageResource(R.drawable.imagegame_alien)
                binding.alien8.setTag(R.id.KEY,null)
                binding.alien8.setTag(R.id.KEY,"alien")
                binding.alien8.visibility = View.VISIBLE
//                binding.alien8.setTag("alien")
                endImage(8)
            }

            9 -> {
                binding.alien9.setImageResource(R.drawable.imagegame_alien)
                binding.alien9.setTag(R.id.KEY,null)
                binding.alien9.setTag(R.id.KEY,"alien")
                binding.alien9.visibility = View.VISIBLE
//                binding.alien9.setTag("alien")
                endImage(9)
            }



            10->{
                var randomNumber = Random.nextInt(1,10)
                when (randomNumber) {

                    1 -> {

                        binding.alien1.setTag(R.id.KEY,null)
                        binding.alien1.setTag(R.id.KEY,"bomb")
//                        binding.alien1.setTag("bomb")
                        binding.alien1.setImageResource(R.drawable.imagegame_bomb)
                        binding.alien1.visibility = View.VISIBLE
                        endImage(10,1)
                    }

                    2 -> {

                        binding.alien2.setTag(R.id.KEY,null)
                        binding.alien2.setTag(R.id.KEY,"bomb")
//                        binding.alien2.setTag("bomb")
                        binding.alien2.setImageResource(R.drawable.imagegame_bomb)
                        binding.alien2.visibility = View.VISIBLE
                        endImage(10,2)
                    }

                    3 -> {

                        binding.alien3.setTag(R.id.KEY,null)
                        binding.alien3.setTag(R.id.KEY,"bomb")
//                        binding.alien3.setTag("bomb")
                        binding.alien3.setImageResource(R.drawable.imagegame_bomb)
                        binding.alien3.visibility = View.VISIBLE
                        endImage(10,3)
                    }

                    4 -> {

                        binding.alien4.setTag(R.id.KEY,null)
                        binding.alien4.setTag(R.id.KEY,"bomb")
//                        binding.alien4.setTag("bomb")
                        binding.alien4.setImageResource(R.drawable.imagegame_bomb)
                        binding.alien4.visibility = View.VISIBLE
                        endImage(10,4)
                    }

                    5 -> {

                        binding.alien5.setTag(R.id.KEY,null)
                        binding.alien5.setTag(R.id.KEY,"bomb")
//                        binding.alien5.setTag("bomb")
                        binding.alien5.setImageResource(R.drawable.imagegame_bomb)
                        binding.alien5.visibility = View.VISIBLE
                        endImage(10,5)
                    }

                    6 -> {

                        binding.alien6.setTag(R.id.KEY,null)
                        binding.alien6.setTag(R.id.KEY,"bomb")
//                        binding.alien6.setTag("bomb")
                        binding.alien6.setImageResource(R.drawable.imagegame_bomb)
                        binding.alien6.visibility = View.VISIBLE
                        endImage(10,6)
                    }

                    7 -> {

                        binding.alien7.setTag(R.id.KEY,null)
                        binding.alien7.setTag(R.id.KEY,"bomb")
//                        binding.alien7.setTag("bomb")
                        binding.alien7.setImageResource(R.drawable.imagegame_bomb)
                        binding.alien7.visibility = View.VISIBLE
                        endImage(10,7)
                    }

                    8 -> {

                        binding.alien8.setTag(R.id.KEY,null)
                        binding.alien8.setTag(R.id.KEY,"bomb")
//                        binding.alien8.setTag("bomb")
                        binding.alien8.setImageResource(R.drawable.imagegame_bomb)
                        binding.alien8.visibility = View.VISIBLE
                        endImage(10,8)
                    }

                    9 -> {

                        binding.alien9.setTag(R.id.KEY,null)
                        binding.alien9.setTag(R.id.KEY,"bomb")
//                        binding.alien9.setTag("bomb")
                        binding.alien9.setImageResource(R.drawable.imagegame_bomb)
                        binding.alien9.visibility = View.VISIBLE
                        endImage(10,9)
                    }
                }
            }


        }

    }

    fun endImage(alien: Int, bomb : Int = 0){
        timer = object : CountDownTimer(4000, 1000) {

            // Callback function, fired on regular interval
            override fun onTick(millisUntilFinished: Long) {
//                binding.countdown.setText("seconds remaining: " + millisUntilFinished / 1000)
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
                game(Random.nextInt(1,11))
            }
        }.start()
    }

}