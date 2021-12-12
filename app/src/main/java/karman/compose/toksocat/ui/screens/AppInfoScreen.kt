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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import karman.compose.toksocat.R
import karman.compose.toksocat.navControllerPreview
import karman.compose.toksocat.ui.theme.*

@Composable
fun AboutScreen(navigator: NavHostController) {
    Column(
        Modifier
            .fillMaxSize()
            .background(color = background)
            .padding(top = 46.dp, start = 46.dp, end = 46.dp, bottom = 40.dp)
    ) {
        Row(
            Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "ToksoCat",
                fontFamily = fonts,
                fontSize = 36.sp,
                fontWeight = FontWeight.Bold,
                color = selected,
                modifier = Modifier.weight(1f)
            )
            Image(
                painter = painterResource(id = R.drawable.ic_tc_logo),
                contentDescription = "",
                Modifier.size(70.dp)
            )
        }
        Text(
            text = "Made with love by us",
            fontFamily = fonts,
            fontSize = 24.sp,
            fontWeight = FontWeight.SemiBold,
            color = selected,
            modifier = Modifier.padding(top = 35.dp)
        )
        Row(
            Modifier
                .fillMaxWidth()
                .padding(top = 35.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.sad_cat),
                contentDescription = "Alvin Nur R",
                modifier = Modifier.size(70.dp)
            )
            Text(
                text = "Alvin Nur R",
                fontFamily = fonts,
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium,
                color = Color(0xFFCDBBA7),
                modifier = Modifier.padding(start = 23.dp)
            )
        }
        Row(
            Modifier
                .fillMaxWidth()
                .padding(top = 35.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.sad_cat),
                contentDescription = "Iqbal Shafiq R",
                modifier = Modifier.size(70.dp)
            )
            Text(
                text = "Iqbal Shafiq R",
                fontFamily = fonts,
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium,
                color = Color(0xFFFFBF86),
                modifier = Modifier.padding(start = 23.dp)
            )
        }
        Text(
            text = """This application was created to complete the final project of artificial intelligence course""".trimMargin(),
            textAlign = TextAlign.Center,
            fontFamily = fonts,
            fontSize = 24.sp,
            fontWeight = FontWeight.Normal,
            color = selected,
            modifier = Modifier.padding(top = 104.dp)
        )

        Spacer(modifier = Modifier.weight(1f))

        Button(
            onClick = { },
            colors = ButtonDefaults.buttonColors(backgroundColor = notSelected),
            shape = RoundedCornerShape(16.dp),
            elevation = ButtonDefaults.elevation(0.dp),
            modifier = Modifier
                .height(55.dp)
                .width(273.dp)
                .align(Alignment.CenterHorizontally)
        ) {
            Text(
                text = "Back",
                fontFamily = fonts,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = selected
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview_about() {
    ToksoCat_ComposeTheme {
        AboutScreen(navControllerPreview)
    }
}