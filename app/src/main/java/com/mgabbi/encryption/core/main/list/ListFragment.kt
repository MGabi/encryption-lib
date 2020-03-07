package com.mgabbi.encryption.core.main.list

import androidx.lifecycle.observe
import com.mgabbi.encryption.ListBinding
import com.mgabbi.encryption.R
import com.mgabbi.encryption.shared.base.BaseFragment
import com.mgabbi.encryption.shared.base.BaseViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class ListFragment : BaseFragment<ListBinding, BaseViewModel>(R.layout.fr_list) {

    override val viewModel by viewModel<ListViewModel>()

    private val adapter by lazy {
        MockListAdapter()
    }

    override fun setupViews() {
        binding?.rvMock?.adapter = adapter
        setupObservers()
    }

    private fun setupObservers() {
        viewModel.mockList.observe(this, adapter::submitList)
    }
}
