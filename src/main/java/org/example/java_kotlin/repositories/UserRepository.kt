package org.example.java_kotlin.repositories

import org.example.java_kotlin.model.UserEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository: CrudRepository<UserEntity, Long> {
    fun findByLogin(login: String): UserEntity?
}