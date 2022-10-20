package com.example.dobyvatel

import android.animation.ObjectAnimator
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
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
    var currentPlanet = "SLNKO"
    var scoreQuestion = 0

    var currentQuestion = QuizzClass("","","","")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuizzBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        whatIsCurrentPlanet()

        var listOfQuestion = ArrayList<QuizzClass>()

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
                row++
            }
            rowIterator.next()
        }

        var randomOrderRadio = ArrayList<RadioButton>()
        randomOrderRadio.add(binding.radioButton2)
        randomOrderRadio.add(binding.radioButton3)
        randomOrderRadio.add(binding.radioButton4)


        ///TODO najprv random cislo -> potom vytiahnut z listu to
        createRandomQuestion(listOfQuestion, randomOrderRadio)

//        val randomNu = Random.nextInt(0, listOfQuestion.size)
//        val objectQue = listOfQuestion.get(randomNu)
//        binding.radioButton2.text = objectQue.answer1
//        binding.radioButton3.text = objectQue.answer2
//        binding.radioButton4.text = objectQue.correctAns
//        randomOrderRadio.shuffle()
//        binding.radioGroup.removeAllViews()
//        for (radio in randomOrderRadio) {
//            binding.radioGroup.addView(radio)
//        }



        binding.nextQuestion.setOnClickListener {
            isCorrectAnswer(currentQuestion)
            createRandomQuestion(listOfQuestion, randomOrderRadio)
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

        val randomNu = Random.nextInt(0, list.size)
        currentQuestion = list.get(randomNu)

        //TODO vyhodnotenie


        //TODO predtym ako sa vsetko znova nacita treba urobit vyhodnotenie
        binding.radioGroup.clearCheck()
        binding.radioGroup.removeAllViews()

        binding.question.text = currentQuestion.question
        binding.radioButton2.text = currentQuestion.answer1
        binding.radioButton3.text = currentQuestion.answer2
        binding.radioButton4.text = currentQuestion.correctAns

        radioButton.shuffle()

        for (radio in radioButton) {
            binding.radioGroup.addView(radio)
        }

    }

    fun isCorrectAnswer(quizzCorrect: QuizzClass){
        val radio: RadioButton = findViewById(binding.radioGroup.checkedRadioButtonId)
        if(radio.text == quizzCorrect.correctAns){
            scoreQuestion++
            ObjectAnimator.ofInt(binding.progressBar,"progress", scoreQuestion)
                .start()
        }


    }


}