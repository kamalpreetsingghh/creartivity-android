package com.cleverlycode.creartivity.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.cleverlycode.creartivity.R

val Poppins = FontFamily(
    Font(R.font.poppins_light, FontWeight.Thin),
    Font(R.font.poppins_regular, FontWeight.Normal),
    Font(R.font.poppins_semibold, FontWeight.SemiBold),
    Font(R.font.poppins_bold, FontWeight.Bold)
)

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = Poppins,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),
    bodyMedium = Typography().bodyMedium.copy(fontFamily = Poppins),
    bodySmall = Typography().bodySmall.copy(fontFamily = Poppins),

    displayLarge = Typography().displayLarge.copy(fontFamily = Poppins),
    displayMedium = Typography().displayMedium.copy(fontFamily = Poppins),
    displaySmall = Typography().displaySmall.copy(fontFamily = Poppins),

    headlineLarge = Typography().headlineLarge.copy(fontFamily = Poppins),
    headlineMedium = Typography().headlineMedium.copy(fontFamily = Poppins),
    headlineSmall = Typography().headlineSmall.copy(fontFamily = Poppins),

    titleLarge = Typography().titleLarge.copy(fontFamily = Poppins),
    titleMedium = Typography().titleMedium.copy(fontFamily = Poppins),
    titleSmall = Typography().titleSmall.copy(fontFamily = Poppins),

    labelLarge = Typography().labelLarge.copy(fontFamily = Poppins),
    labelMedium = Typography().labelMedium.copy(fontFamily = Poppins),
    labelSmall = Typography().labelSmall.copy(fontFamily = Poppins)


)