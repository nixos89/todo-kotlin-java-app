package org.example.java_kotlin.service

import org.example.java_kotlin.model.Todo
import java.util.*

interface TodoService {
    fun getTodoById(todoId: Long): Optional<Todo>
    fun getAllTodos(): Iterable<Todo>
    fun createTodo(todo: Todo): Boolean
    fun updateTodo(todo: Todo, todoId: Long): Todo?
    fun patchTodo(todo: Todo, todoId: Long): Todo?
    fun deleteTodo(todoId: Long): Boolean
}