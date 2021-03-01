package fr.tguillouet.domain.interaction.jsonplaceholder

import fr.tguillouet.domain.interaction.jsonplaceholder.models.UserModel
import fr.tguillouet.domain.models.Result
import fr.tguillouet.domain.repository.JsonPlaceholderRepository

class GetUsersUseCaseImpl(
    private val jsonPlaceholderRepository: JsonPlaceholderRepository
): GetUsersUseCase {
    override suspend fun invoke(): Result<List<UserModel>> {
        return jsonPlaceholderRepository.getUsers()
    }
}