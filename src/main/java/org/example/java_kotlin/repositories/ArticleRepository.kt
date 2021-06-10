package org.example.java_kotlin.repositories

import org.example.java_kotlin.model.ArticleEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ArticleRepository: CrudRepository<ArticleEntity, Long> {
    fun findBySlug(slug: String): ArticleEntity?
    fun findAllByOrderByAddedAtDesc(): Iterable<ArticleEntity>
}