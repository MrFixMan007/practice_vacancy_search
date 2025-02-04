package ru.my.auth.impl.presentation.codeinput

import kotlinx.coroutines.runBlocking
import ru.my.base.api.domain.usecase.SetProfileEmailUseCase
import ru.my.base.api.screenmodel.BaseScreenModel
import javax.inject.Inject

class CodeInputScreenModel @Inject constructor(
    private val setProfileEmailUseCase: SetProfileEmailUseCase,
) : BaseScreenModel<CodeInputScreenState, CodeInputScreenSideEffect>(CodeInputScreenState()) {

    internal fun init(email: String) {
        setState {
            state.value.copy(
                email = email,
            )
        }
    }

    internal fun setCodeSymbol(newCodeSymbol: String) {
        val state = state.value
        val newCodeSymbolLast = newCodeSymbol.lastOrNull()

        if (newCodeSymbol.isEmpty()) { // если стираем
            val newCode = state.code.dropLast(1)
            setState {
                state.copy(
                    code = newCode,
                    isContinueButtonEnabled = false,
                )
            }
            state.focusRequester[(newCode.length - 1).coerceAtLeast(0)].requestFocus()
        } else {
            newCodeSymbolLast?.let {
                if (newCodeSymbolLast.isDigit()) {
                    if (state.code.length < state.pinLength) {
                        val newCode = state.code + newCodeSymbolLast
                        setState {
                            state.copy(
                                code = newCode,
                                isContinueButtonEnabled = newCode.length == state.pinLength,
                            )
                        }
                        state.focusRequester[newCode.length.coerceAtMost(state.pinLength - 1)].requestFocus()
                    }
                }
            }
        }
    }

    internal fun login() {
        setProfileEmailUseCase.execute(state.value.email)

        runBlocking {
            postSideEffect(CodeInputScreenSideEffect.Login)
        }
    }

}