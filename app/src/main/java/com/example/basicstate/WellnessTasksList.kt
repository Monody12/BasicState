package com.example.basicstate

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun WellnessTasksList(
    list:List<WellnessTask>,
    onCheckedTask:(WellnessTask, Boolean) -> Unit,
    onCloseTask:(WellnessTask) -> Unit,
    modifier: Modifier = Modifier
){
  LazyColumn(modifier = modifier){
      items (list) {task ->
          WellnessTaskItem(
              taskName = task.label,
              checked = task.checked.value,
              onCheckedChange = { onCheckedTask(task, it) },
              onClose = { onCloseTask(task) }
          )
      }
  }
}
