package com.mgabbi.encryption.core.main

import com.mgabbi.encryption.ActMainBinding
import com.mgabbi.encryption.R
import com.mgabbi.encryption.shared.base.BaseActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity<ActMainBinding, MainActivityViewModel>(R.layout.activity_main) {
    override val viewModel by viewModel<MainActivityViewModel>()

    override fun setupViews() {
    }
}
