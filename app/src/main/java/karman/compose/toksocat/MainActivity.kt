package karman.compose.toksocat

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import karman.compose.toksocat.ui.screens.AboutScreen
import karman.compose.toksocat.ui.screens.ResultScreen
import karman.compose.toksocat.ui.screens.StartScreen
import karman.compose.toksocat.ui.screens.TestScreen
import karman.compose.toksocat.ui.theme.ToksoCat_ComposeTheme

@SuppressLint("StaticFieldLeak")
lateinit var navControllerPreview: NavHostController

class MainActivity : ComponentActivity() {

    enum class Screen {
        ABOUT,
        START,
        TEST,
        RESULT
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            navControllerPreview = navController
            ToksoCat_ComposeTheme {
                NavHost(navController = navController, startDestination = Screen.START.name) {
                    composable(Screen.START.name) {
                        StartScreen(navController)
                    }
                    composable(Screen.TEST.name) {
                        TestScreen(navController)
                    }
                    composable(Screen.ABOUT.name) {
                        AboutScreen(navController)
                    }
                    composable(Screen.RESULT.name) {
                        ResultScreen(navController)
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ToksoCat_ComposeTheme {
        Greeting("Android")
    }
}