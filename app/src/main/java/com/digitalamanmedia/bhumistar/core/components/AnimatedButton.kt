package com.digitalamanmedia.bhumistar.core.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun AnimatedButton(
    btnName:String,
    modifier: Modifier = Modifier,
    onSubmitClick:()->Unit,
    isBtnLoading:Boolean,
    btmEnabled:Boolean = true
) {
    OutlinedButton(
        modifier = modifier,
        onClick = onSubmitClick,
        border = BorderStroke(1.dp, MaterialTheme.colors.error),
        shape = RoundedCornerShape(12.dp),
        enabled = btmEnabled,
        colors = ButtonDefaults.outlinedButtonColors(
            backgroundColor = Color.Transparent
        )
    ) {
        Box (
            modifier = Modifier.fillMaxSize()
        ) {
            if (isBtnLoading) {
               LoadingState(
                   modifier = Modifier
                       .align(Alignment.Center)
               )
            } else {
                Text(
                    text = btnName,
                    color = MaterialTheme.colors.error,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 18.sp,
                    modifier = Modifier
                        .padding(vertical = 3.dp)
                        .align(Alignment.Center)
                )
            }
        }
    }

}