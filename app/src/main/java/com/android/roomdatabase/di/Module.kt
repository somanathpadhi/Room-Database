package com.android.roomdatabase.di

import android.content.Context
import androidx.room.Room
import com.android.roomdatabase.ContactsDao
import com.android.roomdatabase.ContactsDatabase
import com.android.roomdatabase.ContactsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object Module {

    @Provides
    fun provideContactsDatabase(@ApplicationContext context: Context): ContactsDatabase =
        Room.databaseBuilder(context, ContactsDatabase::class.java, "ContactsDB").build()

    @Provides
    fun providesContactsDao(contactsDatabase: ContactsDatabase):ContactsDao =
        contactsDatabase.contactDao()
    @Provides
    fun providesContactsRepository(contactsDao: ContactsDao): ContactsRepository =
        ContactsRepository(contactsDao)

}