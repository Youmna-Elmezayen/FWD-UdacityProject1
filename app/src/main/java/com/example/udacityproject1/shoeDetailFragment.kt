package com.example.udacityproject1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.udacityproject1.databinding.FragmentShoeDetailBinding
import com.example.udacityproject1.model.Shoe


class shoeDetailFragment : Fragment() {

    private lateinit var viewModel: ShoeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentShoeDetailBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_detail, container, false)

        viewModel = ViewModelProvider(requireActivity())[ShoeViewModel::class.java]

        with(binding)
        {
            shoe = Shoe("", 0.0, "", "")
        }

        binding.saveBtn.setOnClickListener {

            val name = binding.shoe?.name ?:""
            val size = binding.shoe?.size.toString()
            val company = binding.shoe?.company ?:""
            val desc = binding.shoe?.description ?:""

            if(name == "" || size == "" || company == "" || desc == "")
            {
                Toast.makeText(context, "There is an empty field. Please fill.", Toast.LENGTH_LONG).show()
            }
            else
            {
                viewModel.updateShoeList(name, size.toDouble(), company, desc)
                Toast.makeText(context, "Shoe is added to shoe list.", Toast.LENGTH_SHORT).show()
                findNavController().navigateUp()
            }

        }

        binding.cancelBtn.setOnClickListener {
            findNavController().navigateUp()
        }

        return binding.root
    }

}