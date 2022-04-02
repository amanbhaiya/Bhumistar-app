package com.digitalamanmedia.bhumistar.persentation.authentication.user_auth.user_auth_screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
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
fun ForgotPasswordScreen(
    darkTheme:Boolean,
    email:String,
    password:String,
    cnfPassword:String,
    onEmailChanged:(String)->Unit,
    onPasswordChanged:(String)->Unit,
    onSubmitClick:()->Unit,
    onClickVerify:()->Unit,
    onForgotPasswordVisibilityClick:()->Unit,
    onLoginTextClick:()->Unit,
    onCnfNumberChanged:(String)->Unit,
    icon: ImageVector,
    visibility: VisualTransformation = VisualTransformation.None,
    btmEnabled:Boolean = false,
    isBtnLoading:Boolean,
    isTextLoading:Boolean
) {


        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 16.dp, end = 16.dp)
                .background(MaterialTheme.colors.surface)
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
                text = email,
                painter = Icons.Default.Person,
                hint = "Enter your registered email...",
                onValueChanged = onEmailChanged,
                modifier = Modifier.fillMaxWidth(),
                keyboardType = KeyboardType.Email,
                verify = "Verify",
                onClickVerify = onClickVerify,
                isTextLoading = isTextLoading
            )
            Spacer(modifier = Modifier.padding(8.dp))
            TransparentTextField(
                text = cnfPassword,
                hint = "Enter new password...",
                painter = Icons.Default.VerifiedUser,
                icon = icon,
                onValueChanged = onCnfNumberChanged,
                modifier = Modifier.fillMaxWidth(),
                keyboardType = KeyboardType.Password,
                visualTransformation = visibility,
                onClickVerify = onForgotPasswordVisibilityClick
            )
            Spacer(modifier = Modifier.padding(4.dp))
            TransparentTextField(
                text = password,
                hint = "Confirm password...",
                painter = Icons.Default.VerifiedUser,
                icon = icon,
                onValueChanged = onPasswordChanged,
                modifier = Modifier.fillMaxWidth(),
                keyboardType = KeyboardType.Password,
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

            AnimatedButton(
                btnName = "Submit",
                onSubmitClick = onSubmitClick,
                isBtnLoading = isBtnLoading,
                modifier = Modifier
                    .fillMaxWidth(0.4f)
                    .height(52.dp)
                    .align(Alignment.CenterHorizontally),
                btmEnabled = btmEnabled
            )
        }

}