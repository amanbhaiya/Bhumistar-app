package com.digitalamanmedia.bhumistar.persentation.screens.profile.profile_screens

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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.digitalamanmedia.bhumistar.R
import com.digitalamanmedia.bhumistar.persentation.screens.profile.view_model.ProfileUserUiEvent
import com.digitalamanmedia.bhumistar.persentation.screens.profile.view_model.ProfileViewModal

@Composable
fun TermsAndConditions(
    viewModel:ProfileViewModal
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
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp, vertical = 16.dp),
            ) {
                Text(
                    text = stringResource(id = R.string.Terms_and_Conditions),
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
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
            ) {
                Text(
                    text = stringResource(id = R.string.Terms_and_Conditions_Text),
                    fontSize = 13.sp,
                    color = MaterialTheme.colors.primaryVariant
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = stringResource(id = R.string.Welcome_to_Bhumistar),
                    fontSize = 18.sp,
                    color = MaterialTheme.colors.error
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = stringResource(id = R.string.Welcome_to_Bhumistar_Text_1),
                    fontSize = 13.sp,
                    color = MaterialTheme.colors.primaryVariant
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = stringResource(id = R.string.Welcome_to_Bhumistar_Text_2),
                    fontSize = 13.sp,
                    color = MaterialTheme.colors.primaryVariant
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = stringResource(id = R.string.To_whom_does_this_policy_apply),
                    fontSize = 18.sp,
                    color = MaterialTheme.colors.error
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = stringResource(id = R.string.To_whom_does_this_policy_apply_Text),
                    fontSize = 13.sp,
                    color = MaterialTheme.colors.primaryVariant
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = stringResource(id = R.string.Users),
                    fontSize = 16.sp,
                    color = MaterialTheme.colors.error
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = stringResource(id = R.string.Users_Text),
                    fontSize = 13.sp,
                    color = MaterialTheme.colors.primaryVariant
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = stringResource(id = R.string.What_information_do_we_collect_and_where_do_we_get_it_from),
                    fontSize = 18.sp,
                    color = MaterialTheme.colors.error
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = stringResource(id = R.string.What_information_do_we_collect_and_where_do_we_get_it_from_Text_1),
                    fontSize = 13.sp,
                    color = MaterialTheme.colors.primaryVariant
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = stringResource(id = R.string.What_information_do_we_collect_and_where_do_we_get_it_from_Text_2),
                    fontSize = 13.sp,
                    color = MaterialTheme.colors.primaryVariant
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = stringResource(id = R.string.What_information_do_we_collect_and_where_do_we_get_it_from_Text_3),
                    fontSize = 13.sp,
                    color = MaterialTheme.colors.primaryVariant
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = stringResource(id = R.string.What_information_do_we_collect_and_where_do_we_get_it_from_Text_4),
                    fontSize = 13.sp,
                    color = MaterialTheme.colors.primaryVariant
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = stringResource(id = R.string.Information_we_collect_from_REPs),
                    fontSize = 16.sp,
                    color = MaterialTheme.colors.error
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = stringResource(id = R.string.Information_we_collect_from_REPs_Text_1),
                    fontSize = 13.sp,
                    color = MaterialTheme.colors.primaryVariant
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = stringResource(id = R.string.Information_we_collect_from_REPs_Text_2),
                    fontSize = 13.sp,
                    color = MaterialTheme.colors.primaryVariant
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = stringResource(id = R.string.Location_Data),
                    fontSize = 16.sp,
                    color = MaterialTheme.colors.error
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = stringResource(id = R.string.Location_Data_Text),
                    fontSize = 13.sp,
                    color = MaterialTheme.colors.primaryVariant
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = stringResource(id = R.string.Why_we_collect_information_from_you),
                    fontSize = 18.sp,
                    color = MaterialTheme.colors.primaryVariant
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    modifier = Modifier.padding(start = 20.dp),
                    text = stringResource(id = R.string.Why_we_collect_information_from_you_Text_1),
                    fontSize = 13.sp,
                    color = MaterialTheme.colors.primaryVariant
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    modifier = Modifier.padding(start = 20.dp),
                    text = stringResource(id = R.string.Why_we_collect_information_from_you_Text_2),
                    fontSize = 13.sp,
                    color = MaterialTheme.colors.primaryVariant
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    modifier = Modifier.padding(start = 20.dp),
                    text = stringResource(id = R.string.Why_we_collect_information_from_you_Text_3),
                    fontSize = 13.sp,
                    color = MaterialTheme.colors.primaryVariant
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = stringResource(id = R.string.Services_Description),
                    fontSize = 16.sp,
                    color = MaterialTheme.colors.error
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = stringResource(id = R.string.Services_Description_Text_1),
                    fontSize = 13.sp,
                    color = MaterialTheme.colors.primaryVariant
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = stringResource(id = R.string.Services_Description_Text_2),
                    fontSize = 13.sp,
                    color = MaterialTheme.colors.primaryVariant
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = stringResource(id = R.string.Services_Description_Text_3),
                    fontSize = 13.sp,
                    color = MaterialTheme.colors.primaryVariant
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = stringResource(id = R.string.With_respect_to_Ad_servers),
                    fontSize = 16.sp,
                    color = MaterialTheme.colors.error
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = stringResource(id = R.string.With_respect_to_Ad_servers_Text),
                    fontSize = 13.sp,
                    color = MaterialTheme.colors.primaryVariant
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = stringResource(id = R.string.Direct_contact_with_REP),
                    fontSize = 16.sp,
                    color = MaterialTheme.colors.error
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = stringResource(id = R.string.Direct_contact_with_REP_Text),
                    fontSize = 13.sp,
                    color = MaterialTheme.colors.primaryVariant
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = stringResource(id = R.string.Mortgage_services),
                    fontSize = 16.sp,
                    color = MaterialTheme.colors.error
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = stringResource(id = R.string.Mortgage_services_Text),
                    fontSize = 13.sp,
                    color = MaterialTheme.colors.primaryVariant
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = stringResource(id = R.string.User_Generated_Content),
                    fontSize = 16.sp,
                    color = MaterialTheme.colors.error
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = stringResource(id = R.string.User_Generated_Content_Text_1),
                    fontSize = 13.sp,
                    color = MaterialTheme.colors.primaryVariant
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = stringResource(id = R.string.User_Generated_Content_Text_2),
                    fontSize = 13.sp,
                    color = MaterialTheme.colors.primaryVariant
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = stringResource(id = R.string.Representations_and_Warranties_by_REPs),
                    fontSize = 18.sp,
                    color = MaterialTheme.colors.error
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = stringResource(id = R.string.Representations_and_Warranties_by_REPs_Text),
                    fontSize = 13.sp,
                    color = MaterialTheme.colors.primaryVariant
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    modifier = Modifier.padding(start = 20.dp),
                    text = stringResource(id = R.string.Representations_and_Warranties_by_REPs_Text_1),
                    fontSize = 13.sp,
                    color = MaterialTheme.colors.primaryVariant
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    modifier = Modifier.padding(start = 20.dp),
                    text = stringResource(id = R.string.Representations_and_Warranties_by_REPs_Text_2),
                    fontSize = 13.sp,
                    color = MaterialTheme.colors.primaryVariant
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    modifier = Modifier.padding(start = 20.dp),
                    text = stringResource(id = R.string.Representations_and_Warranties_by_REPs_Text_3),
                    fontSize = 13.sp,
                    color = MaterialTheme.colors.primaryVariant
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    modifier = Modifier.padding(start = 20.dp),
                    text = stringResource(id = R.string.Representations_and_Warranties_by_REPs_Text_4),
                    fontSize = 13.sp,
                    color = MaterialTheme.colors.primaryVariant
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = stringResource(id = R.string.Disclaimers_related_to_completeness_and_authenticity_of_the_content_listings),
                    fontSize = 18.sp,
                    color = MaterialTheme.colors.error
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    modifier = Modifier.padding(start = 20.dp),
                    text = stringResource(id = R.string.Disclaimers_related_to_completeness_and_authenticity_of_the_content_listings_Text_1),
                    fontSize = 13.sp,
                    color = MaterialTheme.colors.primaryVariant
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    modifier = Modifier.padding(start = 20.dp),
                    text = stringResource(id = R.string.Disclaimers_related_to_completeness_and_authenticity_of_the_content_listings_Text_2),
                    fontSize = 13.sp,
                    color = MaterialTheme.colors.primaryVariant
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    modifier = Modifier.padding(start = 20.dp),
                    text = stringResource(id = R.string.Disclaimers_related_to_completeness_and_authenticity_of_the_content_listings_Text_3),
                    fontSize = 13.sp,
                    color = MaterialTheme.colors.primaryVariant
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    modifier = Modifier.padding(start = 40.dp),
                    text = stringResource(id = R.string.Certain_points_to_bear_in_mind_Text_1),
                    fontSize = 13.sp,
                    color = MaterialTheme.colors.primaryVariant
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    modifier = Modifier.padding(start = 40.dp),
                    text = stringResource(id = R.string.Certain_points_to_bear_in_mind_Text_2),
                    fontSize = 13.sp,
                    color = MaterialTheme.colors.primaryVariant
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    modifier = Modifier.padding(start = 40.dp),
                    text = stringResource(id = R.string.Certain_points_to_bear_in_mind_Text_3),
                    fontSize = 13.sp,
                    color = MaterialTheme.colors.primaryVariant
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    modifier = Modifier.padding(start = 40.dp),
                    text = stringResource(id = R.string.Certain_points_to_bear_in_mind_Text_4),
                    fontSize = 13.sp,
                    color = MaterialTheme.colors.primaryVariant
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    modifier = Modifier.padding(start = 40.dp),
                    text = stringResource(id = R.string.Certain_points_to_bear_in_mind_Text_5),
                    fontSize = 13.sp,
                    color = MaterialTheme.colors.primaryVariant
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    modifier = Modifier.padding(start = 20.dp),
                    text = stringResource(id = R.string.Disclaimers_related_to_completeness_and_authenticity_of_the_content_listings_Text_4),
                    fontSize = 13.sp,
                    color = MaterialTheme.colors.primaryVariant
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    modifier = Modifier.padding(start = 20.dp),
                    text = stringResource(id = R.string.Disclaimers_related_to_completeness_and_authenticity_of_the_content_listings_Text_5),
                    fontSize = 13.sp,
                    color = MaterialTheme.colors.primaryVariant
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    modifier = Modifier.padding(start = 20.dp),
                    text = stringResource(id = R.string.Disclaimers_related_to_completeness_and_authenticity_of_the_content_listings_Text_6),
                    fontSize = 13.sp,
                    color = MaterialTheme.colors.primaryVariant
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    modifier = Modifier.padding(start = 20.dp),
                    text = stringResource(id = R.string.Disclaimers_related_to_completeness_and_authenticity_of_the_content_listings_Text_7),
                    fontSize = 13.sp,
                    color = MaterialTheme.colors.primaryVariant
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = stringResource(id = R.string.Disclaimers_related_to_completeness_and_authenticity_of_the_content_listings_Text_8),
                    fontSize = 13.sp,
                    color = MaterialTheme.colors.primaryVariant
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = stringResource(id = R.string.Copyright_and_Trademark_Policy),
                    fontSize = 16.sp,
                    color = MaterialTheme.colors.error
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = stringResource(id = R.string.Copyright_and_Trademark_Policy_Text_1),
                    fontSize = 13.sp,
                    color = MaterialTheme.colors.primaryVariant
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = stringResource(id = R.string.Copyright_and_Trademark_Policy_Text_2),
                    fontSize = 13.sp,
                    color = MaterialTheme.colors.primaryVariant
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = stringResource(id = R.string.Copyright_and_Trademark_Policy_Text_3),
                    fontSize = 13.sp,
                    color = MaterialTheme.colors.primaryVariant
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = stringResource(id = R.string.General_Matters),
                    fontSize = 18.sp,
                    color = MaterialTheme.colors.error
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = stringResource(id = R.string.General_Matters_Text),
                    fontSize = 13.sp,
                    color = MaterialTheme.colors.primaryVariant
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = stringResource(id = R.string.Third_Party_Websites),
                    fontSize = 16.sp,
                    color = MaterialTheme.colors.error
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = stringResource(id = R.string.Third_Party_Websites_Text),
                    fontSize = 13.sp,
                    color = MaterialTheme.colors.primaryVariant
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = stringResource(id = R.string.Home_Loan_services),
                    fontSize = 16.sp,
                    color = MaterialTheme.colors.error
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = stringResource(id = R.string.Home_Loan_services_Text),
                    fontSize = 13.sp,
                    color = MaterialTheme.colors.primaryVariant
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = stringResource(id = R.string.Sale_Merger),
                    fontSize = 16.sp,
                    color = MaterialTheme.colors.error
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = stringResource(id = R.string.Sale_Merger_Text),
                    fontSize = 13.sp,
                    color = MaterialTheme.colors.primaryVariant
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = stringResource(id = R.string.Indemnification_and_Limitation_of_Liability),
                    fontSize = 16.sp,
                    color = MaterialTheme.colors.error
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = stringResource(id = R.string.Indemnification_and_Limitation_of_Liability_Text_1),
                    fontSize = 13.sp,
                    color = MaterialTheme.colors.primaryVariant
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = stringResource(id = R.string.Indemnification_and_Limitation_of_Liability_Text_2),
                    fontSize = 13.sp,
                    color = MaterialTheme.colors.primaryVariant
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = stringResource(id = R.string.Indemnification_and_Limitation_of_Liability_Text_3),
                    fontSize = 13.sp,
                    color = MaterialTheme.colors.primaryVariant
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = stringResource(id = R.string.Information_we_collect_from_REPs),
                    fontSize = 13.sp,
                    color = MaterialTheme.colors.primaryVariant
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = stringResource(id = R.string.Amendment_to_the_Terms_of_Service),
                    fontSize = 16.sp,
                    color = MaterialTheme.colors.error
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = stringResource(id = R.string.Amendment_to_the_Terms_of_Service_Text),
                    fontSize = 13.sp,
                    color = MaterialTheme.colors.primaryVariant
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = stringResource(id = R.string.Arbitration),
                    fontSize = 16.sp,
                    color = MaterialTheme.colors.error
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = stringResource(id = R.string.Arbitration_Text),
                    fontSize = 13.sp,
                    color = MaterialTheme.colors.primaryVariant
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = stringResource(id = R.string.Grievance_Redress_Mechanism),
                    fontSize = 16.sp,
                    color = MaterialTheme.colors.error
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = stringResource(id = R.string.Grievance_Redress_Mechanism_Text),
                    fontSize = 13.sp,
                    color = MaterialTheme.colors.primaryVariant
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = stringResource(id = R.string.Owner_Terms),
                    fontSize = 16.sp,
                    color = MaterialTheme.colors.error
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = stringResource(id = R.string.Owner_Terms_Text),
                    fontSize = 13.sp,
                    color = MaterialTheme.colors.primaryVariant
                )

            }
        }
        Spacer(modifier = Modifier.height(70.dp))
        BackHandler() {
            viewModel.onUiEvent(ProfileUserUiEvent.TermsIsBack)
        }
    }
}