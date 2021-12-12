package karman.compose.toksocat.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import karman.compose.toksocat.MainActivity
import karman.compose.toksocat.R
import karman.compose.toksocat.ui.theme.*

@Composable
fun TestScreen(navigator: NavHostController? = null) {
    val selectedVariant = remember { mutableStateOf(1) }
    val scrollState = rememberScrollState()
    Column(
        Modifier
            .fillMaxSize()
            .background(color = background)
            .padding(top = 46.dp, start = 46.dp, end = 46.dp)
            .verticalScroll(scrollState)
    ) {
        Row(
            Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                fontFamily = fonts,
                text = "ToksoCat",
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
            text = "Question 1",
            fontSize = 24.sp,
            fontFamily = fonts,
            fontWeight = FontWeight.SemiBold,
            color = selected,
            modifier = Modifier.padding(top = 35.dp)
        )
        Text(
            text = """What do you think about the liveliness of your cat?""".trimMargin(),
            fontSize = 22.sp,
            fontFamily = fonts,
            fontWeight = FontWeight.Medium,
            color = selected,
            modifier = Modifier.padding(top = 25.dp)
        )
        Text(
            fontFamily = fonts,
            text = "Choose 1 answer",
            fontSize = 18.sp,
            fontWeight = FontWeight.Normal,
            color = selected,
            modifier = Modifier.padding(top = 25.dp)
        )

        VariantButton("A. As active as usual", 1, selectedVariant.value) { selectedVariant.value = it }
        VariantButton("B. Looks lazier than usual", 2, selectedVariant.value) { selectedVariant.value = it }
        VariantButton("C. More active than usual", 3, selectedVariant.value) { selectedVariant.value = it }
        VariantButton("D. Not sure", 4, selectedVariant.value) { selectedVariant.value = it }

        Spacer(modifier = Modifier.height(10.dp))
        Spacer(modifier = Modifier.weight(1f))
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Button(
                onClick = { MainActivity.Screen.START },
                colors = ButtonDefaults.buttonColors(backgroundColor = notSelected),
                shape = RoundedCornerShape(topStartPercent = 16),
                elevation = ButtonDefaults.elevation(0.dp),
                modifier = Modifier
                    .weight(1F)
                    .height(55.dp)
            ) {
                Text(
                    text = "Back",
                    fontFamily = fonts,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = selected
                )
            }
            Button(
                onClick = { MainActivity.Screen.RESULT },
                colors = ButtonDefaults.buttonColors(backgroundColor = selected),
                shape = RoundedCornerShape(topEndPercent = 16),
                elevation = ButtonDefaults.elevation(0.dp),
                modifier = Modifier
                    .weight(1F)
                    .height(55.dp)
            ) {
                Text(
                    text = "Next",
                    fontFamily = fonts,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = background
                )
            }
        }
    }
}

@Composable
fun VariantButton(text: String, index: Int, selectedIndex: Int, onSelected: (Int) -> Unit) {
    val isActive = index == selectedIndex
    Button(
        onClick = { onSelected.invoke(index) },
        colors = ButtonDefaults.buttonColors(
            backgroundColor = if (isActive) selected else notSelected
        ),
        shape = RoundedCornerShape(16),
        elevation = ButtonDefaults.elevation(0.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 21.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp, vertical = 10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = text,
                fontFamily = fonts,
                fontSize = 18.sp,
                color = if (isActive) background else selected,
                modifier = Modifier.weight(1f)
            )
            if (isActive) {
                Image(
                    painter = painterResource(id = R.drawable.ic_group),
                    contentDescription = "selected answer",
                    modifier = Modifier.padding(start = 16.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview_test() {
    ToksoCat_ComposeTheme {
        TestScreen()
    }
}