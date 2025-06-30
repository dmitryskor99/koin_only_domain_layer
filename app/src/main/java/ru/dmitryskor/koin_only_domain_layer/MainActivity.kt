package ru.dmitryskor.koin_only_domain_layer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import ru.dmitryskor.koin_only_domain_layer.login.AuthRepository
import ru.dmitryskor.koin_only_domain_layer.login.BaseAuthRepository
import ru.dmitryskor.koin_only_domain_layer.login.IsLoginUseCase
import ru.dmitryskor.koin_only_domain_layer.login.OnSingInUseCase
import ru.dmitryskor.koin_only_domain_layer.navigation.BaseNavigation
import ru.dmitryskor.koin_only_domain_layer.ui.theme.Koin_only_domain_layerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Koin_only_domain_layerTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    BaseNavigation(
                        modifier = Modifier.padding(innerPadding),
                        isLogin = Client.getIsLoginUseCase(),
                        onSign = Client.getOnSingInUseCase(),
                        getRooms = Client.getGetRoomsUseCase()
                    )
                }
            }
        }
    }
}