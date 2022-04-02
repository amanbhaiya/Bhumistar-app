package com.digitalamanmedia.bhumistar.data.remote.dto.VendorDto

data class CreateVendorDto(
    val vendor_type:String,
    val vendor_name:String,
    val vendor_ph_number:String,
    val vendor_email:String,
    val vendor_password:String
)
