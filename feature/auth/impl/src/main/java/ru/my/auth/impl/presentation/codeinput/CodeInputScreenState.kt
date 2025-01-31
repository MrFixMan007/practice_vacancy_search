package ru.my.auth.impl.presentation.codeinput

import androidx.compose.runtime.Immutable
import androidx.compose.ui.focus.FocusRequester
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf
import ru.my.base.screenmodel.model.UIState

@Immutable
data class CodeInputScreenState(
    val code: String = "",
    val pinLength: Int = 4,
    val isContinueButtonEnabled: Boolean = false,
    val focusRequester: ImmutableList<FocusRequester> = persistentListOf(*Array(pinLength) { FocusRequester() }),
) : UIState