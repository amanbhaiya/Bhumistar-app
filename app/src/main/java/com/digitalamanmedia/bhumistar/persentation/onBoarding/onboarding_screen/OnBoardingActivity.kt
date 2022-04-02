package com.digitalamanmedia.bhumistar.persentation.onBoarding.onboarding_screen

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.*
import com.digitalamanmedia.bhumistar.core.Commons
import com.digitalamanmedia.bhumistar.domain.repository.local.OnBoardingDataStoreRepository
import com.digitalamanmedia.bhumistar.domain.use_cases.AllUseCases
import com.digitalamanmedia.bhumistar.persentation.MainActivity
import com.digitalamanmedia.bhumistar.persentation.authentication.AuthenticationActivity
import com.digitalamanmedia.bhumistar.ui.theme.BhumistarTheme
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.rememberPagerState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class OnBoardingActivity : ComponentActivity() {
    @Inject lateinit var allUseCases: AllUseCases
    @ExperimentalPagerApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val state = rememberPagerState(initialPage = 0)
            val scope = rememberCoroutineScope()
            var backEnabled by remember { mutableStateOf(true) }
            val itemsLight = Commons.getLight()
            val itemsDark = Commons.getDark()
            val darkTheme = isSystemInDarkTheme()
            BhumistarTheme {
//                    val intent = Intent(this, AuthenticationActivity::class.java)
                val intent = Intent(this, MainActivity::class.java)
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
                                    startActivity(intent)
                                    finish()
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
                            }

                            startActivity(intent)
                            finish()
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
                                    startActivity(intent)
                                    finish()
                                }
                            }
                        },
                        onBackClick = {
                            if (state.currentPage == 0){

                            }else{

                                scope.launch {
                                    state.scrollToPage(state.currentPage-1)

                                }
                            }
                        },
                        onSkipClick = {
                            scope.launch {
                                allUseCases.onBoardingUseCase.write(value = true)
                            }

                            startActivity(intent)
                            finish()
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
        }
    }


}

