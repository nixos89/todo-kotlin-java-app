package org.example.java_kotlin.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

/* TODO: Try LATER to place `data` modifier before `class`
    keyword to check behaviour when using it with Hibernate */
@Entity
class Todo(
    @Id @GeneratedValue var todoId: Long,
    var title: String,
    var description: String)