package com.android.roomdatabase

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface ContactsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertContact(contact: Contact)

    @Delete
    suspend fun deleteContact(contact: Contact)

    @Query("SELECT * FROM CONTACTS_TABLE ORDER BY name")
    fun getAllContacts(): Flow<List<Contact>>
}