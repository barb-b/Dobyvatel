package com.example.dobyvatel

import android.animation.ObjectAnimator
import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.opengl.Visibility
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.RadioButton
import androidx.appcompat.app.AppCompatActivity
import com.example.dobyvatel.databinding.ActivityQuizzBinding
import com.example.dobyvatel.objects.MilkyWayPlanets
import com.example.dobyvatel.objects.QuizzClass
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import kotlin.collections.ArrayList
import kotlin.random.Random


class Quizz : AppCompatActivity() {

    private lateinit var binding: ActivityQuizzBinding

    var row = 0
    val question = 1
    val answer1 = 2
    val answer2 = 3
    val rightAnswer = 4
    var currentPlanet = ""
    var scoreQuestion = 0
    var numberOfQuestions = 0

    var currentQuestion = QuizzClass("","","","")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuizzBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var listOfQuestion = ArrayList<QuizzClass>()

        //zisti planetu ktora sa aktualne hra
        whatIsCurrentPlanet()

        ///Otvor excel
        val open = assets.open("planety_quizz.xlsx")
        val workBook = XSSFWorkbook(open)
        val sheet = workBook.getSheetAt(0)
        val rowIterator = sheet.rowIterator()

        ///Napln array otazkami o sucastnej planete
        while (rowIterator.hasNext()) {

            if (sheet.getRow(row).getCell(0).toString() == currentPlanet) {

                val otazka = QuizzClass(
                    sheet.getRow(row).getCell(question).toString(),
                    sheet.getRow(row).getCell(answer1).toString(),
                    sheet.getRow(row).getCell(answer2).toString(),
                    sheet.getRow(row).getCell(rightAnswer).toString()
                )
                listOfQuestion.add(otazka)
            }
            row++
            rowIterator.next()
        }

        //Natlaci radio buttony do listu aby sa potom v metode mohli nahodne prehodit
        var randomOrderRadio = ArrayList<RadioButton>()
        randomOrderRadio.add(binding.radioButton2)
        randomOrderRadio.add(binding.radioButton3)
        randomOrderRadio.add(binding.radioButton4)

        ///TODO najprv random cislo -> potom vytiahnut z listu to
        createRandomQuestion(listOfQuestion, randomOrderRadio)

        //LISTENERY
        binding.nextQuestion.setOnClickListener {

            if(binding.radioGroup.checkedRadioButtonId == -1){
                ///Ak radiobutton nie je zaskrtnyty nic sa nespravi

            }else{
                isCorrectAnswer(currentQuestion)

                Handler(Looper.getMainLooper()).postDelayed({

                    createRandomQuestion(listOfQuestion, randomOrderRadio)
                }, 3000)

            }
        }
    }

    fun whatIsCurrentPlanet() {
        if (MilkyWayPlanets.sunIsPlaying) {
            currentPlanet = "SLNKO"
        } else if (MilkyWayPlanets.mercuryIsPlaying) {
            currentPlanet = "MERKUR"
        } else if (MilkyWayPlanets.venusIsPlaying) {
            currentPlanet = "VENUSA"
        } else if (MilkyWayPlanets.earthIsPlaying) {
            currentPlanet = "ZEM"
        } else if (MilkyWayPlanets.marsIsPlaying) {
            currentPlanet = "MARS"
        } else if (MilkyWayPlanets.jupiterIsPlaying) {
            currentPlanet = "JUPITER"
        } else if (MilkyWayPlanets.saturnIsPlaying) {
            currentPlanet = "SATURN"
        } else if (MilkyWayPlanets.uranusIsPlaying) {
            currentPlanet = "URAN"
        } else if (MilkyWayPlanets.neptuneIsPlaying) {
            currentPlanet = "NEPTUN"
        }
    }

    fun createRandomQuestion(list: ArrayList<QuizzClass>, radioButton:ArrayList<RadioButton>){


        if(numberOfQuestions == 3){
            // 3 otazky -> navrat ku planetam a vyhodnotenie
            //TODO VYHODNOTENIE
            // Clear vsetko

            // Nastavenie visibility
            binding.radioGroup.visibility = View.GONE
            binding.question.visibility = View.GONE
            binding.progressBar.visibility = View.GONE
            binding.nextQuestion.visibility = View.GONE
            binding.finish.visibility = View.VISIBLE

            if (scoreQuestion == 3){
                // HRAC VYHRAL

                binding.finish.text = "Vyhral si"

                Handler(Looper.getMainLooper()).postDelayed({
                    val intent = Intent()
                    ///TODO dat to metody -> opakovanie
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
                    setResult(Activity.RESULT_OK, intent)
                    finish()
                }, 3000)

            }else{
                // HRAC PREHRAL

                binding.finish.text = "Prehral si"
                Handler(Looper.getMainLooper()).postDelayed({

                    setResult(Activity.RESULT_OK, intent)
                    finish()
                }, 3000)

            }


        }else{
            // Generuje sa dalsia otazka

            // Z listu sa vytiahne random otazka
            val randomNu = Random.nextInt(0, list.size)
            currentQuestion = list.get(randomNu)

            //TODO vyhodnotenie
            //TODO predtym ako sa vsetko znova nacita treba urobit vyhodnotenie

            // Cistenie a nahadzanie otazok
            binding.radioGroup.clearCheck()
            binding.radioGroup.removeAllViews()
            binding.question.text = currentQuestion.question
            binding.radioButton2.text = currentQuestion.answer1
            binding.radioButton3.text = currentQuestion.answer2
            binding.radioButton4.text = currentQuestion.correctAns

            //OTAZKA sa vymaze zo zoznamu, aby sa neopakovala
            // random prehodenie otazok
            list.removeAt(randomNu)
            radioButton.shuffle()

            for (radio in radioButton) {
                binding.radioGroup.addView(radio)
            }
            numberOfQuestions++
        }
    }

    // Je odpoved na otazky sprana?
    fun isCorrectAnswer(quizzCorrect: QuizzClass){
        val radio: RadioButton = findViewById(binding.radioGroup.checkedRadioButtonId)
        ///TODO oznac spravnu odpoved na zeleno a zlu na cerveno

        if(radio.text == quizzCorrect.correctAns){
            scoreQuestion++
            radio.setBackgroundColor(Color.GREEN)
            ObjectAnimator.ofInt(binding.progressBar,"progress", scoreQuestion)
                .start()
        }else{
            //zla odpoved
            radio.setBackgroundColor(Color.RED)

        }
        Handler(Looper.getMainLooper()).postDelayed({
            radio.background = null
        }, 3000)
    }
}