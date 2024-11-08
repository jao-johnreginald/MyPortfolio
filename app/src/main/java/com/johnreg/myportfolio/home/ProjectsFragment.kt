package com.johnreg.myportfolio.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.johnreg.myportfolio.R
import com.johnreg.myportfolio.databinding.FragmentProjectsBinding
import com.johnreg.myportfolio.models.FirstProjects
import com.johnreg.myportfolio.models.Projects.projects

class ProjectsFragment : Fragment() {

    private var _binding: FragmentProjectsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProjectsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setAdapter()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setAdapter() {
        binding.rvProjects.adapter = ProjectsAdapter(projects) { position ->
            when (position) {
                0 -> findNavController().navigate(
                    ProjectsFragmentDirections.actionProjectsFragmentToFirstFragment(
                        FirstProjects.START
                    )
                )

                1 -> findNavController().navigate(
                    ProjectsFragmentDirections.actionProjectsFragmentToFirstFragment(
                        FirstProjects.QUOTE
                    )
                )

                2 -> findNavController().navigate(R.id.action_projectsFragment_to_bmiFragment)
                3 -> findNavController().navigate(R.id.action_projectsFragment_to_converterFragment)
            }
        }
    }

}