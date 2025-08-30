package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.MyApplicationTheme
import com.lightspark.composeqr.QrCodeView

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    UserProfile(
                        name = "Bardia",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun UserProfile(name: String, modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier
            .fillMaxSize()
            .padding(31.dp)
            .clip(RoundedCornerShape(26.dp)),
        color = Color(0xFF5B497E)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(40.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.hello),
                contentDescription = stringResource(id = R.string.Bardia_javadi),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(125.dp)
                    .clip(CircleShape)
            )

            Spacer(modifier = Modifier.height(50.dp))

            Surface(
                modifier = Modifier
                    .clip(RoundedCornerShape(16.dp))
                    .padding(8.dp),
                color = Color(0xFF5B497E)
            ) {
                Text(
                    text = "4003623011",
                    color = Color.White,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Light,
                    modifier = Modifier.padding(0.dp)
                )
            }

            Spacer(modifier = Modifier.height(50.dp))
            QRCodeDisplay()
            Spacer(modifier = Modifier.height(150.dp))
        }
    }
}

@Composable
fun QRCodeDisplay() {
    QrCodeView(
        data = "https://t.me/brdia_82",
        modifier = Modifier.size(250.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.telegram_icon),
            contentDescription = "Telegram Icon",
            modifier = Modifier.size(60.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun UserProfilePreview() {
    MyApplicationTheme {
        UserProfile("Android")
    }
}
