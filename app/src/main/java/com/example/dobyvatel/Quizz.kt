package com.example.dobyvatel

import android.content.ContentProvider
import android.content.res.AssetFileDescriptor
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContentProviderCompat.requireContext
import com.example.dobyvatel.databinding.ActivityQuizzBinding
import com.example.dobyvatel.objects.QuizzClass
import org.apache.poi.ss.usermodel.WorkbookFactory
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import java.io.BufferedInputStream
import java.io.File
import java.io.FileInputStream
import java.io.InputStream


class Quizz : AppCompatActivity() {

    private lateinit var binding: ActivityQuizzBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuizzBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var listOfQuestion = ArrayList<QuizzClass>()


        ///Otvor excel
        val open = assets.open("planety_quizz.xlsx")
        val workBook = XSSFWorkbook(open)
        val sheet = workBook.getSheetAt(0)


        val name = sheet.getRow(0).getCell(0)
        val rowIterator = sheet.rowIterator()

        var row = 0
        val otazka = 1
        val odp = 2
        val col2 = 3
        val correctcolu = 4

        while(rowIterator.hasNext()){

            if(sheet.getRow(row).getCell(0).toString() == "SLNKO"){

                val otazka = QuizzClass(sheet.getRow(row).getCell(otazka).toString(),
                    sheet.getRow(row).getCell(odp).toString(),
                    sheet.getRow(row).getCell(col2).toString(),
                    sheet.getRow(row).getCell(correctcolu).toString())
                listOfQuestion.add(otazka)
                row++
            }
            rowIterator.next()
        }

        println()
        


        binding.textView2.text = name.toString()
    }




}