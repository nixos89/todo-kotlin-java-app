package org.example.java_kotlin.controller

import org.example.java_kotlin.model.Todo
import org.example.java_kotlin.repositories.TodoRepository
import org.example.java_kotlin.service.TodoService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.util.ObjectUtils
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/todos")
class TodoController(private val todoRepository: TodoRepository, private val todoService: TodoService) {

    @GetMapping("/{todoId}")
    fun getTodo(@PathVariable todoId: Long): ResponseEntity<Todo> {
        val todo = todoService.getTodoById(todoId)
        if (todo.isPresent) return ResponseEntity(todo.get(), HttpStatus.OK)
        return ResponseEntity(HttpStatus.NOT_FOUND)
    }

    @GetMapping
    fun getAllTodos(): ResponseEntity<List<Todo>> {
        val todos = todoService.getAllTodos().toList()
        if (todos.isNotEmpty()) return ResponseEntity(todos, HttpStatus.OK)
        return ResponseEntity(HttpStatus.NOT_FOUND)
    }

    @PostMapping
    fun createTodo(@Validated @RequestBody todo: Todo): ResponseEntity<Void> {
        if (todoService.createTodo(todo)) {
            return ResponseEntity(HttpStatus.CREATED)
        }
        return ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
    }

    @PutMapping("/{todoId}")
    fun updateTodo(@Validated @RequestBody todo: Todo, @PathVariable("todoId") todoId: Long): ResponseEntity<Void> {
        val todoUpdated = todoService.updateTodo(todo, todoId)
        if (ObjectUtils.isEmpty(todoUpdated)) {
            return ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }
        return ResponseEntity(HttpStatus.NO_CONTENT)

    }

    @PatchMapping("/{todoId}")
    fun partialUpdateTodo(@RequestBody todo: Todo, @PathVariable todoId: Long): ResponseEntity<Void> {
        val patchedTodo = todoService.patchTodo(todo, todoId)
        if (ObjectUtils.isEmpty(patchedTodo)) {
            return ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }
        return ResponseEntity(HttpStatus.NO_CONTENT)
    }

    @DeleteMapping("/{todoId}")
    fun deleteTodo(@PathVariable todoId: Long): ResponseEntity<Void> {
        if (todoService.deleteTodo(todoId)) {
            return ResponseEntity(HttpStatus.NO_CONTENT)
        }
        return ResponseEntity(HttpStatus.NOT_FOUND)
    }

}