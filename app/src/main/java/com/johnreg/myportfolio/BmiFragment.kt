package com.johnreg.myportfolio

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.johnreg.myportfolio.databinding.FragmentBmiBinding
import java.text.DecimalFormat

class BmiFragment : Fragment() {

    private lateinit var binding: FragmentBmiBinding

    /** Class variables are also called 'Fields' */
    private lateinit var ageText: String
    private lateinit var feetText: String
    private lateinit var inchesText: String
    private lateinit var weightText: String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBmiBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnCalculate.setOnClickListener {
            getTexts()
            areTextsEmpty()
        }
    }

    private fun getTexts() {
        ageText = binding.etAge.text.toString()
        feetText = binding.etFeet.text.toString()
        inchesText = binding.etInches.text.toString()
        weightText = binding.etWeight.text.toString()
    }

    private fun areTextsEmpty() {
        if (ageText.isEmpty() || feetText.isEmpty() || inchesText.isEmpty() || weightText.isEmpty()) {
            Toast.makeText(requireContext(), "Please fill every blank.", Toast.LENGTH_SHORT).show()
        } else {
            setResultText()
        }
    }

    private fun setResultText() {
        val bmi: Double = calculateBmi()
        val bmiText: String = DecimalFormat("0.00").format(bmi)

        val age: Int = Integer.parseInt(ageText)

        val fullResultString: String = if (age >= 18) {
            getResultString(bmi, bmiText)
        } else {
            getGuidanceString(bmiText)
        }

        binding.tvResult.text = fullResultString
    }

    private fun calculateBmi(): Double {
        // Converting the 'number Strings' into 'int variables'
        val feet: Int = Integer.parseInt(feetText)
        val inches: Int = Integer.parseInt(inchesText)
        val weight: Int = Integer.parseInt(weightText)

        // 1 foot is 12 inches
        val totalInches: Int = (feet * 12) + inches

        // Height in meters is inches * 0.0254
        val heightInMeters: Double = totalInches * 0.0254

        // BMI formula = weight in kg / height in meters squared
        return weight / (heightInMeters * heightInMeters)
    }

    private fun getResultString(bmi: Double, bmiText: String): String = when {
        // Display underweight
        bmi < 18.5 -> "$bmiText - You are underweight."
        // Display overweight
        bmi > 25 -> "$bmiText - You are overweight."
        // Display healthy
        else -> "$bmiText - You are a healthy weight."
    }

    private fun getGuidanceString(bmiText: String): String {
        val message = " - As you are under 18, please consult with your doctor for the healthy range"
        return when {
            // Display boy guidance
            binding.rbMale.isChecked -> "$bmiText$message for boys."
            // Display girl guidance
            binding.rbFemale.isChecked -> "$bmiText$message for girls."
            // Display general guidance
            else -> "$bmiText$message."
        }
    }

}