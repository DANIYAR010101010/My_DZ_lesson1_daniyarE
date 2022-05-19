package com.example.my_dz_lesson1_daniyare.ui.profile

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.my_dz_lesson1_daniyare.databinding.FragmentNotificationsBinding
import com.example.my_dz_lesson1_daniyare.databinding.FragmentProfileBinding
import com.google.android.material.bottomnavigation.BottomNavigationView


class ProfileFragment : Fragment() {
    private lateinit var binding: FragmentProfileBinding

    private lateinit var launcher: ActivityResultLauncher<Intent>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentProfileBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initLauncher()
        initListener()
    }

    private fun initListener() {
        binding.imageAvatar.setOnClickListener {
            val intent = Intent()
            intent.action = Intent.ACTION_PICK
            intent.type = "image/*"
            launcher.launch(intent)
        }
    }

    private fun initLauncher() {
        launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {

                if (it.resultCode == AppCompatActivity.RESULT_OK) {
                    val image = it.data?.data
                    if (image != null) {
                        binding.imageAvatar.setImageURI(image)
                    }
                }
            }

    }


}









