package fr.tguillouet.template.di

import fr.tguillouet.template.ui.home.presentation.MainViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val homePresentationModule = module {
    viewModel { MainViewModel() }
}