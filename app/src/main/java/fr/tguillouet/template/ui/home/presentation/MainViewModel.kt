package fr.tguillouet.template.ui.home.presentation

import fr.tguillouet.domain.interaction.jsonplaceholder.GetUsersUseCase
import fr.tguillouet.domain.interaction.jsonplaceholder.models.UserModel
import fr.tguillouet.domain.models.onFailure
import fr.tguillouet.domain.models.onSuccess
import fr.tguillouet.template.ui.common.BaseViewModel
import fr.tguillouet.template.ui.common.ViewState

class MainViewModel(
    private val getUsersUseCase: GetUsersUseCase
): BaseViewModel<List<UserModel>>() {
    fun loadUsers() = executeUseCase {
        getUsersUseCase()
            .onSuccess { _viewState.value = ViewState.Success(it) }
            .onFailure { _viewState.value = ViewState.Error(it.throwable) }
    }
}