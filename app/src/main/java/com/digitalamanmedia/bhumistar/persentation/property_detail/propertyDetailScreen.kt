package com.digitalamanmedia.bhumistar.persentation.screens


import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.size.Size
import com.digitalamanmedia.bhumistar.R
import com.digitalamanmedia.bhumistar.core.Commons
import com.digitalamanmedia.bhumistar.core.Commons.Companion.LOGO
import com.digitalamanmedia.bhumistar.core.components.LoadingState
import com.digitalamanmedia.bhumistar.core.utils.RoundOffRating
import com.digitalamanmedia.bhumistar.persentation.property_detail.components.*
import com.digitalamanmedia.bhumistar.persentation.screens.property_detail.component.CommentBox
import com.digitalamanmedia.bhumistar.persentation.property_detail.viewModal.PropertyDetailViewModel
import com.digitalamanmedia.bhumistar.persentation.property_detail.viewModal.PropertyUiEvent
import com.digitalamanmedia.bhumistar.persentation.screens.search.components.OfferPictures
import com.digitalamanmedia.bhumistar.ui.theme.YellowP
import com.google.accompanist.flowlayout.FlowRow
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import java.text.SimpleDateFormat


@SuppressLint("SimpleDateFormat")
@Composable
fun PropertyDetailScreen(
    viewModel: PropertyDetailViewModel = hiltViewModel(),
    navControllerRoot:NavController
) {
    val state = viewModel.state.value
    val refreshState = rememberSwipeRefreshState(isRefreshing = state.isRefreshing)
    SwipeRefresh(
        state = refreshState,
        onRefresh = { viewModel.onUiEvent(PropertyUiEvent.OnSwipeRefresh) }
    ) {
        if (state.isLoading) {
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
            LazyColumn(modifier = Modifier.fillMaxSize()
            ) {
                val rating = RoundOffRating.rating(state.averageRating)
                Log.d("tag",rating.toString())
                item {

                    UpperDetail(
                        rating = rating,
                        propertyName = state.property_name,
                        vendorName = state.vendor_name,
                        vendorType = state.vendor_type,
                        propertyAddress = state.property_address,
                        reviews = state.comments.size,
                        propertySQFT = state.price_sq_ft,
                        netPrice = state.net_price)
                    Spacer(modifier = Modifier.height(8.dp))
                }
                item {
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(12.dp)
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                        ) {
                            Text(
                                modifier = Modifier
                                    .fillMaxWidth(),
                                text = "Property Pictures",
                                color = MaterialTheme.colors.error,
                                fontSize = 22.sp
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                            PropertyPictures(
                                picOne = rememberAsyncImagePainter(
                                    model = ImageRequest.Builder(LocalContext.current)
                                        .data(Commons.PROPERTY_IMAGE_URL+state.pic_one)
                                        .crossfade(1000)
                                        .placeholder(R.drawable.bhumistarjpg)
                                        .size(Size.ORIGINAL) // Set the target size to load the image at.
                                        .build()
                                ),
                                picTwo = rememberAsyncImagePainter(
                                    model = ImageRequest.Builder(LocalContext.current)
                                        .data(Commons.PROPERTY_IMAGE_URL+state.pic_two)
                                        .crossfade(1000)
                                        .placeholder(R.drawable.bhumistarjpg)
                                        .size(Size.ORIGINAL) // Set the target size to load the image at.
                                        .build()
                                ),
                                picThree = rememberAsyncImagePainter(
                                    model = ImageRequest.Builder(LocalContext.current)
                                        .data(Commons.PROPERTY_IMAGE_URL+state.pic_three)
                                        .crossfade(1000)
                                        .placeholder(R.drawable.bhumistarjpg)
                                        .size(Size.ORIGINAL) // Set the target size to load the image at.
                                        .build()
                                ),
                                picFour = rememberAsyncImagePainter(
                                    model = ImageRequest.Builder(LocalContext.current)
                                        .data(Commons.PROPERTY_IMAGE_URL+state.pic_four)
                                        .crossfade(1000)
                                        .placeholder(R.drawable.bhumistarjpg)
                                        .size(Size.ORIGINAL) // Set the target size to load the image at.
                                        .build()
                                )
                            )
                            Spacer(modifier = Modifier.height(12.dp))
                        }
                    }

                }
                item {
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(12.dp)
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(12.dp)
                        ) {
                            Text(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(bottom = 8.dp),
                                text = "Property Overview",
                                color = MaterialTheme.colors.error,
                                fontSize = 22.sp
                            )

                            Divider()
                            Spacer(modifier = Modifier.height(12.dp))
                            FlowRow(
                                modifier = Modifier
                                    .fillMaxWidth(),
                                mainAxisSpacing = 10.dp,
                                crossAxisSpacing = 10.dp
                            ) {
                                state.property_amenities.map { it.trim() }.forEach {
                                    OverviewItem(text = it)
                                }
//                                Log.d("tag",state.imageUri)
//                                Log.d("tag",viewModel.userId.value.toString())
                            }
                        }

                    }
                    Spacer(modifier = Modifier.height(16.dp))

                }
                item {
                    PropertyDetails(
                        price = state.net_price,
                        priceSQFT = state.price_sq_ft,
                        bookingAmount = state.booking_amount,
                        emi = "37.9K",
                        projectName = state.property_name,
                        buildupArea = state.buildup_area,
                        carpetArea = state.carpet_area,
                        superBuildupArea = state.super_buildup_area
                    )
                }
                item {
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(12.dp)
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(12.dp)
                        ) {
                            Text(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(bottom = 8.dp),
                                text = "About Project",
                                color = MaterialTheme.colors.error,
                                fontSize = 22.sp
                            )

                            Divider()
                            Spacer(modifier = Modifier.height(12.dp))
                            Text(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(bottom = 8.dp),
                                text = state.about_property,
                                color = MaterialTheme.colors.primaryVariant,
                                fontSize = 15.sp
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                }
                item {
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(12.dp)
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(12.dp)
                        ) {
                            Text(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(bottom = 8.dp),
                                text = "Project Locality",
                                color = MaterialTheme.colors.error,
                                fontSize = 22.sp
                            )

                            Divider()
                            Spacer(modifier = Modifier.height(12.dp))
                            Text(
                                modifier = Modifier
                                    .fillMaxWidth(),
                                text = state.property_address,
                                color = MaterialTheme.colors.primaryVariant,
                                fontSize = 15.sp
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(12.dp))
                }
                item {
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(12.dp)
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(12.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {

                            Text(
                                modifier = Modifier
                                    .fillMaxWidth(0.4f),
                                text = "Ratings",
                                color = MaterialTheme.colors.error,
                                fontSize = 22.sp
                            )

                            Row(
                                modifier = Modifier
                                    .fillMaxWidth(),
                                verticalAlignment = Alignment.CenterVertically
                            ) {

                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.End,
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    for (i in 0..4) {
                                        Icon(
                                            imageVector = Icons.Filled.Star,
                                            contentDescription = "icon",
                                            modifier = Modifier.padding(2.dp),
                                            tint = if (i < rating) YellowP else Color.Gray
                                        )
                                    }
                                    Spacer(modifier = Modifier.width(4.dp))
                                    Icon(
                                        modifier = Modifier.size(20.dp),
                                        imageVector = Icons.Default.Person,
                                        contentDescription = "",
                                        tint = MaterialTheme.colors.primaryVariant
                                    )
                                    Spacer(modifier = Modifier.width(2.dp))
                                    Text(
                                        text = state.comments.size.toString(),
                                        color = MaterialTheme.colors.primaryVariant,
                                        fontSize = 17.sp,
                                        maxLines = 1,
                                        overflow = TextOverflow.Ellipsis
                                    )
                                }

                            }

                        }
                    }
                    Spacer(modifier = Modifier.height(12.dp))
                }
                item {
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(12.dp)
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(12.dp)
                        ) {
                            Text(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(bottom = 8.dp),
                                text = "All Ratings and Reviews",
                                color = MaterialTheme.colors.error,
                                fontSize = 22.sp
                            )

                            Divider()
                            Spacer(modifier = Modifier.height(12.dp))
                            if (state.comments.isEmpty()) {
                                Text(
                                    modifier = Modifier
                                        .fillMaxWidth(),
                                    text = "Be first to post a review",
                                    color = MaterialTheme.colors.primaryVariant,
                                    fontSize = 16.sp
                                )
                            }else{
                                state.comments.forEachIndexed {i, comment ->
                                    val image: String = comment.user_image?:LOGO
                                    if (i == 1 && state.onlyTwoComments){
                                        return@forEachIndexed
                                    }
                                    val dateTime = SimpleDateFormat("dd-MMMM-yyyy, HH:mm")
                                    val date = dateTime.format(comment.time?.toLong())
                                    CommentItem(
                                        name = comment.username ?: "",
                                        date = date,
                                        comment = comment.comment ?: "",
                                        rating = comment.rating ?: 0,
                                        userImage = rememberAsyncImagePainter(
                                            model = ImageRequest.Builder(LocalContext.current)
                                                .data(Commons.IMAGE_URL+image)
                                                .crossfade(1000)
                                                .placeholder(R.drawable.bhumistarjpg)
                                                .size(Size.ORIGINAL) // Set the target size to load the image at.
                                                .build()
                                        )
                                    )
                                }
                            }
                            if (state.comments.isNotEmpty()) {
                                Text(
                                    modifier = Modifier
                                        .clickable {
                                            viewModel.onUiEvent(PropertyUiEvent.AllReviews)
                                        }
                                        .align(CenterHorizontally),
                                    text = if (state.onlyTwoComments) "See all Reviews" else "Hide all Reviews",
                                    color = MaterialTheme.colors.error,
                                    fontSize = 22.sp
                                )
                            }
                        }

                    }
                    Spacer(modifier = Modifier.height(12.dp))
                }
                item {
                    CommentBox(
                        rating = viewModel.rating.value,
                        onStarClick = {
                            viewModel.onUiEvent(PropertyUiEvent.OnClickRating(it))
                        },
                        comment = viewModel.comment.value,
                        onCommentEnter = {
                            viewModel.onUiEvent(PropertyUiEvent.EnterComment(it))
                        },
                        isLogin = state.isLogin,
                        onSubmitComment = {
                            viewModel.onUiEvent(PropertyUiEvent.SubmitReview(navControllerRoot))
                        },
                        btnLoading = state.commentBtnLoading
                    )
                    Spacer(modifier = Modifier.height(12.dp))
                }
                item {
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(12.dp)
                    ) {
                        OfferPictures(
                            size = 300.dp
                        )
                    }
                    Spacer(modifier = Modifier.height(12.dp))
                }
            }
        }
    }
}