package com.digitalamanmedia.bhumistar.persentation.screens.home


import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.digitalamanmedia.bhumistar.R
import com.digitalamanmedia.bhumistar.core.components.LoadingState
import com.digitalamanmedia.bhumistar.core.utils.RoundOffRating
import com.digitalamanmedia.bhumistar.persentation.navigation.NormalScreens.BottomNavScreens
import com.digitalamanmedia.bhumistar.persentation.screens.home.components.PropertyItems
import com.digitalamanmedia.bhumistar.persentation.screens.home.viewmodel.HomeViewModel
import com.digitalamanmedia.bhumistar.persentation.screens.search.components.OfferPictures
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState


@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: HomeViewModel = hiltViewModel(),
) {
    val state = rememberSwipeRefreshState(isRefreshing = viewModel.isRefreshing.value)
    SwipeRefresh(
        state = state,
        onRefresh = {
            viewModel.onRefresh()
        }
    ) {
        if (viewModel.isLoading.value) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                LoadingState(
                    fontSize = 28.sp,
                    circleSize = 5.dp,
                    travelDistance = 14.dp,
                    spaceBetween = 5.dp
                )
            }
        }else {
            if (viewModel.noData.value) {
                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    item {
                        Row(
                            modifier = Modifier
                                .padding(12.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ){
                            Image(
                                painter = painterResource(id = R.drawable.error),
                                contentDescription = ""
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Column(
                                verticalArrangement = Arrangement.Center
                            ) {
                                Text(
                                    text = "Oops.",
                                    color = MaterialTheme.colors.error,
                                    fontSize = 20.sp
                                )
                                Spacer(modifier = Modifier.height(8.dp))
                                Text(
                                    text = viewModel.errorMessage.value,
                                    color = MaterialTheme.colors.primaryVariant,
                                    fontSize = 16.sp
                                )
                            }
                        }
                    }
                    item {
                        Spacer(modifier = Modifier.width(8.dp))
                    }

                }
            }else {
                LazyColumn(modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
                ) {
                    item {
                        OfferPictures()
                        Spacer(modifier = Modifier.height(8.dp))
                    }

                    item {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 12.dp),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = "Flats and more Property",
                                fontSize = 18.sp,
                                color = MaterialTheme.colors.primaryVariant,
                            )
                            Text(
                                text = "View all >>",
                                fontSize = 18.sp,
                                color = MaterialTheme.colors.error,
                                modifier = Modifier.clickable {
                                    try {
                                        // The navigation code that throw this exception

                                        navController.navigate(
                                            BottomNavScreens.Search.route//+"?verified=Flat"
                                        ) {

                                            navController.graph.startDestinationRoute?.let { screen_route ->
                                                popUpTo(screen_route) {
                                                    saveState = true
                                                }
                                            }
                                            launchSingleTop = true
                                            restoreState = true
                                        }
                                    } catch (e: IllegalStateException) {

                                    }
                                }
                            )
                        }
                        LazyRow(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 12.dp),
                        ) {
                            items(viewModel.flat) { item ->
                                val a = item.comments?.map {
                                    it.rating
                                }
                                val c = a?.sumOf { it ?: 0 }
                                val b = if (a?.size == 0) {
                                    0.0f
                                } else {
                                    c?.div(a.size)?.toFloat()
                                }
                                val rating = RoundOffRating.rating(b ?: 0.0F)
                                PropertyItems(
                                    navController = navController,
                                    id = item.id ?: 0,
                                    picture = item.pic_one,
                                    propertyName = item.property_name ?: "",
                                    propertyType = item.property_type ?: "",
                                    vendorName = item.vendor_name ?: "",
                                    vendorType = item.vendor_type ?: "",
                                    netPrice = item.net_price ?: "",
                                    priceSQFT = item.price_sq_ft ?: "",
                                    allCommentsNumber = item.comments?.size ?: 0,
                                    rating = rating,
                                    propertyAddress = item.property_address ?: "")
                                Spacer(modifier = Modifier.width(8.dp))
                            }
                        }


                        Spacer(modifier = Modifier.height(8.dp))
                    }
                    item {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 12.dp),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = "Most Rated",
                                fontSize = 18.sp,
                                color = MaterialTheme.colors.primaryVariant,
                            )
                            Text(
                                text = "View all >>",
                                fontSize = 18.sp,
                                color = MaterialTheme.colors.error,
                                modifier = Modifier.clickable { }
                            )
                        }
                        LazyRow(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 12.dp),
                        ) {
                            items(viewModel.mostRatedList) { item ->
                                val a = item.comments?.map {
                                    it.rating
                                }
                                val c = a?.sumOf { it ?: 0 }
                                val b = if (a?.size == 0) {
                                    0.0f
                                } else {
                                    c?.div(a.size)?.toFloat()
                                }
                                val rating = RoundOffRating.rating(b ?: 0.0F)
                                PropertyItems(
                                    navController = navController,
                                    id = item.id ?: 0,
                                    picture = item.pic_one,
                                    propertyName = item.property_name ?: "",
                                    propertyType = item.property_type ?: "",
                                    vendorName = item.vendor_name ?: "",
                                    vendorType = item.vendor_type ?: "",
                                    netPrice = item.net_price ?: "",
                                    priceSQFT = item.price_sq_ft ?: "",
                                    allCommentsNumber = item.comments?.size ?: 0,
                                    rating = rating,
                                    propertyAddress = item.property_address ?: "")
                                Spacer(modifier = Modifier.width(8.dp))
                            }


                        }


                        Spacer(modifier = Modifier.height(8.dp))
                    }
                    item {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 12.dp),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = "Recent Apartments & Villas",
                                fontSize = 18.sp,
                                color = MaterialTheme.colors.primaryVariant,
                            )
                            Text(
                                text = "View all >>",
                                fontSize = 18.sp,
                                color = MaterialTheme.colors.error,
                                modifier = Modifier.clickable {
                                    try {
                                        // The navigation code that throw this exception

                                        navController.navigate(
                                            BottomNavScreens.Search.route//+"?apartment=Apartments & Villas"
                                        ) {

                                            navController.graph.startDestinationRoute?.let { screen_route ->
                                                popUpTo(screen_route) {
                                                    saveState = true
                                                }
                                            }
                                            launchSingleTop = true
                                            restoreState = true
                                        }
                                    } catch (e: IllegalStateException) {

                                    }
                                }
                            )
                        }
                        LazyRow(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 12.dp),
                        ) {
                            items(viewModel.apartmentAndVilla) { item ->
                                val a = item.comments?.map {
                                    it.rating
                                }
                                val c = a?.sumOf { it ?: 0 }
                                val b = if (a?.size == 0) {
                                    0.0f
                                } else {
                                    c?.div(a.size)?.toFloat()
                                }
                                val rating = RoundOffRating.rating(b ?: 0.0F)
                                PropertyItems(
                                    navController = navController,
                                    id = item.id ?: 0,
                                    picture = item.pic_one,
                                    propertyName = item.property_name ?: "",
                                    propertyType = item.property_type ?: "",
                                    vendorName = item.vendor_name ?: "",
                                    vendorType = item.vendor_type ?: "",
                                    netPrice = item.net_price ?: "",
                                    priceSQFT = item.price_sq_ft ?: "",
                                    allCommentsNumber = item.comments?.size ?: 0,
                                    rating = rating,
                                    propertyAddress = item.property_address ?: "")
                                Spacer(modifier = Modifier.width(8.dp))
                            }

                        }


                        Spacer(modifier = Modifier.height(8.dp))
                    }
                    item {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 12.dp),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = "Recent Lands & Plots",
                                fontSize = 18.sp,
                                color = MaterialTheme.colors.primaryVariant,
                            )
                            Text(
                                text = "View all >>",
                                fontSize = 18.sp,
                                color = MaterialTheme.colors.error,
                                modifier = Modifier.clickable {
                                    try {
                                        // The navigation code that throw this exception

                                        navController.navigate(
                                            BottomNavScreens.Search.route//+"?land=Lands & Plots"
                                        ) {

                                            navController.graph.startDestinationRoute?.let { screen_route ->
                                                popUpTo(screen_route) {
                                                    saveState = true
                                                }
                                            }
                                            launchSingleTop = true
                                            restoreState = true
                                        }
                                    } catch (e: IllegalStateException) {

                                    }
                                }
                            )
                        }
                        LazyRow(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 12.dp),
                        ) {
                            items(viewModel.landsAndPlots) { item ->
                                val a = item.comments?.map {
                                    it.rating
                                }
                                val c = a?.sumOf { it ?: 0 }
                                val b = if (a?.size == 0) {
                                    0.0f
                                } else {
                                    c?.div(a.size)?.toFloat()
                                }
                                val rating = RoundOffRating.rating(b ?: 0.0F)
                                PropertyItems(
                                    navController = navController,
                                    id = item.id ?: 0,
                                    picture = item.pic_one,
                                    propertyName = item.property_name ?: "",
                                    propertyType = item.property_type ?: "",
                                    vendorName = item.vendor_name ?: "",
                                    vendorType = item.vendor_type ?: "",
                                    netPrice = item.net_price ?: "",
                                    priceSQFT = item.price_sq_ft ?: "",
                                    allCommentsNumber = item.comments?.size ?: 0,
                                    rating = rating,
                                    propertyAddress = item.property_address ?: "")
                                Spacer(modifier = Modifier.width(8.dp))
                            }
                        }
                    }

                    item {
                        Spacer(modifier = Modifier.height(70.dp))
                    }
                }
            }
        }
    }
}