package com.digitalamanmedia.bhumistar.persentation.main_screens.screens.search.view_modal

import com.digitalamanmedia.bhumistar.domain.modal.property_modal.NormalPropertyResponseModal

data class SearchState(
    val propertyList:List<NormalPropertyResponseModal> = emptyList(),
    val lastPage:Boolean = false,
    val isLoading:Boolean = true,
    val searchByType:Boolean = false,
    val searchByWord:Boolean = false,
    val searchByMostRated:Boolean = false,
    val search:String = "",
    val hint:String = "Enter City/Locality/Project/Society",
    val noData:Boolean = false,
    val searchTextWord:String = "",
    val searchTextResult:String = "",
    val listSize:Int = 0,
    val onSearchRefresh:Boolean = false,
)
