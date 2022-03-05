package com.digitalamanmedia.bhumistar.persentation.splash

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.lifecycle.lifecycleScope
import com.digitalamanmedia.bhumistar.MainActivity
import com.digitalamanmedia.bhumistar.persentation.onBoarding.onboarding_screen.OnBoardingActivity
import com.digitalamanmedia.bhumistar.persentation.utils.DataPreference

import com.digitalamanmedia.bhumistar.ui.theme.BhumistarTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
@AndroidEntryPoint
class SplashScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val dataPreference = DataPreference(this)

            BhumistarTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.primary) {
                    AppSplashScreen()
                    val intentB = Intent(this,OnBoardingActivity::class.java)
                    val intentM = Intent(this,MainActivity::class.java)
                    lifecycleScope.launchWhenCreated {
                        delay(2000)
                        if (dataPreference.read("Aman") == true){
                            startActivity(intentM)
                            finish()
                        }else{
                            startActivity(intentB)
                            finish()

                        }
                    }
                }
            }
        }
    }
}

