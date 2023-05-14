package com.timife.fixturesapp.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.timife.fixturesapp.presentation.competitions.ui.CompetitionScreen
import com.timife.fixturesapp.presentation.fixtures.ui.FixturesScreen
import com.timife.fixturesapp.ui.theme.FixturesAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FixturesAppTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = Screen.CompetitionsScreen.route
                ) {
                    composable(Screen.CompetitionsScreen.route) {
                        CompetitionScreen(navController = navController)
                    }
                    composable(Screen.FixturesScreen.route + "/{competition}/{competitionName}",
                        arguments = listOf(
                            navArgument(name = "competition") {
                                type = NavType.IntType
                            },
                            navArgument("competitionName") {
                                type = NavType.StringType
                            }
                        )) { backStackEntry ->
                        val competitionArgs = backStackEntry.arguments?.getString("competitionName")
                        FixturesScreen(header = competitionArgs ?: "", navController = navController)
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    FixturesAppTheme {
        Greeting("Android")
    }
}