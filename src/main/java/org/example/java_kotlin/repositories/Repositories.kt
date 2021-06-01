package org.example.java_kotlin.repositories

import org.example.java_kotlin.model.Article
import org.example.java_kotlin.model.Todo
import org.example.java_kotlin.model.User
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ArticleRepository: CrudRepository<Article, Long> {
    fun findBySlug(slug: String): Article?
    fun findAllByOrderByAddedAtDesc(): Iterable<Article>
}

@Repository
interface UserRepository: CrudRepository<User, Long> {
    fun findByLogin(login: String): User?
}

@Repository
interface TodoRepository: CrudRepository<Todo, Long> {
    fun getTodoByTodoId(todoId: Long): Todo
    fun findAllByOrderByTitleAsc(): Iterable<Todo>
    fun findTodoByDescriptionContains(text: String): Iterable<Todo>
}
