package com.mgabbi.encryption.core.main.splash

import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.mgabbi.encryption.R
import com.mgabbi.encryption.SplashScreenBinding
import com.mgabbi.encryption.shared.base.BaseFragment
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

const val DELAY = 1500L

class SplashScreenFragment : BaseFragment<SplashScreenBinding, SplashScreenViewModel>(R.layout.fr_splash_screen) {
    override val viewModel by viewModel<SplashScreenViewModel>()

    override fun setupViews() {
        lifecycleScope.launch {
            delay(DELAY)
            findNavController().navigate(SplashScreenFragmentDirections.actionSplashScreenFragmentToListFragment())
        }
    }
}
