package fr.tguillouet.data.http.jsonplaceholder

import fr.tguillouet.data.http.jsonplaceholder.models.User
import retrofit2.Response
import retrofit2.http.GET

interface JsonPlaceholderApi {
    @GET("users")
    suspend fun getUsers(): Response<List<User>>
}