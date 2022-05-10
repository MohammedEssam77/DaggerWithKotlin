package com.example.kotlinwithdagger.repositry

import com.example.kotlinwithdagger.apiService.ApiService
import javax.inject.Inject

class Repository
@Inject
constructor(private val apiService: ApiService) {
    suspend fun getData() = apiService.getData()


}