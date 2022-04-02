package com.digitalamanmedia.bhumistar.data.remote.dto.responseDto.property_reponse_dto

import com.digitalamanmedia.bhumistar.domain.modal.property_modal.PropertyDetailModal

data class PropertyDetailDto(
    val about_property: String?,
    val booking_amount: String?,
    val buildup_area: String?,
    val carpet_area: String?,
    val comments: List<CommentsDataDto>?,
    val created_at: String?,
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
    val vendor_data: VendorDataDto?,
    val vendor_id: Int?
)
    fun PropertyDetailDto.toPropertyDetailModal(): PropertyDetailModal {
        return PropertyDetailModal(
            about_property = about_property,
            booking_amount = booking_amount,
            buildup_area = buildup_area,
            carpet_area = carpet_area,
            flat_type = flat_type,
            id = id,
            net_price = net_price,
            pic_four = pic_four,
            pic_one = pic_one,
            pic_three = pic_three,
            pic_two = pic_two,
            price_sq_ft = price_sq_ft,
            property_address = property_address,
            property_amenities = property_amenities,
            property_name = property_name,
            property_type = property_type,
            super_buildup_area = super_buildup_area,
            vendor_data = vendor_data?.toVendorDataModal(),
            comments = comments?.map {
                it.toCommentsDataModal()
            }
        )
    }


