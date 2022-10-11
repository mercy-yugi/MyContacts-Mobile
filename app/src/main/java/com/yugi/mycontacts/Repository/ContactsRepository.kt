package com.yugi.mycontacts.Repository

import androidx.lifecycle.LiveData
import com.yugi.mycontacts.Database.ContactsDb
import com.yugi.mycontacts.Model.Contact
import com.yugi.mycontacts.MyContacts
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ContactsRepository {
    val database = ContactsDb.getDatabase(MyContacts.appContext)
    suspend fun saveContact(contact: Contact) {
        withContext(Dispatchers.IO) {
            database.contactDao().insertContact(contact)
        }
        fetchContacts()
    }
    fun fetchContacts(): LiveData<List<Contact>> {
        return database.contactDao().getAllContacts()
    }
    fun getContactById(contactId: Int): LiveData<Contact> {
        return database.contactDao().getContactById(contactId)
    }
}