package com.example.month_5_.MVVM

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.month_5_.MVVM.repository.CountViewMVVM
import com.example.month_5_.databinding.FragmentCountMVVMBinding


class CountMVVMFragment : Fragment() {
    private lateinit var binding: FragmentCountMVVMBinding
    private lateinit var viewmodel: CountViewMVVM

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCountMVVMBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewmodel = ViewModelProvider(this).get(CountViewMVVM::class.java)

        viewmodel.getCount().observe(viewLifecycleOwner) { it ->
            binding.tvView.text = it.toString()
        }

        initClicker()
    }

    private fun initClicker() {
        binding.btnAdd.setOnClickListener {
            viewmodel.inc()
        }
        binding.btnDic.setOnClickListener {
            viewmodel.dec()
        }
    }
}

