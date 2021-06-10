package org.example.java_kotlin.repositories

import org.example.java_kotlin.model.ToDoEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository


@Repository
interface TodoRepository: CrudRepository<ToDoEntity, Long> {
    fun findAllByOrderByTodoId(): Iterable<ToDoEntity>
}
