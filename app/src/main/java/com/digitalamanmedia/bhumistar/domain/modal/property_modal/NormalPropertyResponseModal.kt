package com.digitalamanmedia.bhumistar.domain.modal.property_modal


data class NormalPropertyResponseModal(
    val id: Int?,
    val net_price: String?,
    val pic_one: String?,
    val price_sq_ft: String?,
    val property_address: String?,
    val property_name: String?,
    val property_type: String?,
    val vendor_name: String?,
    val vendor_type: String?,
    val comments:List<CommentsDataModal>?

)