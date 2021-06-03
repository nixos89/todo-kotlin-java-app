package org.example.java_kotlin.model

import org.example.java_kotlin.util.toSlug
import java.time.LocalDateTime
import javax.persistence.*

@Entity(name="users")
class User(
    var login: String,
    var firstName: String,
    var lastName: String,
    var description: String? = null,
    @Id
    @SequenceGenerator(name="user_generator", sequenceName = "user_sequence", allocationSize = 1)
    @GeneratedValue(generator = "user_generator")
    var userId: Long? = null)

@Entity(name="article")
class Article(
    var title: String,
    var headline: String,
    var content: String,
    @ManyToOne var author: User,
    var slug: String = title.toSlug(),
    var addedAt: LocalDateTime = LocalDateTime.now(),
    @Id
    @SequenceGenerator(name="article_generator", sequenceName = "article_sequence", allocationSize = 1)
    @GeneratedValue(generator = "article_generator")
    var articleId: Long? = null)

