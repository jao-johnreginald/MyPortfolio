package com.johnreg.myportfolio.firstprojects

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.johnreg.myportfolio.databinding.FragmentConverterBinding
import java.text.DecimalFormat

class ConverterFragment : Fragment() {

    private lateinit var binding: FragmentConverterBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentConverterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnConvert.setOnClickListener { isTextEmpty() }
    }

    private fun isTextEmpty() {
        if (binding.etInchesConverter.text.isEmpty()) {
            Toast.makeText(requireContext(), "Please type in the number of inches.", Toast.LENGTH_SHORT).show()
        } else {
            setResultText()
        }
    }

    private fun setResultText() {
        val inches: Int = Integer.parseInt(binding.etInchesConverter.text.toString())
        val heightInMeters: Double = inches * 0.0254
        val metersTextResult: String = DecimalFormat("0.00").format(heightInMeters)
        val fullTextResult = "$metersTextResult meters"
        binding.tvResultConverter.text = fullTextResult
    }

}