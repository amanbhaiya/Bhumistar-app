package com.digitalamanmedia.bhumistar.persentation.property_detail.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.digitalamanmedia.bhumistar.R

@Composable
fun PropertyPictures(
    picOne:Painter,
    picTwo:Painter,
    picThree:Painter,
    picFour:Painter,
) {
    LazyRow(modifier = Modifier.fillMaxWidth()
    ){
        item {
            Image(
                painter = picOne,
                contentDescription = "b1",
                modifier = Modifier
                    .clip(RoundedCornerShape(15.dp))
                    .height(250.dp)
                    .width(350.dp),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.width(12.dp))
        }
        item {
            Image(
                painter = picTwo,
                contentDescription = "b1",
                modifier = Modifier
                    .clip(RoundedCornerShape(15.dp))
                    .height(250.dp)
                    .width(350.dp),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.width(12.dp))
        }
        item {
            Image(
                painter = picThree,
                contentDescription = "b1",
                modifier = Modifier
                    .clip(RoundedCornerShape(15.dp))
                    .height(250.dp)
                    .width(350.dp),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.width(12.dp))
        }
        item {
            Image(
                painter = picFour,
                contentDescription = "b1",
                modifier = Modifier
                    .clip(RoundedCornerShape(15.dp))
                    .height(250.dp)
                    .width(350.dp),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.width(12.dp))
        }
    }
}