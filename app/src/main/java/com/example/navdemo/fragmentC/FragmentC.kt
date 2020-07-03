package com.example.navdemo.fragmentC

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.navdemo.R
import com.example.navdemo.databinding.FragmentCBinding

class FragmentC : Fragment() {

    private lateinit var binding: FragmentCBinding
    private lateinit var fragmentCViewModel: FragmentCViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_c, container, false
        )
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fragmentCViewModel = ViewModelProvider(this).get(FragmentCViewModel::class.java)

        fragmentCViewModel.setItems()

        val dummyAdapter = DummyAdapter()

        dummyAdapter.onItemClickListener = {
            findNavController().navigate(FragmentCDirections.fragmentCToFragmentD())
        }
        binding.dummyList.layoutManager = LinearLayoutManager(requireContext())
        binding.dummyList.adapter = dummyAdapter

        fragmentCViewModel.firstVisiblePosition.value?.let {
            (binding.dummyList.layoutManager as LinearLayoutManager).scrollToPosition(it)
        }

        // Observe on the viewlifecyleowner in order to prevent viewmodel leaks
        fragmentCViewModel.dummies.observe(viewLifecycleOwner, Observer {
            dummyAdapter.setDummies(it)
        })

    }

    override fun onPause() {
        super.onPause()
        fragmentCViewModel.setVisiblePosition(
            (binding.dummyList.layoutManager as LinearLayoutManager).findFirstCompletelyVisibleItemPosition()
        )
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}