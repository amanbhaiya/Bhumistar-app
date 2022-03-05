package com.digitalamanmedia.bhumistar.persentation.authentication.user_auth

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Person

import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.digitalamanmedia.bhumistar.R
import com.digitalamanmedia.bhumistar.persentation.authentication.Authentication
import com.digitalamanmedia.bhumistar.persentation.authentication.components.OTPScreen
import com.digitalamanmedia.bhumistar.persentation.authentication.components.TransparentTextField
import com.digitalamanmedia.bhumistar.persentation.authentication.user_auth.user_viewmodel.UserAuthViewModel
import com.digitalamanmedia.bhumistar.persentation.authentication.user_auth.user_viewmodel.UserUiEvent


@Composable
fun UserAuth(
    onSubmitClick:()->Unit,
    viewModel:UserAuthViewModel = hiltViewModel()
) {


    var number by remember {
        mutableStateOf("")
    }
    var otp by remember {
        mutableStateOf("")
    }
    val focusRequester = FocusRequester()
    var email by remember {
        mutableStateOf("")
    }
    var name by remember {
        mutableStateOf("")
    }
    val darkTheme = isSystemInDarkTheme()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.surface),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center

    ) {
        Column(modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.8f)
            .padding(start = 16.dp, end = 16.dp)

        ) {
            if (darkTheme){
                Image(
                    modifier = Modifier
                        .size(100.dp),
                    painter = painterResource(
                        id = R.drawable.night_logo),
                    contentDescription = "logo"
                )
            }else{
                Image(
                    modifier = Modifier
                        .size(100.dp),
                    painter = painterResource(
                        id = R.drawable.bhumistar),
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
                text = "User Registration",
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold,
                color = MaterialTheme.colors.primaryVariant
            )
            Spacer(modifier = Modifier.padding(8.dp))
            TransparentTextField(
                text = viewModel.state.value.phone_number,
                hint = "Enter your number...",
                leadingText = "+91",
                onValueChanged = {
                    viewModel.onUiEvent(UserUiEvent.EnterPhoneNumber(it))
                },
                modifier = Modifier.fillMaxWidth(),
                keyboardType = KeyboardType.Number,
                verify = "Get OTP",
                onClickVerify = {
                    viewModel.onUiEvent(UserUiEvent.GetOTP("+91"+viewModel.state.value.phone_number))
                }
            )
            Spacer(modifier = Modifier.padding(8.dp))

            OTPScreen(
                code = viewModel.state.value.number_OTP,
                codeLength = 6,
                focusRequester = focusRequester,
                onValueChange = {
                    viewModel.onUiEvent(UserUiEvent.EnterOTP(it))
                },
                modifier = Modifier
                    .width(45.dp)
                    .height(55.dp),
            )

            Spacer(modifier = Modifier.padding(4.dp))
            TransparentTextField(
                text = name,
                hint = "Enter your name...",
                painter = Icons.Default.Person,
                onValueChanged = {
                    name = it
                },
                modifier = Modifier.fillMaxWidth(),
                keyboardType = KeyboardType.Text,
            )
            Spacer(modifier = Modifier.padding(8.dp))
            TransparentTextField(
                text = email,
                hint = "Enter your email...",
                painter = Icons.Default.Email,
                onValueChanged = {
                    email= it
                },
                modifier = Modifier.fillMaxWidth(),
                keyboardType = KeyboardType.Email,
            )
        }
        OutlinedButton(
            modifier = Modifier.fillMaxWidth(0.4f),
            onClick = onSubmitClick,
            border = BorderStroke(1.dp, MaterialTheme.colors.error),
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.outlinedButtonColors(
                backgroundColor = Color.Transparent
            )
        ) {
            Text(
                text = "Register",
                color = MaterialTheme.colors.error,
                fontWeight = FontWeight.SemiBold,
                fontSize = 18.sp,
                modifier = Modifier.padding(vertical = 3.dp)
            )
        }
    }
}