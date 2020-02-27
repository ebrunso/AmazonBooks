package com.example.amazonbooks.datasource.remote.retrofit

import android.database.Observable
import com.example.amazonbooks.datasource.model.BookResponse.AmazonResponse
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Path

interface BookService {
    // Static Objects in Kotlin
    companion object{
        fun getBookCallService() =
            RetrofitHelper.retrofitInstance.create(BookService::class.java)
    }

    @GET("books/")
    fun getBooks()
            : Deferred<AmazonResponse>

}