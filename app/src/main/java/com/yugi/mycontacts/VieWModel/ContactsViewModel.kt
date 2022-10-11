package com.yugi.mycontacts.VieWModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yugi.mycontacts.Model.Contact
import com.yugi.mycontacts.Repository.ContactsRepository
import kotlinx.coroutines.launch

class ContactsViewModel:ViewModel() {
    var contactsRepository = ContactsRepository()
    lateinit var contactLiveData: LiveData<Contact>
    fun getContactById(contactId: Int) {
        contactLiveData = contactsRepository.getContactById(contactId)
    }
    fun saveContact(contact: Contact) {
        viewModelScope.launch {
            contactsRepository.saveContact(contact)
        }
    }
}