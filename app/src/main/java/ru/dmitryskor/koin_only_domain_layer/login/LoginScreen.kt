package ru.dmitryskor.koin_only_domain_layer.login

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun LoginScreen(modifier: Modifier = Modifier) {
    LoginContent(
        modifier = modifier,
        onLogin = {

        }
    )
}

@Composable
private fun LoginContent(
    modifier: Modifier = Modifier,
    onLogin: () -> Unit
) {
    Box(
        modifier = modifier
            .fillMaxSize()
    ) {
        Button(
            modifier = Modifier
                .align(Alignment.Center),
            onClick = onLogin
        ) {
            Text("Sing in")
        }
    }
}