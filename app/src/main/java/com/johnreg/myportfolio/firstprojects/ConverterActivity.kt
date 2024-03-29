package com.johnreg.myportfolio.firstprojects

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.johnreg.myportfolio.databinding.ActivityConverterBinding

class ConverterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityConverterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityConverterBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}