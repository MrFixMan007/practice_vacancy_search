package ru.my.auth.impl.presentation.auth.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.my.auth.impl.R
import ru.my.theme.LocalColors
import ru.my.theme.LocalTypography
import ru.my.theme.VacancySearchTheme
import ru.my.uicommon.components.AlphaButton
import ru.my.uicommon.components.BlueShadowButton
import ru.my.uicommon.components.TextInputField

@Composable
internal fun AuthScreenContent(
    email: String,
    onEmailChanged: (email: String) -> Unit,
    isContinueButtonEnabled: Boolean,
    isLoginWithPasswordEnabled: Boolean,
    onContinueClick: () -> Unit,
    onLoginWithPasswordClick: () -> Unit,
    onSearchEmployeesClick: () -> Unit,
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Text(
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(start = 16.dp, top = 32.dp, end = 16.dp, bottom = 0.dp),
            text = stringResource(R.string.login_to_account),
            style = LocalTypography.current.title2,
            color = LocalColors.current.basicColors.white,
        )

        Column(
            modifier = Modifier
                .align(Alignment.Center)
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        color = LocalColors.current.basicColors.grey1,
                        shape = RoundedCornerShape(8.dp)
                    )
                    .padding(horizontal = 16.dp, vertical = 24.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Text(
                    text = stringResource(R.string.job_search),
                    style = LocalTypography.current.title3,
                    color = LocalColors.current.basicColors.white
                )
                TextInputField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(40.dp)
                        .background(
                            color = LocalColors.current.basicColors.grey2,
                            shape = RoundedCornerShape(8.dp)
                        ),
                    text = email,
                    onTextChanged = onEmailChanged,
                    textColor = LocalColors.current.basicColors.grey3,
                    keyboardType = KeyboardType.Email,
                )

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    BlueShadowButton(
                        modifier = Modifier.weight(0.5f),
                        text = stringResource(R.string.continue_label),
                        buttonHeight = 40.dp,
                        isEnabled = isContinueButtonEnabled,
                        onClick = onContinueClick
                    )

                    Spacer(modifier = Modifier.weight(0.1f))

                    AlphaButton(
                        modifier = Modifier.height(40.dp),
                        text = stringResource(R.string.login_with_password),
                        onClick = { onLoginWithPasswordClick() },
                        textColor = LocalColors.current.specialColors.blue,
                        buttonColor = null,
                        cornerRadius = 8.dp,
                        isEnabled = isLoginWithPasswordEnabled,
                    )
                }
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        color = LocalColors.current.basicColors.grey1,
                        shape = RoundedCornerShape(8.dp)
                    )
                    .padding(horizontal = 16.dp, vertical = 24.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Column(
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Text(
                        text = stringResource(R.string.employees_search_title),
                        style = LocalTypography.current.title3,
                        color = LocalColors.current.basicColors.white,
                    )
                    Text(
                        text = stringResource(R.string.employees_search_text),
                        style = LocalTypography.current.buttonText2,
                        color = LocalColors.current.basicColors.white,
                    )
                }

                AlphaButton(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(32.dp),
                    text = stringResource(R.string.employees_search_button_label),
                    onClick = onSearchEmployeesClick
                )
            }
        }
    }
}

@Composable
@Preview(backgroundColor = 0xFF000000, showBackground = true)
private fun AuthScreenContentPreview() {
    VacancySearchTheme {

        Box(modifier = Modifier.fillMaxSize()) {
            AuthScreenContent(
                email = "text",
                onEmailChanged = {},
                isContinueButtonEnabled = true,
                isLoginWithPasswordEnabled = true,
                onContinueClick = {},
                onLoginWithPasswordClick = {},
                onSearchEmployeesClick = {},
            )
        }
    }
}