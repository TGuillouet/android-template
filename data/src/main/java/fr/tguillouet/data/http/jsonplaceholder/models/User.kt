package fr.tguillouet.data.http.jsonplaceholder.models

import fr.tguillouet.data.common.DomainMapper
import fr.tguillouet.domain.interaction.jsonplaceholder.models.UserModel

data class User(
    val id: Int,
    val name: String,
    val email: String
): DomainMapper<UserModel> {
    override fun mapToDomainModel() = UserModel(
        id,
        name,
        email
    )
}
