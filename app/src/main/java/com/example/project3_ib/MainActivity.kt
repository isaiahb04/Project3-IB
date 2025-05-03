package com.example.project3_ib

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.Crossfade
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.project3_ib.ui.theme.Project3IBTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Project3IBTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    ImageSwitcherApp()
                }
            }
        }
    }
}

@Composable
fun ImageSwitcherApp() {
    var currentImage by remember { mutableStateOf(R.drawable.img1) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Crossfade(targetState = currentImage) { imageRes ->
            Image(
                painter = painterResource(id = imageRes),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp)
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            val buttonModifier = Modifier
                .weight(1f)
                .height(60.dp)
                .padding(horizontal = 4.dp)

            Button(
                onClick = { currentImage = R.drawable.img1 },
                colors = ButtonDefaults.buttonColors(containerColor = Color.Red),
                modifier = buttonModifier,
                shape = MaterialTheme.shapes.medium
            ) {
                Icon(
                    painter = painterResource(R.drawable.ic_red),
                    contentDescription = "Red",
                    modifier = Modifier.size(24.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text("Red", color = Color.White)
            }

            Button(
                onClick = { currentImage = R.drawable.img2 },
                colors = ButtonDefaults.buttonColors(containerColor = Color.Green),
                modifier = buttonModifier,
                shape = MaterialTheme.shapes.medium
            ) {
                Icon(
                    painter = painterResource(R.drawable.ic_green),
                    contentDescription = "Green",
                    modifier = Modifier.size(24.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text("Green", color = Color.White)
            }

            Button(
                onClick = { currentImage = R.drawable.img3 },
                colors = ButtonDefaults.buttonColors(containerColor = Color.Blue),
                modifier = buttonModifier,
                shape = MaterialTheme.shapes.medium
            ) {
                Icon(
                    painter = painterResource(R.drawable.ic_blue),
                    contentDescription = "Blue",
                    modifier = Modifier.size(24.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text("Blue", color = Color.White)
            }
        }

    }
}
