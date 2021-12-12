package karman.compose.toksocat.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import karman.compose.toksocat.MainActivity
import karman.compose.toksocat.R
import karman.compose.toksocat.navControllerPreview
import karman.compose.toksocat.ui.theme.*

@Composable
fun StartScreen(navigator: NavHostController) {
    Column(
        Modifier
            .fillMaxSize()
            .background(color = background)
    ) {
        Spacer(modifier = Modifier.height(116.dp))
        Image(
            painter = painterResource(id = R.drawable.ic_tc_logo),
            contentDescription = null,
            modifier = Modifier
                .size(170.dp, 170.dp)
                .fillMaxWidth()
                .align(Alignment.CenterHorizontally)
        )
        Text(
            text = "ToksoCat",
            fontFamily = fonts,
            color = selected,
            fontSize = 36.sp,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = 37.dp)
        )
        Text(
            textAlign = TextAlign.Center,
            fontFamily = fonts,
            text = """
An expert system that
can help you to detect
whether your cat has
toxoplasmy""".trimMargin(),
            color = selected,
            fontSize = 24.sp,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = 37.dp)
        )
        Spacer(modifier = Modifier.weight(1f))
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 76.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = selected),
            shape = RoundedCornerShape(15.dp),
            onClick = { navigator.navigate(MainActivity.Screen.TEST.name) },
            elevation = ButtonDefaults.elevation(0.dp),
        ) {
            Text(
                text = "Begin Test",
                color = background,
                fontSize = 24.sp,
                fontWeight = FontWeight(700)
            )
        }
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 76.dp)
                .padding(top = 26.dp, bottom = 40.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = notSelected),
            shape = RoundedCornerShape(15.dp),
            onClick = { navigator.navigate(MainActivity.Screen.ABOUT.name) },
            elevation = ButtonDefaults.elevation(0.dp)
        ) {
            Text(
                text = "About Us",
                fontFamily = fonts,
                color = selected,
                fontSize = 24.sp,
                fontWeight = FontWeight(700)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ToksoCat_ComposeTheme {
        StartScreen(navControllerPreview)
    }
}