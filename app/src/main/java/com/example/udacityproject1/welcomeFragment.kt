package com.example.udacityproject1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.example.udacityproject1.databinding.FragmentLoginBinding
import com.example.udacityproject1.databinding.FragmentWelcomeBinding

class welcomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentWelcomeBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_welcome, container, false)
        binding.instructionsBtn.setOnClickListener{view: View->
            Navigation.findNavController(view).navigate(R.id.action_welcomeFragment_to_instructionsFragment)
        }
        return binding.root
    }


}