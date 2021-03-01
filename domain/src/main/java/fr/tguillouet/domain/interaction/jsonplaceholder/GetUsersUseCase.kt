package fr.tguillouet.domain.interaction.jsonplaceholder

import fr.tguillouet.domain.base.UseCase
import fr.tguillouet.domain.interaction.jsonplaceholder.models.UserModel
import fr.tguillouet.domain.models.Result

interface GetUsersUseCase: UseCase {
    suspend operator fun invoke(): Result<List<UserModel>>
}