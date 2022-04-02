package com.digitalamanmedia.bhumistar.domain.modal.property_modal


data class PropertyDetailModal(
    val about_property: String?,
    val booking_amount: String?,
    val buildup_area: String?,
    val carpet_area: String?,
    val comments: List<CommentsDataModal>?,
    val flat_type: String?,
    val id: Int?,
    val net_price: String?,
    val pic_four: String?,
    val pic_one: String?,
    val pic_three: String?,
    val pic_two: String?,
    val price_sq_ft: String?,
    val property_address: String?,
    val property_amenities: String?,
    val property_name: String?,
    val property_type: String?,
    val super_buildup_area: String?,
    val vendor_data: VendorDataModal?
) {
    fun toNormalPropertyResponseModal(): NormalPropertyResponseModal {
        return NormalPropertyResponseModal(
            id = id,
            net_price = net_price,
            pic_one = pic_one,
            price_sq_ft = price_sq_ft,
            property_name = property_name,
            property_address = property_address,
            property_type = property_type,
            vendor_name = vendor_data?.vendor_name,
            vendor_type = vendor_data?.vendor_type,
            comments = comments
        )
    }

}