package com.android.roomdatabase

import java.util.concurrent.Flow
import javax.inject.Inject

class ContactsRepository @Inject constructor(private val dao: ContactsDao) {

    suspend fun insertContact(contact: Contact) = dao.insertContact(contact)
    suspend fun deleteContact(contact: Contact) = dao.deleteContact(contact)
    val contactsData = dao.getAllContacts()
}