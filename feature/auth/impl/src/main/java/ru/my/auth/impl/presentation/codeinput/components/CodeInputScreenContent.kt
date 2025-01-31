package ru.my.auth.impl.presentation.codeinput.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf
import ru.my.auth.impl.R
import ru.my.theme.LocalColors
import ru.my.theme.LocalTypography
import ru.my.theme.VacancySearchTheme
import ru.my.uicommon.components.BlueShadowButton

@Composable
fun CodeInputScreenContent(
    email: String,
    pinLength: Int,
    code: String,
    isContinueButtonEnabled: Boolean,
    onContinueClick: () -> Unit,
    onPinChange: (position: Int, newChar: String) -> Unit,
    focusRequester: ImmutableList<FocusRequester>,
) {
    LaunchedEffect(Unit) {
        focusRequester[0].requestFocus()
    }

    Column(
        Modifier
            .fillMaxWidth()
            .padding(top = 130.dp, start = 16.dp, end = 16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = stringResource(id = R.string.code_input_title, email),
            style = LocalTypography.current.title2,
            color = LocalColors.current.basicColors.white
        )
        Text(
            text = stringResource(id = R.string.code_input_text, email),
            style = LocalTypography.current.title3,
            color = LocalColors.current.basicColors.white
        )

        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            repeat(pinLength) { index ->
                Box(
                    modifier = Modifier
                        .size(48.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .background(LocalColors.current.basicColors.grey2)
                        .clickable { focusRequester[(code.length - 1).coerceAtLeast(0)].requestFocus() },
                    contentAlignment = Alignment.Center
                ) {
                    val value = code.getOrNull(index)?.toString() ?: ""
                    BasicTextField(
                        modifier = Modifier
                            .align(Alignment.Center)
                            .focusRequester(focusRequester[index])
                            .width(18.dp),
                        value = value,
                        onValueChange = { newValue ->
                            onPinChange(index, newValue)
                        },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                        maxLines = 1,
                        singleLine = true,
                        cursorBrush = SolidColor(Color.White),
                        textStyle = LocalTypography.current.title1.copy(color = LocalColors.current.basicColors.white),
                    ) {
                        if (value.isEmpty()) {
                            Text(
                                modifier = Modifier
                                    .wrapContentWidth()
                                    .height(16.dp),
                                text = "*",
                                style = LocalTypography.current.title1,
                                color = LocalColors.current.basicColors.white
                            )
                        } else {
                            it()
                        }
                    }
                }
            }
        }

        BlueShadowButton(
            modifier = Modifier.fillMaxWidth(),
            text = stringResource(R.string.continue_label),
            buttonHeight = 48.dp,
            isEnabled = isContinueButtonEnabled,
            onClick = onContinueClick,
        )
    }
}

@Composable
@Preview
private fun Preview() {
    VacancySearchTheme {
        CodeInputScreenContent(
            email = "fdskl",
            pinLength = 4,
            isContinueButtonEnabled = true,
            onContinueClick = {},
            onPinChange = { _, _ -> },
            code = "123",
            focusRequester = persistentListOf(*Array(4) { FocusRequester() })
        )
    }
}