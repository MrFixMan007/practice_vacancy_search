package ru.my.base.api.extensions

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

fun Job?.singleAction(delayMs: Long = 300, action: () -> Unit): Job {
    return if (this?.isActive != true) {
        CoroutineScope(Dispatchers.Main).launch {
            action()
            delay(delayMs)
        }.also { it.start() }
    } else {
        this
    }
}