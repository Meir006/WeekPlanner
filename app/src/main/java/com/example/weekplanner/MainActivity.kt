package com.example.weekplanner

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.weekplanner.ui.screens.DaysScreen
import com.example.weekplanner.ui.screens.TasksScreen
import com.example.weekplanner.ui.theme.WeekPlannerTheme
import com.example.weekplanner.viewmodel.TaskViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WeekPlannerTheme {
                val navController = rememberNavController()
                val viewModel: TaskViewModel = viewModel()

                NavHost(navController = navController, startDestination = "days") {

                    composable("days") {
                        DaysScreen(
                            onDayClick = { index ->
                                navController.navigate("tasks/$index")
                            }
                        )
                    }

                    composable(
                        route = "tasks/{dayIndex}",
                        arguments = listOf(
                            navArgument("dayIndex") { type = NavType.IntType }
                        )
                    ) { taskElement ->
                        val dayIndex = taskElement.arguments?.getInt("dayIndex")?:0
                        TasksScreen(
                            dayIndex = dayIndex,
                            viewModel = viewModel,
                            onBack = { navController.popBackStack() }
                        )
                    }
                }
            }
        }
    }
}