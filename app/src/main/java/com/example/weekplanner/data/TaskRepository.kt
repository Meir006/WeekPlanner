package com.example.weekplanner.data

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class TaskRepository {
    private val _tasks = MutableStateFlow(emptyList<Task>());
    val tasks: StateFlow<List<Task>> = _tasks.asStateFlow()
}




