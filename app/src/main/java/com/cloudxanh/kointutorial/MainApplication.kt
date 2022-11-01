package com.cloudxanh.kointutorial

import android.app.Application
import com.cloudxanh.kointutorial.di.allAlbumModule
import com.cloudxanh.kointutorial.di.featureModule1
import com.cloudxanh.kointutorial.di.featureModule2
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin


/**
 * @Created by Sonpxp on 11/1/2022.
 * @Website: Cloudxanh.com
 * @Email: sonpxp@gmail.com
 */
class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            // Log Koin into Android logger
            androidLogger()
            // Reference Android context
            androidContext(this@MainApplication)
            // Load modules
            // modules(myAppModules)

            // Load modules
            // modules(featureModule1, featureModule2)
            modules(allAlbumModule)
        }

    }
}