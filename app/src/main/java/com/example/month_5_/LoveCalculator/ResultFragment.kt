package com.example.month_5_.LoveCalculator

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.month_5_.databinding.FragmentResultBinding

class ResultFragment : Fragment() {
    private lateinit var binding: FragmentResultBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentResultBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var result = arguments?.getString("result")
        var fname = arguments?.getString("fname")
        var sname = arguments?.getString("sname")
        var persantage = arguments?.getString("persantage")

        with(binding) {
            tvFirst.text = fname.toString()
            tvSecond.text = sname.toString()
            tvPersenter.text = persantage.toString()
            tvResult.text = result.toString()

            btnTryAgain.setOnClickListener {
                findNavController().navigateUp()
            }
        }
    }
}


