package com.digitalamanmedia.bhumistar.persentation.screens.profile


import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons

import androidx.compose.material.icons.outlined.*
import androidx.compose.runtime.*

import androidx.compose.ui.Alignment

import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Green

import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType

import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import com.digitalamanmedia.bhumistar.R
import com.digitalamanmedia.bhumistar.core.Commons
import com.digitalamanmedia.bhumistar.persentation.screens.profile.component.Dropdown
import com.digitalamanmedia.bhumistar.persentation.screens.profile.component.ProfileTextField
import com.digitalamanmedia.bhumistar.persentation.screens.profile.utils.GetDistrict
import com.digitalamanmedia.bhumistar.persentation.screens.profile.utils.StateAndDistrict
import com.digitalamanmedia.bhumistar.ui.theme.Bhumistar
import com.digitalamanmedia.bhumistar.ui.theme.YellowP

@Composable
fun ProfileScreen() {
    val scrollState = rememberScrollState()
    val scrollStateDropDownState = rememberScrollState()
    val scrollStateDropDownDistrict = rememberScrollState()
    var states by remember {
        mutableStateOf("")
    }
    var cities by remember {
        mutableStateOf("")
    }
    var pinCode by remember {
        mutableStateOf("")
    }
    var name by remember {
        mutableStateOf("Bhumistar")
    }
    var number by remember {
        mutableStateOf("9089475635")
    }
    var email by remember {
        mutableStateOf("bhumistar@gmail.com")
    }
    var isReadable by remember {
        mutableStateOf(true)
    }
    var isEnable by remember {
        mutableStateOf(false)
    }
    var expandedState by remember {
        mutableStateOf(false)
    }
    var expandedCity by remember {
        mutableStateOf(false)
    }




    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(12.dp)
            .verticalScroll(scrollState)
    ) {

        Card(modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.1f),){

           Row(modifier = Modifier
               .fillMaxSize()
               .padding(horizontal = 16.dp, vertical = 16.dp),
               verticalAlignment = Alignment.CenterVertically
           ) {
               Image(
                   painter = painterResource(id = R.drawable.bhumistarjpg),
                   contentDescription ="",
                   modifier = Modifier
                       .clip(CircleShape)
                       .fillMaxHeight()
                       .fillMaxWidth(0.2f)
               )

               Column(
                   modifier = Modifier
                       .fillMaxWidth(0.8f)
                       .fillMaxHeight()
                       .padding(horizontal = 16.dp, vertical = 8.dp),
                   verticalArrangement = Arrangement.Center
               ) {
                   Text(
                       modifier = Modifier
                           .fillMaxWidth()
                           .clickable {

                           },
                       text = "Bhumistar",
                       fontSize = 17.sp,
                       fontWeight = FontWeight.SemiBold,
                       color = MaterialTheme.colors.error
                   )
                   Text(
                       modifier = Modifier
                           .fillMaxWidth()
                           .clickable {

                           },
                       text = "bhumistar@gmail.com",
                       fontSize = 14.sp,
                       color = MaterialTheme.colors.primaryVariant
                   )

               }


           }
       }
        Spacer(modifier = Modifier.height(25.dp))

        Card(modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.06f),){

            Row(modifier = Modifier
                .fillMaxSize(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(modifier = Modifier
                    .fillMaxWidth(0.8F)
                    .fillMaxHeight()
                    .padding(horizontal = 16.dp, vertical = 8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Outlined.Phone,
                        contentDescription = "",
                        tint = Color.White,
                        modifier = Modifier
                            .clip(CircleShape)
                            .background(Bhumistar)
                            .padding(8.dp)
                    )
                    Text(
                        modifier = Modifier
                            .padding(start = 16.dp)
                            .clickable {

                            },
                        text = "Contact Us",
                        fontSize = 18.sp,
                        color = MaterialTheme.colors.primaryVariant
                    )
                }
                Box(modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .padding(horizontal = 16.dp, vertical = 8.dp),
                    contentAlignment = Alignment.CenterEnd
                ) {
                    IconButton(
                        onClick = { },
                        modifier = Modifier
                            .padding(8.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Outlined.KeyboardArrowRight,
                            contentDescription = "text",
                            tint = MaterialTheme.colors.error
                        )

                    }
                }
            }
        }
        Spacer(modifier = Modifier.height(3.dp))

        Card(modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.06f),){

            Row(modifier = Modifier
                .fillMaxSize(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(modifier = Modifier
                    .fillMaxWidth(0.8F)
                    .fillMaxHeight()
                    .padding(horizontal = 16.dp, vertical = 8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Outlined.Info,
                        contentDescription = "",
                        tint = Color.White,
                        modifier = Modifier
                            .clip(CircleShape)
                            .background(Green)
                            .padding(8.dp)
                    )
                    Text(
                        modifier = Modifier
                            .padding(start = 16.dp)
                            .clickable {

                            },
                        text = "Term of use",
                        fontSize = 18.sp,
                        color = MaterialTheme.colors.primaryVariant
                    )
                }
                Box(modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .padding(horizontal = 16.dp, vertical = 8.dp),
                    contentAlignment = Alignment.CenterEnd
                ) {
                    IconButton(
                        onClick = { },
                        modifier = Modifier
                            .padding(8.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Outlined.KeyboardArrowRight,
                            contentDescription = "text",
                            tint = MaterialTheme.colors.error
                        )

                    }
                }
            }
        }
        Spacer(modifier = Modifier.height(3.dp))

        Card(modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.06f),){

            Row(modifier = Modifier
                .fillMaxSize(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(modifier = Modifier
                    .fillMaxWidth(0.8F)
                    .fillMaxHeight()
                    .padding(horizontal = 16.dp, vertical = 8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Outlined.Lock,
                        contentDescription = "",
                        tint = Color.White,
                        modifier = Modifier
                            .clip(CircleShape)
                            .background(YellowP)
                            .padding(8.dp)
                    )
                    Text(
                        modifier = Modifier
                            .padding(start = 16.dp)
                            .clickable {

                            },
                        text = "Privacy policy",
                        fontSize = 18.sp,
                        color = MaterialTheme.colors.primaryVariant
                    )
                }
                Box(modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .padding(horizontal = 16.dp, vertical = 8.dp),
                    contentAlignment = Alignment.CenterEnd
                ) {
                    IconButton(
                        onClick = { },
                        modifier = Modifier
                            .padding(8.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Outlined.KeyboardArrowRight,
                            contentDescription = "text",
                            tint = MaterialTheme.colors.error
                        )

                    }
                }
            }
        }
        Spacer(modifier = Modifier.height(25.dp))

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
                       onClick = {
                           isEnable = true
                           isReadable = false
                       }
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
                ProfileTextField(
                    value = name,
                    isEnabled = isEnable,
                    isRead = isReadable,
                    onValueChanged = {
                        name = it
                    },
                    onClearClick = {
                        name = ""
                    }
                )

                Spacer(modifier = Modifier.height(16.dp))
                ProfileTextField(
                    value = number,
                    isEnabled = isEnable,
                    isRead = isReadable,
                    onValueChanged = {
                        number = it
                    },
                    onClearClick = {
                        number = ""
                    }
                )

                Spacer(modifier = Modifier.height(16.dp))
                ProfileTextField(
                    value = email,
                    isEnabled = isEnable,
                    isRead = isReadable,
                    onValueChanged = {
                        email = it
                    },
                    onClearClick = {
                    }
                )

                Spacer(modifier = Modifier.height(16.dp))
                Dropdown(
                    hint = "Select your State",
                    value = states,
                    expanded = expandedState,
                    onValueChanged = {
                        states = it
                    },
                    onDropDownClick = {
                        expandedState = !expandedState
                    },

                    onClickItems = {state->
                        if (state != states){
                            states = ""
                            states = state
                            cities = ""
                        }

                        expandedState = false
                    },
                    list = StateAndDistrict.getState(),
                    scrollState = scrollStateDropDownState
                )

                Dropdown(
                    hint = "Select your District",
                    value = cities,
                    expanded = expandedCity,
                    onValueChanged = {
                        cities = it
                    },
                    onDropDownClick = {
                        expandedCity = !expandedCity
                    },

                    onClickItems = {city->
                        cities = ""
                        cities = city
                        expandedCity = false
                    },
                    list = GetDistrict.getDistrict(states),
                    scrollState = scrollStateDropDownDistrict
                )

                ProfileTextField(
                    value = pinCode,
                    onValueChanged = {
                        pinCode = it
                    },
                    onClearClick = {
                        pinCode = ""
                    },
                    hint = "Enter Your PinCode",
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Number
                    )
                )

                Spacer(modifier = Modifier.height(16.dp))
                OutlinedButton(
                    modifier = Modifier.fillMaxWidth(),
                    onClick ={
                        isEnable = false
                        isReadable = true
                    },
                    border = BorderStroke(1.dp, MaterialTheme.colors.error),
                    shape = RoundedCornerShape(12.dp),
                    colors = ButtonDefaults.outlinedButtonColors(
                        backgroundColor = Color.Transparent
                    )
                ) {
                    Text(
                        text = "Submit",
                        color = MaterialTheme.colors.error,
                        fontWeight = FontWeight.SemiBold,
                        modifier = Modifier.padding(3.dp),
                        fontSize = 17.sp
                    )
                }

            }
        }
        Spacer(modifier = Modifier.height(80.dp))
    }

}

