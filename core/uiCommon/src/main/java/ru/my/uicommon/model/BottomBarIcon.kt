package ru.my.uicommon.model

import androidx.compose.foundation.layout.BoxScope
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import cafe.adriel.voyager.navigator.tab.Tab

@Immutable
data class BottomBarIcon(
    val tab: Tab,
    val additionalContent: @Composable ((BoxScope.() -> Unit))? = null
)