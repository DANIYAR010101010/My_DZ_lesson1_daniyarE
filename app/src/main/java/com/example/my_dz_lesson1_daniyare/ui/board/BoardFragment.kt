package com.example.my_dz_lesson1_daniyare.ui.board

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.example.my_dz_lesson1_daniyare.Preferences
import com.example.my_dz_lesson1_daniyare.R
import com.example.my_dz_lesson1_daniyare.databinding.FragmentBoardBinding
import com.example.my_dz_lesson1_daniyare.databinding.FragmentNewsBinding
import com.example.my_dz_lesson1_daniyare.model.FragmentImage
import me.relex.circleindicator.CircleIndicator3

class BoardFragment : Fragment() {
    private lateinit var binding: FragmentBoardBinding
    private val ddd = arrayListOf<FragmentImage>()

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
        val adapter = BoardAdapter(requireContext(),findNavController())


        binding.viewPager.adapter = adapter
        activity?.onBackPressedDispatcher?.addCallback(viewLifecycleOwner){
            activity?.finish()
        }
        binding.skipImage.setOnClickListener {
            Preferences(requireContext()).saveState()
            findNavController().navigateUp()
        }
        binding.viewPager.orientation=ViewPager2.ORIENTATION_HORIZONTAL
        val indicator : CircleIndicator3? = activity?.findViewById<CircleIndicator3>(R.id.tochki)
        indicator?.setViewPager(binding.viewPager)
    }


}