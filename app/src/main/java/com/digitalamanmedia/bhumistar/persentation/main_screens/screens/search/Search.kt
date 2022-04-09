package com.digitalamanmedia.bhumistar.persentation.main_screens.screens.search


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.size.Size
import com.digitalamanmedia.bhumistar.R
import com.digitalamanmedia.bhumistar.core.Commons.Companion.PAGE_SIZE
import com.digitalamanmedia.bhumistar.core.Commons.Companion.PROPERTY_IMAGE_URL
import com.digitalamanmedia.bhumistar.core.components.LoadingState
import com.digitalamanmedia.bhumistar.core.utils.RoundOffRating
import com.digitalamanmedia.bhumistar.persentation.main_screens.screens.search.components.SearchBar
import com.digitalamanmedia.bhumistar.persentation.main_screens.screens.search.components.SearchItems
import com.digitalamanmedia.bhumistar.persentation.main_screens.screens.search.view_modal.SearchUiEvent
import com.digitalamanmedia.bhumistar.persentation.main_screens.screens.search.view_modal.SearchViewModal
import com.digitalamanmedia.bhumistar.persentation.navigation.NormalScreens.Screens
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import java.lang.IllegalStateException


@ExperimentalMaterialApi
@Composable
fun SearchScreen(
    navControllerRoot: NavController,
    viewModel: SearchViewModal = hiltViewModel()
) {

    val state = viewModel.state.value
    val refreshState = rememberSwipeRefreshState(isRefreshing = state.onSearchRefresh)
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(12.dp)
    ) {
        SearchBar(
            text = state.search,
            onValueChanged = {
                viewModel.onUiEvent(SearchUiEvent.Search(it))
            },
            onFocusChanged = {
                viewModel.onUiEvent(SearchUiEvent.ChangeSearchFocus(it))
            },
            onSearchClick = {
                viewModel.onUiEvent(SearchUiEvent.SearchQuery)
            }
        )
        Spacer(modifier = Modifier.height(16.dp))
        if (state.isLoading){
            LoadingState(
                modifier = Modifier.align(CenterHorizontally),
                fontSize = 22.sp,
                circleSize = 4.dp,
                travelDistance = 14.dp,
                spaceBetween = 5.dp
            )
            Spacer(modifier = Modifier.height(16.dp))
        }
        Text(
            modifier = Modifier
                .fillMaxWidth(),
            text = "${state.listSize} Results Found | Property for -> ${state.searchTextWord}",
            color = MaterialTheme.colors.primaryVariant,
            fontSize = 20.sp
        )
        Spacer(modifier = Modifier.height(16.dp))

        SwipeRefresh(
            state = refreshState,
            onRefresh = {
                viewModel.onUiEvent(SearchUiEvent.OnSearchRefresh)
            }
        ) {


            if (state.noData) {
                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    item {
                        Text(
                            modifier = Modifier
                                .fillMaxWidth(),
                            text = "Oops.",
                            color = MaterialTheme.colors.error,
                            fontSize = 35.sp
                        )
                    }
                    item {
                        Spacer(modifier = Modifier.height(8.dp))
                    }
                    item {
                        Text(
                            modifier = Modifier
                                .fillMaxWidth(),
                            text = state.searchTextResult,
                            color = MaterialTheme.colors.primaryVariant,
                            fontSize = 30.sp
                        )
                    }
                }
            }
            LazyColumn {
                itemsIndexed(viewModel.propertyListNew.value) { index,item ->

                    if (index + 1 == viewModel.page.value * PAGE_SIZE && !state.lastPage){
                        viewModel.onListScrollPosition(index)
                    }

                    val a = item.comments?.map {
                        it.rating
                    }
                    val c = a?.sumOf { it ?: 0 }
                    val b = if (a?.size == 0) {
                        0.0f
                    } else {
                        c?.div(a.size)?.toFloat()
                    }
                    val rating = RoundOffRating.rating(b?:0.0F)
                    SearchItems(onItemClick = {
                        try {
                            navControllerRoot.navigate(
                                Screens.DetailScreen.route + "?id=${item.id}"
                            )
                        }catch (e : IllegalStateException){

                        }
                    },
                        painter = rememberAsyncImagePainter(
                            model = ImageRequest.Builder(LocalContext.current)
                                .data(PROPERTY_IMAGE_URL + item.pic_one)
                                .crossfade(1000)
                                .placeholder(R.drawable.bhumistarjpg)
                                .size(Size.ORIGINAL) // Set the target size to load the image at.
                                .build()
                        ),
                        propertyName = item.property_name,
                        propertyType = item.property_type,
                        vendorName = item.vendor_name,
                        vendorType = item.vendor_type,
                        netPrice = item.net_price,
                        priceSQFT = item.price_sq_ft,
                        address = item.property_address,
                        reviews = item.comments?.size.toString(),
                        rating = rating
                    )

                    Spacer(modifier = Modifier.height(12.dp))
                }
                item {
                    Spacer(modifier = Modifier.height(70.dp))
                }
            }
        }
    }
}




