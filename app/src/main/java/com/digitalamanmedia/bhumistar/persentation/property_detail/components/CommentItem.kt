package com.digitalamanmedia.bhumistar.persentation.property_detail.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.digitalamanmedia.bhumistar.R
import com.digitalamanmedia.bhumistar.ui.theme.YellowP

@Composable
fun CommentItem(
    name: String,
    date: String,
    comment: String,
    rating: Int,
    userImage: Painter
) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                modifier = Modifier
                    .clip(CircleShape)
                    .size(55.dp),
                painter = userImage,
                contentDescription = ""
            )
            Spacer(modifier = Modifier.width(8.dp))
            Column {
                Text(
                    text = name,
                    color = MaterialTheme.colors.primaryVariant,
                    fontSize = 16.sp
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = date,
                    color = MaterialTheme.colors.primaryVariant.copy(0.5f),
                    fontSize = 14.sp
                )
            }
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.End
        ) {
            for (i in 0..4){
                Icon(
                    imageVector = Icons.Filled.Star,
                    contentDescription = "icon",
                    modifier = Modifier
                        .padding(2.dp)
                        .size(17.dp),
                    tint = if (i < rating) YellowP else Color.Gray
                )
            }
        }

    }

    Spacer(modifier = Modifier.height(12.dp))
    Text(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 12.dp),
        text = comment,
        color = MaterialTheme.colors.primaryVariant,
        fontSize = 13.sp
    )
    Divider()
    Spacer(modifier = Modifier.height(12.dp))
}