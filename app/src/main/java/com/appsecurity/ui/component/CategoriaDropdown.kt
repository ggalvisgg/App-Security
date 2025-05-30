package com.appsecurity.ui.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.appsecurity.model.CategoriaReporte

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CategoriaDropdown(
    categoriaSeleccionada: CategoriaReporte,
    onCategoriaSeleccionada: (CategoriaReporte) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }
    val categorias = CategoriaReporte.values()

    Column (modifier = Modifier.fillMaxWidth().padding(horizontal = 60.dp)) {

        ExposedDropdownMenuBox(
            expanded = expanded,
            onExpandedChange = { expanded = !expanded }
        ) {
            OutlinedTextField(
                value = categoriaSeleccionada.displayName, // Usamos displayName para mostrarlo bonito
                onValueChange = {},
                readOnly = true,
                label = { Text("Selecciona una categoría") },
                trailingIcon = {
                    ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded)
                },
                modifier = Modifier
                    .menuAnchor() // Necesario para que funcione con ExposedDropdownMenu
                    .fillMaxWidth()
            )

            ExposedDropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                categorias.forEach { categoria ->
                    DropdownMenuItem(
                        text = { Text(categoria.displayName) },
                        onClick = {
                            onCategoriaSeleccionada(categoria)
                            expanded = false
                        }
                    )
                }
            }
        }
    }
}