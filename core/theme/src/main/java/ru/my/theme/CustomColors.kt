package ru.my.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color

@Immutable
class CustomColors(
    val basicColors: BasicColors,
    val specialColors: SpecialColors,
    val shadowColors: ShadowColors,
)

@Immutable
class BasicColors(
    black: Color,
    grey1: Color,
    grey2: Color,
    grey3: Color,
    grey4: Color,
    grey5: Color,
    white: Color,
) {
    var black by mutableStateOf(black)
        private set

    var grey1 by mutableStateOf(grey1)
        private set

    var grey2 by mutableStateOf(grey2)
        private set

    var grey3 by mutableStateOf(grey3)
        private set

    var grey4 by mutableStateOf(grey4)
        private set

    var grey5 by mutableStateOf(grey5)
        private set

    var white by mutableStateOf(white)
        private set
}

@Immutable
class SpecialColors(
    blue: Color,
    darkBlue: Color,
    green: Color,
    darkGreen: Color,
    red: Color,
) {
    var blue by mutableStateOf(blue)
        private set

    var darkBlue by mutableStateOf(darkBlue)
        private set

    var green by mutableStateOf(green)
        private set

    var darkGreen by mutableStateOf(darkGreen)
        private set

    var red by mutableStateOf(red)
        private set
}

@Immutable
class ShadowColors(
    shadows: Color,
) {
    var shadows by mutableStateOf(shadows)
        private set
}