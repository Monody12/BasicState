package com.example.basicstate

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

//@Composable
//fun WaterCounter(modifier: Modifier = Modifier) {
//    Column(modifier = modifier.padding(16.dp)) {
//        // Changes to count are now tracked by Compose
//        val count : MutableState<Int> = rememberSaveable { mutableStateOf(0) }
//        Text(
//            text = "You drank ${count.value} glasses of water today",
//        )
//        if (count.value > 0){
//            var showTask by remember { mutableStateOf(true) }
//            if (showTask) {
//                WellnessTaskItem(
//                    taskName = "Have you taken your 15 minute walk today?",
//
//                )
//            }
//        }
//        Button(onClick = { count.value++ }, Modifier.padding(8.dp), enabled = count.value <= 10) {
//            Text(text = "I drank a glass of water")
//        }
//        Button(onClick = { count.value = 0 }, Modifier.padding(8.dp), enabled = count.value > 0) {
//            Text(text = "Clear water count")
//        }
//    }
//}

@Composable
fun StatelessCounter(count: Int,onIncrement:()->Unit,onClear:()->Unit,modifier:Modifier){
    Column(modifier = modifier.padding(16.dp)) {
        Text(
            text = "You drank $count glasses of water today",
        )
        Button(onClick = onIncrement, Modifier.padding(8.dp), enabled = count <= 10) {
            Text(text = "I drank a glass of water")
        }
        Button(onClick = onClear, Modifier.padding(8.dp), enabled = count > 0) {
            Text(text = "Clear water count")
        }
    }
}

@Composable
fun StatefulCounter(modifier: Modifier = Modifier) {
    var count by rememberSaveable { mutableStateOf(0) }
    StatelessCounter(count, { count++ }, { count = 0 },modifier)
}

@Composable
fun WellnessScreen(
    modifier: Modifier = Modifier,
    wellnessViewModel: WellnessViewModel = viewModel()
){
    Column (modifier = modifier) {
        StatefulCounter()
        WellnessTasksList(
            list = wellnessViewModel.tasks,
            onCheckedTask = { task, checked ->
                wellnessViewModel.changeTaskChecked(task, checked)
            },
            onCloseTask = { task ->
                wellnessViewModel.remove(task)
            }
        )
    }
}