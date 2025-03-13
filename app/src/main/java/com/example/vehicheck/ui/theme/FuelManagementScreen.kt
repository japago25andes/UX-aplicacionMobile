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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.vehicheck.R
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.draw.clip
import androidx.navigation.NavController

@Composable
fun FuelManagementScreen(
    navController: NavController,
    onBackClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFEAEFFF))
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "Gestión de combustible",
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF6C44F4)
        )

        Spacer(modifier = Modifier.height(26.dp))

        Image(
            painter = painterResource(id = R.drawable.ic_fuel),
            contentDescription = "Fuel Image",
            modifier = Modifier
                .height(280.dp)
                .fillMaxWidth()
                .clip(RoundedCornerShape(12.dp)),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.height(56.dp))

        Button(
            onClick = { navController.navigate("fuel_entry") },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF6C44F4)),
            shape = RoundedCornerShape(16.dp)
        ) {
            Text("+ REGISTRAR COMBUSTIBLE", color = Color.White, fontSize = 16.sp)
        }

        Spacer(modifier = Modifier.height(44.dp))

        Text(
            text = "Históricos",
            fontSize = 18.sp,
            color = Color(0xFF6C44F4)
        )

        Spacer(modifier = Modifier.height(8.dp))

        Card(
            shape = RoundedCornerShape(12.dp),
            colors = CardDefaults.cardColors(containerColor = Color(0xFFF3E5F5)),
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                FuelHistoryItem("13 Ene 25", "85.500")
                FuelHistoryItem("23 Dic 24", "150.000")
                FuelHistoryItem("06 Jun 24", "70.0000")
            }
        }

        Spacer(modifier = Modifier.height(44.dp))

        Button(
            onClick = { onBackClick() }, // Volverá atrás
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF6C44F4)),
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("REGRESAR", color = Color.White, fontSize = 18.sp)
        }
    }
}

@Composable
fun FuelHistoryItem(date: String, amount: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = "$date | Valor $amount", fontSize = 16.sp, color = Color(0xFF6C44F4))
        Icon(
            painter = painterResource(id = R.drawable.ic_heart),
            contentDescription = "Favorite",
            tint = Color(0xFF6C44F4)
        )
    }
}
