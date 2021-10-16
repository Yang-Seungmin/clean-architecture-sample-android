package com.example.cleanarchitecture.base.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.FragmentActivity

open class DataBindingFragment<A : FragmentActivity, T : ViewDataBinding>(@LayoutRes private val layoutId: Int) :
    BaseFragment<A>() {

    private lateinit var _binding: T
    val binding: T get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = DataBindingUtil.inflate(
            LayoutInflater.from(requireContext()),
            layoutId,
            container,
            false
        )
        return _binding.root
    }

    override fun onDestroyView() {
        binding.unbind()
        super.onDestroyView()
    }
}