package com.example.unittest_sample

import android.app.Application
import com.example.unittest_sample.data.DataService
import com.example.unittest_sample.ui.main.MainViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import org.koin.dsl.module

class App: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@App)
            modules(listOf(viewModelModule,dataModule))
        }
    }


    private val viewModelModule = module {
        viewModel {
            MainViewModel(get())
        }
    }
    private val dataModule = module {
        single { DataService(get()) }
    }
}