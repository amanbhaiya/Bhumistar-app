package com.digitalamanmedia.bhumistar.core.utils

import androidx.compose.material.ScaffoldState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class SnackBarManager (
    private val scope: CoroutineScope
){
    private var snackBarJob : Job? = null

    init {
        cancelActiveJob()
    }
    fun getScope() = scope

    fun showSnackBar(
        scaffoldState: ScaffoldState,
        message:String,
        actionLevel:String
    ){
        if (snackBarJob == null){
            snackBarJob = scope.launch {
                scaffoldState.snackbarHostState.showSnackbar(
                    message = message,
                    actionLabel = actionLevel
                )
                cancelActiveJob()
            }
        }else{
            cancelActiveJob()
            snackBarJob = scope.launch {
                scaffoldState.snackbarHostState.showSnackbar(
                    message = message,
                    actionLabel = actionLevel
                )
                cancelActiveJob()
            }
        }
    }

    private fun cancelActiveJob() {
        snackBarJob?.let { job->
            job.cancel()
            snackBarJob = Job()
        }
    }
}