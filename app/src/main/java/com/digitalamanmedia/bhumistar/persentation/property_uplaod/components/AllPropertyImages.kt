package com.digitalamanmedia.bhumistar.persentation.property_uplaod.components


import android.net.Uri
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import com.digitalamanmedia.bhumistar.R
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.size.Size


@ExperimentalMaterialApi
@Composable
fun AllPropertyImages(
    uri: Uri?,
    selectImage:()->Unit
) {
    val darkTheme = isSystemInDarkTheme()
    val alpha = if (darkTheme){
        1f
    }else{
        0.1f
    }
    val painter = if (uri == null){
        painterResource(id = R.drawable.night_logo)
    }else {
        rememberAsyncImagePainter(
            model = ImageRequest.Builder(LocalContext.current)
                .data(uri)
                .size(Size.ORIGINAL) // Set the target size to load the image at.
                .build()
        )
    }
    Image(
        modifier = Modifier
            .size(128.dp)
            .border(1.dp, MaterialTheme.colors.error, RoundedCornerShape(5.dp))
            .clickable { selectImage() }
            .background(MaterialTheme.colors.primary.copy(alpha)),
        painter = painter,
        contentDescription = null,
        contentScale = ContentScale.Fit

    )
    Spacer(modifier = Modifier.width(12.dp))
}