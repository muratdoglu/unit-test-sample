package com.example.unittest_sample.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.unittest_sample.R
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.dsl.module

class MainActivity : AppCompatActivity() {
    private val mainViewModel by viewModel<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

}