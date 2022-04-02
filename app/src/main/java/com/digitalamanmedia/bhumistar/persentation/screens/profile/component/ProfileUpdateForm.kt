package com.digitalamanmedia.bhumistar.persentation.screens.profile.component

import androidx.compose.animation.*
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Create
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.digitalamanmedia.bhumistar.core.components.CircleLoadingState
import com.digitalamanmedia.bhumistar.ui.theme.Bhumistar
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import com.digitalamanmedia.bhumistar.core.components.AnimatedButton

@Composable
fun ProfileUpdateForm(
    name:String,
    number:String,
    email:String,
    state:String,
    city:String,
    pinCode:String,
    password:String,
    cnfPassword:String,
    onNameChanged:(String)->Unit,
    onNumberChanged:(String)->Unit,
    onEmailChanged:(String)->Unit,
    onStateChanged:(String)->Unit,
    onCityChanged:(String)->Unit,
    onPinCodeChanged:(String)->Unit,
    onPasswordChanged:(String)->Unit,
    onCnfPasswordChanged:(String)->Unit,
    isEnable:Boolean,
    icon:ImageVector,
    isReadable:Boolean,
    visibility:VisualTransformation,
    onEditClick:()->Unit,
    onNameClear:()->Unit,
    onNumberClear:()->Unit,
    onEmailClear:()->Unit,
    onPinCodeClear:()->Unit,
    onPasswordIconToggle:()->Unit,
    onCnfPasswordIconToggle:()->Unit,
    expandedCity:Boolean,
    expandedState:Boolean,
    onStateDropDown:()->Unit,
    onCityDropDown:()->Unit,
    onStateItemClick:(String)->Unit,
    onCityItemClick:(String)->Unit,
    listCities: List<String>,
    listStates: List<String>,
    onSubmitClick:()->Unit,
    scrollStateDropDownState:ScrollState,
    scrollStateDropDownDistrict:ScrollState,
    trailingEnabled:Boolean,
    isLoading:Boolean,
    userLogin:()->Unit,
    isLogin:Boolean

) {
    val iconState = if (expandedState){
        Icons.Filled.KeyboardArrowUp
    }else{
        Icons.Filled.KeyboardArrowDown
    }
    val iconCity = if (expandedCity){
        Icons.Filled.KeyboardArrowUp
    }else{
        Icons.Filled.KeyboardArrowDown
    }

    Card(modifier = Modifier.fillMaxWidth()) {
        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(

                    text = "Your Profile",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = MaterialTheme.colors.primaryVariant
                )
                IconButton(
                    onClick = onEditClick
                ) {
                    Icon(imageVector = Icons.Outlined.Create,
                        contentDescription = "",
                        tint = Color.White,
                        modifier = Modifier
                            .clip(CircleShape)
                            .background(Bhumistar)
                            .padding(8.dp)
                    )
                }
            }
            Spacer(modifier = Modifier.height(8.dp))
            CustomTextField(
                value = name,
                isEnabled = isEnable,
                isRead = isReadable,
                onValueChanged = onNameChanged,
                onClearClick = onNameClear,
                trailingEnabled = trailingEnabled,
                hint = "Enter Your name",
            )

            Spacer(modifier = Modifier.height(16.dp))
            CustomTextField(
                value = number,
                isEnabled = isEnable,
                isRead = isReadable,
                onValueChanged = onNumberChanged,
                onClearClick = onNumberClear,
                trailingEnabled = trailingEnabled,
                hint = "Enter Your number",
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.NumberPassword
                )
            )

            Spacer(modifier = Modifier.height(16.dp))
            CustomTextField(
                value = email,
                isEnabled = isEnable,
                isRead = isReadable,
                onValueChanged = onEmailChanged,
                onClearClick = onEmailClear,
                trailingEnabled = trailingEnabled,
                hint = "Enter Your email",
            )

            Spacer(modifier = Modifier.height(16.dp))
            CustomTextField(
                hint = "Select your State",
                value = state,
                isEnabled = isEnable,
                isRead = isReadable,
                onValueChanged = onStateChanged,
                onClearClick = onStateDropDown,
                trailingEnabled = trailingEnabled,
                icon = iconState
            )
            AnimatedVisibility(
                visible = expandedState,
                enter = fadeIn() + slideInVertically(),
                exit = fadeOut() + slideOutVertically()
            ) {
                Dropdown(
                    onClickItems = onStateItemClick,
                    list = listStates,
                    scrollState = scrollStateDropDownState,
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            CustomTextField(
                hint = "Select your District",
                value = city,
                isEnabled = isEnable,
                isRead = isReadable,
                onValueChanged = onCityChanged,
                onClearClick = onCityDropDown,
                trailingEnabled = trailingEnabled,
                icon = iconCity
            )
            AnimatedVisibility(
                visible = expandedCity,
                enter = fadeIn() + slideInVertically(),
                exit = fadeOut() + slideOutVertically()
            ) {

                Dropdown(
                    onClickItems = onCityItemClick,
                    list = listCities,
                    scrollState = scrollStateDropDownDistrict,
                )
            }
            Spacer(modifier = Modifier.height(16.dp))

                CustomTextField(
                    value = pinCode,
                    isEnabled = isEnable,
                    isRead = isReadable,
                    onValueChanged = onPinCodeChanged,
                    onClearClick = onPinCodeClear,
                    hint = "Enter Your PinCode",
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Number
                    ),
                    trailingEnabled = trailingEnabled
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "Update password",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = MaterialTheme.colors.primaryVariant
                )
                Spacer(modifier = Modifier.height(16.dp))

                CustomTextField(
                    value = password,
                    isEnabled = isEnable,
                    isRead = isReadable,
                    onValueChanged = onPasswordChanged,
                    onClearClick = onPasswordIconToggle,
                    hint = "Enter new password",
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Number
                    ),
                    visualTransformation = visibility,
                    icon = icon,
                    trailingEnabled = trailingEnabled
                )
                Spacer(modifier = Modifier.height(16.dp))
                CustomTextField(
                    value = cnfPassword,
                    isEnabled = isEnable,
                    isRead = isReadable,
                    onValueChanged = onCnfPasswordChanged,
                    onClearClick = onCnfPasswordIconToggle,
                    hint = "Confirm Password",
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Number
                    ),
                    visualTransformation = visibility,
                    icon = icon,
                    trailingEnabled = trailingEnabled
                )
                Spacer(modifier = Modifier.height(16.dp))
            if (!isLogin) {
                Row(modifier = Modifier.fillMaxWidth()) {
                    Text(
                        text = "Login as User?",
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
                                userLogin()
                            }
                    )
                }
                Spacer(modifier = Modifier.height(16.dp))
            }else {

                AnimatedButton(
                    btnName = "Submit",
                    onSubmitClick = onSubmitClick,
                    isBtnLoading = isLoading,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(52.dp)
                )
            }


            }
    }
}