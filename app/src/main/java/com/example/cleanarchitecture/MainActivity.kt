package com.example.cleanarchitecture

import android.os.Bundle
import android.view.MenuItem
import androidx.annotation.IdRes
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.cleanarchitecture.base.activity.DataBindingActivity
import com.example.cleanarchitecture.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : DataBindingActivity<ActivityMainBinding>(R.layout.activity_main) {

    private lateinit var _navHostFragment: NavHostFragment
    private lateinit var _navController: NavController

    val navHostFragment: NavHostFragment get() = _navHostFragment
    val navController: NavController get() = _navController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment_main) as NavHostFragment
        _navController = _navHostFragment.findNavController()

        binding.bottomNavigationViewMain.setupWithNavController(_navController)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    fun navigateTo(@IdRes actionId: Int) {
        navController.navigate(actionId)
    }

    fun showBackButton(boolean: Boolean) {
        supportActionBar?.setDisplayHomeAsUpEnabled(boolean)
    }
}