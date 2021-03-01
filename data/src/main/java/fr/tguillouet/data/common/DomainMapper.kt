package fr.tguillouet.data.common

interface DomainMapper<T : Any> {
    fun mapToDomainModel(): T
}