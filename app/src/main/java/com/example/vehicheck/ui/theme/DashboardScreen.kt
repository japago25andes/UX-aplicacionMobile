package com.example.vehicheck.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
fun DashboardScreen(navController: NavController, onLogoutClick: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFEAEFFF))
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "Bienvenido Leonardo",
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF6C44F4)
        )

        Spacer(modifier = Modifier.height(26.dp))

        Button(
            onClick = { /* Acción para crear recordatorio */ },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF6C44F4)),
            shape = RoundedCornerShape(16.dp)
        ) {
            Text("+ CREAR RECORDATORIO", color = Color.White, fontSize = 16.sp)
        }

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "Próximos recordatorios:",
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
                ReminderItem("Cambio Aceite")
                ReminderItem("Compra de SOAT")
                ReminderItem("Sincronización")
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "Vehículos:",
            fontSize = 18.sp,
            color = Color(0xFF6C44F4)
        )

        Spacer(modifier = Modifier.height(12.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            VehicleItem(R.drawable.car_1)
            VehicleItem(R.drawable.car_2)
            VehicleItem(R.drawable.car_3)
        }

        Spacer(modifier = Modifier.height(54.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            FeatureItem(R.drawable.ic_fuel, "Combustible") { navController.navigate("fuel_management") }
            FeatureItem(R.drawable.ic_maintenance, "Mantenimiento") { navController.navigate("maintenance_management") }
        }

        Spacer(modifier = Modifier.height(32.dp))

        Button(
            onClick = { onLogoutClick() },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF6C44F4)),
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("SALIR VEHICHECK", color = Color.White, fontSize = 18.sp)
        }
    }
}

@Composable
fun ReminderItem(title: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = title, fontSize = 16.sp, color = Color(0xFF6C44F4))
        Icon(
            painter = painterResource(id = R.drawable.ic_heart),
            contentDescription = "Favorite",
            tint = Color(0xFF6C44F4)
        )
    }
}

@Composable
fun VehicleItem(imageRes: Int) {
    Box(
        modifier = Modifier
            .size(80.dp)
            .background(Color.White, shape = RoundedCornerShape(8.dp))
            .clip(RoundedCornerShape(8.dp))
    ) {
        Image(
            painter = painterResource(id = imageRes),
            contentDescription = "Vehicle",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
    }
}

@Composable
fun FeatureItem(imageRes: Int, title: String, onClick: () -> Unit) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.clickable { onClick() }
    ) {
        Card(
            shape = RoundedCornerShape(12.dp),
            colors = CardDefaults.cardColors(containerColor = Color(0xFFF3E5F5)),
            modifier = Modifier.padding(8.dp).size(80.dp)
        ) {
            Image(
                painter = painterResource(id = imageRes),
                contentDescription = title,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
        }
        Text(text = title, fontSize = 14.sp, color = Color(0xFF6C44F4))
    }
}
