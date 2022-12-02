package com.assignment.myapplication

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.assignment.myapplication.data.ResponseItem
import com.assignment.myapplication.data.ResponseX
import com.assignment.myapplication.service.ApiService
import okhttp3.OkHttpClient
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val service= Singleton.retrofit.create(ApiService::class.java)
        Log.d("Service", "APIService created.......... ")
        val list: Call<ResponseItem> = service.getJsonResponse()

        
        list.enqueue(object : Callback<ResponseItem> {
            override fun onResponse(call: Call<ResponseItem>, response: Response<ResponseItem>) {
                Log.d("onResponse", "${response.body()} ")
            }

            override fun onFailure(call: Call<ResponseItem>, t: Throwable) {

            }

        })


        //Log.d("Response is cancelled", "${list.}")


        val adapter = JsonListAdapter(arrayListOf("abc","pqr"))
        val recyclerView = findViewById<RecyclerView>(R.id.rv_main_activity)
        recyclerView.adapter = adapter

        recyclerView.layoutManager = LinearLayoutManager(this)

    }
}



object Singleton {

    var retrofit = Retrofit.Builder()
        .baseUrl("https://jsonplaceholder.typicode.com")
        .addConverterFactory(GsonConverterFactory.create())
        .client(OkHttpClient.Builder().build())
        .build()
}