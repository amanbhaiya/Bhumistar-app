package com.digitalamanmedia.bhumistar.persentation.onBoarding.onboarding_screen


import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.digitalamanmedia.bhumistar.persentation.onBoarding.components.BottomSection
import com.digitalamanmedia.bhumistar.persentation.onBoarding.components.OnBoardingPageItem
import com.digitalamanmedia.bhumistar.persentation.onBoarding.components.TopSection
import com.digitalamanmedia.bhumistar.persentation.onBoarding.utils.OnBoardingItem
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState




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
