package com.example.basicstate

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

/**
 * 定义一个数据类
 * 对包含 ID 和标签的任务进行建模
 */
data class WellnessTask(
    val id:Int,
    val label: String,
    var checked: MutableState<Boolean> = mutableStateOf(false)
)