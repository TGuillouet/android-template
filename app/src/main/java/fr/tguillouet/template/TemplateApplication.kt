package fr.tguillouet.template

import android.app.Application
import fr.tguillouet.template.di.appModule
import fr.tguillouet.template.di.homePresentationModule
import org.koin.android.BuildConfig
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

val presentationModules = listOf(appModule, homePresentationModule)

class TemplateApplication: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            if (BuildConfig.DEBUG) androidLogger(Level.DEBUG)

            androidContext(this@TemplateApplication)
            modules(presentationModules)
        }
    }
}