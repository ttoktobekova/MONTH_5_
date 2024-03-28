package com.example.month_5_.LoveCalculator

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.month_5_.R
import com.example.month_5_.databinding.FragmentLoveCalculatorBinding
import com.example.month_5_.model.LoveModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoveCalculatorFragment : Fragment(), LoveView {
    val presenter = PresenterLove(this)

    private lateinit var binding: FragmentLoveCalculatorBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoveCalculatorBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initClicker()
    }

    private fun initClicker() {
        binding.btnHistory.setOnClickListener() {
            binding.apply {
                RetrofitService.api.getLove(
                    etFirst.text.toString(),
                    etSecond.text.toString()
                )
                    .enqueue(object : Callback<LoveModel> {
                        override fun onResponse(
                            call: Call<LoveModel>,
                            response: Response<LoveModel>
                        ) {
                            if (response.isSuccessful) {
                                val fname = response.body()?.firstName
                                val sname = response.body()?.secondName
                                val persantage = response.body()?.percentage
                                val result = response.body()?.result
                                val resultFragment = ResultFragment()
                                val bundle = Bundle()

                                bundle.putString("fname", fname.toString())
                                bundle.putString("sname", sname.toString())
                                bundle.putString("persantage", persantage.toString())
                                bundle.putString("result", result.toString())

                                resultFragment.arguments = bundle
                                findNavController().navigate(R.id.resultFragment, bundle)
                            }
                        }

                        override fun onFailure(call: Call<LoveModel>, t: Throwable) {
                            Log.e("ololo", "onFailure:${t.message}")
                        }

                    })
            }
        }
    }



    override fun showResult(loveModel: LoveModel) {

    }
}






