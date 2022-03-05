package com.digitalamanmedia.bhumistar.persentation.authentication.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.digitalamanmedia.bhumistar.core.Commons


@Composable
fun CheckBoxes(list: List<String>,selectedOption:String,onOptionSelected:(String)->Unit) {

    Row(
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        list.forEach {
            CheckBox(
                text = "Owner",
                selected = (it == selectedOption),
                onClick = {onOptionSelected(it)}
            )
        }

    }
}