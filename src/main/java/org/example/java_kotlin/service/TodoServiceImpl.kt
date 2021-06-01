package org.example.java_kotlin.service

import org.example.java_kotlin.model.Todo
import org.example.java_kotlin.repositories.TodoRepository
import org.springframework.stereotype.Service

@Service
class TodoServiceImpl(private val todoRepository: TodoRepository) : TodoService {

    // TODO: implement methods in `TodoServiceImpl` written in Kotlin-adequate way
    override fun getTodoById(todoId: Long): Todo {
        return todoRepository.getTodoByTodoId(todoId)
    }

    override fun getAllTodos(): Iterable<Todo> {
        return todoRepository.findAllByOrderByTitleAsc()
    }

    override fun saveTodo(todo: Todo): Boolean {
        var savedTodo: Todo
        savedTodo = todoRepository.save(todo)
//        return savedTodo === null ?: false
        return false
    }

    override fun patchTodo(todo: Todo): Boolean {
        var patchedTodo: Todo
        patchedTodo = todoRepository.save(todo)
//        if(patche)
        return false
    }


}