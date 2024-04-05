package com.example.month_5_.MVVM

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.month_5_.databinding.FragmentMutableBinding

class MutableFragment : Fragment() {
    private lateinit var binding: FragmentMutableBinding
   private val viewModel: LoveViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMutableBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initClickers()
    }

    @SuppressLint("FragmentLiveDataObserve")
    private fun initClickers() {
        binding.apply {
            btnRequer.setOnClickListener {
                viewModel.getLiveData(
                    etFirst.text.toString(),
                    etSecond.text.toString()
                ).observe(this@MutableFragment, Observer {model->
                    //observer слушатель
                    tvResult.text = model.toString()
                })
            }
            btnHistory.setOnClickListener { }
        }
    }


}