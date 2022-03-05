package com.digitalamanmedia.bhumistar.persentation.screens.verified

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Phone
import androidx.compose.material.icons.outlined.Verified
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.digitalamanmedia.bhumistar.ui.theme.BhumistarDark

@Composable
fun VerifiedScreen() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {

        Icon(
            imageVector = Icons.Outlined.Verified,
            contentDescription = "",
            modifier = Modifier.size(200.dp),
            tint = BhumistarDark
        )
    }

}