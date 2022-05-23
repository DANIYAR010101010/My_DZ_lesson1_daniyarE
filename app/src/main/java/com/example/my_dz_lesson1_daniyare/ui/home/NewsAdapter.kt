package com.example.my_dz_lesson1_daniyare.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerViewAccessibilityDelegate
import com.example.my_dz_lesson1_daniyare.databinding.ItemNewsBinding
import com.example.my_dz_lesson1_daniyare.model.News
import java.util.ArrayList

class NewsAdapter(private val onClick:(position:Int)->Unit
): RecyclerView.Adapter<NewsAdapter.ViewHolder>() {

    private val list = arrayListOf<News>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(ItemNewsBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.bind(list[position])
    }

    override fun getItemCount()= list.size


    fun addItem(news: News?) {
       news?.let { list.add(0,it)
            notifyItemInserted(list.indexOf(news))
        }

    }

    inner class ViewHolder(private var binding: ItemNewsBinding) : RecyclerView.ViewHolder(binding.root) {
       fun bind(news: News) {
           binding.textTitle.text= news.title

       }

   }
}