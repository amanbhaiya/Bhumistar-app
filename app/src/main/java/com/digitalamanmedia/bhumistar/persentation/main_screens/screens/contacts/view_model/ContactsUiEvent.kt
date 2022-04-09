package com.digitalamanmedia.bhumistar.persentation.main_screens.screens.contacts.view_model



sealed class ContactsUiEvent {
    data class EnterName(val name:String):ContactsUiEvent()
    data class EnterNumber(val number:String):ContactsUiEvent()
    data class EnterEmail(val email:String):ContactsUiEvent()
    data class EnterSubject(val subject:String):ContactsUiEvent()
    data class EnterMessage(val message:String):ContactsUiEvent()
    object ClearName:ContactsUiEvent()
    object ClearNumber:ContactsUiEvent()
    object ClearEmail:ContactsUiEvent()
    object ClearSubject:ContactsUiEvent()
    object Submit:ContactsUiEvent()
}