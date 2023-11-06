package com.example.caloriecalculator2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.caloriecalculator2.databinding.ActivityPocetnaBinding


class PocetnaActivity : AppCompatActivity() {
    lateinit var binding: ActivityPocetnaBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPocetnaBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.waterButtonIMG.setOnClickListener {

            intent = Intent(this, WaterActivity::class.java)

            startActivity(intent)
        }

        binding.foodButtonIMG.setOnClickListener {

            intent = Intent(this, FoodActivity::class.java)
            startActivity(intent)
        }

        binding.profileButtonIMG.setOnClickListener {

            intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
        }


    }
}