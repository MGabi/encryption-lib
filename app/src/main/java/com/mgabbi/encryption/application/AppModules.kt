package com.mgabbi.encryption.application

import com.mgabbi.encryption.core.MainActivityViewModel
import com.mgabbi.encryption.core.home.HomeViewModel
import com.mgabbi.encryption.core.local.NoApiViewModel
import com.mgabbi.encryption.core.remote.RemoteCallViewModel
import com.mgabbi.encryption.data.api.ApiProvider
import com.mgabbi.encryption.data.repo.EncryptedRepo
import com.mgabbi.encryption.data.repo.SimpleRepo
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object AppModules {
    private val viewModels = module {
        viewModel { MainActivityViewModel() }
        viewModel { NoApiViewModel() }
        viewModel { RemoteCallViewModel() }
        viewModel { HomeViewModel() }
    }

    private val apiModule = module {
        single { ApiProvider.provideEncryptedAPI() }
        single { ApiProvider.provideSimpleAPI() }
    }

    private val repoModule = module {
        single { EncryptedRepo() }
        single { SimpleRepo() }
    }

    private val useCases = module {
    }

    val modules = listOf(viewModels, apiModule, repoModule, useCases)
}
