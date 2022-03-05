package com.digitalamanmedia.bhumistar.persentation.screens.profile.component

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.BaselineShift
import androidx.compose.ui.unit.dp


@Composable
fun ProfileTextField(
    value: String,
    hint: String = "",
    onValueChanged:(String)->Unit,
    isRead:Boolean = false,
    isEnabled:Boolean = true,
    onClearClick:()->Unit,
    icon: ImageVector = Icons.Filled.Clear,
    keyboardOptions: KeyboardOptions = KeyboardOptions(
        keyboardType = KeyboardType.Text
    )
) {
    TextField(
        value = value,
        singleLine = true,
        onValueChange = onValueChanged,
        colors = TextFieldDefaults.textFieldColors(
            cursorColor = MaterialTheme.colors.primaryVariant,
            textColor =  MaterialTheme.colors.primaryVariant,
            backgroundColor = Color.Transparent,
            focusedIndicatorColor = MaterialTheme.colors.primaryVariant,
            unfocusedIndicatorColor = MaterialTheme.colors.primaryVariant
        ),
        readOnly = isRead,
        enabled = isEnabled,
        modifier = Modifier
            .clip(RoundedCornerShape(12.dp))
            .border(1.5.dp, MaterialTheme.colors.primaryVariant, RoundedCornerShape(12.dp))
            .fillMaxWidth(),
        textStyle = LocalTextStyle.current.copy(
            baselineShift = BaselineShift.None
        ),
        trailingIcon = {
            IconButton(
                onClick = onClearClick
            ) {
                Icon(
                    imageVector = icon,
                    contentDescription = "Clear",
                    tint = MaterialTheme.colors.primaryVariant
                )
            }
        },
        placeholder = {
            Text(text = hint)
        },
        keyboardOptions = keyboardOptions

    )
}