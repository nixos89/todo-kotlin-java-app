package org.example.java_kotlin.controller

import org.example.java_kotlin.model.Todo
import org.example.java_kotlin.repositories.TodoRepository
import org.example.java_kotlin.service.TodoService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/todos")
class TodoController(private val todoRepository: TodoRepository, private val todoService: TodoService) {

    @GetMapping("/{todoId}")
    fun getTodo(@PathVariable todoId: Long) = todoService.getTodoById(todoId)

    @GetMapping
    fun getAllTodos() = todoService.getAllTodos()

    @PostMapping
    fun saveTodo(@RequestBody todo: Todo) = todoService.saveTodo(todo)

    @PatchMapping
    fun patchTodo(@RequestBody todo: Todo) = todoRepository.save(todo)

}