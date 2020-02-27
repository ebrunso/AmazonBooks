package com.example.amazonbooks.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.amazonbooks.R
import com.example.amazonbooks.datasource.model.BookResponse.AmazonResponse
import kotlinx.android.synthetic.main.book_item.view.*

class BookAdapter() : RecyclerView.Adapter<BookAdapter.ViewHolder>() {
    val bookList = ArrayList<AmazonResponse>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.book_item, parent, false))


    override fun getItemCount() = bookList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int)  =
        holder.populateJoke(bookList[position])

    fun addBook(bookToAdd : AmazonResponse) {
        bookList.add(bookToAdd)
        notifyDataSetChanged()
    }
    inner class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        fun populateJoke(bookResponse: AmazonResponse) {
            itemView.tvBookTitle.text = bookResponse.title
            itemView.tvBookAuthor.text = bookResponse.author
            Glide
                .with(itemView)
                .load(bookResponse.imageURL)
                .into(itemView.ivBookCover)
        }
    }


}