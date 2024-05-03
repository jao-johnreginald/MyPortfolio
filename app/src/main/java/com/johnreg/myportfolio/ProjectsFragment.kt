package com.johnreg.myportfolio

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.johnreg.myportfolio.databinding.FragmentProjectsBinding
import com.johnreg.myportfolio.models.Item

class ProjectsFragment : Fragment() {

    private lateinit var binding: FragmentProjectsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProjectsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setAdapter()
    }

    private fun setAdapter() {
        val projects = listOf(
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

        binding.rvProjects.adapter = ProjectsAdapter(projects)
    }

}