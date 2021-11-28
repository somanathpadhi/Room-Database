package com.android.roomdatabase

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ContactsViewModel @Inject constructor(private val repository: ContactsRepository) :
    ViewModel() {
    suspend fun insertContact(contact: Contact) = repository.insertContact(contact)
    suspend fun deleteContact(contact: Contact) = repository.deleteContact(contact)
    val contactsLiveData = repository.contactsData
}