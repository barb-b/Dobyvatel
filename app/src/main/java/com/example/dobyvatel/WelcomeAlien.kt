package com.example.dobyvatel

import android.animation.TimeInterpolator
import android.content.Intent
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.animation.AnimationUtils
import android.view.animation.CycleInterpolator
import android.view.animation.LinearInterpolator
import androidx.appcompat.app.AppCompatActivity
import com.example.dobyvatel.databinding.ActivityWelcomeAlienBinding

class WelcomeAlien : AppCompatActivity() {

    private lateinit var binding: ActivityWelcomeAlienBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWelcomeAlienBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val animationSlideUp = AnimationUtils.loadAnimation(this, R.anim.show)
        binding.Tod.startAnimation(animationSlideUp)

        binding.next.setOnClickListener {
            val intent = Intent(this, LevelsPage::class.java)
            startActivity(intent)
            finish()
        }
    }
}