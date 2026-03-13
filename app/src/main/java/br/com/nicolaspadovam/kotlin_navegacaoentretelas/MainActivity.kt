package br.com.nicolaspadovam.kotlin_navegacaoentretelas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.com.nicolaspadovam.kotlin_navegacaoentretelas.screens.LoginScreen
import br.com.nicolaspadovam.kotlin_navegacaoentretelas.screens.MenuScreen
import br.com.nicolaspadovam.kotlin_navegacaoentretelas.screens.PedidosScreen
import br.com.nicolaspadovam.kotlin_navegacaoentretelas.screens.PerfilScreen
import br.com.nicolaspadovam.kotlin_navegacaoentretelas.ui.theme.Kotlin_NavegacaoEntreTelasTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Kotlin_NavegacaoEntreTelasTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->   //Inner padding serve para criar um padding(espaçamento) para itens não ficarem sobrepostos por cameras que ficam dentro da tela (xiaomi 12 lite) por exemplo.

                    //controlador para navegar entre as rotas
                    val navController = rememberNavController()

                    NavHost(
                        navController = navController,
                        startDestination = "login",
                    ) {
                        //rotas ou Alias
                        composable(route = "login") {
                            LoginScreen(modifier = Modifier.padding(innerPadding), navController)
                        }

                        composable(route = "menu") {
                            MenuScreen(modifier = Modifier.padding(innerPadding), navController)
                        }

                        composable(route = "pedidos") {
                            PedidosScreen(modifier = Modifier.padding(innerPadding), navController)
                        }

                        composable(route = "perfil") {
                            PerfilScreen(modifier = Modifier.padding(innerPadding), navController)
                        }
                    }
                }
            }
        }

    }
}