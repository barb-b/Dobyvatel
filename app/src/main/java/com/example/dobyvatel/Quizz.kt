package com.example.dobyvatel

import android.content.ContentProvider
import android.content.res.AssetFileDescriptor
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContentProviderCompat.requireContext
import com.example.dobyvatel.databinding.ActivityQuizzBinding
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


        val o = assets.open("planety_quizz.xlsx")

        val workBook = XSSFWorkbook(o)

        val sheet = workBook.getSheetAt(0)
        val name = sheet.getRow(0).getCell(0)

        val f = sheet.rowIterator().forEach { row -> row.rowNum  }
        


        binding.textView2.text = name.toString()
    }




}