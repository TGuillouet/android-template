package fr.tguillouet.domain.di

import fr.tguillouet.domain.interaction.jsonplaceholder.GetUsersUseCase
import fr.tguillouet.domain.interaction.jsonplaceholder.GetUsersUseCaseImpl
import org.koin.dsl.module

val jsonPlaceholderDomainModule = module {
    factory<GetUsersUseCase> { GetUsersUseCaseImpl(get()) }
}