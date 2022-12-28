package com.example.retrofitapi.ui.detail

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofitapi.model.Model
import com.example.retrofitapi.network.RetrofitApi
import com.example.retrofitapi.network.RetrofitHelper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DetailViewModel(private val id:Int, private val repo : ApiRepository) : ViewModel()
{
    private var _detailPost = MutableLiveData<List<Model>>()
    val detailPost : LiveData<List<Model>> = _detailPost
    init {
        getPostDetail(id)
    }
   fun getPostDetail(id:Int)
   {
       viewModelScope.launch(Dispatchers.IO)
       {
          val response = repo.getPostDetail(id)
           _detailPost.postValue(response)

       }
   }
}