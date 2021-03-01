package fr.tguillouet.data.repository

import fr.tguillouet.data.http.getListData
import fr.tguillouet.data.http.jsonplaceholder.JsonPlaceholderApi
import fr.tguillouet.data.repository.base.BaseRepository
import fr.tguillouet.domain.interaction.jsonplaceholder.models.UserModel
import fr.tguillouet.domain.models.Result
import fr.tguillouet.domain.repository.JsonPlaceholderRepository

class JsonPlaceholderRepositoryImpl(
    private val jsonPlaceholderApi: JsonPlaceholderApi
): BaseRepository(), JsonPlaceholderRepository {
    override suspend fun getUsers(): Result<List<UserModel>> {
        return fetchData {
            jsonPlaceholderApi.getUsers().getListData()
        }
    }
}