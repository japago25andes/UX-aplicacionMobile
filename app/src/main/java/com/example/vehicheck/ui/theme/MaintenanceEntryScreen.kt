package com.example.vehicheck.ui.theme

import androidx.compose.foundation.background
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
fun MaintenanceEntryScreen(
    onBackClick: () -> Unit,
    onSaveClick: () -> Unit
) {
    // Variables de estado para los campos
    var selectedVehicle by remember { mutableStateOf("") }
    var maintenanceType by remember { mutableStateOf("") }
    var subType by remember { mutableStateOf("") }
    var detailTitle by remember { mutableStateOf("") }
    var totalCost by remember { mutableStateOf("") }
    var dateTime by remember { mutableStateOf("") }

    // UI
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFEAEFFF))
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "Crear mantenimiento",
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF6C44F4)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Seleccione el vehículo
        OutlinedTextField(
            value = selectedVehicle,
            onValueChange = { selectedVehicle = it },
            label = { Text("Seleccione el vehículo") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(12.dp))

        // Tipo
        OutlinedTextField(
            value = maintenanceType,
            onValueChange = { maintenanceType = it },
            label = { Text("Tipo") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(12.dp))

        // Subtipo
        OutlinedTextField(
            value = subType,
            onValueChange = { subType = it },
            label = { Text("Subtipo") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(12.dp))

        // Detalle / Título
        OutlinedTextField(
            value = detailTitle,
            onValueChange = { detailTitle = it },
            label = { Text("Detalle") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(12.dp))

        // Costo total
        OutlinedTextField(
            value = totalCost,
            onValueChange = { totalCost = it },
            label = { Text("Costo total") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(12.dp))

        // Fecha y hora
        OutlinedTextField(
            value = dateTime,
            onValueChange = { dateTime = it },
            label = { Text("Fecha y hora") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Botones
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(
                onClick = { onBackClick() },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF6C44F4)),
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier
                    .weight(1f)
                    .padding(end = 8.dp)
            ) {
                Text("REGRESAR", color = Color.White, fontSize = 18.sp)
            }

            Button(
                onClick = { onSaveClick() },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF6C44F4)),
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 8.dp)
            ) {
                Text("GUARDAR", color = Color.White, fontSize = 18.sp)
            }
        }
    }
}
