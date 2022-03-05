package com.digitalamanmedia.bhumistar.persentation.authentication.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PhoneLocked
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.digitalamanmedia.bhumistar.ui.theme.Bhumistar



@Composable
fun OTPScreen(
    codeLength: Int,
    code: String,
    onValueChange:(String)->Unit,
    focusRequester: FocusRequester,
    modifier: Modifier = Modifier
) {

    LaunchedEffect(Unit) {
        focusRequester.requestFocus()
    }

    Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
        BasicTextField(
            value = code,
            onValueChange = {
                if (it.length <= codeLength)
                {
                    onValueChange(it)
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .focusRequester(focusRequester = focusRequester),
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.NumberPassword),
            decorationBox = {
                CodeInputDecoration(code, codeLength,modifier)
            })
    }
}

@Composable
private fun CodeInputDecoration(code: String, length: Int,modifier: Modifier) {
    Box(
        modifier = Modifier
            .border(
                border = BorderStroke(1.dp, color = MaterialTheme.colors.primaryVariant),
                shape = RoundedCornerShape(12.dp)
            )
    ) {

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            for (i in 0 until length) {
                val text = if (i < code.length) code[i].toString() else ""
                CodeEntry(text,modifier)
            }

        }
        TextButton(
            onClick = { /*TODO*/ },
            modifier = Modifier.align(Alignment.CenterEnd)
        ) {
            Text(
                text = "Verify",
                color = Bhumistar,
                fontSize = 18.sp

            )
        }
    }
}

@Composable
private fun CodeEntry(
    text: String,
    modifier:Modifier
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            modifier = Modifier.padding(bottom = 5.dp),
            text = text,
            color = MaterialTheme.colors.primaryVariant,
            fontSize = 18.sp
        )
        Divider(
            modifier = Modifier
                .width(25.dp)
                .padding(bottom = 8.dp),
            color = Bhumistar,
            thickness = 1.dp
        )
    }
}