package ru.my.theme

import androidx.compose.runtime.Immutable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Immutable
object CustomTypography {

    private val sfProDisplay = FontFamily(
        Font(R.font.sf_pro_display_medium, FontWeight.Medium),
        Font(R.font.sf_pro_display_regular, FontWeight.Normal),
        Font(R.font.sf_pro_display_semibold, FontWeight.SemiBold),
    )

    val title1 = TextStyle(
        fontWeight = FontWeight.SemiBold,
        fontFamily = sfProDisplay,
        fontSize = 22.sp,
        lineHeight = 26.sp,
    )

    val title2 = TextStyle(
        fontWeight = FontWeight.SemiBold,
        fontFamily = sfProDisplay,
        fontSize = 20.sp,
        lineHeight = 24.sp,
    )

    val title3 = TextStyle(
        fontWeight = FontWeight.Medium,
        fontFamily = sfProDisplay,
        fontSize = 16.sp,
        lineHeight = 19.sp,
    )

    val title4 = TextStyle(
        fontWeight = FontWeight.Medium,
        fontFamily = sfProDisplay,
        fontSize = 14.sp,
        lineHeight = 16.sp,
    )

    val text1 = TextStyle(
        fontWeight = FontWeight.Normal,
        fontFamily = sfProDisplay,
        fontSize = 14.sp,
        lineHeight = 16.sp,
    )

    val buttonText1 = TextStyle(
        fontWeight = FontWeight.SemiBold,
        fontFamily = sfProDisplay,
        fontSize = 16.sp,
        lineHeight = 20.sp,
    )

    val buttonText2 = TextStyle(
        fontWeight = FontWeight.Normal,
        fontFamily = sfProDisplay,
        fontSize = 14.sp,
        lineHeight = 18.sp,
    )

    val tabText = TextStyle(
        fontWeight = FontWeight.Normal,
        fontFamily = sfProDisplay,
        fontSize = 10.sp,
        lineHeight = 11.sp,
    )

    val number = TextStyle(
        fontWeight = FontWeight.Normal,
        fontFamily = sfProDisplay,
        fontSize = 7.sp,
        lineHeight = 8.sp,
    )
}