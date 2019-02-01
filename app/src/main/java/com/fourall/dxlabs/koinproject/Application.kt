package com.fourall.dxlabs.koinproject

import android.app.Application
import com.fourall.dxlabs.koinproject.modules.appModules
import org.koin.android.ext.android.startKoin

class Application : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin(this, listOf(appModules))
    }
}