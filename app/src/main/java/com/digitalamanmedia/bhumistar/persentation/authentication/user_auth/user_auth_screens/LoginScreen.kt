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
fun LoginScreen(
    darkTheme:Boolean,
    email:String,
    password:String,
    onEmailChanged:(String)->Unit,
    onPasswordChanged:(String)->Unit,
    onSubmitClick:()->Unit,
    onLoginPasswordVisibilityClick:()->Unit,
    onForgotTextClick:()->Unit,
    onRegisterTextClick:()->Unit,
    icon:ImageVector,
    visibility: VisualTransformation = VisualTransformation.None,
    btmEnabled:Boolean = false,
    isBtnLoading:Boolean
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
            text = "User Login",
            fontSize = 20.sp,
            fontWeight = FontWeight.SemiBold,
            color = MaterialTheme.colors.primaryVariant
        )
        Spacer(modifier = Modifier.padding(8.dp))

        TransparentTextField(
            text = email,
            hint = "Enter your Email...",
            painter = Icons.Default.Person,
            onValueChanged = onEmailChanged,
            modifier = Modifier.fillMaxWidth(),
            keyboardType = KeyboardType.Text,
        )
        Spacer(modifier = Modifier.padding(8.dp))
        TransparentTextField(
            text = password,
            hint = "Enter your password...",
            painter = Icons.Default.VerifiedUser,
            icon = icon,
            onValueChanged = onPasswordChanged,
            modifier = Modifier.fillMaxWidth(),
            keyboardType = KeyboardType.Text,
            visualTransformation = visibility,
            onClickVerify = onLoginPasswordVisibilityClick
        )
        Spacer(modifier = Modifier.padding(8.dp))
        Row(modifier = Modifier.fillMaxWidth()) {
            Text(
                text = "Don't have an account?",
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
                        onRegisterTextClick()
                    }
            )
        }
        Spacer(modifier = Modifier.padding(4.dp))
        Row(modifier = Modifier.fillMaxWidth()) {
            Text(
                text = "Forgot password?",
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
                        onForgotTextClick()
                    }
            )
        }

        Spacer(modifier = Modifier.padding(8.dp))
        AnimatedButton(
            btnName = "Login",
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
