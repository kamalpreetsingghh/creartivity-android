package com.cleverlycode.creartivity.ui.screens.auth.signup

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.cleverlycode.creartivity.Login
import com.cleverlycode.creartivity.R
import com.cleverlycode.creartivity.ui.composables.AnnotatedClickableText
import com.cleverlycode.creartivity.ui.composables.CustomButton
import com.cleverlycode.creartivity.ui.composables.InputText
import com.cleverlycode.creartivity.ui.theme.CreartivityTheme

@Composable
fun SignUpScreen(
    navController: NavController,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(32.dp))

        Text(
            text = "Lets get you started.",
            fontSize = 32.sp,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Hi there, Embark on a journey of boundless creativity with AI.",
            fontSize = 20.sp,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(32.dp))

        InputText(
            value = "",
            placeholder = stringResource(id = R.string.label_first_name),
            onValueChange = {}
        )

        Spacer(Modifier.height(16.dp))

        InputText(
            value = "",
            placeholder = stringResource(id = R.string.label_last_name),
            onValueChange = {}
        )

        Spacer(Modifier.height(16.dp))

        InputText(
            value = "",
            placeholder = stringResource(id = R.string.label_email),
            onValueChange = {}
        )

        Spacer(Modifier.height(16.dp))

        InputText(
            value = "",
            placeholder = stringResource(id = R.string.label_password),
            onValueChange = {}
        )

        Spacer(Modifier.height(16.dp))

        InputText(
            value = "",
            placeholder = stringResource(id = R.string.label_confirm_password),
            onValueChange = {}
        )

        Spacer(Modifier.height(20.dp))

        CustomButton(
            label = stringResource(R.string.label_create_account),
            onClick = { },
            color = Color.Black
        )

        Spacer(modifier = Modifier.height(36.dp))

        AnnotatedClickableText(
            text = stringResource(R.string.label_sign_in_text),
            clickableText = stringResource(R.string.label_sign_in),
            onClick = { navController.navigate(Login.route) }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SignUpScreenPreview() {
    CreartivityTheme {
        SignUpScreen(
            navController = rememberNavController()
        )
    }
}