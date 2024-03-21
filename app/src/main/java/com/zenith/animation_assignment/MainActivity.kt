package com.zenith.animation_assignment
import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.BlendMode.Companion.Screen
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.zenith.animation_assignment.screen.MainScreen
import com.zenith.animation_assignment.screen.Screen1

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            AnimationApp(navController)
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AnimationApp(navController: NavHostController) {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Animation App") })
        },
        content = {
            NavHost(navController, startDestination = Screens.MainScreen.route) {
                composable(Screens.MainScreen.route) { MainScreen(navController) }
                composable(Screens.Screen1.route) { Screen1(navController) }
                // Add composable functions for other screens
            }
        }
    )
}
