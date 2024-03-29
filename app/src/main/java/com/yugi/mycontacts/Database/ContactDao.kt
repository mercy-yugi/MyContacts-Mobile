package com.yugi.mycontacts.Database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.yugi.mycontacts.Model.Contact

@Dao
interface ContactDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertContact(contact:Contact)

    @Query("SELECT * FROM contacts")
    fun getAllContacts():LiveData<List<Contact>>

    @Query("SELECT * FROM contacts WHERE contactId= :contactsId")
    fun getContactById(contactsId:Int):LiveData<Contact>


}