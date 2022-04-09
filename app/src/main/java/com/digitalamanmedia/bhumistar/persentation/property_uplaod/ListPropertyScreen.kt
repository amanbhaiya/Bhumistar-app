package com.digitalamanmedia.bhumistar.persentation.property_uplaod

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.animation.*
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.digitalamanmedia.bhumistar.R
import com.digitalamanmedia.bhumistar.core.Commons
import com.digitalamanmedia.bhumistar.core.components.AddressField
import com.digitalamanmedia.bhumistar.core.components.AnimatedButton
import com.digitalamanmedia.bhumistar.core.utils.SnackBarManager
import com.digitalamanmedia.bhumistar.persentation.authentication.user_auth.user_viewmodel.UserAuthViewModel
import com.digitalamanmedia.bhumistar.persentation.property_uplaod.components.AllPropertyImages
import com.digitalamanmedia.bhumistar.persentation.property_uplaod.components.CustomTextField
import com.digitalamanmedia.bhumistar.persentation.property_uplaod.components.PropertyTypeBox
import com.digitalamanmedia.bhumistar.persentation.property_uplaod.viewModel.ListPropertyUiEvent
import com.digitalamanmedia.bhumistar.persentation.property_uplaod.viewModel.ListPropertyViewModal
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch


@ExperimentalPermissionsApi
@ExperimentalMaterialApi
@Composable
fun ListPropertyScreen(
    viewModal: ListPropertyViewModal = hiltViewModel(),
    navControllerRoot:NavController
) {

    val scope = rememberCoroutineScope()
    val snackBarManager = SnackBarManager(scope)
    val scaffoldState = rememberScaffoldState()
    var message:String? = null


    LaunchedEffect(key1 = true){
        message = snackBarManager.getScope().launch {
            viewModal.eventFlow.collectLatest {event->
                when(event) {
                    is ListPropertyViewModal.ListPropertySnack.ShowSnackBar -> {
                        snackBarManager.showSnackBar(
                            scaffoldState = scaffoldState,
                            message = event.message,
                            actionLevel = "DISMISS"
                        )
                    }
                }
            }
        }.toString()
    }
    val state = viewModal.state.value

    val launcher1 = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()) { uri: Uri? ->
        viewModal.onUiEvent(ListPropertyUiEvent.GetPicOneUri(uri))
    }
    val launcher2 = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()) { uri: Uri? ->
        viewModal.onUiEvent(ListPropertyUiEvent.GetPicTwoUri(uri))
    }
    val launcher3 = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()) { uri: Uri? ->
        viewModal.onUiEvent(ListPropertyUiEvent.GetPicThreeUri(uri))
    }
    val launcher4 = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()) { uri: Uri? ->
        viewModal.onUiEvent(ListPropertyUiEvent.GetPicFourUri(uri))
    }


    val scrollState = rememberScrollState()
    val scrollStateHorizontal = rememberScrollState()

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            TopAppBar(
                modifier = Modifier
                    .clip(
                        shape = RoundedCornerShape(
                            bottomStart = 5.dp,
                            bottomEnd = 5.dp
                        )
                    ),
                backgroundColor = MaterialTheme.colors.primary,
                title = {
                    Text(
                        text = "List Property",
                        color = Color.White,
                        fontSize = 22.sp
                    )
                },
                navigationIcon = {
                    IconButton(
                        onClick = {
                           navControllerRoot.popBackStack()
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Outlined.ArrowBack,
                            contentDescription = "",
                            tint = Color.White
                        )
                    }
                }
            )
        }
    ) {
        Column(modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .background(MaterialTheme
                .colors.surface
            )
            .padding(16.dp)
        ) {
            val darkTheme = isSystemInDarkTheme()

            Card(modifier = Modifier.fillMaxWidth()) {
                Column(modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp)
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
                        text = "List your property...",
                        fontSize = 22.sp,
                        color = MaterialTheme.colors.error
                    )
                }

            }

            Spacer(modifier = Modifier.height(20.dp))
            Card(modifier = Modifier.fillMaxWidth()) {
                Column(modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp)
                ) {
                    PropertyTypeBox(
                        list = Commons.getPropertyTypeButtons(),
                        selectedOption = viewModal.propertyType.value,
                        onBoxClick = {
                            viewModal.onUiEvent(ListPropertyUiEvent.EnterPropertyType(it))

                        }
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Divider()
                    Spacer(modifier = Modifier.height(12.dp))
                    AnimatedVisibility(
                        modifier = Modifier.fillMaxWidth(),
                        visible = state.isVisible,
                        enter = fadeIn() + slideInVertically(),
                        exit = fadeOut() + slideOutVertically()
                    ) {
                        PropertyTypeBox(
                            list = Commons.getFlatsButtons(),
                            selectedOption = viewModal.flatType.value,
                            onBoxClick = {
                                viewModal.onUiEvent(ListPropertyUiEvent.EnterFlatType(it))
                            }
                        )
                    }
                }

            }



            Spacer(modifier = Modifier.height(12.dp))
            Card(modifier = Modifier.fillMaxWidth()) {
                Column(modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp)
                ) {
                    CustomTextField(
                        hint = "Enter Property Name...",
                        text = viewModal.propertyName.value,
                        onValueChanged = {
                            viewModal.onUiEvent(ListPropertyUiEvent.EnterPropertyName(it))
                        }
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    AddressField(
                        hint = "Enter Property Address...",
                        height = 180.dp,
                        singleLine = false,
                        text = viewModal.propertyAddress.value,
                        onValueChanged = {
                            viewModal.onUiEvent(ListPropertyUiEvent.EnterPropertyAddress(it))
                        }
                    )

                    Spacer(modifier = Modifier.height(12.dp))
                    Row(modifier = Modifier.fillMaxWidth()) {
                        CustomTextField(
                            hint = "Net price...",
                            width = 0.37f,
                            text = viewModal.netPrice.value,
                            onValueChanged = {
                                viewModal.onUiEvent(ListPropertyUiEvent.EnterNetPrice(it))
                            }
                        )
                        Spacer(modifier = Modifier.width(12.dp))
                        CustomTextField(
                            hint = "Booking amount...",
                            width = 1f,
                            text = viewModal.bookingAmount.value,
                            onValueChanged = {
                                viewModal.onUiEvent(ListPropertyUiEvent.EnterBookingAmount(it))
                            }
                        )
                    }
                    Spacer(modifier = Modifier.height(12.dp))
                    Row(modifier = Modifier.fillMaxWidth()) {
                        CustomTextField(
                            hint = "Price/sq.ft...",
                            width = 0.37f,
                            text = viewModal.priceSqFt.value,
                            onValueChanged = {
                                viewModal.onUiEvent(ListPropertyUiEvent.EnterPriceSQFT(it))
                            }
                        )
                        Spacer(modifier = Modifier.width(12.dp))
                        CustomTextField(
                            hint = "Carpet area...",
                            width = 1f,
                            text = viewModal.carpetArea.value,
                            onValueChanged = {
                                viewModal.onUiEvent(ListPropertyUiEvent.EnterCarpetArea(it))
                            }
                        )
                    }
                    Spacer(modifier = Modifier.height(12.dp))
                    Row(modifier = Modifier.fillMaxWidth()) {
                        CustomTextField(
                            hint = "Buildup area...",
                            width = 0.37f,
                            text = viewModal.buildupArea.value,
                            onValueChanged = {
                                viewModal.onUiEvent(ListPropertyUiEvent.EnterBuildupArea(it))
                            }
                        )
                        Spacer(modifier = Modifier.width(12.dp))
                        CustomTextField(
                            hint = "Super buildup area...",
                            width = 1f,
                            text = viewModal.superBuildupArea.value,
                            onValueChanged = {
                                viewModal.onUiEvent(ListPropertyUiEvent.EnterSuperBuildupArea(it))
                            }
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            Card(modifier = Modifier.fillMaxWidth()) {
                Column(modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp)
                ) {
                    Text(
                        text = "Property Amenities...",
                        fontSize = 18.sp,
                        color = MaterialTheme.colors.error
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    AddressField(
                        hint = "Enter Property Amenities...",
                        height = 180.dp,
                        singleLine = false,
                        text = viewModal.propertyAmenities.value,
                        onValueChanged = {
                            viewModal.onUiEvent(ListPropertyUiEvent.EnterPropertiesAmenities(it))
                        }
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    AddressField(
                        hint = "About Property...",
                        height = 180.dp,
                        singleLine = false,
                        text = viewModal.aboutProperty.value,
                        onValueChanged = {
                            viewModal.onUiEvent(ListPropertyUiEvent.EnterAboutProperty(it))
                        }
                    )
                }
            }


            Spacer(modifier = Modifier.height(12.dp))
            Card(modifier = Modifier
                .fillMaxWidth()
            ) {
                Column(modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp)
                ) {
                    Text(
                        text = "Upload four images...",
                        fontSize = 18.sp,
                        color = MaterialTheme.colors.error
                    )
                    Spacer(modifier = Modifier.height(12.dp))
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .horizontalScroll(scrollStateHorizontal)
                    ) {

                        AllPropertyImages(
                            uri = state.picOne,
                            selectImage = {
                                launcher1.launch("image/*")
                            }
                        )

                        AllPropertyImages(
                            uri = state.picTwo,
                            selectImage = {
                                launcher2.launch("image/*")
                            }
                        )
                        AllPropertyImages(
                            uri = state.picThree,
                            selectImage = {
                                launcher3.launch("image/*")
                            }
                        )
                        AllPropertyImages(
                            uri = state.picFour,
                            selectImage = {
                                launcher4.launch("image/*")
                            }
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.height(12.dp))

            AnimatedButton(
                btnName = "Submit",
                onSubmitClick = {
                    viewModal.onUiEvent(ListPropertyUiEvent.Submit)
                    message
                },
                isBtnLoading = state.isLoading,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(52.dp)
            )
        }
    }
}
