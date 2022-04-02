package com.digitalamanmedia.bhumistar.persentation.authentication.vendor_auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.VerifiedUser
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.digitalamanmedia.bhumistar.R
import com.digitalamanmedia.bhumistar.core.components.AnimatedButton
import com.digitalamanmedia.bhumistar.persentation.authentication.components.CheckBoxes
import com.digitalamanmedia.bhumistar.persentation.authentication.components.OTPScreen
import com.digitalamanmedia.bhumistar.persentation.authentication.components.TransparentTextField


@Composable
fun VendorRegisterScreen(
    darkTheme:Boolean,
    number:String,
    password:String,
    otp:String,
    name:String,
    email:String,
    focusRequester: FocusRequester,
    onNumberChanged:(String)->Unit,
    onNameChanged:(String)->Unit,
    onEmailChanged:(String)->Unit,
    onPasswordChanged:(String)->Unit,
    onOTPNumberChanged:(String)->Unit,
    list:List<String>,
    selectedOption:String,
    onOptionSelected:(String)->Unit,
    icon:ImageVector,
    visibility:VisualTransformation,
    togglePassword:()->Unit,
    onLoginClick:()->Unit,
    onSubmitClick:()->Unit,
    btmEnabled:Boolean,
    isBtnLoading:Boolean,
    isRegisterTextLoading:Boolean,
    getOTP:()->Unit,
    verifyOTP:()->Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 16.dp, end = 16.dp),


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
            text = "Vendor Registration",
            fontSize = 20.sp,
            fontWeight = FontWeight.SemiBold,
            color = MaterialTheme.colors.primaryVariant
        )
        Spacer(modifier = Modifier.padding(4.dp))

        CheckBoxes(
            list = list,
            selectedOption = selectedOption,
            onOptionSelected = onOptionSelected
        )
        Spacer(modifier = Modifier.padding(4.dp))
        TransparentTextField(
            text = name,
            hint = "Enter your name...",
            painter = Icons.Default.Person,
            onValueChanged = onNameChanged,
            modifier = Modifier.fillMaxWidth(),
            keyboardType = KeyboardType.Text,
        )
        Spacer(modifier = Modifier.padding(4.dp))

        TransparentTextField(
            text = number,
            hint = "Enter your number...",
            leadingText = "+91",
            onValueChanged = onNumberChanged,
            modifier = Modifier.fillMaxWidth(),
            keyboardType = KeyboardType.NumberPassword,
            verify = "Get OTP",
            isTextLoading = isRegisterTextLoading,
            onClickVerify = getOTP
        )
        Spacer(modifier = Modifier.padding(8.dp))

        OTPScreen(
            code = otp,
            codeLength = 6,
            focusRequester = focusRequester,
            onValueChange = onOTPNumberChanged,
            modifier = Modifier
                .width(45.dp)
                .height(55.dp),
            onVerifyClick = verifyOTP
        )
        Spacer(modifier = Modifier.padding(4.dp))

        TransparentTextField(
            text = email,
            hint = "Enter your email...",
            painter = Icons.Default.Email,
            onValueChanged = onEmailChanged,
            modifier = Modifier.fillMaxWidth(),
            keyboardType = KeyboardType.Email,
        )
        Spacer(modifier = Modifier.padding(4.dp))
        TransparentTextField(
            text = password,
            hint = "Enter your password...",
            painter = Icons.Default.VerifiedUser,
            icon = icon,
            onValueChanged = onPasswordChanged,
            modifier = Modifier.fillMaxWidth(),
            keyboardType = KeyboardType.Password,
            visualTransformation = visibility,
            onClickVerify = togglePassword
        )
        Spacer(modifier = Modifier.padding(4.dp))
        Row(modifier = Modifier.fillMaxWidth()) {
            Text(
                text = "Already register?",
                color = MaterialTheme.colors.primaryVariant,
                modifier = Modifier.padding(vertical = 3.dp)

            )
            Spacer(modifier = Modifier.padding(4.dp))
            Text(
                text = "Click here",
                color = MaterialTheme.colors.error,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier
                    .padding(vertical = 3.dp)
                    .clickable {
                        onLoginClick()
                    }
            )
        }
        Spacer(modifier = Modifier.padding(8.dp))
        AnimatedButton(
            btnName = "Register",
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