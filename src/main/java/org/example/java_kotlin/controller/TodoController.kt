package org.example.java_kotlin.controller

import org.example.java_kotlin.model.ToDoEntity
import org.example.java_kotlin.repositories.TodoRepository
import org.example.java_kotlin.service.ToDoService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.util.ObjectUtils
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/todos")
class TodoController(private val todoRepository: TodoRepository, private val toDoService: ToDoService) {

    @GetMapping("/{todoId}")
    fun getTodo(@PathVariable todoId: Long): ResponseEntity<ToDoEntity> {
        val todo = toDoService.getTodoById(todoId)
        if (todo.isPresent) return ResponseEntity(todo.get(), HttpStatus.OK)
        return ResponseEntity(HttpStatus.NOT_FOUND)
    }

    @GetMapping
    fun getAllTodos(): ResponseEntity<List<ToDoEntity>> {
        val todos = toDoService.getAllTodos().toList()
        if (todos.isNotEmpty()) return ResponseEntity(todos, HttpStatus.OK)
        return ResponseEntity(HttpStatus.NOT_FOUND)
    }

    @PostMapping
    fun createTodo(@Validated @RequestBody toDoEntity: ToDoEntity): ResponseEntity<Void> {
        if (toDoService.createTodo(toDoEntity)) {
            return ResponseEntity(HttpStatus.CREATED)
        }
        return ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
    }

    @PutMapping("/{todoId}")
    fun updateTodo(@Validated @RequestBody toDoEntity: ToDoEntity, @PathVariable("todoId") todoId: Long): ResponseEntity<Void> {
        val todoUpdated = toDoService.updateTodo(toDoEntity, todoId)
        if (ObjectUtils.isEmpty(todoUpdated)) {
            return ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }
        return ResponseEntity(HttpStatus.NO_CONTENT)

    }

    @PatchMapping("/{todoId}")
    fun partialUpdateTodo(@RequestBody toDoEntity: ToDoEntity, @PathVariable todoId: Long): ResponseEntity<Void> {
        val patchedTodo = toDoService.patchTodo(toDoEntity, todoId)
        if (ObjectUtils.isEmpty(patchedTodo)) {
            return ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }
        return ResponseEntity(HttpStatus.NO_CONTENT)
    }

    @DeleteMapping("/{todoId}")
    fun deleteTodo(@PathVariable todoId: Long): ResponseEntity<Void> {
        if (toDoService.deleteTodo(todoId)) {
            return ResponseEntity(HttpStatus.NO_CONTENT)
        }
        return ResponseEntity(HttpStatus.NOT_FOUND)
    }

}