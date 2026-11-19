package com.example.weekplanner.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.weekplanner.data.weekDays
import com.example.weekplanner.ui.components.DayItem

@Composable
fun DaysScreen(onDayClick: (Int) -> Unit) {
    Column(
        modifier = Modifier
            .statusBarsPadding()
            .padding(16.dp)
    ) {
        Text(
            text = "Week Planner",
            style = MaterialTheme.typography.headlineMedium
        )

        weekDays.forEachIndexed { index, day ->
            DayItem(
                dayName = day,
                onClick = { onDayClick(index) },
                modifier = Modifier.padding(top = 8.dp)
            )
        }
    }
}