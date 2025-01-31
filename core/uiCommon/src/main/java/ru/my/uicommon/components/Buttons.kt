package ru.my.uicommon.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import ru.my.theme.LocalColors
import ru.my.theme.LocalTypography
import ru.my.theme.VacancySearchTheme

@Composable
fun ShadowButton(
    text: String,
    buttonHeight: Dp,
    modifier: Modifier = Modifier,
    shadowHeight: Dp = 4.dp,
    isEnabled: Boolean,
    onClick: () -> Unit,
    activatedButtonColor: Color,
    disabledButtonColor: Color,
    activatedTextColor: Color,
    disabledTextColor: Color,
    borderColor: Color = LocalColors.current.basicColors.black,
    shadowColor: Color = LocalColors.current.shadowColors.shadows,
    textStyle: TextStyle = LocalTypography.current.buttonText2,
) {

    if (isEnabled) {
        Box(
            modifier = modifier
                .clip(RoundedCornerShape(8.dp))
                .shadow(
                    elevation = shadowHeight,
                    shape = RoundedCornerShape(8.dp),
                    spotColor = shadowColor
                )
                .padding(bottom = shadowHeight),
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.TopCenter)
                    .clip(RoundedCornerShape(8.dp))
                    .height(buttonHeight)
                    .border(
                        width = 1.dp,
                        color = borderColor,
                        shape = RoundedCornerShape(8.dp)
                    )
                    .background(activatedButtonColor)
                    .clickable(onClick = onClick),
            ) {
                Text(
                    modifier = Modifier.align(Alignment.Center),
                    text = text,
                    style = textStyle,
                    color = activatedTextColor
                )
            }
        }
    } else {
        Box(
            modifier = modifier
                .clip(RoundedCornerShape(8.dp))
                .height(buttonHeight)
                .background(disabledButtonColor),
        ) {
            Text(
                modifier = Modifier.align(Alignment.Center),
                text = text,
                style = LocalTypography.current.buttonText2,
                color = disabledTextColor
            )
        }
    }
}

@Composable
fun AlphaButton(
    text: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    textColor: Color = LocalColors.current.basicColors.white,
    buttonColor: Color? = LocalColors.current.specialColors.green,
    cornerRadius: Dp = 32.dp,
    isEnabled: Boolean = true,
    alpha: Float = 0.4f
) {
    val buttonAlpha = if (isEnabled) 1f else alpha
    Box(
        modifier = modifier
            .clip(shape = RoundedCornerShape(cornerRadius))
            .then(if (buttonColor != null) Modifier.background(color = buttonColor.copy(buttonAlpha)) else Modifier)
            .then(if (isEnabled) Modifier.clickable { onClick() } else Modifier)
    ) {
        Text(
            modifier = Modifier.align(Alignment.Center),
            text = text,
            style = LocalTypography.current.buttonText2,
            color = textColor.copy(buttonAlpha),
        )
    }
}

@Composable
fun BlueShadowButton(
    text: String,
    buttonHeight: Dp,
    modifier: Modifier = Modifier,
    shadowHeight: Dp = 4.dp,
    isEnabled: Boolean,
    onClick: () -> Unit,
) {
    ShadowButton(
        text = text,
        buttonHeight = buttonHeight,
        shadowHeight = shadowHeight,
        modifier = modifier,
        isEnabled = isEnabled,
        onClick = onClick,
        activatedButtonColor = LocalColors.current.specialColors.blue,
        disabledButtonColor = LocalColors.current.specialColors.darkBlue,
        activatedTextColor = LocalColors.current.basicColors.white,
        disabledTextColor = LocalColors.current.basicColors.grey4,
    )
}

@Composable
@Preview(backgroundColor = 0xFFFFFFFF, showBackground = true)
private fun EnabledButtonPreview() {
    VacancySearchTheme {
        BlueShadowButton(
            modifier = Modifier
                .fillMaxWidth(),
            buttonHeight = 40.dp,
            text = "Продолжить",
            isEnabled = true,
            onClick = {},
        )
    }
}

@Composable
@Preview(backgroundColor = 0xFFFFFFFF, showBackground = true)
private fun DisabledButtonPreview() {
    VacancySearchTheme {
        BlueShadowButton(
            modifier = Modifier
                .width(100.dp),
            buttonHeight = 40.dp,
            text = "Продолжить",
            isEnabled = false,
            onClick = {}
        )
    }
}

@Composable
@Preview
fun DisabledAlphaButton() {
    VacancySearchTheme {
        val alpha = 0.1f
        AlphaButton(
            modifier = Modifier
                .fillMaxWidth()
                .height(32.dp),
            alpha = alpha,
            text = "Я ищу сотрудников",
            isEnabled = false,
            onClick = {}
        )
    }
}

@Composable
@Preview
fun EnabledAlphaButton() {
    VacancySearchTheme {
        val alpha = 0.1f
        AlphaButton(
            modifier = Modifier
                .fillMaxWidth()
                .height(32.dp),
            alpha = alpha,
            text = "Я ищу сотрудников",
            isEnabled = true,
            onClick = {}
        )
    }
}

@Composable
@Preview
fun EnabledButtonWithoutColor() {
    VacancySearchTheme {
        AlphaButton(
            modifier = Modifier
                .fillMaxWidth()
                .height(32.dp),
            text = "Я ищу сотрудников",
            isEnabled = true,
            buttonColor = null,
            onClick = {}
        )
    }
}
