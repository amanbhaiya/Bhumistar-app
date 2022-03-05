package com.digitalamanmedia.bhumistar.persentation.authentication.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.RadioButton
import androidx.compose.material.RadioButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.digitalamanmedia.bhumistar.ui.theme.Bhumistar

@Composable
fun CheckBox(
    text: String,
    selected: Boolean,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .height(32.dp)
            .border(
                border = BorderStroke(
                    1.dp,
                    MaterialTheme.colors.primaryVariant
                ),
                shape = RoundedCornerShape(50)),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        RadioButton(

            selected = selected,
            onClick = onClick,
            colors = RadioButtonDefaults.colors(
                selectedColor = Bhumistar,
                unselectedColor = MaterialTheme.colors.primaryVariant
            )
        )
        Text(
            modifier = Modifier.padding(end = 16.dp),
            text = text,
            color = MaterialTheme.colors.primaryVariant,


        )
    }
}