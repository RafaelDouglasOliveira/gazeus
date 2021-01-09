package com.br.rafaeloliveira.gazeus.rest.github

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.br.rafaeloliveira.gazeus.rest.github.provider.CoreProvider
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.dsl.module

class MainActivity : AppCompatActivity() {


    private val coreProvider = CoreProvider()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startKoin {
            androidContext(applicationContext)
            modules(module {
                factory {  }
            })
        }



    }
}