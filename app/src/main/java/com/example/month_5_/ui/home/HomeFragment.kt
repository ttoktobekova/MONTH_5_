package com.example.month_5_.ui.home

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.month_5_.Injector.Injector
import com.example.month_5_.R
import com.example.month_5_.databinding.FragmentHomeBinding
import com.example.month_5_.ui.COUNT.CountView

class HomeFragment : Fragment(), CountView {
    private var _binding: FragmentHomeBinding? = null
    var presenter = Injector.getPresenter(this)
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initClickers()

    }

    private fun initClickers() {
        with(binding) {

            btnAdd.setOnClickListener {
                presenter.increment()
            }
            btnDic.setOnClickListener {
                presenter.decrement()
            }
        }
    }

    override fun showCount(count: Int) {
        binding.tvView.text = count.toString()
    }

    override fun showToast(text: String) {
        Toast.makeText(context, text, Toast.LENGTH_SHORT).show()
    }

    override fun setColor(color: Int,count:Int) {
            binding.tvView.setTextColor(color)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}