package ru.my.uicommon.extensions

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.res.stringResource
import ru.my.uicommon.R

@Composable
@ReadOnlyComposable
fun Int.humanPluralString(): String {
    if (this % 10 in 2..4 && (this % 100) / 10 != 1) return stringResource(id = R.string.mans1)
    return stringResource(id = R.string.mans2)
}

@Composable
@ReadOnlyComposable
fun Int.vacancyPluralString(): String {
    return when {
        this % 100 in 11..19 -> stringResource(R.string.vacancies5)
        this % 10 == 1 -> stringResource(R.string.vacancies1)
        this % 10 in 2..4 -> stringResource(R.string.vacancies2)
        else -> stringResource(R.string.vacancies5)
    }
}

@Composable
fun Int.monthNameString(): String {
    return when (this) {
        1 -> stringResource(R.string.january)
        2 -> stringResource(R.string.february)
        3 -> stringResource(R.string.march)
        4 -> stringResource(R.string.april)
        5 -> stringResource(R.string.may)
        6 -> stringResource(R.string.june)
        7 -> stringResource(R.string.july)
        8 -> stringResource(R.string.august)
        9 -> stringResource(R.string.september)
        10 -> stringResource(R.string.october)
        11 -> stringResource(R.string.november)
        12 -> stringResource(R.string.december)
        else -> ""
    }
}