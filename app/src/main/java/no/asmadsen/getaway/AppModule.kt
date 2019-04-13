package no.asmadsen.getaway

import no.asmadsen.getaway.repositories.AirportRepository
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single { MyDatabase.getDatabase(get()) }
    single { AirportRepository(get()) }

    viewModel { ApplicationViewModel(get(), get()) }

}