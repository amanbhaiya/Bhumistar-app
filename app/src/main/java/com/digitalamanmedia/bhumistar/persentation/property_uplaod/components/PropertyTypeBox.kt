package com.digitalamanmedia.bhumistar.persentation.property_uplaod.components


import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.digitalamanmedia.bhumistar.persentation.authentication.components.CheckBox
import com.google.accompanist.flowlayout.FlowRow

@Composable
fun PropertyTypeBox(
    list: List<String>,
    selectedOption:String,
    onBoxClick:(String)->Unit
) {
    FlowRow(
        modifier = Modifier
            .fillMaxWidth(),
        mainAxisSpacing = 10.dp,
        crossAxisSpacing = 10.dp
    ) {
        list.forEach {
            CheckBox(
                text = it,
                selected = (selectedOption == it),
                onClick = {
                    onBoxClick(it)
                }
            )
        }
    }
}