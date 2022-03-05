package com.digitalamanmedia.bhumistar.persentation.authentication.vendor_auth

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.digitalamanmedia.bhumistar.R
import com.digitalamanmedia.bhumistar.core.Commons
import com.digitalamanmedia.bhumistar.persentation.authentication.components.CheckBoxes
import com.digitalamanmedia.bhumistar.persentation.authentication.components.OTPScreen
import com.digitalamanmedia.bhumistar.persentation.authentication.components.TransparentTextField
import kotlinx.coroutines.selects.select

@Composable
fun VendorAuth(onSubmitClick:()-> Unit) {
    var number by remember {
        mutableStateOf("")
    }
    val list = Commons.getRadioButtons()
    val (selectedOption, onOptionSelected) = remember {
        mutableStateOf(list[0])
    }
    var otp1 by remember {
        mutableStateOf("")
    }
    var otp2 by remember {
        mutableStateOf("")
    }
    val focusRequester = FocusRequester()
    var email by remember {
        mutableStateOf("")
    }
    var name by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }
    val darkTheme = isSystemInDarkTheme()
    var isLogin by remember {
        mutableStateOf(true)
    }
    var isPassword by remember {
        mutableStateOf(false)
    }
    var loginPasswordVisibility by remember {
        mutableStateOf(false)
    }

    val icon = if (loginPasswordVisibility){
        Icons.Default.VisibilityOff
    }else{
        Icons.Default.Visibility
    }
    val visibility =  if (loginPasswordVisibility){
        VisualTransformation.None
    }else{
        PasswordVisualTransformation()
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.surface),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        if (isLogin && !isPassword) {
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
                    text = "Vendor Login",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = MaterialTheme.colors.primaryVariant
                )
                Spacer(modifier = Modifier.padding(8.dp))

                TransparentTextField(
                    text = number,
                    hint = "Enter your number...",
                    leadingText = "+91",
                    onValueChanged = {
                        number = it
                    },
                    modifier = Modifier.fillMaxWidth(),
                    keyboardType = KeyboardType.NumberPassword,
                    onClickVerify = {}
                )
                Spacer(modifier = Modifier.padding(8.dp))
                TransparentTextField(
                    text = password,
                    hint = "Enter your password...",
                    painter = Icons.Default.VerifiedUser,
                    icon = icon,
                    onValueChanged = {
                        password = it
                    },
                    modifier = Modifier.fillMaxWidth(),
                    keyboardType = KeyboardType.Password,
                    visualTransformation = visibility,
                    onClickVerify = {
                        loginPasswordVisibility = !loginPasswordVisibility
                    }
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
                      modifier = Modifier.padding(vertical = 3.dp)
                          .clickable {
                              isLogin = false
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
                        modifier = Modifier.padding(vertical = 3.dp)
                            .clickable {
                                isPassword = true
                            }
                    )
                }

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
                        text = "Login",
                        color = MaterialTheme.colors.error,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 18.sp,
                        modifier = Modifier.padding(vertical = 3.dp)
                    )
                }
            }
        }
        if (isPassword) {
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
                    onValueChanged = {
                        number = it
                    },
                    modifier = Modifier.fillMaxWidth(),
                    keyboardType = KeyboardType.NumberPassword,
                    verify = "Get OTP",
                    onClickVerify = {}
                )
                Spacer(modifier = Modifier.padding(8.dp))
                OTPScreen(
                    code = otp1,
                    codeLength = 6,
                    focusRequester = focusRequester,
                    onValueChange = {
                        otp1 = it
                    },
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
                    onValueChanged = {
                        password = it
                    },
                    modifier = Modifier.fillMaxWidth(),
                    keyboardType = KeyboardType.NumberPassword,
                    visualTransformation = visibility,
                    onClickVerify = {
                        loginPasswordVisibility = !loginPasswordVisibility
                    }
                )
                Spacer(modifier = Modifier.padding(4.dp))
                Text(
                    text = "Click here to Login",
                    color = MaterialTheme.colors.error,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier
                        .padding(vertical = 3.dp)
                        .clickable {
                            isPassword = false
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
        if (!isLogin && !isPassword) {
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
                    onValueChanged = {
                        name = it
                    },
                    modifier = Modifier.fillMaxWidth(),
                    keyboardType = KeyboardType.Text,
                )
                Spacer(modifier = Modifier.padding(4.dp))

                TransparentTextField(
                    text = number,
                    hint = "Enter your number...",
                    leadingText = "+91",
                    onValueChanged = {
                        number = it
                    },
                    modifier = Modifier.fillMaxWidth(),
                    keyboardType = KeyboardType.NumberPassword,
                    verify = "Get OTP",
                )
                Spacer(modifier = Modifier.padding(8.dp))

                OTPScreen(
                    code = otp2,
                    codeLength = 6,
                    focusRequester = focusRequester,
                    onValueChange = {
                        otp2 = it
                    },
                    modifier = Modifier
                        .width(45.dp)
                        .height(55.dp),
                )
                Spacer(modifier = Modifier.padding(4.dp))

                TransparentTextField(
                    text = email,
                    hint = "Enter your email...",
                    painter = Icons.Default.Email,
                    onValueChanged = {
                        email = it
                    },
                    modifier = Modifier.fillMaxWidth(),
                    keyboardType = KeyboardType.Email,
                )
                Spacer(modifier = Modifier.padding(4.dp))
                TransparentTextField(
                    text = password,
                    hint = "Enter your password...",
                    painter = Icons.Default.VerifiedUser,
                    icon = icon,
                    onValueChanged = {
                        password = it
                    },
                    modifier = Modifier.fillMaxWidth(),
                    keyboardType = KeyboardType.Password,
                    visualTransformation = visibility,
                    onClickVerify = {
                        loginPasswordVisibility = !loginPasswordVisibility
                    }
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
                        modifier = Modifier.padding(vertical = 3.dp)
                            .clickable {
                                isLogin = true
                            }
                    )
                }
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
                        text = "Register",
                        color = MaterialTheme.colors.error,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 18.sp,
                        modifier = Modifier.padding(vertical = 3.dp)
                    )
                }
            }
        }


    }
}