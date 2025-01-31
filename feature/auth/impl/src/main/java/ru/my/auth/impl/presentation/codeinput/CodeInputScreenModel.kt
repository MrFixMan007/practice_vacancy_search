package ru.my.auth.impl.presentation.codeinput

import androidx.core.text.isDigitsOnly
import ru.my.base.screenmodel.BaseScreenModel
import javax.inject.Inject

class CodeInputScreenModel @Inject constructor(

) : BaseScreenModel<CodeInputScreenState, Nothing>(CodeInputScreenState()) {

    internal fun setCodeSymbol(index: Int, newCodeSymbol: String) {
        val state = state.value

        if (newCodeSymbol.isEmpty()) {
            val newCode = state.code.dropLast(1)
            setState {
                state.copy(
                    code = newCode,
                    isContinueButtonEnabled = false,
                )
            }
            state.focusRequester[(newCode.length - 1).coerceAtLeast(0)].requestFocus()
        } else if (newCodeSymbol.isDigitsOnly()) {
            if (index <= state.pinLength - 1 && state.code.length < state.pinLength) {
                val newCode = state.code + newCodeSymbol
                setState {
                    state.copy(
                        code = newCode,
                        isContinueButtonEnabled = newCode.length == state.pinLength,
                    )
                }
                if (index < state.pinLength - 1) {
                    state.focusRequester[newCode.length].requestFocus()
                }
            }
        }
    }

}