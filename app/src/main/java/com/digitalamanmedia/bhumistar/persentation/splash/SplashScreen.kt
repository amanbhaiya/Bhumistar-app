package com.digitalamanmedia.bhumistar.persentation.splash

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.lifecycle.lifecycleScope
import com.digitalamanmedia.bhumistar.persentation.MainActivity
import com.digitalamanmedia.bhumistar.core.Commons.Companion.ALREADY_LOGIN_USER
import com.digitalamanmedia.bhumistar.core.Commons.Companion.TRUE
import com.digitalamanmedia.bhumistar.domain.use_cases.AllUseCases
import com.digitalamanmedia.bhumistar.persentation.authentication.AuthenticationActivity
import com.digitalamanmedia.bhumistar.persentation.onBoarding.onboarding_screen.OnBoardingActivity
import com.digitalamanmedia.bhumistar.ui.theme.BhumistarTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import javax.inject.Inject

@AndroidEntryPoint
class SplashScreen : ComponentActivity() {
    @Inject lateinit var allUseCases: AllUseCases
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BhumistarTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.primary) {
                    AppSplashScreen()
                    val intentB = Intent(applicationContext,OnBoardingActivity::class.java)
                    val intentM = Intent(applicationContext, MainActivity::class.java)
//                    val intentA = Intent(applicationContext,AuthenticationActivity::class.java)
                    lifecycleScope.launchWhenCreated {
                        delay(2000)

                        if (allUseCases.onBoardingUseCase.read(TRUE) == true){
                            startActivity(intentM)
                            finish()
//                            if (allUseCases.verificationAlreadyLoginUseCase.readUserKey(ALREADY_LOGIN_USER) == ALREADY_LOGIN_USER) {
//                                startActivity(intentM)
//                                finish()
//                            }else{
//                                startActivity(intentA)
//                                finish()
//                            }
                        }
                        else {
                            startActivity(intentB)
                            finish()

                        }
                    }
                }
            }
        }
    }
}

