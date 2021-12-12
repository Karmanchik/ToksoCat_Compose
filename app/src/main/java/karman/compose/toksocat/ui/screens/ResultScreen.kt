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
import karman.compose.toksocat.MainActivity
import karman.compose.toksocat.R
import karman.compose.toksocat.navControllerPreview
import karman.compose.toksocat.ui.theme.ToksoCat_ComposeTheme
import karman.compose.toksocat.ui.theme.background
import karman.compose.toksocat.ui.theme.fonts
import karman.compose.toksocat.ui.theme.selected

@Composable
fun ResultScreen(navigator: NavHostController) {
    Column(
        Modifier
            .fillMaxSize()
            .background(color = background)
            .padding(top = 46.dp, start = 46.dp, end = 46.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            Modifier.fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_carbon_winter_warning),
                contentDescription = "",
                Modifier
                    .size(width = 74.dp, height = 68.dp)
                    .align(Alignment.TopEnd)
            )
            Image(
                painter = painterResource(id = R.drawable.sad_cat),
                contentDescription = "",
                Modifier
                    .size(170.dp)
                    .padding(top = 34.dp)
                    .align(Alignment.Center)
            )
        }
        Text(
            text = "Result",
            fontSize = 36.sp,
            fontFamily = fonts,
            fontWeight = FontWeight.Bold,
            color = selected,
            modifier = Modifier.padding(top = 35.dp)
        )
        Text(
            text = """Your cat has been diagnosed with toxoplasmosis. Take him to the vet immediately for further treatment.""".trimMargin(),
            textAlign = TextAlign.Center,
            fontFamily = fonts,
            fontSize = 24.sp,
            fontWeight = FontWeight.Medium,
            color = selected,
            modifier = Modifier.padding(top = 25.dp)
        )
        Button(
            onClick = { MainActivity.Screen.START },
            colors = ButtonDefaults.buttonColors(backgroundColor = selected),
            shape = RoundedCornerShape(16.dp),
            elevation = ButtonDefaults.elevation(0.dp),
            modifier = Modifier
                .width(237.dp)
                .padding(top = 65.dp)
        ) {
            Text(
                text = "Back to Home",
                fontFamily = fonts,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = background
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview_result() {
    ToksoCat_ComposeTheme {
        ResultScreen(navControllerPreview)
    }
}