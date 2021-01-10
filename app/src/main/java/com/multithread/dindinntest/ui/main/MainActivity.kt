package com.multithread.dindinntest.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.multithread.dindinntest.databinding.ActivityMainBinding
import com.multithread.dindinntest.extension.makeFullScreen
import dagger.android.*
import javax.inject.Inject

class MainActivity : AppCompatActivity(), HasAndroidInjector {


    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>
    override fun androidInjector(): AndroidInjector<Any> = androidInjector

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        makeFullScreen()
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

}