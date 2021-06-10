package org.example.java_kotlin.model

import org.example.java_kotlin.util.toSlug
import java.time.LocalDateTime
import javax.persistence.*

@Entity(name="article")
@Table(name="article")
class ArticleEntity(
    var title: String,
    var headline: String,
    var content: String,
    @ManyToOne var author: UserEntity,
    var slug: String = title.toSlug(),
    var addedAt: LocalDateTime = LocalDateTime.now(),
    @Id
    @SequenceGenerator(name="article_generator", sequenceName = "article_sequence", allocationSize = 1)
    @GeneratedValue(generator = "article_generator")
    var articleId: Long? = null)