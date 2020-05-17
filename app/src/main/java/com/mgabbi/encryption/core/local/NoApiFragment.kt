package com.mgabbi.encryption.core.local

import androidx.lifecycle.observe
import com.mgabbi.encryption.NoApiBinding
import com.mgabbi.encryption.R
import com.mgabbi.encryption.shared.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class NoApiFragment : BaseFragment<NoApiBinding, NoApiViewModel>(R.layout.fr_no_api_fragment) {

    // Properties

    override val viewModel by viewModel<NoApiViewModel>()

    // Lifecycle

    override fun setupViews() {
        setupObservers()
    }

    // Setup

    private fun setupObservers() {
        viewModel.cmd.observe(viewLifecycleOwner) {
//            when (it) {
                // NoApiViewModel.Command.CommandWithoutData -> {}
                // is NoApiViewModel.Command.CommandWithData -> { it.data }
//            }
        }
    }
}
