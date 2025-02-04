package ru.my.auth.impl.presentation.codeinput

import androidx.compose.runtime.Immutable
import ru.my.base.api.screenmodel.model.UIEffect

@Immutable
sealed class CodeInputScreenSideEffect : UIEffect {

    data object Login : CodeInputScreenSideEffect()
}