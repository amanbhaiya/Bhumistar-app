package com.digitalamanmedia.bhumistar.persentation.property_detail.viewModal

import com.digitalamanmedia.bhumistar.domain.modal.property_modal.CommentsDataModal

data class PropertyDetailState(
    val showAllComments:Boolean = false,
    val commentBtnLoading:Boolean = false,
    val isLogin:Boolean = false,
    val isLoading:Boolean = false,
    val errorMessage:String = "",
    val about_property: String = "",
    val booking_amount: String = "",
    val buildup_area: String = "",
    val carpet_area: String = "",
    val comments: List<CommentsDataModal> = emptyList(),
    val created_at: String = "",
    val flat_type: String = "",
    val net_price: String = "",
    val pic_four: String = "",
    val pic_one: String = "",
    val pic_three: String = "",
    val pic_two: String = "",
    val price_sq_ft: String = "",
    val property_address: String = "",
    val property_amenities:List<String> = emptyList(),
    val property_name: String = "",
    val property_type: String = "",
    val super_buildup_area: String = "",
    val vendor_type:String = "",
    val vendor_name:String = "",
    val isRefreshing:Boolean = false,
    val averageRating:Float = 0F,
    val onlyTwoComments:Boolean = true
)
