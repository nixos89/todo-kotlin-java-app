package org.example.controller

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/todos")
class TodoController {

    @GetMapping("/{todoId}")
    fun getTodo(@PathVariable("todoId") todoId: Long) {
        // TODO: implement `getTodo`
    }

    @GetMapping
    fun getAllTodos() {
        // TODO: implement `getAllTodos`
    }

    // TODO: Research how to implement Model class in Kotlin!
//    @PostMapping
//    fun saveTodo(TodoClass) {
//
//    }

}