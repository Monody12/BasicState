package com.example.basicstate

import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel

private fun getWellnessTasks() = List(30) { i -> WellnessTask(i, "Task # $i") }

class WellnessViewModel : ViewModel() {
    private val _tasks = getWellnessTasks().toMutableStateList()
    val tasks: List<WellnessTask>
        get() = _tasks

    fun remove(item: WellnessTask) {
        _tasks.remove(item)
    }

    // 该方法将接收使用选中状态的新值进行修改的任务。
    fun changeTaskChecked(item:WellnessTask,checked:Boolean)=
        tasks.find { it.id == item.id }?.let {
            it.checked.value = checked
        }
}