package com.example.cleanarchitecture.base.fragment

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity

open class BaseFragment<A : FragmentActivity> : Fragment() {
    val parentActivity get() = activity as? A
}