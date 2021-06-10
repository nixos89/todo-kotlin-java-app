package org.example.java_kotlin.service

import org.example.java_kotlin.model.ToDoEntity
import java.util.*

interface ToDoService {
    fun getTodoById(toDoId: Long): Optional<ToDoEntity>
    fun getAllTodos(): Iterable<ToDoEntity>
    fun createTodo(toDoEntity: ToDoEntity): Boolean
    fun updateTodo(toDoEntity: ToDoEntity, todoId: Long): ToDoEntity?
    fun patchTodo(toDoEntity: ToDoEntity, todoId: Long): ToDoEntity?
    fun deleteTodo(todoId: Long): Boolean
}