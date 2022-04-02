package com.digitalamanmedia.bhumistar.persentation.property_uplaod.viewModel

import android.net.Uri

data class PropertyState(
    val picOne: Uri? = null,
    val picTwo: Uri? = null,
    val picThree: Uri? = null,
    val picFour: Uri? = null,
    val isVisible:Boolean = false,
    val isLoading:Boolean = false
)
