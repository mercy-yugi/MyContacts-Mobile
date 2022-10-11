package com.yugi.mycontacts.Ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.yugi.mycontacts.Model.Contact
import com.yugi.mycontacts.R
import com.yugi.mycontacts.VieWModel.ContactsViewModel
import com.yugi.mycontacts.databinding.ActivityAddContactBinding


class AddContactActivity : AppCompatActivity() {
    lateinit var binding: ActivityAddContactBinding
    val contactsViewModel: ContactsViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_contact)
        binding = ActivityAddContactBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
    override fun onResume() {
        super.onResume()
        binding.btnSave.setOnClickListener {
            validateAddConctact()
        }
    }
    fun validateAddConctact(){
        var name = binding.etName.text.toString()
        var email = binding.etEmail.text.toString()
        var phoneNumber = binding.etPhoneNumber.text.toString()
        var address = binding.etAddress.text.toString()
//    validate
        var error = false
        if (name.isBlank()) {
            error = true
            binding.etName.error = "name is required"
        }
        if (email.isBlank()) {
            error = true
            binding.etEmail.error = " Email is required"
        }
        if (address.isBlank()) {
            error = true
            binding.etAddress.error = "Address is required"
        }
        if (phoneNumber.isBlank()) {
            error = true
            binding.etPhoneNumber.error = "PhoneNumber is required"
        }
        if(!error){
            val contact = Contact(
                contactId = 0,
                name="yugs ",
                phoneNumber="00998777",
                email = "@yugs.com",
                address = "nyc",
                image = "https://www.google.com/search?q=sisterlocks&sxsrf=ALiCzsbPSTu1Tq3XG40U3vXggPfnVOHDRw:1665071513148&source=lnms&tbm=isch&sa=X&ved=2ahUKEwjl9MPg-sv6AhWZPewKHSZIA_wQ_AUoAXoECAEQAw&biw=1294&bih=636&dpr=1#imgrc=aAJchH_jZZ8v-M"
            )
            contactsViewModel.saveContact(contact)
            finish()
        }
    }
}