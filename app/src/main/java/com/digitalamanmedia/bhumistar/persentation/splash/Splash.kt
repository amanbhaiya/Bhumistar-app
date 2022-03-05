package com.digitalamanmedia.bhumistar.persentation.splash


import android.content.Intent
import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.digitalamanmedia.bhumistar.R
import androidx.compose.ui.draw.scale
import androidx.compose.ui.platform.LocalContext

import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp


@Composable
fun AppSplashScreen() {

        val darkTheme = isSystemInDarkTheme()
        val scale= remember{
            Animatable(0f)
        }


        LaunchedEffect(key1 = true, ){
            scale.animateTo(
                targetValue = 1f,
                animationSpec = tween(
                    durationMillis = 1500,
                    easing = {
                        OvershootInterpolator(2f).getInterpolation(it)
                    }
                )
            )


        }
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colors.primary),
            contentAlignment = Alignment.Center,

            ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                if (darkTheme) {
                    Image(

                        painter = painterResource(id = R.drawable.night_logo),
                        contentDescription = "Logo",
                        modifier = Modifier
                            .height(150.dp)
                            .width(150.dp)
                            .scale(scale.value)
                    )
                } else {
                    Image(

                        painter = painterResource(id = R.drawable.bhumistar),
                        contentDescription = "Logo",
                        modifier = Modifier
                            .height(150.dp)
                            .width(150.dp)
                            .scale(scale.value)
                    )
                }


            }
        }
}