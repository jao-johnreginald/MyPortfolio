package com.johnreg.myportfolio.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.johnreg.myportfolio.R
import com.johnreg.myportfolio.databinding.FragmentProjectsBinding
import com.johnreg.myportfolio.models.Item
import com.johnreg.myportfolio.models.FirstProjects

class ProjectsFragment : Fragment() {

    private var _binding: FragmentProjectsBinding? = null
    private val binding get() = _binding!!

    private var _projectsAdapter: ProjectsAdapter? = null
    private val projectsAdapter get() = _projectsAdapter!!

    private val projects = listOf(
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

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProjectsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _projectsAdapter = ProjectsAdapter(projects)

        setAdapter()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        _projectsAdapter = null
    }

    private fun setAdapter() {
        binding.rvProjects.adapter = projectsAdapter

        projectsAdapter.setOnClickListener(object : ProjectsAdapter.OnClickListener {
            override fun onClick(position: Int) {
                when (position) {
                    0 -> {
                        val action = ProjectsFragmentDirections.actionProjectsFragmentToFirstFragment(FirstProjects.START)
                        findNavController().navigate(action)
                    }
                    1 -> {
                        val action = ProjectsFragmentDirections.actionProjectsFragmentToFirstFragment(FirstProjects.QUOTE)
                        findNavController().navigate(action)
                    }
                }
            }
        })
    }

}