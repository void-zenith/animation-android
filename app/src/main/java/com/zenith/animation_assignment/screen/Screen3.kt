package com.zenith.animation_assignment.screen

import android.annotation.SuppressLint
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.navigation.NavController
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
@SuppressLint("RememberReturnType")
@Composable
fun Screen3(navController: NavController) {
    var isExpanded by remember { mutableStateOf(false) }
    val targetValue = if (isExpanded) 200f else 0f
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick={navController.navigate("main")}){
            Text("Go Back")
        }
        Button(
            onClick = {
                isExpanded = !isExpanded
            },
            modifier = Modifier.padding(bottom = 16.dp)
        ) {
            if (isExpanded) {
                Text(text = "Collapse")
            } else {
                Text(text = "Expand")
            }
        }

        val animatedSize by animateFloatAsState(
            targetValue = targetValue,
            animationSpec = tween(durationMillis = 1000)
        )

        Box(
            modifier = Modifier
                .size(animatedSize.dp)
                .background(Color.Blue)
        )

        LaunchedEffect(isExpanded) {
            while (true) {
                delay(1000)
                isExpanded = !isExpanded
            }
        }
    }
}
