package com.mgabbi.encryption.application

import android.app.Application
import com.mgabbi.encryption.lib.Encryption
import com.orhanobut.hawk.Hawk
import org.koin.core.context.startKoin

@Suppress("unused")
class ApplicationClass : Application() {
    override fun onCreate() {
        super.onCreate()
        Hawk.init(applicationContext).build()
        Encryption.init("eyJ0eXBlIjoiQkxPV0ZJU0giLCJwa2V5IjoiNHZLVklJQnExOFh5R2pPcVd5OHhDaHZSeEFtSHBxcVFTY3UvaHZRYUhpUVx1MDAzZCJ9")
//        Base64.getEncoder()
        startKoin {
            modules(AppModules.modules)
        }
    }
}
