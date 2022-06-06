package com.example.my_dz_lesson1_daniyare.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.my_dz_lesson1_daniyare.R
import com.example.my_dz_lesson1_daniyare.databinding.ItemNewsBinding
import com.example.my_dz_lesson1_daniyare.model.News
import java.text.SimpleDateFormat
import java.util.*

class NewsAdapter(private val onClick: (position: Int) -> Unit) :
    RecyclerView.Adapter<NewsAdapter.ViewHolder>() {

    private val list = arrayListOf<News>()
    var onClickListenerAdapter: ((News) -> Unit)? = null
    var onLongClickListenerAdapter: ((Int) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(ItemNewsBinding.inflate(LayoutInflater.from(parent.context),
            parent,
            false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount() = list.size


    fun addItem(news: News?) {
        news?.let {
            list.add(0, it)
            notifyItemInserted(list.indexOf(news))
        }

    }

    fun remove(pos: Int) {
        list.removeAt(pos)
        notifyItemRemoved(pos)
    }

    fun addItems(list: List<News>) {
     this.list.addAll(list)
        notifyDataSetChanged()

    }
    fun getTodaydata():String{
        return SimpleDateFormat("hh:mm,dd MMMM yyyy", Locale.getDefault()).format(Date())
    }

    inner class ViewHolder(private var binding: ItemNewsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(news: News) {
            binding.textTitle.text = news.title
            val drawableBlack = ContextCompat.getDrawable(itemView.context, R.color.black)
            val intBlack = ContextCompat.getColor(itemView.context, R.color.black)
            val drawableWhite = ContextCompat.getDrawable(itemView.context, R.color.purple_200)
            val intWhite = ContextCompat.getColor(itemView.context, R.color.purple_200)
            if (adapterPosition % 2 == 0) {
                binding.textTitle.background = drawableBlack
                binding.textTitle.setTextColor(intWhite)
            } else {
                binding.textTitle.background = drawableWhite
                binding.textTitle.setTextColor(intBlack)
            }
            itemView.setOnClickListener{
                onClickListenerAdapter?.invoke(news)
            }
            binding.data.text = getTodaydata()
            itemView.setOnLongClickListener {
                onLongClickListenerAdapter?.invoke(adapterPosition)
                return@setOnLongClickListener true
            }
        }
    }
}