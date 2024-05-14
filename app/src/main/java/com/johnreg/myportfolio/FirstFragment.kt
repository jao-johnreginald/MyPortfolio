package com.johnreg.myportfolio

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
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

        setTextView()
    }

    private fun setTextView() {
        when (args.project) {
            FirstProjects.START -> binding.tvFirst.text = getString(R.string.hello_world)
            FirstProjects.QUOTE -> binding.tvFirst.text = getString(R.string.quote)
        }
    }

}