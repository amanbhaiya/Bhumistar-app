package com.digitalamanmedia.bhumistar.persentation.authentication.user_auth.user_auth_screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.VerifiedUser
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.digitalamanmedia.bhumistar.R
import com.digitalamanmedia.bhumistar.persentation.authentication.components.OTPScreen
import com.digitalamanmedia.bhumistar.persentation.authentication.components.TransparentTextField


@Composable
fun ForgotPasswordScreen(
    darkTheme:Boolean,
    number:String,
    password:String,
    otp:String,
    focusRequester:FocusRequester,
    onNumberChanged:(String)->Unit,
    onPasswordChanged:(String)->Unit,
    onSubmitClick:()->Unit,
    onVerifyClick:()->Unit,
    onForgotPasswordVisibilityClick:()->Unit,
    onLoginTextClick:()->Unit,
    onOTPNumberChanged:(String)->Unit,
    icon: ImageVector,
    visibility: VisualTransformation = VisualTransformation.None
) {


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
                verify = "Get OTP",
                onClickVerify = onVerifyClick
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
            )
            Spacer(modifier = Modifier.padding(4.dp))
            TransparentTextField(
                text = password,
                hint = "Enter new password...",
                painter = Icons.Default.VerifiedUser,
                icon = icon,
                onValueChanged = onPasswordChanged,
                modifier = Modifier.fillMaxWidth(),
                keyboardType = KeyboardType.NumberPassword,
                visualTransformation = visibility,
                onClickVerify = onForgotPasswordVisibilityClick
            )
            Spacer(modifier = Modifier.padding(4.dp))
            Text(
                text = "Click here to Login",
                color = MaterialTheme.colors.error,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier
                    .padding(vertical = 3.dp)
                    .clickable {
                        onLoginTextClick()
                    }
            )

            Spacer(modifier = Modifier.padding(8.dp))
            OutlinedButton(
                modifier = Modifier
                    .fillMaxWidth(0.4f)
                    .padding(4.dp)
                    .align(Alignment.CenterHorizontally),
                onClick = onSubmitClick,
                border = BorderStroke(1.dp, MaterialTheme.colors.error),
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.outlinedButtonColors(
                    backgroundColor = Color.Transparent
                )

            ) {
                Text(
                    text = "Save",
                    color = MaterialTheme.colors.error,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 18.sp,
                    modifier = Modifier.padding(vertical = 3.dp)
                )
            }
        }

}