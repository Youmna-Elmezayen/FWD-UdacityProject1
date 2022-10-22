package com.example.udacityproject1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.example.udacityproject1.databinding.FragmentInstructionsBinding

class instructionsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentInstructionsBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_instructions, container, false)
        binding.shoeListBtn.setOnClickListener{view: View->
            Navigation.findNavController(view).navigate(R.id.action_instructionsFragment_to_shoeListFragment)
        }
        return binding.root
    }

}