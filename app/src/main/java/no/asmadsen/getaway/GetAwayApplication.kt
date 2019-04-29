package no.asmadsen.getaway

import android.app.Application
import no.asmadsen.getaway.providers.flickr.flickrModule
import no.asmadsen.getaway.providers.sas.sasModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidFileProperties
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class GetAwayApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@GetAwayApplication)
            androidFileProperties()
            modules(
                appModule,
                flickrModule,
                sasModule
            )
            properties(mapOf(
                "api_key.flickr" to "a46d54fa82cfcc316de13fab2920af4e"
            ))
        }
    }
}