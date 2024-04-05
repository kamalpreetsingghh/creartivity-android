package com.cleverlycode.creartivity.ui.screens.auth.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.cleverlycode.creartivity.R
import com.cleverlycode.creartivity.SignUp
import com.cleverlycode.creartivity.ui.composables.AnnotatedClickableText
import com.cleverlycode.creartivity.ui.composables.CustomButton
import com.cleverlycode.creartivity.ui.composables.InputText

@Composable
fun LoginScreen(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Lets Sign you in", fontSize = 28.sp, fontWeight = FontWeight.SemiBold)

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Welcome back,")
        Text(text = "you have been missed")

        Spacer(modifier = Modifier.height(16.dp))

        InputText(
            value = "",
            placeholder = "Email",
            onValueChange = {}
        )

        Spacer(Modifier.height(12.dp))

        InputText(
            value = "",
            placeholder = "Password",
            onValueChange = {}
        )

        Spacer(Modifier.height(16.dp))

        CustomButton(
            label = stringResource(R.string.label_sign_in),
            onClick = { },
            color = Color.Black
        )

        Spacer(modifier = Modifier.height(24.dp))

        AnnotatedClickableText(
            text = stringResource(R.string.label_sign_up_text),
            clickableText = stringResource(R.string.label_sign_up),
            onClick = { navController.navigate(SignUp.route) }
        )
    }
}