package com.johnreg.myportfolio.firstprojects

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.johnreg.myportfolio.R
import com.johnreg.myportfolio.databinding.FragmentFirstBinding
import com.johnreg.myportfolio.models.FirstProjects

class FirstFragment : Fragment() {

    private lateinit var binding: FragmentFirstBinding

    private val args: FirstFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (requireActivity() as AppCompatActivity).supportActionBar?.title = when (args.project) {
            FirstProjects.START -> "Getting Started"
            FirstProjects.QUOTE -> "Quote Project"
        }

        binding.tvFirst.text = when (args.project) {
            FirstProjects.START -> getString(R.string.hello_world)
            FirstProjects.QUOTE -> getString(R.string.quote)
        }
    }

}