package com.zenith.animation_assignment.screen

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.*
import androidx.compose.animation.*
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.with
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
@OptIn(ExperimentalMaterial3Api::class, ExperimentalAnimationApi::class)
@Composable
fun Screen1(navController: NavController) {
    var count by remember {
        mutableStateOf(0)
    }
    var oldCount by remember {
        mutableStateOf(count)
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SideEffect {
            oldCount = count
        }
        Row(modifier = Modifier) {
            val countString = count.toString()
            val oldCountString = oldCount.toString()
            for(i in countString.indices) {
                val oldChar = oldCountString.getOrNull(i)
                val newChar = countString[i]
                val char = if(oldChar == newChar) {
                    oldCountString[i]
                } else {
                    countString[i]
                }
                AnimatedContent(
                    targetState = char,
                    transitionSpec = {

                        if(oldCount < count){
                            slideInVertically { it } with slideOutVertically { -it }

                        }else {
                            slideInVertically { -it } with slideOutVertically { it }

                        }
                    }
                ) { char ->
                    Text(
                        text = char.toString(),
                        softWrap = false,
                        fontSize = 30.sp
                    )
                }
            }
        }

        Button(onClick = { count++ }) {
            Text(text = "Increment")
        }
        Button(onClick = {  count-- }) {
            Text(text = "Decrement")
        }
        Button(onClick = {navController.navigate("main")}) {
            Text(text = "Go Back")
        }
    }
}


@Composable
private fun Expanded() {
}

@Composable
private fun ContentIcon() {
}
