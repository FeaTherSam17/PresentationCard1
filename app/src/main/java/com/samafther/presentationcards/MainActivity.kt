package com.samafther.presentationcards

import android.graphics.drawable.Icon
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.samafther.presentationcards.ui.theme.PresentationCardsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PresentationCardsTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Composable
fun PresentationCard(modifier: Modifier = Modifier){
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        PresentationCardInfo("Samuel Alcantara","Android developer")
        Spacer(modifier= Modifier.height(48.dp))
        PresentationCardSocial()
    }
}


@Composable
fun PresentationCardInfo(name:String, title: String){
    val image = painterResource(R.drawable.ic_logo)
    Box {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                image,
                contentDescription = "Android logo",
                modifier = Modifier.width(300.dp)
            )
            Text(
                text = name,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = title, fontSize = 10.sp
            )
        }
    }
}

@Composable
fun PresentationCardSocial(){
    Box (){
        Column(
            verticalArrangement = Arrangement.SpaceAround
        ) {
            LinkPresentation("+ 000 000 0000", Icons.Default.Phone)
            LinkPresentation("@violet", Icons.Default.Person)
            LinkPresentation("violet@gmail.com", Icons.Default.Email)
        }
    }
}

@Composable
fun LinkPresentation(information:String,imageVector: ImageVector){
    Row() {
        Icon(
            imageVector = imageVector,
            contentDescription = "Phone"
        )
        Text(
            text = information
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    PresentationCardsTheme {
       //Greeting("Android")
        //PresentationCardInfo("Samuel Alcantara","Android developer")
        //LinkPresentation("+ 000 000 0000", Icons.Default.Phone)
        //LinkPresentation("@violet", Icons.Default.Person)
        //LinkPresentation("violet@gmail.com", Icons.Default.Email)
        //PresentationCardSocial()
        PresentationCard()
    }
}