package fr.tguillouet.template.di

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentActivity
import fr.tguillouet.data.common.coroutine.CoroutineContextProvider
import fr.tguillouet.template.routing.AppFragmentNavigator
import fr.tguillouet.template.routing.AppNavigator
import org.koin.dsl.module

val appModule = module {
    single { CoroutineContextProvider() }

    single { (activity: AppCompatActivity) -> AppNavigator(activity) }
    factory { (activity: FragmentActivity) -> AppFragmentNavigator(activity) }
}