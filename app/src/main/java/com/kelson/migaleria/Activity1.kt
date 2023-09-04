package com.kelson.migaleria

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kelson.migaleria.ui.theme.MiGaleriaTheme

class Activity1 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MiGaleriaTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.White
                ) {
                    CuerpoGallery()
                }
            }
        }
    }
}

@Composable
fun CuerpoGallery() {

    data class patos(val imageID: Int, val imageTile: String,val imageDesc: String)
    val pato1 = patos(R.drawable.pato1,"Pato observador","Te observa y te juzga")
    val pato2 = patos(R.drawable.pato1,"Pato bélico","La paz nunca fue una opción")
    val pato3 = patos(R.drawable.pato1,"Pato durmiendo","'ta cansao Zzz")
    val pato4 = patos(R.drawable.pato1,"Pato enojao","¿Quién lo despertó? 😡")
    val listaPatos = arrayOf(pato1,pato2,pato3,pato4)
    var imageName by remember { mutableStateOf(1) }
    imageName = listaPatos[0].imageID
    var imageTitle by remember { mutableStateOf("Pato observador") }
    var imageDesc by remember { mutableStateOf("Te observa y te juzga") }
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Row {
            Card(
                colors = CardDefaults.cardColors(
                    containerColor = Color.Gray,
                ), modifier = Modifier
                    .padding(20.dp)
                    .width(300.dp)
            ){
                Image(
                    painter= painterResource(id = imageName),
                    contentDescription= "pato",
                    contentScale = ContentScale.FillHeight,
                    modifier = Modifier
                        .height(400.dp)
                        .width(300.dp)
                        .padding(10.dp)
                )
            }

        }
        Spacer(modifier = Modifier.height(20.dp))
        Row(modifier = Modifier.width(300.dp)) {
            Card(colors = CardDefaults.cardColors(
                containerColor = colorResource(id = R.color.GrisCard),
            ),modifier = Modifier.width(300.dp)) {
                Spacer(modifier = Modifier.height(8.dp))
                Row {
                    Text(text = "Pato observador", fontSize = 20.sp)
                }
                Spacer(modifier = Modifier.height(8.dp))
                Row {
                    Text(text = "Te observa y te juzga", fontSize = 15.sp, fontWeight = FontWeight.Bold)
                }
                Spacer(modifier = Modifier.height(8.dp))
            }

        }
        Spacer(modifier = Modifier.height(20.dp))
        Row {
            Column(modifier = Modifier.width(150.dp)) {
                Button( colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.AzulBoton))
                    ,onClick = { /*TODO*/ }, modifier = Modifier
                    .width(130.dp)
                    .padding(5.dp)) {
                    Text(text = "Previous")
                }
            }
            Column(modifier = Modifier.width(150.dp)){
                Button(
                    colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.AzulBoton))
                    ,onClick = { /*TODO*/ }
                    , modifier = Modifier
                        .width(130.dp)
                        .padding(5.dp)
                ) {
                    Text(text = "Next")
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MiGaleriaTheme {
        CuerpoGallery()
    }
}