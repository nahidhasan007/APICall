package com.example.retrofitapi.ui.list


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofitapi.model.Model
import com.example.retrofitapi.network.RetrofitApi
import com.example.retrofitapi.network.RetrofitHelper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RetrofitModelView : ViewModel()
{   private var _checkPosts = MutableLiveData<List<Model>>()
    val checkPosts : LiveData<List<Model>>
        get() = _checkPosts
    init {
        getPosts()
    }
    private fun getPosts() {

        var posts : List<Model>
        val readPosts = RetrofitHelper.getInstance().create(RetrofitApi::class.java)
        viewModelScope.launch(Dispatchers.IO) {
           _checkPosts.postValue(readPosts.getPosts())
        }

    }


}