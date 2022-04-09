package com.digitalamanmedia.bhumistar.persentation.main_screens.screens.profile.profile_screens

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.digitalamanmedia.bhumistar.R
import com.digitalamanmedia.bhumistar.persentation.main_screens.screens.profile.view_model.ProfileUserUiEvent
import com.digitalamanmedia.bhumistar.persentation.main_screens.screens.profile.view_model.ProfileViewModal

@Composable
fun PrivacyPolicy(
    viewModel: ProfileViewModal
) {
    val scrollState = rememberScrollState()
    Column(modifier = Modifier
        .fillMaxWidth()
        .verticalScroll(scrollState)
        .padding(horizontal = 16.dp, vertical = 16.dp),
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Box(modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp, vertical = 16.dp),
            ) {
                Text(
                    text = stringResource(id = R.string.Privacy_Policy),
                    fontSize = 28.sp,
                    color = MaterialTheme.colors.primaryVariant
                )
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Card(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Column(modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            ) {
                Text(
                    text = stringResource(id = R.string.Introduction),
                    fontSize = 18.sp,
                    color = MaterialTheme.colors.error
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = stringResource(id = R.string.Introduction_Text_1),
                    fontSize = 13.sp,
                    color = MaterialTheme.colors.primaryVariant
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = stringResource(id = R.string.Introduction_Text_2),
                    fontSize = 13.sp,
                    color = MaterialTheme.colors.primaryVariant
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = stringResource(id = R.string.Using_our_services),
                    fontSize = 18.sp,
                    color = MaterialTheme.colors.error
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = stringResource(id = R.string.Using_our_services_Text_1),
                    fontSize = 13.sp,
                    color = MaterialTheme.colors.primaryVariant
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = stringResource(id = R.string.Using_our_services_Text_2),
                    fontSize = 13.sp,
                    color = MaterialTheme.colors.primaryVariant
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = stringResource(id = R.string.Why_Personal_Data_that_we_collect_about_you),
                    fontSize = 16.sp,
                    color = MaterialTheme.colors.error
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = stringResource(id = R.string.Why_Personal_Data_that_we_collect_about_you_Text_1),
                    fontSize = 13.sp,
                    color = MaterialTheme.colors.primaryVariant
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    modifier = Modifier.padding(start = 20.dp),
                    text = stringResource(id = R.string.Why_Personal_Data_that_we_collect_about_you_Text_2),
                    fontSize = 13.sp,
                    color = MaterialTheme.colors.primaryVariant
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    modifier = Modifier.padding(start = 20.dp),
                    text = stringResource(id = R.string.Why_Personal_Data_that_we_collect_about_you_Text_3),
                    fontSize = 13.sp,
                    color = MaterialTheme.colors.primaryVariant
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    modifier = Modifier.padding(start = 20.dp),
                    text = stringResource(id = R.string.Why_Personal_Data_that_we_collect_about_you_Text_4),
                    fontSize = 13.sp,
                    color = MaterialTheme.colors.primaryVariant
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = stringResource(id = R.string.Why_Personal_Data_that_we_collect_about_you_Text_5),
                    fontSize = 13.sp,
                    color = MaterialTheme.colors.primaryVariant
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = stringResource(id = R.string.Information_that_we_collect_automatically_on_our_Sites),
                    fontSize = 16.sp,
                    color = MaterialTheme.colors.error
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = stringResource(id = R.string.Information_that_we_collect_automatically_on_our_Sites_Text_1),
                    fontSize = 13.sp,
                    color = MaterialTheme.colors.primaryVariant
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = stringResource(id = R.string.Information_that_we_collect_automatically_on_our_Sites_Text_2),
                    fontSize = 13.sp,
                    color = MaterialTheme.colors.primaryVariant
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = stringResource(id = R.string.Information_that_we_collect_automatically_on_our_Sites_Text_3),
                    fontSize = 13.sp,
                    color = MaterialTheme.colors.primaryVariant
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = stringResource(id = R.string.Information_that_we_collect_automatically_on_our_Sites_Text_4),
                    fontSize = 13.sp,
                    color = MaterialTheme.colors.primaryVariant
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = stringResource(id = R.string.How_We_Share_Your_Information),
                    fontSize = 18.sp,
                    color = MaterialTheme.colors.error
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = stringResource(id = R.string.How_We_Share_Your_Information_Text_1),
                    fontSize = 13.sp,
                    color = MaterialTheme.colors.primaryVariant
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    modifier = Modifier.padding(start = 20.dp),
                    text = stringResource(id = R.string.How_We_Share_Your_Information_Text_2),
                    fontSize = 13.sp,
                    color = MaterialTheme.colors.primaryVariant
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    modifier = Modifier.padding(start = 20.dp),
                    text = stringResource(id = R.string.How_We_Share_Your_Information_Text_3),
                    fontSize = 13.sp,
                    color = MaterialTheme.colors.primaryVariant
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    modifier = Modifier.padding(start = 20.dp),
                    text = stringResource(id = R.string.How_We_Share_Your_Information_Text_4),
                    fontSize = 13.sp,
                    color = MaterialTheme.colors.primaryVariant
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = stringResource(id = R.string.How_We_Share_Your_Information_Text_5),
                    fontSize = 13.sp,
                    color = MaterialTheme.colors.primaryVariant
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    modifier = Modifier.padding(start = 20.dp),
                    text = stringResource(id = R.string.How_We_Share_Your_Information_Text_6),
                    fontSize = 13.sp,
                    color = MaterialTheme.colors.primaryVariant
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    modifier = Modifier.padding(start = 20.dp),
                    text = stringResource(id = R.string.How_We_Share_Your_Information_Text_7),
                    fontSize = 13.sp,
                    color = MaterialTheme.colors.primaryVariant
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    modifier = Modifier.padding(start = 20.dp),
                    text = stringResource(id = R.string.How_We_Share_Your_Information_Text_8),
                    fontSize = 13.sp,
                    color = MaterialTheme.colors.primaryVariant
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    modifier = Modifier.padding(start = 20.dp),
                    text = stringResource(id = R.string.How_We_Share_Your_Information_Text_9),
                    fontSize = 13.sp,
                    color = MaterialTheme.colors.primaryVariant
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = stringResource(id = R.string.How_We_Share_Your_Information_Text_10),
                    fontSize = 13.sp,
                    color = MaterialTheme.colors.primaryVariant
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = stringResource(id = R.string.How_We_Share_Your_Information_Text_11),
                    fontSize = 13.sp,
                    color = MaterialTheme.colors.primaryVariant
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = stringResource(id = R.string.How_We_Share_Your_Information_Text_12),
                    fontSize = 13.sp,
                    color = MaterialTheme.colors.primaryVariant
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = stringResource(id = R.string.How_We_Share_Your_Information_Text_13),
                    fontSize = 13.sp,
                    color = MaterialTheme.colors.primaryVariant
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = stringResource(id = R.string.How_We_Share_Your_Information_Text_14),
                    fontSize = 13.sp,
                    color = MaterialTheme.colors.primaryVariant
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = stringResource(id = R.string.How_We_Share_Your_Information_Text_15),
                    fontSize = 13.sp,
                    color = MaterialTheme.colors.primaryVariant
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = stringResource(id = R.string.How_We_Share_Your_Information_Text_16),
                    fontSize = 13.sp,
                    color = MaterialTheme.colors.primaryVariant
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = stringResource(id = R.string.How_We_Share_Your_Information_Text_17),
                    fontSize = 13.sp,
                    color = MaterialTheme.colors.primaryVariant
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    modifier = Modifier.padding(start = 20.dp),
                    text = stringResource(id = R.string.How_We_Share_Your_Information_Text_18),
                    fontSize = 13.sp,
                    color = MaterialTheme.colors.primaryVariant
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    modifier = Modifier.padding(start = 20.dp),
                    text = stringResource(id = R.string.How_We_Share_Your_Information_Text_19),
                    fontSize = 13.sp,
                    color = MaterialTheme.colors.primaryVariant
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    modifier = Modifier.padding(start = 20.dp),
                    text = stringResource(id = R.string.How_We_Share_Your_Information_Text_20),
                    fontSize = 13.sp,
                    color = MaterialTheme.colors.primaryVariant
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = stringResource(id = R.string.How_We_Share_Your_Information_Text_21),
                    fontSize = 13.sp,
                    color = MaterialTheme.colors.primaryVariant
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = stringResource(id = R.string.How_We_Share_Your_Information_Text_22),
                    fontSize = 13.sp,
                    color = MaterialTheme.colors.primaryVariant
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = stringResource(id = R.string.How_We_Share_Your_Information_Text_23),
                    fontSize = 13.sp,
                    color = MaterialTheme.colors.primaryVariant
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = stringResource(id = R.string.How_We_Share_Your_Information_Text_24),
                    fontSize = 13.sp,
                    color = MaterialTheme.colors.primaryVariant
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = stringResource(id = R.string.How_We_Share_Your_Information_Text_25),
                    fontSize = 13.sp,
                    color = MaterialTheme.colors.primaryVariant
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = stringResource(id = R.string.How_We_Share_Your_Information_Text_26),
                    fontSize = 13.sp,
                    color = MaterialTheme.colors.primaryVariant
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = stringResource(id = R.string.How_We_Share_Your_Information_Text_27),
                    fontSize = 13.sp,
                    color = MaterialTheme.colors.primaryVariant
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = stringResource(id = R.string.General_Matter),
                    fontSize = 18.sp,
                    color = MaterialTheme.colors.error
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = stringResource(id = R.string.General_Matter_Text_1),
                    fontSize = 13.sp,
                    color = MaterialTheme.colors.primaryVariant
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = stringResource(id = R.string.General_Matter_Text_2),
                    fontSize = 13.sp,
                    color = MaterialTheme.colors.primaryVariant
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = stringResource(id = R.string.General_Matter_Text_3),
                    fontSize = 13.sp,
                    color = MaterialTheme.colors.primaryVariant
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = stringResource(id = R.string.General_Matter_Text_4),
                    fontSize = 13.sp,
                    color = MaterialTheme.colors.primaryVariant
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = stringResource(id = R.string.General_Matter_Text_5),
                    fontSize = 13.sp,
                    color = MaterialTheme.colors.primaryVariant
                )

            }
        }
        Spacer(modifier = Modifier.height(70.dp))
        BackHandler() {
            viewModel.onUiEvent(ProfileUserUiEvent.PrivacyIsBack)
        }
    }

}