package ru.dmitryskor.koin_only_domain_layer.login

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    onSign: OnSingInUseCase
) {
    LoginContent(
        modifier = modifier,
        onLogin = {
            onSign(it)
        }
    )
}

@Composable
private fun LoginContent(
    modifier: Modifier = Modifier,
    onLogin: (String?) -> Unit
) {
    val input = remember { mutableStateOf("") }

    Box(
        modifier = modifier
            .fillMaxSize()
    ) {
        TextField(
            modifier = Modifier
                .fillMaxWidth(),
            value = input.value,
            onValueChange = {
                input.value = it
            }
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            modifier = Modifier
                .align(Alignment.Center),
            onClick = {
                onLogin(input.value.ifEmpty { null })
            }
        ) {
            Text("Sing in")
        }
    }
}