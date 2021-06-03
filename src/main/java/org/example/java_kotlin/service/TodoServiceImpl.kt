package org.example.java_kotlin.service

import org.example.java_kotlin.model.Todo
import org.example.java_kotlin.repositories.TodoRepository
import org.springframework.stereotype.Service
import org.springframework.util.ObjectUtils
import java.util.*

@Service
class TodoServiceImpl(private val todoRepository: TodoRepository) : TodoService {

    override fun getTodoById(todoId: Long): Optional<Todo> = todoRepository.findById(todoId)

    override fun getAllTodos(): Iterable<Todo> = todoRepository.findAllByOrderByTodoId()

    override fun createTodo(todo: Todo): Boolean {
        val savedTodo = todoRepository.save(todo)
        if (ObjectUtils.isEmpty(savedTodo)) {
            return false
        }
        return true
    }

    override fun updateTodo(todo: Todo, todoId: Long): Todo? {
        return todoRepository.findById(todoId).map { todoDetails ->
            val updatedTodo: Todo = todoDetails.copy(
                title = todo.title,
                description = todo.description
            )
            todoRepository.save(updatedTodo)
        }.orElse(null)
    }

    override fun patchTodo(todo: Todo, todoId: Long): Todo? {
        return todoRepository.findById(todoId).map { todoDetails ->
            val patchedTodo = todoDetails.copy(
                title = todo.title ?: todoDetails.title,
                description = todo.description ?: todoDetails.description
            )
            todoRepository.save(patchedTodo)
        }.orElse(null)
    }

    override fun deleteTodo(todoId: Long): Boolean {
        val todo = getTodoById(todoId)
        if (todo.isPresent) {
            todoRepository.deleteById(todoId)
            return true
        }
        return false
    }

}