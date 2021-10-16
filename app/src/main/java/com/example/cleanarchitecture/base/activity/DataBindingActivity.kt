package com.example.cleanarchitecture.base.activity

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

open class DataBindingActivity<T : ViewDataBinding>(
    @LayoutRes private val layoutId: Int
) : BaseActivity() {

    private lateinit var _binding: T
    val binding get() = _binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = DataBindingUtil.setContentView(this, layoutId)
    }

    override fun onDestroy() {
        _binding.unbind()
        super.onDestroy()
    }

}
