package org.example.java_kotlin

import com.ninjasquad.springmockk.MockkBean
import io.mockk.every
import org.example.java_kotlin.model.ArticleEntity
import org.example.java_kotlin.model.UserEntity
import org.example.java_kotlin.repositories.ArticleRepository
import org.example.java_kotlin.repositories.TodoRepository
import org.example.java_kotlin.repositories.UserRepository
import org.example.java_kotlin.service.ToDoService
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*

//https://github.com/spring-guides/tut-spring-boot-kotlin/blob/main/src/test/kotlin/com/example/blog/HttpControllersTests.kt
@WebMvcTest
class HttpControllersTests(@Autowired val mockMvc: MockMvc) {

    @MockkBean
    private lateinit var userRepository: UserRepository

    @MockkBean
    private lateinit var articleRepository: ArticleRepository

    @MockkBean
    private lateinit var todoRepository: TodoRepository

    @MockkBean
    private lateinit var todoService: ToDoService

    @Test
    fun `List articles`() {
        val juergen = UserEntity("springjuergen", "Juergen", "Hoeller")
        val spring5Article = ArticleEntity(
            "Spring Framework 5.0 goes GA",
            "Dear Spring community ...", "Lorem ipsum", juergen
        )
        val spring43Article = ArticleEntity(
            "Spring Framework 4.3 goes GA",
            "Dear Spring community ...", "Lorem ipsum", juergen
        )

        every { articleRepository.findAllByOrderByAddedAtDesc() } returns listOf(spring5Article, spring43Article)

        mockMvc.perform(get("/api/article/").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk)
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("\$.[0].author.login").value(juergen.login))
                .andExpect(jsonPath("\$.[0].slug").value(spring5Article.slug))
                .andExpect(jsonPath("\$.[1].author.login").value(juergen.login))
                .andExpect(jsonPath("\$.[1].slug").value(spring43Article.slug))
    }

    @Test
    fun `List users`() {
        val juergen = UserEntity("springjuergen", "Juergen", "Hoeller")
        val smaldini = UserEntity("smaldini", "Stéphane", "Maldini")
        every {userRepository.findAll()} returns listOf(juergen, smaldini)
        mockMvc.perform(get("/api/user/").accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk)
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("\$.[0].login").value(juergen.login))
            .andExpect(jsonPath("\$.[1].login").value(smaldini.login))
    }

}