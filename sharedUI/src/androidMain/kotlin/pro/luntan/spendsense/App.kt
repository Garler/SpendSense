package pro.luntan.spendsense

import android.app.Application
import android.content.Context
import org.koin.dsl.module
import pro.luntan.spendsense.di.initKoin

class App: Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin(appModule = module {
            single<Context> { this@App.applicationContext }
        })
        instance = this
    }

    companion object{
        lateinit var instance: App
    }
}