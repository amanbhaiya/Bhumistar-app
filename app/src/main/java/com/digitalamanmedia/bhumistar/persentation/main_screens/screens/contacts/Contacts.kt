package com.digitalamanmedia.bhumistar.persentation.main_screens.screens.contacts

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.digitalamanmedia.bhumistar.R
import com.digitalamanmedia.bhumistar.persentation.main_screens.screens.contacts.view_model.ContactsUiEvent
import com.digitalamanmedia.bhumistar.persentation.main_screens.screens.contacts.view_model.ContactsViewModel
import com.digitalamanmedia.bhumistar.persentation.screens.profile.component.CustomTextField

@Composable
fun ContactScreen(
    viewModel: ContactsViewModel = hiltViewModel()
) {
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .verticalScroll(scrollState)
            .padding(horizontal = 16.dp, vertical = 16.dp),
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth(),
        ) {
            Column(modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            ) {
                Text(
                    text = stringResource(id = R.string.Contacts),
                    fontSize = 22.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = MaterialTheme.colors.error
                )
                Spacer(modifier = Modifier.padding(vertical = 8.dp))
                Text(
                    text = stringResource(id = R.string.Contacts_Text),
                    fontSize = 15.sp,

                    )
                Spacer(modifier = Modifier.padding(vertical = 16.dp))
                CustomTextField(
                    value = viewModel.name.value,
                    onValueChanged = {
                       viewModel.onEvent(ContactsUiEvent.EnterName(it))
                    },
                    hint = "Enter Your Name",
                    isRead = false,
                    isEnabled = true,
                    onClearClick = { viewModel.onEvent(ContactsUiEvent.ClearName) },
                    trailingEnabled = true,
                    singleLine = false
                )
                Spacer(modifier = Modifier.padding(vertical = 12.dp))
                CustomTextField(
                    value = viewModel.email.value,
                    onValueChanged = {
                        viewModel.onEvent(ContactsUiEvent.EnterEmail(it))
                    },
                    hint = "Enter Your Email",
                    isRead = false,
                    isEnabled = true,
                    onClearClick = { viewModel.onEvent(ContactsUiEvent.ClearEmail) },
                    trailingEnabled = true,
                    singleLine = false
                )
                Spacer(modifier = Modifier.padding(vertical = 12.dp))
                CustomTextField(
                    value = viewModel.number.value,
                    onValueChanged = {
                        viewModel.onEvent(ContactsUiEvent.EnterNumber(it))
                    },
                    hint = "Enter Your Number",
                    isRead = false,
                    isEnabled = true,
                    onClearClick = { viewModel.onEvent(ContactsUiEvent.ClearNumber) },
                    trailingEnabled = true,
                    singleLine = false,
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.NumberPassword
                    )
                )
                Spacer(modifier = Modifier.padding(vertical = 12.dp))
                CustomTextField(
                    value = viewModel.subject.value,
                    onValueChanged = {
                        viewModel.onEvent(ContactsUiEvent.EnterSubject(it))
                    },
                    hint = "Enter Problem Subject",
                    isRead = false,
                    isEnabled = true,
                    onClearClick = {
                        viewModel.onEvent(ContactsUiEvent.ClearSubject)
                    },
                    trailingEnabled = true,
                    singleLine = false
                )
                Spacer(modifier = Modifier.padding(vertical = 12.dp))
                TextField(
                    value = viewModel.message.value,
                    onValueChange = {
                        viewModel.onEvent(ContactsUiEvent.EnterMessage(it))
                    },
                    placeholder = {
                        Text(text = "Hi there, I would like to...")
                    },
                    colors = TextFieldDefaults.textFieldColors(
                        cursorColor = MaterialTheme.colors.primaryVariant,
                        textColor =  MaterialTheme.colors.primaryVariant,
                        backgroundColor = Color.Transparent,
                        focusedIndicatorColor = MaterialTheme.colors.primaryVariant,
                        unfocusedIndicatorColor = MaterialTheme.colors.primaryVariant
                    ),
                    modifier = Modifier
                        .clip(RoundedCornerShape(12.dp))
                        .border(
                            1.3.dp,
                            MaterialTheme.colors.primaryVariant,
                            RoundedCornerShape(12.dp)
                        )
                        .fillMaxWidth()
                        .height(170.dp),
                    maxLines = 10
                )
                Spacer(modifier = Modifier.padding(vertical = 16.dp))
                OutlinedButton(
                    modifier = Modifier
                        .fillMaxWidth(0.4f)
                        .height(52.dp)
                        .align(Alignment.CenterHorizontally),
                    onClick = {
                              viewModel.onEvent(ContactsUiEvent.Submit)
                    },
                    border = BorderStroke(1.dp, MaterialTheme.colors.error),
                    shape = RoundedCornerShape(12.dp),
                    colors = ButtonDefaults.outlinedButtonColors(
                        backgroundColor = Color.Transparent
                    ),

                    ) {
                    Box (
                        modifier = Modifier.fillMaxSize()
                    ) {
                        Text(
                            text = "Submit",
                            color = MaterialTheme.colors.error,
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 18.sp,
                            modifier = Modifier
                                .padding(vertical = 3.dp)
                                .align(Alignment.Center)
                        )
                    }

                }
                Spacer(modifier = Modifier.padding(16.dp))

            }
        }
        Spacer(modifier = Modifier.padding(30.dp))

    }

}