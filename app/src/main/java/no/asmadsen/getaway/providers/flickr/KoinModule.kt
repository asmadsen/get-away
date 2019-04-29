package no.asmadsen.getaway.providers.flickr

import no.asmadsen.getaway.repositories.FlickrRepository
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory

val flickrModule = module {
    single {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.flickr.com/")
            .addConverterFactory(GsonConverterFactory.create(get()))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(OkHttpClient().newBuilder().apply {
                addInterceptor(HttpLoggingInterceptor().apply {
                    this.level = HttpLoggingInterceptor.Level.BODY
                })
            }.build())
            .build()
        retrofit.create(FlickrApi::class.java)
    }

    single { FlickrRepository(get(), getProperty("api_key.flickr")) }
}