package com.example.udacityproject1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.example.udacityproject1.databinding.FragmentLoginBinding


class loginFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentLoginBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)
        binding.signupBtn.setOnClickListener{view: View->
            if(binding.emailEditText.text.toString() == "" || binding.passwordEditText.text.toString() == "")
            {
                Toast.makeText(context, "There is an empty field. Please fill.", Toast.LENGTH_LONG).show()
            }
            else
            {
                Toast.makeText(context, "Registration successful", Toast.LENGTH_LONG).show()
                Navigation.findNavController(view).navigate(R.id.action_loginFragment2_to_welcomeFragment2)
            }

        }
        binding.signInBtn.setOnClickListener{view: View->
            if(binding.emailEditText.text.toString() == "" || binding.passwordEditText.text.toString() == "")
            {
                Toast.makeText(context, "There is an empty field. Please fill.", Toast.LENGTH_LONG).show()
            }
            else
            {
                Toast.makeText(context, "Login successful", Toast.LENGTH_SHORT).show()
                Navigation.findNavController(view).navigate(R.id.action_loginFragment2_to_welcomeFragment2)
            }

        }
        return binding.root
    }

}