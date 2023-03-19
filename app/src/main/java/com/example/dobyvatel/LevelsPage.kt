package com.example.dobyvatel

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.dobyvatel.databinding.ActivityLevelsPageBinding
import com.example.dobyvatel.databinding.ActivityMilkywayMapBinding

class LevelsPage : AppCompatActivity() {

    private lateinit var binding: ActivityLevelsPageBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityLevelsPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.milkyway.animate().rotationBy(100F).setDuration(2000)

        binding.milkyway.setOnClickListener{

            val intent = Intent(this, MilkyWay::class.java)
            startActivity(intent)
        }
    }
}