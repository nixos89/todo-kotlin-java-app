package org.example.java_kotlin.service

import org.example.java_kotlin.model.ToDoEntity
import org.example.java_kotlin.repositories.TodoRepository
import org.springframework.stereotype.Service
import org.springframework.util.ObjectUtils
import java.util.*

@Service
class ToDoServiceImpl(private val todoRepository: TodoRepository) : ToDoService {

    override fun getTodoById(toDoId: Long): Optional<ToDoEntity> = todoRepository.findById(toDoId)

    override fun getAllTodos(): Iterable<ToDoEntity> = todoRepository.findAllByOrderByTodoId()

    override fun createTodo(toDoEntity: ToDoEntity): Boolean {
        val savedTodo = todoRepository.save(toDoEntity)
        if (ObjectUtils.isEmpty(savedTodo)) {
            return false
        }
        return true
    }

    override fun updateTodo(toDoEntity: ToDoEntity, todoId: Long): ToDoEntity? {
        return todoRepository.findById(todoId).map { todoDetails ->
            val updatedToDoEntity: ToDoEntity = todoDetails.copy(
                title = toDoEntity.title,
                description = toDoEntity.description
            )
            todoRepository.save(updatedToDoEntity)
        }.orElse(null)
    }

    override fun patchTodo(toDoEntity: ToDoEntity, todoId: Long): ToDoEntity? {
        return todoRepository.findById(todoId).map { todoDetails ->
            val patchedTodo = todoDetails.copy(
                title = toDoEntity.title ?: todoDetails.title,
                description = toDoEntity.description ?: todoDetails.description
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