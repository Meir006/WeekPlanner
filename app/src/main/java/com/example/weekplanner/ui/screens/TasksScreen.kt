package com.example.weekplanner.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.weekplanner.data.weekDays
import com.example.weekplanner.ui.components.TaskItem
import com.example.weekplanner.viewmodel.TaskViewModel

@Composable
fun TasksScreen(
    dayIndex: Int,
    viewModel: TaskViewModel,
    onBack: () -> Unit
) {
    val allTasks by viewModel.tasks.collectAsState()
    var text by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .padding(16.dp)
    ) {
        TextButton(onClick = onBack) {
            Text("Back")
        }

        Text(weekDays[dayIndex])

        TextField(
            value = text,
            onValueChange = { text = it }
        )

        Button(onClick = {
            viewModel.addTask(dayIndex, text)
            text = ""
        }) {
            Text("Add")
        }

        LazyColumn {
            items(allTasks.filter { it.dayIndex == dayIndex }) { task ->
                TaskItem(
                    task = task,
                    onDelete = { viewModel.removeTask(task) },
                    onToggle = { viewModel.completedToggle(task) },
                )
            }
        }
    }
}