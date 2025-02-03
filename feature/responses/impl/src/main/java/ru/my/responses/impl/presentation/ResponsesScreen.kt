package ru.my.responses.impl.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import cafe.adriel.voyager.core.screen.Screen
import ru.my.theme.LocalColors
import ru.my.theme.LocalTypography
import ru.my.uicommon.R

class ResponsesScreen : Screen {

    @Composable
    override fun Content() {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            Text(
                modifier = Modifier.align(Alignment.Center),
                text = stringResource(R.string.responses),
                style = LocalTypography.current.title1,
                color = LocalColors.current.basicColors.white,
            )
        }
    }
}