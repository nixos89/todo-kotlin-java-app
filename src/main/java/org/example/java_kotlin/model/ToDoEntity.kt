package org.example.java_kotlin.model

import javax.persistence.*

@Entity
@Table(name="todo")
data class ToDoEntity(
    @Id
    @SequenceGenerator(name="todo_generator", sequenceName = "todo_sequence", allocationSize = 1)
    @GeneratedValue(generator = "todo_generator")
    var todoId: Long,
    var title: String?,
    var description: String?)