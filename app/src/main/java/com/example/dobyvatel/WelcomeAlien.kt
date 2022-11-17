package com.example.dobyvatel

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.dobyvatel.databinding.ActivityWelcomeAlienBinding

class WelcomeAlien : AppCompatActivity() {

    private lateinit var binding: ActivityWelcomeAlienBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWelcomeAlienBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.next.setOnClickListener {
            val intent = Intent(this, LevelsPage::class.java)
            startActivity(intent)
            finish()
        }
    }
}