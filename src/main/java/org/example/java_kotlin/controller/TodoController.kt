package org.example.java_kotlin.controller

import org.example.java_kotlin.model.Todo
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/todos")
class TodoController {

    @GetMapping("/{todoId}")
    fun getTodo(@PathVariable todoId: Long) {
        // TODO: implement `getTodo`
    }

    @GetMapping
    fun getAllTodos() {
        // TODO: implement `getAllTodos`
    }

    @PostMapping
    fun saveTodo(@RequestBody todo: Todo) {
        // TODO: implement `saveTodo`
    }

}