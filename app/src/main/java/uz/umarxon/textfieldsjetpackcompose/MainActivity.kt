package uz.umarxon.textfieldsjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import uz.umarxon.textfieldsjetpackcompose.ui.theme.TextFieldsJetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White),
            ) {
                HelloTitle()
                PasswordTextField()
                SimpleTextField()
            }
        }
    }
}

@Composable
private fun HelloTitle() {
    Text("Text Fields Examples")
}

@Composable
fun PasswordTextField() {

    var password by rememberSaveable { mutableStateOf("") }
    var passwordVisibility by remember { mutableStateOf(false) }

    val icon = if (passwordVisibility)
        painterResource(id = R.drawable.design_ic_visibility)
    else
        painterResource(id = R.drawable.design_ic_visibility_off)

    OutlinedTextField(
        value = password,
        onValueChange = {
            password = it
        },
        placeholder = { Text(text = "Password") },
        label = { Text("Password") },
        trailingIcon = {
            IconButton(onClick = {
                passwordVisibility = !passwordVisibility
            }) {
                Icon(
                    painter = icon,
                    contentDescription = "Visibility icon"
                )
            }
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password
        ),
        visualTransformation = if (passwordVisibility) VisualTransformation.None
        else PasswordVisualTransformation()
    )

}

@Composable
fun SimpleTextField() {
    var text by remember { mutableStateOf("Type here..") }

    TextField(value = text, onValueChange = {
        text = it
    }, modifier = Modifier.padding(15.dp))

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TextFieldsJetpackComposeTheme {
        Column(
            modifier = Modifier.fillMaxSize()
                .background(Color.White),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            HelloTitle()
            PasswordTextField()
            SimpleTextField()
        }
    }
}