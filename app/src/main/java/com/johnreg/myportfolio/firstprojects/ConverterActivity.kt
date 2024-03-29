package com.johnreg.myportfolio.firstprojects

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.johnreg.myportfolio.databinding.ActivityConverterBinding
import java.text.DecimalFormat

class ConverterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityConverterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityConverterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnConvert.setOnClickListener { isTextEmpty() }
    }

    private fun isTextEmpty() {
        if (binding.etInchesConverter.text.isEmpty()) {
            Toast.makeText(this, "Please type in the number of inches.", Toast.LENGTH_SHORT).show()
        } else setResultText()
    }

    private fun setResultText() {
        val inches: Int = Integer.parseInt(binding.etInchesConverter.text.toString())
        val heightInMeters: Double = inches * 0.0254
        val metersTextResult: String = DecimalFormat("0.00").format(heightInMeters)
        val fullTextResult = "$metersTextResult meters"
        binding.tvResultConverter.text = fullTextResult
    }

}