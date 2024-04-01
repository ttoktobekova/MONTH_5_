package com.example.month_5_.image

import android.annotation.SuppressLint
import android.nfc.tech.MifareUltralight.PAGE_SIZE
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.OnScrollListener
import com.example.month_5_.databinding.FragmentImageBinding
import com.example.month_5_.image.model.PixaModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ImageFragment : Fragment() {
    private lateinit var binding: FragmentImageBinding
    private var adapter = PixaAdapter(arrayListOf())
    var oldWord = ""
    var newWord = ""
    var page = 1

    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentImageBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        addScrollListener()
        initAdapter()
        initClicker()
    }

    private fun addScrollListener() {
        binding.rvPhoto.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {

                super.onScrolled(recyclerView, dx, dy)
                val layoutManager = binding.rvPhoto.layoutManager as LinearLayoutManager
                val visibleImage = layoutManager.childCount
                val totalCount = layoutManager.itemCount
                val firstImage = layoutManager.findFirstVisibleItemPosition()

                if ((visibleImage + firstImage) >= totalCount && firstImage >= 0
                    && totalCount >= PAGE_SIZE
                ) {
                    page++
                    requestImage()
                }
            }
        })
    }

    private fun requestImage() {
        RetrofitServiceGallery.api.getImages(
            searchWord = binding.photoEt.text.toString(),
            page = page
        ).enqueue(object : Callback<PixaModel> {
            override fun onResponse(p0: Call<PixaModel>, response: Response<PixaModel>) {
                if (response.isSuccessful) {
                    response.body()?.let {
                        adapter.addImages(it.hits)
                        binding.rvPhoto.adapter = adapter
                    }
                }
            }

            override fun onFailure(p0: Call<PixaModel>, p1: Throwable) {
            }
        })
    }


    private fun initClicker() {
        binding.btnRequest.setOnClickListener {
            oldWord = binding.photoEt.text.toString()
            newWord = binding.photoEt.text.toString()
            if (oldWord != newWord) {
                ++page
            } else {
                ++page
                requestByImage(oldWord)
            }
            requestByImage(binding.photoEt.text.toString())

        }

    }

    private fun requestByImage(searchWord: String) {
        RetrofitServiceGallery.api.getImages(searchWord = searchWord, page = page)
            .enqueue(object : Callback<PixaModel> {
                @SuppressLint("NotifyDataSetChanged")
                override fun onResponse(p0: Call<PixaModel>, response: Response<PixaModel>) {
                    if (response.isSuccessful) {
                        response.body()?.let { model ->
                            if (oldWord != newWord) {
                                adapter.list = model.hits
                            } else {
                                adapter.addList(model.hits)
                            }
                            adapter.notifyDataSetChanged()
                        }
                        oldWord = binding.photoEt.text.toString()
                    }
                }

                override fun onFailure(p0: Call<PixaModel>, error: Throwable) {
                    Log.e("ololo", "onFailure :${error.message}")
                }
            })
    }

    private fun initAdapter() {
        binding.rvPhoto.adapter = adapter
    }
}
