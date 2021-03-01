package fr.tguillouet.data.di

import fr.tguillouet.data.repository.JsonPlaceholderRepositoryImpl
import fr.tguillouet.domain.repository.JsonPlaceholderRepository
import org.koin.dsl.module

val repositoriesModule = module {
    factory<JsonPlaceholderRepository> { JsonPlaceholderRepositoryImpl(get()) }
}