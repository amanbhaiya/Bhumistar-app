package com.digitalamanmedia.bhumistar.persentation.property_detail.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.digitalamanmedia.bhumistar.ui.theme.OnBoarding
import com.digitalamanmedia.bhumistar.ui.theme.YellowP

@Composable
fun UpperDetail(
    rating:Int,
    propertyName:String,
    vendorName:String,
    vendorType:String,
    propertyAddress:String,
    reviews:Int,
    propertySQFT:String,
    netPrice:String
) {
    Box(modifier = Modifier.background(Color.Black)) {
        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp)
            .background(Color.Black)
        ) {
            Text(
                modifier = Modifier
                    .fillMaxWidth(),
                text = propertyName,
                color = MaterialTheme.colors.error,
                fontSize = 30.sp
            )
            Spacer(modifier = Modifier.height(12.dp))
            Row(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = "By:",
                    color = Color.White,
                    fontSize = 14.sp
                )
                Spacer(modifier = Modifier.width(2.dp))
                Text(
                    text = vendorName,
                    color = MaterialTheme.colors.error,
                    fontSize = 14.sp
                )
                Spacer(modifier = Modifier.width(2.dp))
                Text(
                    text = "($vendorType)",
                    color = Color.Gray,
                    fontSize = 14.sp
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                modifier = Modifier
                    .fillMaxWidth(0.85f),
                text = propertyAddress,
                color = Color.White,
                fontSize = 12.sp
            )
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                for (i in 0..4){
                    Icon(
                        imageVector = Icons.Filled.Star,
                        contentDescription = "icon",
                        modifier = Modifier.padding(2.dp)
                            .size(17.dp),
                        tint = if (i < rating) YellowP else Color.Gray
                    )
                }
                Spacer(modifier = Modifier.width(4.dp))
                Icon(
                    modifier = Modifier.size(12.dp),
                    imageVector = Icons.Default.Person,
                    contentDescription = "",
                    tint = Color.White
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = "($reviews Reviews)",
                    fontSize = 12.sp,
                    modifier = Modifier
                        .fillMaxWidth(),
                    color = Color.White,
                )
            }
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                modifier = Modifier
                    .fillMaxWidth(),
                text = "₹ $netPrice",
                color = Color.White,
                fontSize = 30.sp
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                modifier = Modifier
                    .fillMaxWidth(),
                text = "₹ $propertySQFT/sq.ftL",
                color = Color.White,
                fontSize = 18.sp
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                modifier = Modifier
                    .fillMaxWidth(),
                text = "EMI starts at ₹ 4.14K/sq.ftL",
                color = OnBoarding,
                fontSize = 18.sp
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                modifier = Modifier
                    .fillMaxWidth(0.8f),
                text = "Price excludes maintenance, floor rise coat, stamp duty, registration, GST etc.",
                color = Color.White,
                fontSize = 12.sp
            )
            Spacer(modifier = Modifier.height(20.dp))
        }
    }
}