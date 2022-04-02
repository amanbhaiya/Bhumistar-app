package com.digitalamanmedia.bhumistar.persentation.property_detail.viewModal

sealed class PropertyUiEvent {
    data class EnterComment(val comment:String): PropertyUiEvent()
    data class OnClickRating(val rating:Int): PropertyUiEvent()
    object SubmitReview: PropertyUiEvent()
    object OnSwipeRefresh: PropertyUiEvent()
    object AllReviews: PropertyUiEvent()
}