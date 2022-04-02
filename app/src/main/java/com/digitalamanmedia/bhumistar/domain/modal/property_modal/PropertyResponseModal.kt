package com.digitalamanmedia.bhumistar.domain.modal.property_modal


data class PropertyResponseModal(
    val data: List<PropertyDetailModal>?,
    val message: String,
    val status: Int
)
