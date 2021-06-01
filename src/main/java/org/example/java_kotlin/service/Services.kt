package org.example.java_kotlin.service

import org.example.java_kotlin.model.Todo

interface TodoService {
    fun getTodoById(todoId: Long): Todo

    fun getAllTodos(): Iterable<Todo>

    fun saveTodo(todo: Todo): Boolean

    fun patchTodo(todo: Todo): Boolean
}