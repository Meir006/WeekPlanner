package com.example.weekplanner.data

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class TaskRepository {
    private val _tasks = MutableStateFlow(emptyList<Task>());
    val tasks: StateFlow<List<Task>> = _tasks.asStateFlow()

    private var nextId = 0;

    fun addTask(name: String, dayIndex: Int) {
        val task = Task(nextId, name, false, dayIndex)
        nextId++
        _tasks.value = _tasks.value + task
    }

    fun removeTask(task: Task) {
        _tasks.value = _tasks.value - task;
    }

    fun completedToggle(task: Task) {
        _tasks.value = _tasks.value.map {
            if (it.id == task.id) {
                it.copy(isCompleted = !it.isCompleted)
            } else {
                it
            }
        }
    }
}




