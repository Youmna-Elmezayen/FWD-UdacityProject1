package com.example.udacityproject1

import android.os.Bundle
import android.view.*
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.udacityproject1.databinding.FragmentShoeListBinding
import com.example.udacityproject1.databinding.NewShoeLayoutBinding


class shoeListFragment : Fragment() {

    private lateinit var viewModel: ShoeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentShoeListBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_list, container, false)
        binding.newShoeFloatingBtn.setOnClickListener {view: View->
            Navigation.findNavController(view).navigate(R.id.action_shoeListFragment_to_shoeDetailFragment)
        }

        viewModel = ViewModelProvider(requireActivity())[ShoeViewModel::class.java]
        viewModel.shoesList.observe(viewLifecycleOwner) {shoeList ->
            for (shoe in shoeList)
            {
                binding.emptyText.isVisible = false
                val newShoeBinding: NewShoeLayoutBinding = DataBindingUtil.inflate(inflater, R.layout.new_shoe_layout, container, false)
                newShoeBinding.nameDisplay.text = shoe.name
                newShoeBinding.sizeDisplay.text = shoe.size.toString()
                newShoeBinding.companyDisplay.text = shoe.company
                newShoeBinding.descDisplay.text = shoe.description

                binding.parentShoeView.addView(newShoeBinding.root)
            }
        }

        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.overflow_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.logoutItem)
        {
            findNavController().navigate(R.id.loginFragment2)
        }
        return false
    }
}