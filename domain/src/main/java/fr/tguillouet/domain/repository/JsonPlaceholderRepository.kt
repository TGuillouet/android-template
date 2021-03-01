package fr.tguillouet.domain.repository

import fr.tguillouet.domain.interaction.jsonplaceholder.models.UserModel
import fr.tguillouet.domain.models.Result

interface JsonPlaceholderRepository {
    suspend fun getUsers(): Result<List<UserModel>>
}