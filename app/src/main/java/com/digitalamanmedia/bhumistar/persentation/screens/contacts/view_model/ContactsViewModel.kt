package com.digitalamanmedia.bhumistar.persentation.screens.contacts.view_model

import android.app.Application
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.digitalamanmedia.bhumistar.domain.use_cases.AllUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class ContactsViewModel @Inject constructor(
    private val allUseCases: AllUseCases,
    private val context:Application
) : ViewModel(){

    private val _name = mutableStateOf("")
    val name: State<String> = _name

    private val _number = mutableStateOf("")
    val number: State<String> = _number

    private val _email = mutableStateOf("")
    val email: State<String> = _email

    private val _subject = mutableStateOf("")
    val subject: State<String> = _subject

    private val _message = mutableStateOf("")
    val message: State<String> = _message
    init {
        viewModelScope.launch {
            allUseCases.readUserDataUseCase().collect{ data->
                _name.value = data.name?:""
                _email.value = data.email?:""
                _number.value = data.number?:""
            }
        }
    }

    fun onEvent(event:ContactsUiEvent){
        when(event){
            is ContactsUiEvent.EnterName->{
                _name.value = event.name
            }
            is ContactsUiEvent.EnterNumber->{
                _number.value = event.number
            }
            is ContactsUiEvent.EnterEmail->{
                _email.value = event.email
            }
            is ContactsUiEvent.EnterSubject->{
                _subject.value = event.subject
            }
            is ContactsUiEvent.EnterMessage->{
                _message.value = event.message
            }
            is ContactsUiEvent.ClearName->{
                _name.value = ""
            }
            is ContactsUiEvent.ClearNumber->{
                _number.value = ""
            }
            is ContactsUiEvent.ClearEmail->{
                _email.value = ""
            }
            is ContactsUiEvent.ClearSubject->{
                _subject.value = ""
            }
            is ContactsUiEvent.Submit->{
                val intent = Intent(Intent.ACTION_SENDTO).apply {
                    data = Uri.parse("mailto:amanky611@gmail.com")
                    putExtra(Intent.EXTRA_SUBJECT,subject.value)
                    putExtra(Intent.EXTRA_TEXT,message.value)
                    flags = Intent.FLAG_ACTIVITY_NEW_TASK
                }
                context.applicationContext.startActivity(intent)
            }
        }
    }
}