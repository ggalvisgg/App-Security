package com.appsecurity.ui.component

import android.graphics.Color as AndroidColor
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@Composable
fun ButtonIcon(
    icon: ImageVector,
    text: String,
    onClick: () -> Unit,
    color: String,
    enable: Boolean
){
    Button (
        enabled = enable,
        colors = ButtonDefaults.buttonColors(Color(AndroidColor.parseColor(color))),
        onClick = onClick)
    {
        Icon(
            imageVector = icon,
            contentDescription = "Icono de inicio",
            modifier = Modifier
                .padding(3.dp)
        )
        Text(text = text)
    }
}