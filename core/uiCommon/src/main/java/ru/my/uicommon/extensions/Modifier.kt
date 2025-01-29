package ru.my.uicommon.extensions

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import ru.my.theme.LocalColors

@Composable
fun Modifier.iconClickable(
    radius: Dp = 20.dp,
    onClick: () -> Unit,
) = this.clickable(
    onClick = onClick,
    indication = ripple(
        bounded = false,
        radius = radius,
        color = LocalColors.current.shadowColors.shadows,
    ),
    interactionSource = remember { MutableInteractionSource() },
)