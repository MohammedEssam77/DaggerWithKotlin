package com.example.kotlinwithdagger.apiService

import com.example.kotlinwithdagger.pojo.NewsModel
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("Api/News/GetNewsHome/209361/0/0/20/0")
    suspend fun getData():Response<List<NewsModel>>
}