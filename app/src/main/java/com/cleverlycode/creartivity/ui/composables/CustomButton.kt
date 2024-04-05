package com.cleverlycode.creartivity.ui.composables

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@Composable
fun CustomButton(
    label: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    icon: ImageVector? = null,
    contentDescription: String? = null,
    color: Color = Color.Black,
    textColor: Color = MaterialTheme.colorScheme.onPrimary
) {
    Button(
        modifier = modifier.fillMaxWidth(),
        contentPadding = PaddingValues(12.dp),
        onClick = onClick,
        enabled = enabled,
        colors = ButtonDefaults.buttonColors(containerColor = color),
        elevation = null
    ) {
        if (icon != null) {
            Icon(
                imageVector = icon,
                contentDescription = contentDescription
            )
        }
        Text(
            text = label,
            color = textColor
        )
    }
}