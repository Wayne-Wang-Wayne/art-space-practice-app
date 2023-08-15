package com.example.artspaceapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.artspaceapp.ui.theme.ArtSpaceAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceAppTheme {
                ArtSpaceApp()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ArtSpaceApp() {
    ArtSpacePage()
}

@Composable
fun ArtSpacePage(
    modifier: Modifier = Modifier
) {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentSize(Alignment.Center)
                .weight(6f)
                .height(300.dp)
                .padding(20.dp)
                .shadow(
                    elevation = 10.dp
                )
        )
        DesTexts(
            "Title",
            "content",
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentSize(Alignment.Center)
                .weight(2f)
        )
        ActionButtons(
            onPreClick = {},
            onNextClick = {},
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentSize(Alignment.Center)
                .weight(2f)
                .padding(20.dp)
        )
    }

}

@Composable
fun DesTexts(
    title: String,
    content: String,
    modifier: Modifier = Modifier
) {

    Column(
        modifier = modifier
    ) {
        Text(text = title)
        Text(text = content)
    }

}

@Composable
fun ActionButtons(
    onPreClick: () -> Unit,
    onNextClick: () -> Unit,
    modifier: Modifier = Modifier
) {

    Row(
        horizontalArrangement = Arrangement.Center,
        modifier = modifier
    ) {
        OutlinedButton(
            onClick = onPreClick,
            border = BorderStroke(1.dp, Color.Black),
            colors = ButtonDefaults.outlinedButtonColors(
                backgroundColor = Color.Gray
            ),
            modifier = Modifier.weight(1f)
        ) {
            Text(text = stringResource(R.string.previous))
        }
        Spacer(
            modifier = Modifier.width(10.dp)
        )
        OutlinedButton(
            onClick = onNextClick,
            border = BorderStroke(1.dp, Color.Black),
            colors = ButtonDefaults.outlinedButtonColors(
                backgroundColor = Color.Gray
            ),
            modifier = Modifier.weight(1f)
        ) {
            Text(text = stringResource(R.string.next))
        }
    }

}