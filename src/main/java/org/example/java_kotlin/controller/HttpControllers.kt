package org.example.java_kotlin.controller

import org.example.java_kotlin.repositories.ArticleRepository
import org.example.java_kotlin.repositories.UserRepository
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.server.ResponseStatusException

/* These classes are just part of SpringBoot Kotlin tutorial */
@RestController
@RequestMapping("/api/article")
class ArticleController(private val articleRepository: ArticleRepository) {

    @GetMapping("/")
    fun findAll() = articleRepository.findAllByOrderByAddedAtDesc()

    @GetMapping("/{slug}")
    fun findOne(@PathVariable slug: String) = articleRepository
        .findBySlug(slug) ?: throw ResponseStatusException(HttpStatus.NOT_FOUND, "This article does not exist!")

}

@RestController
@RequestMapping("/api/user")
class UserController(private val userRepository: UserRepository) {

    @GetMapping("/")
    fun findAll() = userRepository.findAll()

    @GetMapping("/{login}")
    fun findOne(@PathVariable login: String) = userRepository
        .findByLogin(login) ?: throw ResponseStatusException(HttpStatus.NOT_FOUND, "This user does not exist!")

}