package com.example.my_dz_lesson1_daniyare.ui.board

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.navigation.fragment.findNavController
import com.example.my_dz_lesson1_daniyare.R
import com.example.my_dz_lesson1_daniyare.databinding.FragmentBoardBinding
import com.example.my_dz_lesson1_daniyare.databinding.FragmentNewsBinding

class BoardFragment : Fragment() {
    private lateinit var binding: FragmentBoardBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentBoardBinding.inflate(layoutInflater,container,false)

        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = BoardAdapter(findNavController())
        binding.viewPager.adapter = adapter
        activity?.onBackPressedDispatcher?.addCallback(viewLifecycleOwner){
            activity?.finish()
        }
    }


}