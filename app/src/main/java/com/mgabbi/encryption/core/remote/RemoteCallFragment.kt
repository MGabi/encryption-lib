package com.mgabbi.encryption.core.remote

import com.mgabbi.encryption.R
import com.mgabbi.encryption.RemoteCallBinding
import com.mgabbi.encryption.shared.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class RemoteCallFragment : BaseFragment<RemoteCallBinding, RemoteCallViewModel>(R.layout.fr_remote_call) {

    // Properties

    override val viewModel by viewModel<RemoteCallViewModel>()

    // Lifecycle

    override fun setupViews() {
    }
}
