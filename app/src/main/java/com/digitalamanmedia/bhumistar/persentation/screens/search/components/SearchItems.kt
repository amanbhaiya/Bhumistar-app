package com.digitalamanmedia.bhumistar.persentation.screens.search.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import com.digitalamanmedia.bhumistar.R
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.digitalamanmedia.bhumistar.ui.theme.YellowP


@Composable
fun SearchItems(
    onItemClick:()->Unit,
    painter:Painter,
    propertyName:String?,
    propertyType:String?,
    vendorName:String?,
    vendorType:String?,
    netPrice:String?,
    priceSQFT:String?,
    address:String?,
    reviews:String?,
    rating:Int

) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                onItemClick()
            }
    ) {
        val darkTheme = isSystemInDarkTheme()
        val color = if (darkTheme){
            MaterialTheme.colors.primaryVariant
        }else{
            MaterialTheme.colors.primaryVariant.copy(alpha = 0.55f)
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(160.dp)
                .padding(10.dp)
        ) {
            Image(
                painter = painter,
                contentDescription = "",
                modifier = Modifier
                    .fillMaxHeight()
                    .width(140.dp),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.width(10.dp))
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    modifier = Modifier
                        .fillMaxWidth(),
                    text = propertyName?:"",
                    color = MaterialTheme.colors.primaryVariant,
                    fontSize = 15.sp,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    modifier = Modifier
                        .fillMaxWidth(),
                    text = propertyType?:"",
                    color = color,
                    fontSize = 13.sp,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    modifier = Modifier
                        .fillMaxWidth(),
                    text = "By: $vendorName ($vendorType)",
                    color = color,
                    fontSize = 12.sp,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ){
                    Column(
                        verticalArrangement = Arrangement.SpaceBetween
                    ){
                        Text(
                            text = "₹ $netPrice",
                            color = MaterialTheme.colors.primaryVariant,
                            fontSize = 18.sp,
                            maxLines = 1
                        )
                        Spacer(modifier = Modifier.width(2.dp))
                        Text(
                            text = "EMI starts at Rs 71.99K",
                            color = color,
                            fontSize = 12.sp,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                    }
                    Column(
                        verticalArrangement = Arrangement.SpaceBetween

                    ){
                        Text(
                            text = "₹ $priceSQFT",
                            color = MaterialTheme.colors.primaryVariant,
                            fontSize = 18.sp,
                            maxLines = 1
                        )
                        Spacer(modifier = Modifier.width(2.dp))
                        Text(
                            text = "Avg Price/sq.ft",
                            color = color,
                            fontSize = 12.sp,
                            maxLines = 1
                        )
                    }

                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    for (i in 0..4){
                        Icon(
                            imageVector = Icons.Filled.Star,
                            contentDescription = "icon",
                            modifier = Modifier.padding(2.dp)
                                .size(14.dp),
                            tint = if (i < rating) YellowP else Color.Gray
                        )
                    }
                    Icon(
                        modifier = Modifier.size(12.dp),
                        imageVector = Icons.Default.Person,
                        contentDescription = ""
                    )
                    Spacer(modifier = Modifier.width(2.dp))
                    Text(
                        text = "$reviews",
                        color = color,
                        fontSize = 12.sp,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }
                Text(
                    modifier = Modifier
                        .fillMaxWidth(),
                    text = address?:"",
                    color = color,
                    fontSize = 12.sp,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )

            }

        }
    }
}