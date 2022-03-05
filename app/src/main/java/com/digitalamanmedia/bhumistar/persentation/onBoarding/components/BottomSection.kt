package com.digitalamanmedia.bhumistar.persentation.onBoarding.components

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@Composable
fun BottomSection(onClickNext:()->Unit,size:Int,index:Int) {
    val darkTheme = isSystemInDarkTheme()
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colors.surface),

    ) {
        Indicators(size = size, index = index)

        FloatingActionButton(
            onClick = onClickNext,
            modifier = Modifier
                .padding(12.dp)
                .align(Alignment.CenterEnd),
            backgroundColor = MaterialTheme.colors.error,
        ) {
            Icon(
                imageVector = Icons.Default.KeyboardArrowRight,
                contentDescription = "",
                tint = MaterialTheme.colors.surface
            )
        }

    }

}