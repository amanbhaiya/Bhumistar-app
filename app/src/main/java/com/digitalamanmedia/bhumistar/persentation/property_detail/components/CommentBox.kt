package com.digitalamanmedia.bhumistar.persentation.screens.property_detail.component

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Star
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.digitalamanmedia.bhumistar.core.components.AnimatedButton
import com.digitalamanmedia.bhumistar.ui.theme.YellowP

@Composable
fun CommentBox(
    rating:Int,
    onStarClick:(Int)->Unit,
    comment:String,
    onCommentEnter:(String)->Unit,
    isLogin:Boolean,
    onSubmitComment:()->Unit,
    btnLoading:Boolean
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
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp),
                text = "Leave your comment",
                color = MaterialTheme.colors.error,
                fontSize = 22.sp
            )

            Divider()
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp),
                text = "Leave your comment",
                color = MaterialTheme.colors.primaryVariant.copy(0.5f),
                fontSize = 14.sp
            )
            Spacer(modifier = Modifier.height(4.dp))

            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp),
                text = "Your rating",
                color = MaterialTheme.colors.primaryVariant.copy(0.5f),
                fontSize = 14.sp
            )
            Spacer(modifier = Modifier.height(4.dp))
            Row(modifier = Modifier.fillMaxWidth()) {

                for (i in 0..4){
                    Icon(
                        imageVector = Icons.Filled.Star,
                        contentDescription = "icon",
                        modifier = Modifier.padding(4.dp)
                            .clickable {
                                onStarClick(i+1)
                            },
                        tint = if (i < rating) YellowP else Color.Gray
                    )
                }
            }
            Spacer(modifier = Modifier.height(4.dp))

            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp),
                text = "Your Reviews",
                color = MaterialTheme.colors.primaryVariant.copy(0.5f),
                fontSize = 14.sp
            )
            Spacer(modifier = Modifier.height(4.dp))
            TextField(
                value = comment,
                onValueChange = onCommentEnter,
                placeholder = {
                    Text(
                        text = "Hi there, Leave your comment..."
                    )
                },
                colors = TextFieldDefaults.textFieldColors(
                    cursorColor = MaterialTheme.colors.primaryVariant,
                    textColor =  MaterialTheme.colors.primaryVariant,
                    backgroundColor = Color.Transparent,
                    focusedIndicatorColor = MaterialTheme.colors.primaryVariant,
                    unfocusedIndicatorColor = MaterialTheme.colors.primaryVariant
                ),
                modifier = Modifier
                    .clip(RoundedCornerShape(12.dp))
                    .border(
                        1.3.dp,
                        MaterialTheme.colors.primaryVariant,
                        RoundedCornerShape(12.dp)
                    )
                    .fillMaxWidth()
                    .height(170.dp),
                maxLines = 4
            )
            Spacer(modifier = Modifier.height(12.dp))
            AnimatedButton(
                btnName = if (isLogin) "Submit Review" else "Login as User",
                onSubmitClick = onSubmitComment,
                isBtnLoading = btnLoading,
                btmEnabled = true,
                modifier = Modifier.fillMaxWidth()
                    .height(52.dp)
            )

        }
    }
}