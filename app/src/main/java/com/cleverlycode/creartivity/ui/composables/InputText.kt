package com.cleverlycode.creartivity.ui.composables

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun InputText(value: String, placeholder: String, onChange: (String) -> Unit,) {
    OutlinedTextField(
        value = value,
        onValueChange = { onChange(it) },
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        placeholder = { Text(text = placeholder) },
        shape = RoundedCornerShape(8.dp),
        singleLine = true,
    )
}