package com.mgabbi.encryption.application

import com.mgabbi.encryption.core.main.MainActivityViewModel
import com.mgabbi.encryption.core.main.list.GetMockListUseCase
import com.mgabbi.encryption.core.main.list.ListViewModel
import com.mgabbi.encryption.core.main.splash.SplashScreenViewModel
import com.mgabbi.encryption.data.api.ApiProvider
import com.mgabbi.encryption.data.repo.MockRepo
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object AppModules {
    private val viewModels = module {
        viewModel { MainActivityViewModel() }
        viewModel { SplashScreenViewModel() }
        viewModel { ListViewModel(get()) }
    }

    private val apiModule = module {
        single { ApiProvider.provideMockAPI() }
    }

    private val repoModule = module {
        single { MockRepo() }
    }

    private val useCases = module {
        single { GetMockListUseCase(get()) }
    }

    val modules = listOf(viewModels, apiModule, repoModule, useCases)
}
