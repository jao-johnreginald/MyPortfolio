package com.johnreg.myportfolio

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.johnreg.myportfolio.databinding.ActivityMainBinding
import com.johnreg.myportfolio.firstprojects.BmiActivity
import com.johnreg.myportfolio.firstprojects.ConverterActivity
import com.johnreg.myportfolio.firstprojects.QuoteActivity
import com.johnreg.myportfolio.model.Item
import com.johnreg.myportfolio.firstprojects.StartActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val projectsAdapter by lazy { ProjectsAdapter(getProjects()) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvProjects.layoutManager = LinearLayoutManager(this)
        binding.rvProjects.adapter = projectsAdapter

        projectsAdapter.setOnClickListener(object : ProjectsAdapter.OnClickListener {
            override fun onClick(position: Int) {
                val intent = parseIntToIntent(position)
                startActivity(intent)
            }
        })
    }

    private fun getProjects(): List<Item> = listOf(
        Item(
            "Start",
            "Our very first project, the default 'Hello World' app!",
            R.drawable.getting_started
        ),
        Item(
            "Quote Project",
            "Making a simple change to the layout, with my own personal motivational quote for software developers.",
            R.drawable.quote
        ),
        Item(
            "BMI Calculator",
            "A real life working BMI calculator teaching me Variables, Methods and Conditional Logic.",
            R.drawable.weight_scale
        ),
        Item(
            "Inches to Meters Converter",
            "My own personal calculator app I made on my own to convert inches to meters.",
            R.drawable.ruler
        ),
        Item(
            "Reginald's Restaurant",
            "A menu app for a fictional restaurant, learning about Activities, Classes & Objects, Arrays, Intents and ListViews.",
            R.drawable.restaurant
        )
    )

    private fun parseIntToIntent(int: Int): Intent = when (int) {
        0 -> Intent(this, StartActivity::class.java)
        1 -> Intent(this, QuoteActivity::class.java)
        2 -> Intent(this, BmiActivity::class.java)
        3 -> Intent(this, ConverterActivity::class.java)
        else -> Intent(this, MainActivity::class.java)
    }

}