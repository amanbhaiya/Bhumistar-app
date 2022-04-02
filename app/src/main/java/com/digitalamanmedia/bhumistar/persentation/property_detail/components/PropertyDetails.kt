package com.digitalamanmedia.bhumistar.persentation.property_detail.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun PropertyDetails(
    price:String,
    priceSQFT:String,
    bookingAmount:String,
    emi:String,
    projectName:String,
    buildupArea:String,
    carpetArea:String,
    superBuildupArea:String
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Column (
                    modifier = Modifier
                        .fillMaxWidth(0.5f),
                ){
                    Text(
                        modifier = Modifier
                            .padding(bottom = 3.dp),
                        text = "Property Overview",
                        color = MaterialTheme.colors.primaryVariant.copy(0.6f),
                        fontSize = 14.sp
                    )
                    Text(
                        modifier = Modifier
                            .padding(bottom = 8.dp),
                        text = "₹ $price",
                        color = MaterialTheme.colors.primaryVariant,
                        fontSize = 18.sp
                    )
                    Text(
                        modifier = Modifier
                            .padding(bottom = 3.dp),
                        text = "Price/Sq.ft.",
                        color = MaterialTheme.colors.primaryVariant.copy(0.6f),
                        fontSize = 14.sp
                    )
                    Text(
                        modifier = Modifier
                            .padding(bottom = 8.dp),
                        text = "₹ $priceSQFT",
                        color = MaterialTheme.colors.primaryVariant,
                        fontSize = 18.sp
                    )
                }
                Column (
                    modifier = Modifier
                        .fillMaxWidth(),
                ){
                    Text(
                        modifier = Modifier
                            .padding(bottom = 3.dp),
                        text = "Booking amount",
                        color = MaterialTheme.colors.primaryVariant.copy(0.6f),
                        fontSize = 14.sp
                    )
                    Text(
                        modifier = Modifier
                            .padding(bottom = 8.dp),
                        text = "₹ $bookingAmount",
                        color = MaterialTheme.colors.primaryVariant,
                        fontSize = 18.sp
                    )
                    Text(
                        modifier = Modifier
                            .padding(bottom = 3.dp),
                        text = "EMI starts at",
                        color = MaterialTheme.colors.primaryVariant.copy(0.6f),
                        fontSize = 14.sp
                    )
                    Text(
                        modifier = Modifier
                            .padding(bottom = 8.dp),
                        text = "₹ $emi",
                        color = MaterialTheme.colors.primaryVariant,
                        fontSize = 18.sp
                    )
                }
            }
            Divider()
            Spacer(modifier = Modifier.height(12.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Column (
                    modifier = Modifier
                        .fillMaxWidth(0.5f),
                ){
                    Text(
                        modifier = Modifier
                            .padding(bottom = 3.dp),
                        text = "Property Name",
                        color = MaterialTheme.colors.primaryVariant.copy(0.6f),
                        fontSize = 14.sp
                    )
                    Text(
                        modifier = Modifier
                            .padding(bottom = 8.dp),
                        text = projectName,
                        color = MaterialTheme.colors.primaryVariant,
                        fontSize = 18.sp
                    )
                    Text(
                        modifier = Modifier
                            .padding(bottom = 3.dp),
                        text = "Buildup Area",
                        color = MaterialTheme.colors.primaryVariant.copy(0.6f),
                        fontSize = 14.sp
                    )
                    Text(
                        modifier = Modifier
                            .padding(bottom = 8.dp),
                        text = "$buildupArea/Sq.ft.",
                        color = MaterialTheme.colors.primaryVariant,
                        fontSize = 18.sp
                    )

                }
                Column (
                    modifier = Modifier
                        .fillMaxWidth(),
                ){
                    Text(
                        modifier = Modifier
                            .padding(bottom = 3.dp),
                        text = "Carpet Area",
                        color = MaterialTheme.colors.primaryVariant.copy(0.6f),
                        fontSize = 14.sp
                    )
                    Text(
                        modifier = Modifier
                            .padding(bottom = 8.dp),
                        text = "$carpetArea Sq.ft.",
                        color = MaterialTheme.colors.primaryVariant,
                        fontSize = 18.sp
                    )
                    Text(
                        modifier = Modifier
                            .padding(bottom = 8.dp),
                        text = "Super Build Area",
                        color = MaterialTheme.colors.primaryVariant.copy(0.6f),
                        fontSize = 14.sp
                    )
                    Text(
                        modifier = Modifier
                            .padding(bottom = 8.dp),
                        text = "$superBuildupArea /Sq.ft.",
                        color = MaterialTheme.colors.primaryVariant,
                        fontSize = 18.sp
                    )
                }
            }
        }
    }
}