package com.example.my_dz_lesson1_daniyare

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.navigateUp
import com.example.my_dz_lesson1_daniyare.databinding.FragmentNewsBinding
import com.example.my_dz_lesson1_daniyare.model.News

class NewsFragment : Fragment() {
    private var binding: FragmentNewsBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentNewsBinding.inflate(layoutInflater,container,false)

        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getEditText()
        binding?.btnSave?.setOnClickListener {
            save()
        }
    }

    private fun getEditText() {
        val text = arguments?.getString("keyString")
        binding?.editNews?.setText(text)
    }

    private fun save() {
        val text = binding?.editNews?.text.toString()
        val news = News(text,System.currentTimeMillis())
        val bundle = bundleOf("news" to news)
        parentFragmentManager.setFragmentResult("rk_news",bundle)
        findNavController().navigateUp()

    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}