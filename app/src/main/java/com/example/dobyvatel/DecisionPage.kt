package com.example.dobyvatel

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.dobyvatel.databinding.ActivityDecisionPageBinding


class DecisionPage : AppCompatActivity() {

    private lateinit var binding: ActivityDecisionPageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDecisionPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //TODO hlavny obrazok podla toho aka planeta je otvorena
        //TODO text podla toho aka planeta je otvorena


        binding.fight.setOnClickListener {
            //TODO presmerovanie na imageGame stranku
            //TODO algoritmus -> ci sa akceptuje boj alebo nie
            //TODO prepocitavanie -> zmizne druhy button -> zmizne text -> odpocitavanie, potom sa objavi vysledok
            //TODO a bude presmerovany na stranku ktora zvitazi
            //TODO mozno nejaka statistika, ze kolko krat si vybral hrac boj a mier
            //TODO vyhodnocovanie -> vypnut scrollview, zmena textu atd
        }

        binding.peace.setOnClickListener {
            //TODO mierova dohoda?? kam to bude
            //TODO detto algoritmus ci sa rozhodnu to schvalit
        }



    }
}