package com.example.amazonbooks

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.amazonbooks.datasource.remote.retrofit.BookService
import com.example.amazonbooks.view.adapter.BookAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    val adapter by lazy{ BookAdapter() }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rvBooks.layoutManager = LinearLayoutManager(this)
        rvBooks.adapter = adapter

        getBooksFromAPI()
    }


    fun getBooksFromAPI(){
        val service = BookService.getBookCallService()

        CoroutineScope(Dispatchers.IO).launch {
            val bookRequest = service. getBooks()
            withContext(Dispatchers.Main){
                val response = bookRequest.await()
                adapter.addBook(response)
            }
        }
    }


}
