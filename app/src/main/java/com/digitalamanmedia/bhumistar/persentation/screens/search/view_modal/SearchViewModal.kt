package com.digitalamanmedia.bhumistar.persentation.screens.search.view_modal

import android.app.Application

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.digitalamanmedia.bhumistar.core.utils.Resource
import com.digitalamanmedia.bhumistar.domain.use_cases.AllUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class SearchViewModal @Inject constructor(
    private val allUseCases: AllUseCases,
    context: Application,
    savedStateHandle: SavedStateHandle
): ViewModel() {

    private val _state = mutableStateOf(SearchState())
    val state: State<SearchState> = _state

    init {
//        savedStateHandle.get<String>("verified")?.let {
//            if (it != "") {
//                getResponseSearchProperty(it)
//            }else{
//                getResponseAllProperty()
//            }
//        }
        getResponseAllProperty()
    }




    fun onUiEvent(event: SearchUiEvent){
        when(event){
            is SearchUiEvent.Search ->{
                _state.value = state.value.copy(
                    search = event.value
                )
            }
            is SearchUiEvent.SearchQuery ->{
               getResponseSearchProperty(
                   searchWord = state.value.search
               )

            }
            is SearchUiEvent.OnSearchRefresh ->{
                getResponseAllProperty()

            }
            is SearchUiEvent.ChangeSearchFocus ->{
                if (event.focusState.isFocused){
                    _state.value = state.value.copy(
                        search = ""
                    )
                }else{
                    _state.value = state.value.copy(
                        search = state.value.hint
                    )

                }
            }
        }
    }

    private fun getResponseSearchProperty(searchWord:String){
        allUseCases.searchPropertyUseCase(searchWord = searchWord).onEach {result->
            when(result){
                is Resource.Loading->{
                    _state.value = state.value.copy(
                        isLoading = true
                    )
                }
                is Resource.Success->{
                    if (result.data.status ==1) {
                        _state.value = state.value.copy(
                            isLoading = false,
                            noData = false,
                            propertyList = result.data.data?.map {
                                it.toNormalPropertyResponseModal()
                            }?: emptyList(),
                            searchTextWord = result.data.message,
                            listSize = result.data.data?.size?:0,
                        )
                    }else{
                        _state.value = state.value.copy(
                            listSize = 0,
                            isLoading = false,
                            noData = true,
                            searchTextWord = "",
                            searchTextResult = result.data.message,
                        )
                    }
                }
                is Resource.Error->{
                    _state.value = state.value.copy(
                        listSize = 0,
                        isLoading = false,
                        noData = true,
                        searchTextWord = "0",
                        searchTextResult = result.message,
                    )
                }
            }
        }.launchIn(viewModelScope)
    }






    private fun getResponseAllProperty(){
        allUseCases.allPropertyListUseCase().onEach {result->
            when(result){

                is Resource.Loading->{
                    _state.value = state.value.copy(
                        isLoading = true
                    )
                }
                is Resource.Success->{
                    if (result.data.status ==1) {
                        _state.value = state.value.copy(
                            isLoading = false,
                            noData = false,
                            propertyList = result.data.data?.map {
                                it.toNormalPropertyResponseModal()
                            }?: emptyList(),
                            searchTextWord = result.data.message,
                            listSize = result.data.data?.size?:0
                        )
                    }else{
                        _state.value = state.value.copy(
                            listSize = 0,
                            isLoading = false,
                            noData = true,
                            searchTextWord = "",
                            searchTextResult = result.data.message,
                        )
                    }
                }
                is Resource.Error->{
                    _state.value = state.value.copy(
                        listSize = 0,
                        isLoading = false,
                        noData = true,
                        searchTextWord = "0",
                        searchTextResult = result.message,
                    )
                }
            }
        }.launchIn(viewModelScope)
    }
}