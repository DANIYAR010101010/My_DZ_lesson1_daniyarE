package com.example.my_dz_lesson1_daniyare.ui.home

import android.app.AlertDialog
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.my_dz_lesson1_daniyare.App
import com.example.my_dz_lesson1_daniyare.R
import com.example.my_dz_lesson1_daniyare.databinding.FragmentHomeBinding
import com.example.my_dz_lesson1_daniyare.model.News

class HomeFragment : Fragment()   {
    private lateinit var adapter: NewsAdapter
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        adapter = NewsAdapter{
            parentFragmentManager.setFragmentResultListener("rk_new", viewLifecycleOwner
            ) { _: String, bundle: Bundle ->
                val news = bundle.getSerializable("new") as News
                Log.e("Home", "text =  $news")

            }
        }
        val list = App.dataBase.newsDao().getAll()

            adapter.addItems(list)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        ViewModelProvider(this).get(HomeViewModel::class.java)
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        binding.root
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initListener()

        binding.btnPlus.setOnClickListener {
            findNavController().navigate(R.id.newsFragment)
        }
        parentFragmentManager.setFragmentResultListener("rk_news", viewLifecycleOwner
        ) { _: String, bundle: Bundle ->
            val news = bundle.getSerializable("news") as News
            Log.e("Home", "text =  $news")
            adapter.addItem(news)
        }

        binding.recyclerView.adapter = adapter
    }

    private fun initListener() {
        adapter.onClickListenerAdapter = {
            val bundle = Bundle()
            bundle.putString("keyString", it.title)
            findNavController().navigate(R.id.newsFragment, bundle)
        }

        adapter.onLongClickListenerAdapter = {
            val alert = AlertDialog.Builder(context)
            alert.setTitle("удалить новость")
            alert.setMessage("правда хотите удалить новость?")
            alert.setPositiveButton("удалить") { _, _ ->
                Toast.makeText(
                    requireContext(),
                    "Удален объект под номером $it",
                    Toast.LENGTH_SHORT
                ).show()
                adapter.remove(it)
                binding.recyclerView.adapter = adapter
            }
            alert.setNegativeButton("отмена") { dialog, _ -> dialog.cancel() }
            alert.show()
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}