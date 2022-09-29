package com.example.basiccalculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Calculator()
        }
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun Calculator() {
    var inputA by remember { mutableStateOf("") }
    var inputB by remember { mutableStateOf("") }
    var outputText by remember { mutableStateOf("") }
    val keyboardController = LocalSoftwareKeyboardController.current



    Column(
        modifier = Modifier.padding(70.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(10.dp)

    ) {

        Text(
            text = "Calculator",
            fontFamily = FontFamily.SansSerif,
            fontSize = 50.sp,
            color = Color.Blue,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 10.dp),
        )

        OutlinedTextField(
            value = inputA,
            onValueChange = { inputA = it },
            modifier = Modifier
                .width(200.dp)
                .padding(top = 10.dp),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Next
            )
        )
        OutlinedTextField(
            value = inputB,
            onValueChange = { inputB = it },
            modifier = Modifier
                .width(200.dp)
                .padding(bottom = 10.dp, top = 10.dp),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(onDone = { keyboardController?.hide() }),
        )
        Row {
            Button(
                onClick = { outputText = addition(inputA.toInt(), inputB.toInt()) },
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
                modifier = Modifier
                    .width(50.dp)
                    .padding(top = 10.dp, bottom = 10.dp),
            ) {
                Text(text = "+", fontWeight = FontWeight.Bold, fontSize = 20.sp)
            }
            Button(
                onClick = { outputText = subtract(inputA.toInt(), inputB.toInt()) },
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
                modifier = Modifier
                    .width(50.dp)
                    .padding(top = 10.dp, bottom = 10.dp),
            ) {
                Text(text = "-", fontWeight = FontWeight.Bold, fontSize = 20.sp)
            }
            Button(
                onClick = { outputText = multiply(inputA.toInt(), inputB.toInt()) },
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
                modifier = Modifier
                    .width(50.dp)
                    .padding(top = 10.dp, bottom = 10.dp),
            ) {
                Text(text = "*", fontWeight = FontWeight.Bold, fontSize = 20.sp)
            }
            Button(
                onClick = { outputText = divide(inputA.toInt(), inputB.toInt()) },
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
                modifier = Modifier
                    .width(50.dp)
                    .padding(top = 10.dp, bottom = 10.dp),
            ) {
                Text(text = "/", fontWeight = FontWeight.Bold, fontSize = 20.sp)
            }
        }
        Text(
            text = "Result:  $outputText",
            modifier = Modifier
                .width(200.dp)
                .padding(bottom = 10.dp, top = 10.dp),
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )
    }
}

fun addition(a: Int, b: Int): String {
    val ab = a + b
    return ab.toString()
}

fun subtract(a: Int, b: Int): String {
    val ab = a - b
    return ab.toString()
}

fun multiply(a: Int, b: Int): String {
    val ab = a * b
    return ab.toString()
}

fun divide(a: Int, b: Int): String {
    val ab = a.toDouble() / b.toDouble()
    return ab.toString()
}