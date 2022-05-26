package com.example.my_dz_lesson1_daniyare.ui.board

import android.opengl.Visibility
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.NonNull
import androidx.navigation.NavController
import androidx.recyclerview.widget.RecyclerView
import com.example.my_dz_lesson1_daniyare.R
import com.example.my_dz_lesson1_daniyare.databinding.ItemBoardBinding
import com.example.my_dz_lesson1_daniyare.model.News

class BoardAdapter(val navController: NavController):
    RecyclerView.Adapter<BoardAdapter.ViewHolder>() {


     private val list = arrayListOf<String>("Салам","Hello","Привет","Ni hao")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(ItemBoardBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
     holder.bind(position)

    }

    override fun getItemCount()= list.size




    inner class ViewHolder(private var binding: ItemBoardBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            binding.textTitle.text= list[position]
            if (position == list.lastIndex)
                binding.btnStart.visibility= View.VISIBLE
            else binding.btnStart.visibility=View.INVISIBLE

            binding.btnStart.setOnClickListener {
            navController.navigateUp()
            }
        }



    }




}