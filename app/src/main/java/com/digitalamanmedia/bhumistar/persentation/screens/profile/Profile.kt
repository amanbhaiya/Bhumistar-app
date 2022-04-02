package com.digitalamanmedia.bhumistar.persentation.screens.profile


import android.content.Intent
import android.net.Uri
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material.icons.outlined.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.size.Size
import com.digitalamanmedia.bhumistar.R
import com.digitalamanmedia.bhumistar.core.Commons
import com.digitalamanmedia.bhumistar.core.Commons.Companion.LOGO
import com.digitalamanmedia.bhumistar.core.components.CircleLoadingState
import com.digitalamanmedia.bhumistar.persentation.authentication.AuthenticationActivity
import com.digitalamanmedia.bhumistar.persentation.property_uplaod.viewModel.ListPropertyUiEvent
import com.digitalamanmedia.bhumistar.persentation.screens.profile.component.ProfileUpdateForm
import com.digitalamanmedia.bhumistar.persentation.screens.profile.profile_screens.PrivacyPolicy
import com.digitalamanmedia.bhumistar.persentation.screens.profile.profile_screens.TermsAndConditions
import com.digitalamanmedia.bhumistar.persentation.screens.profile.utils.GetDistrict
import com.digitalamanmedia.bhumistar.persentation.screens.profile.utils.StateAndDistrict
import com.digitalamanmedia.bhumistar.persentation.screens.profile.view_model.ProfileUserUiEvent
import com.digitalamanmedia.bhumistar.persentation.screens.profile.view_model.ProfileViewModal
import com.digitalamanmedia.bhumistar.ui.theme.Bhumistar
import com.digitalamanmedia.bhumistar.ui.theme.YellowP

