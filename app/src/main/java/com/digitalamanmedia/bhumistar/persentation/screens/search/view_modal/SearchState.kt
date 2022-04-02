package com.digitalamanmedia.bhumistar.persentation.screens.search.view_modal

import com.digitalamanmedia.bhumistar.domain.modal.property_modal.NormalPropertyResponseModal

data class SearchState(
    val propertyList:List<NormalPropertyResponseModal> = emptyList(),
    val isLoading:Boolean = true,
    val search:String = "",
    val hint:String = "Enter City/Locality/Project/Society",
    val noData:Boolean = false,
    val searchTextWord:String = "",
    val searchTextResult:String = "",
    val listSize:Int = 0,
    val onSearchRefresh:Boolean = false,
)
