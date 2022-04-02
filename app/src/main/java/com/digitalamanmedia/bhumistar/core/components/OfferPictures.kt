package com.digitalamanmedia.bhumistar.persentation.screens.search.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.size.Size
import com.digitalamanmedia.bhumistar.R
import com.digitalamanmedia.bhumistar.core.Commons


@Composable
fun OfferPictures(
    size: Dp = 145.dp
) {
    LazyRow(modifier = Modifier
        .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        items(Commons.pictures) {item->
            Image(
                painter = rememberAsyncImagePainter(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(Commons.PROPERTY_IMAGE_URL+item)
                        .crossfade(1000)
                        .placeholder(R.drawable.bhumistarjpg)
                        .size(Size.ORIGINAL) // Set the target size to load the image at.
                        .build()
                ),
                contentDescription = "b1",
                modifier = Modifier
                    .clip(RoundedCornerShape(5.dp))
                    .size(size)
            )
            Spacer(modifier = Modifier.width(12.dp))
        }
    }
}