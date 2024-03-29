package com.johnreg.myportfolio.firstprojects

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.johnreg.myportfolio.databinding.ActivityBmiBinding

class BmiActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBmiBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBmiBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}