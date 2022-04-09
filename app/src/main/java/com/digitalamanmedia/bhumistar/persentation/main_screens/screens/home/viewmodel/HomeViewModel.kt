package com.digitalamanmedia.bhumistar.persentation.main_screens.screens.home.viewmodel

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.digitalamanmedia.bhumistar.core.Commons.Companion.APARTMENT
import com.digitalamanmedia.bhumistar.core.Commons.Companion.FLAT
import com.digitalamanmedia.bhumistar.core.Commons.Companion.LAND
import com.digitalamanmedia.bhumistar.core.Commons.Companion.PLOT
import com.digitalamanmedia.bhumistar.core.Commons.Companion.VILLA
import com.digitalamanmedia.bhumistar.core.utils.Resource
import com.digitalamanmedia.bhumistar.core.utils.RoundOffRating
import com.digitalamanmedia.bhumistar.domain.modal.property_modal.NormalPropertyResponseModal
import com.digitalamanmedia.bhumistar.domain.use_cases.AllUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val allUseCases: AllUseCases
): ViewModel() {
    private val _isLoading = mutableStateOf(false)
    val isLoading: State<Boolean> = _isLoading

    private val _isRefreshing = mutableStateOf(false)
    val isRefreshing: State<Boolean> = _isRefreshing

    val flat = mutableListOf<NormalPropertyResponseModal>()
    val apartmentAndVilla = mutableListOf<NormalPropertyResponseModal>()
    val landsAndPlots = mutableListOf<NormalPropertyResponseModal>()
    private val allList = mutableListOf<NormalPropertyResponseModal>()
    val mostRatedList = mutableListOf<NormalPropertyResponseModal>()

    private val _noData = mutableStateOf(false)
    val noData: State<Boolean> = _noData

    private val _errorMessage = mutableStateOf("")
    val errorMessage: State<String> = _errorMessage

    init {
       getAllProperty()
    }

    fun onRefresh(){
        getAllProperty()
    }
    private fun getMostRatedList(){
        allList.forEach { item->
            val listOfRating = item.comments?.map { i->
                i.rating
            }

            val sumOfRating = listOfRating?.sumOf { it?:0 }

            val averageRating = if (listOfRating?.size ?:0  == 0){
                0.0F
            }else {
                sumOfRating?.div(listOfRating.size)?.toFloat()
            }

            val rating = RoundOffRating.rating(averageRating?:0.0F)
            if (rating == 4) {
                if (mostRatedList.size != 5){
                    mostRatedList.add(item)
                }
            }
        }

    }

    private fun getAllProperty(){
        allUseCases.allPropertyListUseCase("All property Lists",1,20).onEach {result->
            when(result){

                is Resource.Loading->{
                    _isLoading.value = true
                }
                is Resource.Success-> {
                    if (result.data.status == 1) {
                        _noData.value = false
                        flat.clear()
                        apartmentAndVilla.clear()
                        landsAndPlots.clear()
                        allList.clear()
                        mostRatedList.clear()

                        val list = result.data.data?.map {
                            it.toNormalPropertyResponseModal()
                        }?: emptyList()
                        allList.addAll(list)
                        getMostRatedList()
                        list.forEach {
                            when(it.property_type){
                                FLAT ->{
                                    if (flat.size != 5) {
                                        flat.add(it)
                                    }
                                }
                                PLOT ->{
                                    if (landsAndPlots.size != 5) {
                                        landsAndPlots.add(it)
                                    }
                                }
                                APARTMENT ->{
                                    if (apartmentAndVilla.size != 5) {
                                        apartmentAndVilla.add(it)
                                    }
                                }
                                LAND ->{
                                    if (landsAndPlots.size != 5) {
                                        landsAndPlots.add(it)
                                    }
                                }
                                VILLA ->{
                                    if (apartmentAndVilla.size != 5) {
                                        apartmentAndVilla.add(it)
                                    }
                                }
                            }
                        }
                        _isLoading.value = false

                    }
                }
                is Resource.Error->{
                    _noData.value = true
                    _errorMessage.value = result.message
                    _isLoading.value = false

                }
            }
        }.launchIn(viewModelScope)
    }
}