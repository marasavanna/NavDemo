package com.example.navdemo.fragmentA

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.navdemo.R
import com.example.navdemo.databinding.FragmentABinding

class FragmentA : Fragment() {

    private lateinit var binding: FragmentABinding

    private lateinit var fragmentAViewModel: FragmentAViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_a, container, false)
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fragmentAViewModel = ViewModelProvider(this).get(FragmentAViewModel::class.java)

        binding.changeText.setOnClickListener {
            fragmentAViewModel.changeText("I'm shiny happy and new")
        }

        fragmentAViewModel.selectedNumber.observe(viewLifecycleOwner, Observer {
            binding.dummy.text = it
        })

        binding.gotoB.setOnClickListener {
            findNavController().navigate(FragmentADirections.fragmentAToFragmentB())
        }
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}