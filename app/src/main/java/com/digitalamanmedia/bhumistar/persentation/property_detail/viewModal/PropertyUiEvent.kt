package com.digitalamanmedia.bhumistar.persentation.property_detail.viewModal

import androidx.navigation.NavController

sealed class PropertyUiEvent {
    data class EnterComment(val comment:String): PropertyUiEvent()
    data class OnClickRating(val rating:Int): PropertyUiEvent()
    data class SubmitReview(val navControllerRoot: NavController): PropertyUiEvent()
    object OnSwipeRefresh: PropertyUiEvent()
    object AllReviews: PropertyUiEvent()
}