package com.appsecurity.ui.user.tabs

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.appsecurity.R

@Composable
fun HomeUserTab(){

    Text(
        text = "HOME, EL MAPA"
    )

    Image(
        bitmap = ImageBitmap.imageResource(id = R.drawable.mapa),
        contentDescription = stringResource(id = R.string.textIconApp),
        modifier = Modifier
            .height(300.dp)
            .width(600.dp)
    )

}