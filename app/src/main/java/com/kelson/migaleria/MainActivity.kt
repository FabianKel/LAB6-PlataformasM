package com.kelson.migaleria

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kelson.migaleria.ui.theme.MiGaleriaTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MiGaleriaTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = colorResource(R.color.AzulFondo)
                ) {
                    Login()
                }
            }
        }
    }
}

@Composable
fun Login(modifier: Modifier = Modifier) {
    Column(modifier = Modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        Row {
            Text(
                text = "INICIA SESIÓN :D",
                modifier = modifier, color = Color.White, fontSize = 30.sp, fontWeight = FontWeight.Bold
            )
        }

        var username : String
        username = CampoInput(titulo = "user", 10, "Text").text
        var password : String
        password = CampoInput(titulo = "password", 8, "Password").text
        BotonIngreso(txt = "Sumbmit", username, password)

    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CampoInput(titulo:String, max:Int, passwordType:String) : TextFieldValue {
    var text by remember { mutableStateOf(TextFieldValue("")) }
    Text(text = "Ingresa tu $titulo", modifier = Modifier.padding(vertical = 5.dp))
    Row (modifier = Modifier.padding(vertical = 30.dp)) {
        val mContext = LocalContext.current
        if(passwordType == "Password"){
            TextField(
                value = text,
                onValueChange = {
                    if (it.text.length <= max) text = it
                    else Toast.makeText(mContext, "No pueden haber más de $max Caracteres", Toast.LENGTH_SHORT).show()
                },
                placeholder = { Text(text = titulo) },
                label = { Text(text = titulo) },
                colors = TextFieldDefaults.textFieldColors(containerColor = colorResource(R.color.AzulFondo)),
                //Agregar característica de conrtaseña
                visualTransformation = PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
            )
        }else{
            TextField(
                value = text,
                onValueChange = {
                    if (it.text.length <= max) text = it
                    else Toast.makeText(mContext, "No pueden haber más de $max Caracteres", Toast.LENGTH_SHORT).show()
                },
                placeholder = { Text(text = titulo) },
                label = { Text(text = titulo) },
                colors = TextFieldDefaults.textFieldColors(containerColor = colorResource(R.color.AzulFondo))
            )
        }
    }
    return text
}

@Composable
fun BotonIngreso(txt:String, username:String, password:String){
    var userval = stringResource(id =R.string.user)
    var passval = stringResource(id =R.string.password)
    Row {
        val mContext = LocalContext.current
        Button( colors = ButtonDefaults.buttonColors(
            containerColor = Color.DarkGray,
            contentColor = MaterialTheme.colorScheme.surface
        ),
                onClick = {
                    if (    username.equals(userval)  and  password.equals(passval) ){
                        mContext.startActivity(Intent(mContext, Activity1::class.java))
                    }else{
                        Toast.makeText(mContext, "Datos incorrectos, el usuario es: ${userval}, y la contraseña es: ${passval}", Toast.LENGTH_SHORT).show()
                        mContext.startActivity(Intent(mContext, Activity1::class.java))
                    }

        }
        ) {
            Text("Ingresar", color = Color.White)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginPreview() {
    MiGaleriaTheme {
        Login()
    }
}