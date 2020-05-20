package com.mgabbi.encryption.application

import android.app.Application
import com.mgabbi.encryption.R
import com.mgabbi.encryption.lib.crypto.Encryption
import com.orhanobut.hawk.Hawk
import org.koin.core.context.startKoin

@Suppress("unused")
class ApplicationClass : Application() {
    override fun onCreate() {
        super.onCreate()
        Hawk.init(applicationContext).build()
        Encryption.init(getString(R.string.api_key))
        startKoin {
            modules(AppModules.modules)
        }
    }
}
