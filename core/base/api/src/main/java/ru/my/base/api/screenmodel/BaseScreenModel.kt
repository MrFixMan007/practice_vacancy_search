package ru.my.base.api.screenmodel

import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.screenModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import ru.my.base.api.screenmodel.model.UIEffect
import ru.my.base.api.screenmodel.model.UIState

abstract class BaseScreenModel<State : UIState, Effect : UIEffect>(
    initialState: State,
) : ScreenModel {

    private val _state: MutableStateFlow<State> = MutableStateFlow(initialState)
    val state = _state.asStateFlow()

    private val _effect: Channel<Effect> = Channel()
    val effect = _effect.receiveAsFlow()

    protected fun setState(transform: (State) -> State) {
        _state.update(transform)
    }

    protected fun postSideEffect(builder: () -> Effect) {
        screenModelScope.launch(Dispatchers.IO) {
            _effect.send(builder())
        }
    }

    protected suspend fun postSideEffect(effect: Effect) {
        _effect.send(effect)
    }

}