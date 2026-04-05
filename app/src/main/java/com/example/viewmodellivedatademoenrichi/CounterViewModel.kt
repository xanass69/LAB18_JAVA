package com.example.viewmodellivedatademoenrichi

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class CounterViewModel : ViewModel() {

    // MutableStateFlow = variable modifiable
    private val _count = MutableStateFlow(0)

    // StateFlow = variable exposée (lecture seule pour l'Activity)
    val count: StateFlow<Int> = _count.asStateFlow()

    fun increment() {
        _count.value = _count.value + 1
        println("ViewModel increment: ${_count.value}")
    }

    fun decrement() {
        _count.value = _count.value - 1
        println("ViewModel decrement: ${_count.value}")
    }

    fun reset() {
        _count.value = 0
        println("ViewModel reset: ${_count.value}")
    }

    override fun onCleared() {
        super.onCleared()
        println("ViewModel détruit (seulement quand l'app se ferme vraiment)")
    }
}