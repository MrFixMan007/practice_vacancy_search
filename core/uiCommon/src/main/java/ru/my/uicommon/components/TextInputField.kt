package ru.my.uicommon.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.my.theme.LocalColors
import ru.my.theme.LocalTypography
import ru.my.theme.VacancySearchTheme

@Composable
fun TextInputField(
    text: String,
    onTextChanged: (String) -> Unit,
    modifier: Modifier = Modifier,
    textColor: Color,
    keyboardType: KeyboardType = KeyboardType.Text,
) {
    val focusRequester = remember { FocusRequester() }

    Box(
        modifier = modifier.clickable(
            onClick = { focusRequester.requestFocus() },
            interactionSource = remember { MutableInteractionSource() },
            indication = null
        )
    ) {
        BasicTextField(
            modifier = Modifier
                .align(Alignment.CenterStart)
                .padding(horizontal = 8.dp)
                .focusRequester(focusRequester),
            value = text,
            onValueChange = onTextChanged,
            keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
            maxLines = 1,
            singleLine = true,
            cursorBrush = SolidColor(Color(0xFF2B7EFE)),
            textStyle = LocalTypography.current.text1.copy(color = textColor)
        )
    }

}

@Composable
@Preview(backgroundColor = 0xFFFFFFFF, showBackground = true)
private fun Preview() {
    VacancySearchTheme {
        var text = remember { "456" }
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            TextInputField(
                text = text,
                onTextChanged = { text = it },
                modifier = Modifier
                    .height(40.dp)
                    .align(Alignment.Center),
                textColor = LocalColors.current.basicColors.black
            )
        }
    }
}