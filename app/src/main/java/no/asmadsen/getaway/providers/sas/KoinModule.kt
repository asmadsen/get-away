package no.asmadsen.getaway.providers.sas

import no.asmadsen.getaway.repositories.SasRepository
import okhttp3.Callback
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

val sasModule = module {
    single {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.flysas.com/")
            .addConverterFactory(GsonConverterFactory.create(get()))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(OkHttpClient().newBuilder().apply {
                addInterceptor(HttpLoggingInterceptor().apply {
                    this.level = HttpLoggingInterceptor.Level.BODY
                })
            }.build())
            .build()
        retrofit.create(SasApi::class.java)
    }
}