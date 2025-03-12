package com.example.vehicheck.ui.theme

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SuccessDialog(onDismiss: () -> Unit, onChangePassword: () -> Unit) {
    AlertDialog(
        onDismissRequest = { onDismiss() },
        confirmButton = {
            TextButton(onClick = { onChangePassword() }) {
                Text("ACEPTAR", color = Color(0xFF6C44F4), fontWeight = FontWeight.Bold)
            }
        },
        title = { Text("Aviso importante", fontWeight = FontWeight.Bold, color = Color(0xFF6C44F4)) },
        text = {
            Text("Se envió un correo electrónico a tu dirección registrada, con tu nueva contraseña y usuario registrado.")
        },
        shape = RoundedCornerShape(12.dp)
    )
}