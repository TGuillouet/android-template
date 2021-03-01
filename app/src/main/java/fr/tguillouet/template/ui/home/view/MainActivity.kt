package fr.tguillouet.template.ui.home.view

import android.os.Bundle
import android.util.Log
import fr.tguillouet.domain.interaction.jsonplaceholder.models.UserModel
import fr.tguillouet.template.common.extensions.subscribe
import fr.tguillouet.template.ui.common.BaseActivity
import fr.tguillouet.template.databinding.ActivityMainBinding
import fr.tguillouet.template.ui.common.ViewState
import fr.tguillouet.template.ui.home.presentation.MainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity<ActivityMainBinding>() {

    private val viewModel: MainViewModel by viewModel()

    override fun getViewBindings(): ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        subscribeToData()

        viewModel.loadUsers()
    }

    private fun subscribeToData() {
        viewModel.viewState.subscribe(this, ::handleData)
    }

    private fun handleData(state: ViewState<List<UserModel>>) {
        when(state) {
            is ViewState.Success -> handleSuccess(state.data)
            is ViewState.Error -> handleError(state.error)
            is ViewState.NoInternetState -> {}
        }
    }

    private fun handleSuccess(data: List<UserModel>) {
        Log.d("Data", data.toString())
    }

    private fun handleError(error: Throwable) {}
}