package fr.tguillouet.data.di

import fr.tguillouet.data.common.utils.Connectivity
import fr.tguillouet.data.common.utils.ConnectivityImpl
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val appDataModule = module {
    factory<Connectivity> { ConnectivityImpl(androidContext()) }
}