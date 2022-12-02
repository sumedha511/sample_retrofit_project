package com.assignment.myapplication.service

import com.assignment.myapplication.data.ResponseItem
import com.assignment.myapplication.data.ResponseX
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers

interface ApiService {
    @GET("/posts/1")
    fun getJsonResponse():Call<ResponseItem>
}