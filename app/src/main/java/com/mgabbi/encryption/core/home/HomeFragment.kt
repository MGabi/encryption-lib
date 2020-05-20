package com.mgabbi.encryption.core.home

import androidx.lifecycle.observe
import com.mgabbi.encryption.HomeBinding
import com.mgabbi.encryption.R
import com.mgabbi.encryption.shared.base.BaseFragment
import com.mgabbi.encryption.shared.utils.extensions.navController
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : BaseFragment<HomeBinding, HomeViewModel>(R.layout.fr_home) {

    // Properties

    override val viewModel by viewModel<HomeViewModel>()

    // Lifecycle

    override fun setupViews() {
        setupObservers()
    }

    // Setup

    private fun setupObservers() {
        viewModel.cmd.observe(viewLifecycleOwner) {
            when (it) {
                is HomeViewModel.Command.Navigate -> navController?.navigate(it.direction)
            }
        }
    }
}
