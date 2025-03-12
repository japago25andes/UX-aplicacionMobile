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
fun MaintenanceManagementScreen(
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
            text = "Gestión de mantenimiento",
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF6C44F4)
        )

        Spacer(modifier = Modifier.height(26.dp))

        Button(
            onClick = { navController.navigate("maintenance_entry") },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF6C44F4)),
            shape = RoundedCornerShape(16.dp)
        ) {
            Text("+ REGISTRAR MANTENIMIENTO", color = Color.White, fontSize = 16.sp)
        }

        Spacer(modifier = Modifier.height(54.dp))

        Text(
            text = "Próximos mantenimientos",
            fontSize = 18.sp,
            color = Color(0xFF6C44F4)
        )

        Spacer(modifier = Modifier.height(28.dp))

        MaintenanceItem("Cambio de frenos", "Llevar al taller autoAndes para la revisión llamar al 3458900 ....")
        MaintenanceItem("Cambio refrigerante", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do")

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "Histórico de mantenimientos",
            fontSize = 18.sp,
            color = Color(0xFF6C44F4)
        )

        Spacer(modifier = Modifier.height(28.dp))

        Card(
            shape = RoundedCornerShape(12.dp),
            colors = CardDefaults.cardColors(containerColor = Color(0xFFF3E5F5)),
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                MaintenanceHistoryItem("13 Ene 25", "Cambio de batería")
                MaintenanceHistoryItem("23 Dic 24", "Cambio de llantas")
                MaintenanceHistoryItem("06 Jun 24", "Lorem ipsum dolor")
            }
        }

        Spacer(modifier = Modifier.height(34.dp))

        Button(
            onClick = { onBackClick() },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF6C44F4)),
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("REGRESAR", color = Color.White, fontSize = 18.sp)
        }
    }
}

@Composable
fun MaintenanceItem(title: String, description: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_maintenance),
            contentDescription = "Maintenance Icon",
            tint = Color.Gray,
            modifier = Modifier.size(24.dp)
        )
        Column(modifier = Modifier.weight(1f).padding(start = 8.dp)) {
            Text(text = title, fontSize = 16.sp, fontWeight = FontWeight.Bold, color = Color(0xFF6C44F4))
            Text(text = description, fontSize = 14.sp, color = Color.Gray)
        }
        Text(text = "Caption", fontSize = 14.sp, color = Color.Gray)
    }
}

@Composable
fun MaintenanceHistoryItem(date: String, detail: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = "$date | $detail", fontSize = 16.sp, color = Color(0xFF6C44F4))
        Icon(
            painter = painterResource(id = R.drawable.ic_heart),
            contentDescription = "Favorite",
            tint = Color(0xFF6C44F4)
        )
    }
}
