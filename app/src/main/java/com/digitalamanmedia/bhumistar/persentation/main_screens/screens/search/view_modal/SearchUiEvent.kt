package com.digitalamanmedia.bhumistar.persentation.main_screens.screens.search.view_modal

import androidx.compose.ui.focus.FocusState

sealed class SearchUiEvent{
    data class Search(val value:String): SearchUiEvent()
    data class ChangeSearchFocus(val focusState: FocusState): SearchUiEvent()
    object SearchQuery: SearchUiEvent()
    object OnSearchRefresh: SearchUiEvent()
}
