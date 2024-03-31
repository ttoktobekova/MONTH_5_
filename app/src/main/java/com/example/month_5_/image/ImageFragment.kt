package com.example.month_5_.image

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.month_5_.databinding.FragmentImageBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ImageFragment : Fragment() {
    private lateinit var binding: FragmentImageBinding
    private var adapter = PixaAdapter(arrayListOf())
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentImageBinding.inflate(layoutInflater)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initAdapter()
        initClicker()
    }

    private fun initAdapter() {
        binding.rvPhoto.adapter = adapter

    }

    private fun initClicker() {
        binding.btnRequest.setOnClickListener {
            RetrofitServiceGallery.api.getImages(searchWord = binding.photoEt.text.toString())
                .enqueue(object : Callback<PixaModel> {
                    override fun onResponse(p0: Call<PixaModel>, response: Response<PixaModel>) {
                        if (response.isSuccessful) {
                            response.body()?.let { model ->
                                adapter.addList(model.hits)
                            }
                        }
                    }

                    override fun onFailure(p0: Call<PixaModel>, error: Throwable) {
                        Log.e("ololo", "onFailure :${error.message}")
                    }
                })
        }
    }
}