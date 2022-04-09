package com.digitalamanmedia.bhumistar.persentation.main_screens.screens.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.size.Size
import com.digitalamanmedia.bhumistar.R
import com.digitalamanmedia.bhumistar.core.Commons
import com.digitalamanmedia.bhumistar.persentation.navigation.NormalScreens.BottomNavScreens
import com.digitalamanmedia.bhumistar.persentation.navigation.NormalScreens.Screens
import com.digitalamanmedia.bhumistar.ui.theme.YellowP

@Composable
fun PropertyItems(
    navControllerRoot:NavController,
    id:Int,
    picture:String?,
    propertyName:String,
    propertyType:String,
    vendorName:String,
    vendorType:String,
    netPrice:String,
    priceSQFT:String,
    allCommentsNumber:Int,
    rating:Int,
    propertyAddress:String

) {
    val darkTheme = isSystemInDarkTheme()
    val color = if (darkTheme){
        MaterialTheme.colors.primaryVariant
    }else{
        MaterialTheme.colors.primaryVariant.copy(alpha = 0.55f)
    }
    Card(
        modifier = Modifier
            .width(300.dp)
            .fillMaxHeight(0.5f
            ).clickable {
                try {
                    navControllerRoot.navigate(
                        Screens.DetailScreen.route + "?id=$id"
                    )
                } catch (e: IllegalStateException) {

                }
            }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Image(
                painter = rememberAsyncImagePainter(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(Commons.PROPERTY_IMAGE_URL+picture)
                        .crossfade(1000)
                        .placeholder(R.drawable.bhumistarjpg)
                        .size(Size.ORIGINAL) // Set the target size to load the image at.
                        .build()
                ),
                contentDescription = "b1",
                modifier = Modifier
                    .clip(RoundedCornerShape(topStart = 5.dp, topEnd = 5.dp))
                    .width(300.dp)
                    .height(200.dp),
                contentScale = ContentScale.Crop
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp)
            ) {
                Text(
                    modifier = Modifier
                        .fillMaxWidth(),
                    text = propertyName,
                    color = MaterialTheme.colors.primaryVariant,
                    fontSize = 15.sp,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    modifier = Modifier
                        .fillMaxWidth(),
                    text = "Residential $propertyType",
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
                        text = "$allCommentsNumber",
                        color = color,
                        fontSize = 12.sp,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }
                Text(
                    modifier = Modifier
                        .fillMaxWidth(),
                    text = propertyAddress,
                    color = color,
                    fontSize = 12.sp,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }

        }
    }
}