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
fun FuelEntryScreen(
    onBackClick: () -> Unit,
    onSaveClick: () -> Unit
) {
    // Campos vacíos al inicio (puedes cambiar a valores iniciales si quieres)
    var date by remember { mutableStateOf("") }
    var fuelQuantity by remember { mutableStateOf("") }
    var totalCost by remember { mutableStateOf("") }
    var mileage by remember { mutableStateOf("") }
    var selectedVehicle by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFEAEFFF))
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(24.dp))

        // Título
        Text(
            text = "Abastecimiento combustible",
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF6C44F4)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Fecha
        OutlinedTextField(
            value = date,
            onValueChange = { date = it },
            label = { Text("Fecha") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(12.dp))

        // Cantidad de combustible, Galones
        OutlinedTextField(
            value = fuelQuantity,
            onValueChange = { fuelQuantity = it },
            label = { Text("Cantidad de combustible, Galones") },
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

        // Kilometraje actual
        OutlinedTextField(
            value = mileage,
            onValueChange = { mileage = it },
            label = { Text("Kilometraje actual") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Seleccione el vehículo",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF6C44F4)
        )

        Spacer(modifier = Modifier.height(4.dp))

        OutlinedTextField(
            value = selectedVehicle,
            onValueChange = { selectedVehicle = it },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Botones inferior
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
