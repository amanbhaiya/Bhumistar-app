package com.digitalamanmedia.bhumistar.persentation.authentication.components


import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation


import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.digitalamanmedia.bhumistar.ui.theme.Bhumistar



@Composable
fun TransparentTextField(
    text: String,
    onClickVerify:()->Unit = {},
    hint: String = "",
    modifier: Modifier = Modifier,
    leadingText: String = "",
    onValueChanged: (String)-> Unit,
    painter: ImageVector? = null,
    keyboardType: KeyboardType,
    verify: String = "",
    visualTransformation: VisualTransformation = VisualTransformation.None,
    icon:ImageVector? = null

) {
    Box(modifier = modifier) {
        OutlinedTextField(
            value = text,
            onValueChange = onValueChanged,
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth(),
            shape = RoundedCornerShape(12.dp),
            keyboardOptions = KeyboardOptions(
                keyboardType = keyboardType
            ),

            label = {
                Text(
                    text = hint,

                )
            },
            leadingIcon = {
                Text(
                    text = leadingText,
                    fontSize = 18.sp,
                    color = Bhumistar
                )
                if (painter != null) {
                    Icon(
                        imageVector = painter,
                        contentDescription = "",
                        tint = MaterialTheme.colors.primaryVariant
                    )
                }
            },
            visualTransformation = visualTransformation,
            textStyle = LocalTextStyle.current.copy(

                fontSize = 18.sp

                ),
            trailingIcon = {
                IconButton(
                    onClick = onClickVerify
                ) {
                    if (icon != null) {
                        Icon(
                            imageVector = icon,
                            contentDescription = "icon",
                            tint = MaterialTheme.colors.primaryVariant
                        )
                    }
                }
                TextButton(
                    onClick = onClickVerify,

                ) {
                    Text(
                        text = verify,
                        color = Bhumistar,
                        fontSize = 18.sp

                    )
                }
            },
            colors = TextFieldDefaults.outlinedTextFieldColors(
               cursorColor = MaterialTheme.colors.primaryVariant,
               focusedBorderColor = MaterialTheme.colors.primaryVariant,
               unfocusedBorderColor = MaterialTheme.colors.primaryVariant,
               focusedLabelColor = MaterialTheme.colors.primaryVariant
           )
        )




    }
}