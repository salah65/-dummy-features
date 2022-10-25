package com.budiyev.android.libdemoapp.news.ui.Home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nytimesapp.Network.Resource
import com.example.nytimesapp.Network.RetrofitInstance
import com.example.nytimesapp.Network.handleError
import com.example.nytimesapp.mapper.toDomainModel
import com.budiyev.android.libdemoapp.news.model.Article
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HomeViewModel : ViewModel() {
    val articlesLiveData by lazy { MutableLiveData<Resource<List<Article>>>() }

    init {
        articlesLiveData.value = Resource.loading()
        getArticles()
    }


    fun getArticles() {
        viewModelScope.launch(handleError(articlesLiveData)) {
            withContext(IO) {
                val response = RetrofitInstance.getService().getMostPopularArticles(7)
                if (response.isSuccessful)
                    articlesLiveData.postValue(Resource.success(response.body()?.results?.toDomainModel()))

            }
        }
    }
}