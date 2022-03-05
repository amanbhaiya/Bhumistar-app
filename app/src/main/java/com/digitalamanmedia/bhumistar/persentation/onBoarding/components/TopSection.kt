package com.digitalamanmedia.bhumistar.persentation.onBoarding.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.outlined.ArrowRight
import androidx.compose.material.icons.outlined.KeyboardArrowRight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun TopSection(
    onBackClick:()->Unit,
    onSkipClick:()->Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colors.surface),
    ) {
        OutlinedButton(
            onClick = onBackClick,
            modifier = Modifier
                .padding(12.dp)
                .align(Alignment.CenterStart),
            shape = CircleShape,
            border = BorderStroke(1.dp,MaterialTheme.colors.primaryVariant),
            colors = ButtonDefaults.outlinedButtonColors(backgroundColor =  MaterialTheme.colors.surface),

            ) {
           Icon(
               imageVector = Icons.Default.KeyboardArrowLeft,
               contentDescription ="",
               tint = MaterialTheme.colors.primaryVariant

           )
        }
        OutlinedButton(
            onClick = onSkipClick,
            modifier = Modifier
                .padding(12.dp)
                .align(Alignment.CenterEnd),
            shape = CircleShape,
            border = BorderStroke(1.dp,MaterialTheme.colors.primaryVariant),
            colors = ButtonDefaults.outlinedButtonColors(backgroundColor =  MaterialTheme.colors.surface),

        ){
            Text(
                text = "Skip",
                color = MaterialTheme.colors.primaryVariant,
                modifier = Modifier
                    .padding(start = 6.dp)
            )
            Icon(
                imageVector = Icons.Outlined.ArrowRight,
                contentDescription = "",
                tint = MaterialTheme.colors.primaryVariant
            )

        }

    }

}