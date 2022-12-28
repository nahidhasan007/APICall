package com.example.retrofitapi.ui.detail

import androidx.lifecycle.LiveData
import com.example.retrofitapi.model.Model
import com.example.retrofitapi.network.RetrofitApi

class ApiRepository(private val api: RetrofitApi) {
  suspend fun getPostDetail(id:Int) = api.detailPost(id)
}