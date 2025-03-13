package com.example.vehicheck.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.vehicheck.R

@Composable
fun RecoverPasswordScreen(onAcceptClick: () -> Unit) {
    var userInput by remember { mutableStateOf("") }
    var showDialog by remember { mutableStateOf(false) } // Estado del Pop-up


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFEAEFFF))
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.login_image),
            contentDescription = "Recover Password Image",
            modifier = Modifier
                .height(180.dp)
                .fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(24.dp))

        OutlinedTextField(
            value = userInput,
            onValueChange = { userInput = it },
            label = { Text("Usuario / Correo electrónico") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = { showDialog = true },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF6C44F4)),
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("ACEPTAR", color = Color.White, fontSize = 18.sp)
        }
    }

    if (showDialog) {
        SuccessDialog(
            onDismiss = { showDialog = false },
            onChangePassword = {
                showDialog = false
                onAcceptClick()
            }
        )
    }


}