@Composable
fun ProfileScreen(
    viewModal: ProfileViewModal = hiltViewModel()
) {
    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()) { uri: Uri? ->
        viewModal.onUiEvent(ProfileUserUiEvent.GetPictureUri(uri))
    }
    val context = LocalContext.current
    val scrollStateDropDownState = rememberScrollState()
    val scrollStateDropDownDistrict = rememberScrollState()

    val state = viewModal.profileState.value
    val icon = if (state.passwordVisibility || state.passwordVisibilityCnf){
        Icons.Default.VisibilityOff
    }else{
        Icons.Default.Visibility
    }
    val visibility =  if (state.passwordVisibility || state.passwordVisibilityCnf){
        VisualTransformation.None
    }else{
        PasswordVisualTransformation()
    }



    Scaffold {
        if (viewModal.profileState.value.isTerms && !viewModal.profileState.value.isPrivacy){
            TermsAndConditions(viewModel = viewModal)
        }
        if (viewModal.profileState.value.isPrivacy && !viewModal.profileState.value.isTerms){
            PrivacyPolicy(viewModel = viewModal)
        }
        if (!viewModal.profileState.value.isPrivacy && !viewModal.profileState.value.isTerms) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(12.dp)
            ) {
                item {

                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight(0.1f),
                    ) {

                        Row(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(horizontal = 16.dp, vertical = 16.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {


                            Image(
                                painter = rememberAsyncImagePainter(
                                    model = ImageRequest.Builder(LocalContext.current)
                                        .data(Commons.IMAGE_URL + state.userImageUri)
                                        .crossfade(1000)
                                        .placeholder(R.drawable.bhumistarjpg)
                                        .size(Size.ORIGINAL) // Set the target size to load the image at.
                                        .build()
                                ),
                                contentDescription = "",
                                modifier = Modifier
                                    .clip(CircleShape)
                                    .size(85.dp)
                                    .clickable {
                                        launcher.launch("image/*")
                                    },
                                contentScale = ContentScale.Crop
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
                                    text = if(viewModal.userName.value.isEmpty())"Bhumistar" else viewModal.userName.value,
                                    fontSize = 17.sp,
                                    fontWeight = FontWeight.SemiBold,
                                    color = MaterialTheme.colors.error
                                )
                                Text(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .clickable {

                                        },
                                    text =if(viewModal.userEmail.value.isEmpty())"bhumistar@gmail.com" else viewModal.userEmail.value,
                                    fontSize = 14.sp,
                                    color = MaterialTheme.colors.primaryVariant
                                )

                            }


                        }
                    }
                    Spacer(modifier = Modifier.height(25.dp))
                }
                item {

                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight(0.06f),
                    ) {

                        Row(
                            modifier = Modifier
                                .fillMaxSize()
                                .clickable {
                                    viewModal.onUiEvent(ProfileUserUiEvent.TermsIsVisible)
                                },
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Row(
                                modifier = Modifier
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
                                        .padding(start = 16.dp),
                                    text = "Terms and Conditions",
                                    fontSize = 18.sp,
                                    color = MaterialTheme.colors.primaryVariant
                                )
                            }
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .fillMaxHeight()
                                    .padding(horizontal = 16.dp, vertical = 8.dp),
                                contentAlignment = Alignment.CenterEnd
                            ) {
                                IconButton(
                                    onClick = {
                                        viewModal.onUiEvent(ProfileUserUiEvent.TermsIsVisible)
                                    },
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
                }
                item {
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight(0.06f),
                    ) {

                        Row(
                            modifier = Modifier
                                .fillMaxSize()
                                .clickable {

                                    viewModal.onUiEvent(ProfileUserUiEvent.PrivacyIsVisible)
                                },
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Row(
                                modifier = Modifier
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
                                        .padding(start = 16.dp),
                                    text = "Privacy policy",
                                    fontSize = 18.sp,
                                    color = MaterialTheme.colors.primaryVariant
                                )
                            }
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .fillMaxHeight()
                                    .padding(horizontal = 16.dp, vertical = 8.dp),
                                contentAlignment = Alignment.CenterEnd
                            ) {
                                IconButton(
                                    onClick = {
                                        viewModal.onUiEvent(ProfileUserUiEvent.PrivacyIsVisible)
                                    },
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
                }
                item {
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight(0.06f),
                    ) {

                        Row(
                            modifier = Modifier
                                .fillMaxSize()
                                .clickable {
                                    val intent = Intent(context.applicationContext,
                                        AuthenticationActivity::class.java).apply {
                                        flags = Intent.FLAG_ACTIVITY_NEW_TASK
                                    }
                                    context.startActivity(intent)
                                },
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth(0.8F)
                                    .fillMaxHeight()
                                    .padding(horizontal = 16.dp, vertical = 8.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Icon(
                                    imageVector = Icons.Outlined.Person,
                                    contentDescription = "",
                                    tint = Color.White,
                                    modifier = Modifier
                                        .clip(CircleShape)
                                        .background(Bhumistar)
                                        .padding(8.dp)
                                )
                                Text(
                                    modifier = Modifier
                                        .padding(start = 16.dp),
                                    text = "Register as Vendor/User",
                                    fontSize = 18.sp,
                                    color = MaterialTheme.colors.primaryVariant
                                )
                            }
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .fillMaxHeight()
                                    .padding(horizontal = 16.dp, vertical = 8.dp),
                                contentAlignment = Alignment.CenterEnd
                            ) {
                                IconButton(
                                    onClick = {
                                        val intent = Intent(context.applicationContext,
                                            AuthenticationActivity::class.java).apply {
                                            flags = Intent.FLAG_ACTIVITY_NEW_TASK
                                        }
                                        context.startActivity(intent)
                                    },
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
                }
                item {
                    ProfileUpdateForm(
                        name = viewModal.name.value,
                        number = viewModal.number.value,
                        email = viewModal.email.value,
                        state = viewModal.state.value,
                        city = viewModal.city.value,
                        pinCode = viewModal.pinCode.value,
                        password = viewModal.password.value,
                        cnfPassword = viewModal.cnfPassword.value,
                        onNameChanged = { viewModal.onUiEvent(ProfileUserUiEvent.EnterName(it)) },
                        onNumberChanged = { viewModal.onUiEvent(ProfileUserUiEvent.EnterNumber(it)) },
                        onEmailChanged = { viewModal.onUiEvent(ProfileUserUiEvent.EnterEmail(it)) },
                        onStateChanged = { viewModal.onUiEvent(ProfileUserUiEvent.EnterState(it)) },
                        onCityChanged = { viewModal.onUiEvent(ProfileUserUiEvent.EnterCity(it)) },
                        onPinCodeChanged = { viewModal.onUiEvent(ProfileUserUiEvent.EnterPinCode(it)) },
                        onPasswordChanged = {
                            viewModal.onUiEvent(ProfileUserUiEvent.EnterPassword(it))
                        },
                        onCnfPasswordChanged = {
                            viewModal.onUiEvent(
                                ProfileUserUiEvent.EnterConfirmPassword(
                                    it
                                )
                            )
                        },
                        isEnable = state.isEnable,
                        isReadable = state.isReadable,
                        icon = icon,
                        visibility = visibility,
                        onEditClick = {
                            viewModal.onUiEvent(ProfileUserUiEvent.OnEditClick)
                        },
                        onNameClear = {
                            viewModal.onUiEvent(ProfileUserUiEvent.OnNameClear)
                        },
                        onNumberClear = {
                            viewModal.onUiEvent(ProfileUserUiEvent.OnNumberClear)
                        },
                        onEmailClear = {
                            viewModal.onUiEvent(ProfileUserUiEvent.OnEmailClear)
                        },
                        onPinCodeClear = {
                            viewModal.onUiEvent(ProfileUserUiEvent.OnPinCodeClear)
                        },
                        onPasswordIconToggle = {
                            viewModal.onUiEvent(ProfileUserUiEvent.TogglePassword)
                        },
                        onCnfPasswordIconToggle = {
                            viewModal.onUiEvent(ProfileUserUiEvent.ToggleCnfPassword)
                        },
                        expandedCity = state.expandedCity,
                        expandedState = state.expandedState,
                        onStateDropDown = {
                            viewModal.onUiEvent(ProfileUserUiEvent.OnStateDrop)
                        },
                        onCityDropDown = {
                            viewModal.onUiEvent(ProfileUserUiEvent.OnCityDrop)
                        },
                        onStateItemClick = { state ->
                            viewModal.onUiEvent(ProfileUserUiEvent.OnStateClick(state))
                        },
                        onCityItemClick = { city ->
                            viewModal.onUiEvent(ProfileUserUiEvent.OnCityClick(city))
                        },
                        listStates = StateAndDistrict.getState(),
                        listCities = GetDistrict.getDistrict(viewModal.state.value),
                        onSubmitClick = {
                            viewModal.onUiEvent(ProfileUserUiEvent.UpdateUser)
//                    snackBarManager.getScope().launch {
//                       viewModal.eventFlow.collectLatest { event->
//                           when(event){
//                              is  ProfileViewModal.ProfileUiEvent.ShowSnackBar->{
//                                   snackBarManager.showSnackBar(
//                                       scaffoldState = scaffoldState,
//                                       message = event.message,
//                                       actionLevel = "DISMISS"
//                                   )
//                               }
//                           }
//                       }
//                    }

                        },
                        scrollStateDropDownState = scrollStateDropDownState,
                        scrollStateDropDownDistrict = scrollStateDropDownDistrict,
                        trailingEnabled = state.trailingEnabled,
                        isLoading = state.isLoading,
                        userLogin = {
                            viewModal.onUiEvent(ProfileUserUiEvent.UserLogin)
                        },
                        isLogin = state.isUserLogin

                    )
                }
                item {
                    Spacer(modifier = Modifier.height(80.dp))
                }
            }
        }
    }


}

