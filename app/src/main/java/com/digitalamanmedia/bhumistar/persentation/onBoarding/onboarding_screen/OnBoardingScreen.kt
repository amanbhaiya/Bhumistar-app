package com.digitalamanmedia.bhumistar.persentation.onBoarding.onboarding_screen


import androidx.activity.compose.BackHandler
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.digitalamanmedia.bhumistar.core.Commons
import com.digitalamanmedia.bhumistar.domain.use_cases.AllUseCases
import com.digitalamanmedia.bhumistar.persentation.navigation.NormalScreens.BottomNavScreens
import com.digitalamanmedia.bhumistar.persentation.navigation.NormalScreens.Screens
import com.digitalamanmedia.bhumistar.persentation.onBoarding.components.BottomSection
import com.digitalamanmedia.bhumistar.persentation.onBoarding.components.OnBoardingPageItem
import com.digitalamanmedia.bhumistar.persentation.onBoarding.components.TopSection
import com.digitalamanmedia.bhumistar.persentation.onBoarding.utils.OnBoardingItem
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch


@ExperimentalPagerApi
@Composable
fun OnBoardingScreen(
    allUseCases: AllUseCases,
    navControllerRoot: NavController
) {
    val state = rememberPagerState(initialPage = 0)
    val scope = rememberCoroutineScope()
    var backEnabled by remember { mutableStateOf(true) }
    val itemsLight = Commons.getLight()
    val itemsDark = Commons.getDark()
    val darkTheme = isSystemInDarkTheme()
    if (darkTheme){
        OnBoardingScreenAll(
            items = itemsDark,
            state = state,
            onNextClick = {
                scope.launch {
                    if (state.currentPage+1 < itemsDark.size){
                        scope.launch {
                            state.scrollToPage(state.currentPage+1)
                        }
                    }else{
                        allUseCases.onBoardingUseCase.write(value = true)
                        navControllerRoot.popBackStack()
                        navControllerRoot.navigate(Screens.MainScreen.route)
                    }
                }
            },
            onBackClick = {
                if (state.currentPage != 0){
                    scope.launch {
                        state.scrollToPage(state.currentPage-1)

                    }
                }
            },
            onSkipClick = {
                scope.launch {
                    allUseCases.onBoardingUseCase.write(value = true)
                    navControllerRoot.popBackStack()
                    navControllerRoot.navigate(Screens.MainScreen.route)
                }
            }
        )

    }else{
        OnBoardingScreenAll(
            items = itemsLight,
            state = state,
            onNextClick = {
                scope.launch {
                    if (state.currentPage+1 < itemsLight.size){
                        scope.launch {
                            state.scrollToPage(state.currentPage+1)
                        }
                    }else{
                        allUseCases.onBoardingUseCase.write(value = true)
                        navControllerRoot.popBackStack()
                        navControllerRoot.navigate(Screens.MainScreen.route)
                    }
                }
            },
            onBackClick = {
                if (state.currentPage != 0){
                    scope.launch {
                        state.scrollToPage(state.currentPage-1)

                    }
                }
            },
            onSkipClick = {
                scope.launch {
                    allUseCases.onBoardingUseCase.write(value = true)
                    navControllerRoot.popBackStack()
                    navControllerRoot.navigate(Screens.MainScreen.route)
                }
            }
        )
    }
    BackHandler(enabled = backEnabled) {
        if (state.currentPage == 0){
            backEnabled = false
        }else{
            scope.launch {
                state.scrollToPage(state.currentPage-1)
            }
        }

    }
}












@ExperimentalPagerApi
@Composable
fun OnBoardingScreenAll(
    items: List<OnBoardingItem>,
    state: PagerState,
    onNextClick:()->Unit,
    onBackClick:()->Unit,
    onSkipClick:()->Unit
) {

    Column(modifier = Modifier.fillMaxSize()) {
        TopSection(
            onBackClick = onBackClick,
            onSkipClick = onSkipClick
        )
        HorizontalPager(
            count = items.size,
            state = state,
            modifier = Modifier
                .fillMaxSize()
                .weight(0.8f)
        ) { page ->
            OnBoardingPageItem(items = items[page])
        }
        BottomSection(
            onClickNext = onNextClick, size = items.size,
            index = state.currentPage
        )


    }
}
