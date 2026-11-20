
package com.example.weekplanner.viewmodel

import androidx.lifecycle.ViewModel
import com.example.weekplanner.data.Task
import com.example.weekplanner.data.TaskRepository
import kotlinx.coroutines.flow.StateFlow

class TaskViewModel(
    private val repository: TaskRepository = TaskRepository()
) : ViewModel() {

    val tasks: StateFlow<List<Task>> = repository.tasks

    fun addTask(dayIndex: Int, name: String) {
        if (name.isNotBlank()) {
            repository.addTask(name.trim(), dayIndex)
        }
    }

    fun removeTask(task: Task) {
        repository.removeTask(task)
    }

    fun completedToggle(task: Task) {
        repository.completedToggle(task)
    }

}
