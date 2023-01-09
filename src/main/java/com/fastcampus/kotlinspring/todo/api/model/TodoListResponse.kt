package com.fastcampus.kotlinspring.todo.api.model

import com.fastcampus.kotlinspring.todo.domain.Todo
import com.fasterxml.jackson.annotation.JsonIgnore



data class TodoListResponse(
    val items: List<TodoResponse>,
) {
    val size: Int
        @JsonIgnore
        get() = items.size
    fun get(index: Int) = items[index]

    companion object {
        @JvmStatic
        fun of(todoList: List<Todo>): TodoListResponse =
            TodoListResponse(todoList.map(TodoResponse::of))
    }
}