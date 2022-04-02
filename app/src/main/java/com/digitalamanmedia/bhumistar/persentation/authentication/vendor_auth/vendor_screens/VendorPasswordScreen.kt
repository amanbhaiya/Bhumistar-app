package com.digitalamanmedia.bhumistar.persentation.authentication.vendor_auth.vendor_screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.VerifiedUser
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.digitalamanmedia.bhumistar.R
import com.digitalamanmedia.bhumistar.core.components.AnimatedButton
import com.digitalamanmedia.bhumistar.persentation.authentication.components.TransparentTextField


@Composable
fun VendorPasswordScreen(
    darkTheme:Boolean,
    number:String,
    password:String,
    cnfPassword:String,
    onNumberChanged:(String)->Unit,
    onPasswordChanged:(String)->Unit,
    onCnfPasswordChanged:(String)->Unit,
    onVerifyNumber:()->Unit,
    icon:ImageVector,
    visibility:VisualTransformation,
    togglePassword:()->Unit,
    onLoginClick:()->Unit,
    onSubmitClick:()->Unit,
    isBtnLoading:Boolean,
    btmEnabled:Boolean,
    isPasswordTextLoading:Boolean
){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 16.dp, end = 16.dp)
    ) {

        if (darkTheme) {
            Image(
                modifier = Modifier
                    .size(100.dp),
                painter = painterResource(
                    id = R.drawable.night_logo
                ),
                contentDescription = "logo"
            )
        } else {
            Image(
                modifier = Modifier
                    .size(100.dp),
                painter = painterResource(
                    id = R.drawable.bhumistar
                ),
                contentDescription = "logo"
            )
        }
        Text(
            text = "Welcome to Bhumistar",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colors.primaryVariant
        )
        Spacer(modifier = Modifier.padding(4.dp))
        Text(
            text = "Forgot Password",
            fontSize = 20.sp,
            fontWeight = FontWeight.SemiBold,
            color = MaterialTheme.colors.primaryVariant
        )
        Spacer(modifier = Modifier.padding(8.dp))

        TransparentTextField(
            text = number,
            hint = "Enter your number...",
            leadingText = "+91",
            onValueChanged = onNumberChanged,
            modifier = Modifier.fillMaxWidth(),
            keyboardType = KeyboardType.NumberPassword,
            verify = "Verify",
            onClickVerify = onVerifyNumber,
            isTextLoading = isPasswordTextLoading
        )
        Spacer(modifier = Modifier.padding(4.dp))
        TransparentTextField(
            text = password,
            hint = "Enter new password...",
            painter = Icons.Default.VerifiedUser,
            icon = icon,
            onValueChanged = onPasswordChanged,
            modifier = Modifier.fillMaxWidth(),
            keyboardType = KeyboardType.Text,
            visualTransformation = visibility,
            onClickVerify = togglePassword
        )
        Spacer(modifier = Modifier.padding(4.dp))

        TransparentTextField(
            text = cnfPassword,
            hint = "Confirm password...",
            painter = Icons.Default.VerifiedUser,
            icon = icon,
            onValueChanged = onCnfPasswordChanged,
            modifier = Modifier.fillMaxWidth(),
            keyboardType = KeyboardType.Text,
            visualTransformation = visibility,
            onClickVerify = togglePassword
        )
        Spacer(modifier = Modifier.padding(4.dp))
        Text(
            text = "Click here to Login",
            color = MaterialTheme.colors.error,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier
                .padding(vertical = 3.dp)
                .clickable {
                    onLoginClick()
                }
        )

        Spacer(modifier = Modifier.padding(8.dp))
        AnimatedButton(
            btnName = "Submit",
            onSubmitClick = onSubmitClick,
            isBtnLoading = isBtnLoading,
            btmEnabled = btmEnabled,
            modifier = Modifier
                .fillMaxWidth(0.4f)
                .height(52.dp)
                .align(Alignment.CenterHorizontally)
        )
    }
}