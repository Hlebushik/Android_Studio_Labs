package com.example.lab8

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.lab8.databinding.SportsDetailsBinding

class SportsDetailsActivity : AppCompatActivity() {
    private lateinit var binding: SportsDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = SportsDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sportsName = intent.getStringExtra("sportsName")
        binding.sportsButton.text = sportsName
    }
}

