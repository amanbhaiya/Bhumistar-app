package com.digitalamanmedia.bhumistar.persentation.main_screens.screens.search.view_modal

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.digitalamanmedia.bhumistar.core.Commons.Companion.APARTMENT_VILLA
import com.digitalamanmedia.bhumistar.core.Commons.Companion.FLAT
import com.digitalamanmedia.bhumistar.core.Commons.Companion.LAND_PLOT
import com.digitalamanmedia.bhumistar.core.Commons.Companion.MOST_RATED
import com.digitalamanmedia.bhumistar.core.Commons.Companion.PAGE_SIZE
import com.digitalamanmedia.bhumistar.core.utils.Resource
import com.digitalamanmedia.bhumistar.core.utils.RoundOffRating
import com.digitalamanmedia.bhumistar.domain.modal.property_modal.NormalPropertyResponseModal
import com.digitalamanmedia.bhumistar.domain.use_cases.AllUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class SearchViewModal @Inject constructor(
    private val allUseCases: AllUseCases,
    savedStateHandle: SavedStateHandle
): ViewModel() {

    val propertyListNew = mutableStateOf<List<NormalPropertyResponseModal>>(listOf())


    private val _state = mutableStateOf(SearchState())
    val state: State<SearchState> = _state
    private val _type = mutableStateOf("")
    val type: State<String> = _type

    val page = mutableStateOf(1)
    val typeWord = mutableStateOf("All Property Lists")


    var listScrollPosition = 0






    init {
        savedStateHandle.get<String>("verified")?.let {types->
            _type.value = types
            _state.value = state.value.copy(
                search = types
            )
            when(types){
                FLAT->{
                    getResponsePropertyByType(types)
                }
                LAND_PLOT->{

                    getResponseSearchProperty(type.value)
                }
                APARTMENT_VILLA->{
                    getResponseSearchProperty(type.value)
                }
                MOST_RATED->{
                    typeWord.value = MOST_RATED
                    getMostRatedProperty()
                }
                else->{
                    getResponseAllPropertyFirstPage()
                }
            }
        }
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
                getResponseAllPropertyFirstPage()

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


    private fun getMostRatedProperty(){
        propertyListNew.value = emptyList()
        page.value = 1
        allUseCases.allPropertyListUseCase(typeWord.value,page.value, PAGE_SIZE).onEach { result->
            when(result){
                is Resource.Loading->{
                    _state.value = state.value.copy(
                        isLoading = true
                    )
                }
                is Resource.Success->{
                    if (result.data.status == 1) {

                        Log.d("size", result.data.data?.map { it.comments?.size }.toString())

                        propertyListNew.value = result.data.data?.filter {
                            it.comments?.isNotEmpty()?:true
                        }?.map {
                            it.toNormalPropertyResponseModal()
                        }?: emptyList()
                        _state.value = state.value.copy(
                            isLoading = false,
                            noData = false,
                            lastPage = false,
                            searchByType = false,
                            searchByMostRated = true,
                            searchByWord = false,
                            searchTextWord = result.data.message,
                            listSize = propertyListNew.value.size
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

    private fun getResponseSearchProperty(searchWord:String){
        page.value = 1
        propertyListNew.value = emptyList()
        allUseCases.searchPropertyUseCase(
            searchWord = searchWord,
            page = page.value,
            limit = PAGE_SIZE
        ).onEach { result->
            when(result){
                is Resource.Loading->{
                    _state.value = state.value.copy(
                        isLoading = true
                    )
                }
                is Resource.Success->{
                    if (result.data.status ==1) {
                        propertyListNew.value = result.data.data?.map {
                            it.toNormalPropertyResponseModal()
                        }?: emptyList()
                        _state.value = state.value.copy(
                            isLoading = false,
                            noData = false,
                            lastPage = false,
                            searchByType = false,
                            searchByMostRated = false,
                            searchByWord = true,
                            searchTextWord = result.data.message,
                            listSize = propertyListNew.value.size
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

    private fun getResponsePropertyByType(type:String){
        page.value = 1
        propertyListNew.value = emptyList()
        allUseCases.getPropertyByTypeUseCase(
            type = type,
            page = page.value,
            limit = PAGE_SIZE
        ).onEach {result->
            when(result){
                is Resource.Loading->{
                    _state.value = state.value.copy(
                        isLoading = true
                    )
                }
                is Resource.Success->{
                    if (result.data.status ==1) {
                        propertyListNew.value = result.data.data?.map {
                            it.toNormalPropertyResponseModal()
                        }?: emptyList()
                        _state.value = state.value.copy(
                            isLoading = false,
                            noData = false,
                            lastPage = false,
                            searchByType = true,
                            searchByMostRated = false,
                            searchByWord = false,
                            searchTextWord = result.data.message,
                            listSize = propertyListNew.value.size
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



    private fun getResponseAllPropertyFirstPage(){
        page.value = 1
        propertyListNew.value = emptyList()

        allUseCases.allPropertyListUseCase(typeWord.value,page.value, PAGE_SIZE).onEach {result->
            when(result){

                is Resource.Loading->{
                    _state.value = state.value.copy(
                        isLoading = true
                    )
                }
                is Resource.Success->{
                    if (result.data.status ==1) {
                        propertyListNew.value = result.data.data?.map {
                            it.toNormalPropertyResponseModal()
                        }?: emptyList()
                        _state.value = state.value.copy(
                            isLoading = false,
                            noData = false,
                            lastPage = false,
                            searchByType = false,
                            searchByMostRated = false,
                            searchByWord = false,
                            searchTextWord = result.data.message,
                            listSize = propertyListNew.value.size
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


    private fun incrementPageNumber(){
        page.value = page.value + 1
    }

    fun onListScrollPosition(position:Int){
        if (!state.value.lastPage) {
            listScrollPosition = position
           if (state.value.searchByType){
               nextPageSearchByTypeProperty()
           }else if (state.value.searchByWord){
                nextPageSearchByWordProperty()
           }else if (state.value.searchByMostRated){
                nextPageSearchByMostRatedProperty()
           }else {
               nextPageAllProperty()
           }
        }

    }

    private fun appendList(list: List<NormalPropertyResponseModal>){
        val current = mutableListOf<NormalPropertyResponseModal>()
        current.addAll(propertyListNew.value)
        current.addAll(list)
        propertyListNew.value = current
    }

    private fun nextPageAllProperty(){
        if (listScrollPosition + 1 == page.value * PAGE_SIZE){
            incrementPageNumber()
            if (page.value > 1) {
                allUseCases.allPropertyListUseCase(typeWord.value,page.value, PAGE_SIZE).onEach { result ->
                    when (result) {
                        is Resource.Loading -> {
                            _state.value = state.value.copy(
                                isLoading = true
                            )
                        }
                        is Resource.Success -> {
                            if (result.data.status == 1) {
                                appendList(result.data.data?.map { it.toNormalPropertyResponseModal() }
                                    ?: emptyList())
                                _state.value = state.value.copy(
                                    isLoading = false,
                                    noData = false,
                                    searchTextWord = result.data.message,
                                    listSize = propertyListNew.value.size
                                )
                            } else {
                                _state.value = state.value.copy(
                                    isLoading = false,
                                    lastPage = true
                                )
                            }
                        }
                        is Resource.Error -> {
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
    }
    private fun nextPageSearchByWordProperty(){
        if (listScrollPosition + 1 == page.value * PAGE_SIZE){
            incrementPageNumber()
            if (page.value > 1) {
                val query = if (state.value.search == state.value.hint) type.value else state.value.search
                Log.d("Trigger","Triggered: $query")
                allUseCases.searchPropertyUseCase(query,page.value, PAGE_SIZE).onEach { result ->

                    when (result) {
                        is Resource.Loading -> {
                            _state.value = state.value.copy(
                                isLoading = true
                            )
                        }
                        is Resource.Success -> {
                            if (result.data.status == 1) {
                                Log.d("Trigger","Triggered: ${result.data.data?.size}")
                                appendList(result.data.data?.map { it.toNormalPropertyResponseModal() }
                                    ?: emptyList())
                                _state.value = state.value.copy(
                                    isLoading = false,
                                    noData = false,
                                    searchTextWord = result.data.message,
                                    listSize = propertyListNew.value.size
                                )
                            } else {
                                _state.value = state.value.copy(
                                    isLoading = false,
                                    lastPage = true
                                )
                            }
                        }
                        is Resource.Error -> {
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
    }
    private fun nextPageSearchByTypeProperty(){
        if (listScrollPosition + 1 == page.value * PAGE_SIZE){
            incrementPageNumber()
            if (page.value > 1) {
                allUseCases.getPropertyByTypeUseCase(type.value,page.value, PAGE_SIZE).onEach { result ->
                    when (result) {
                        is Resource.Loading -> {
                            _state.value = state.value.copy(
                                isLoading = true
                            )
                        }
                        is Resource.Success -> {
                            if (result.data.status == 1) {
                                appendList(result.data.data?.map { it.toNormalPropertyResponseModal() }
                                    ?: emptyList())
                                _state.value = state.value.copy(
                                    isLoading = false,
                                    noData = false,
                                    searchTextWord = result.data.message,
                                    listSize = propertyListNew.value.size
                                )
                            } else {
                                _state.value = state.value.copy(
                                    isLoading = false,
                                    lastPage = true
                                )
                            }
                        }
                        is Resource.Error -> {
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
    }
    private fun nextPageSearchByMostRatedProperty(){
        if (listScrollPosition + 1 == page.value * PAGE_SIZE){
            incrementPageNumber()
            if (page.value > 1) {
                allUseCases.getPropertyByTypeUseCase(type.value,page.value, PAGE_SIZE).onEach { result ->
                    when (result) {
                        is Resource.Loading -> {
                            _state.value = state.value.copy(
                                isLoading = true
                            )
                        }
                        is Resource.Success -> {
                            if (result.data.status == 1) {
                                appendList(
                                    result.data.data?.filter {
                                        it.comments?.isNotEmpty()?:true
                                    }?.map {
                                        it.toNormalPropertyResponseModal()
                                    }?: emptyList()
                                )
                                _state.value = state.value.copy(
                                    isLoading = false,
                                    noData = false,
                                    searchTextWord = result.data.message,
                                    listSize = propertyListNew.value.size
                                )
                            } else {
                                _state.value = state.value.copy(
                                    isLoading = false,
                                    lastPage = true
                                )
                            }
                        }
                        is Resource.Error -> {
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
    }
}