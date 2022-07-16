package com.yugi.mycontacts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.yugi.mycontacts.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
   lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        displayContacts()
    }
    fun displayContacts(){
        var contact1=Contact("Mercy","073676384","mercyyugi@gmail.com","kisimani","https://images.unsplash.com/photo-1529245019870-59b249281fd3?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8OHx8YWZyaWNhbnxlbnwwfHwwfHw%3D&auto=format&fit=crop&w=500&q=60")
        var contact2=Contact("Rosemary","079984894","rose@gmail.com","embu","https://images.unsplash.com/photo-1566051587526-f62c8a4522ba?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8OXx8YWZyaWNhbnxlbnwwfHwwfHw%3D&auto=format&fit=crop&w=500&q=60")
        var contact3=Contact("Kirigo","073676384","mercyyugi@gmail.com","kikuyu","https://images.unsplash.com/photo-1627634432023-95713e2ff3f0?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8NDF8fGFmcmljYW58ZW58MHx8MHx8&auto=format&fit=crop&w=500&q=60")
        var contact4=Contact("Zuena","073676384","mercyyugi@gmail.com","kisimani","https://images.unsplash.com/photo-1589156280159-27698a70f29e?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8NjF8fGFmcmljYW58ZW58MHx8MHx8&auto=format&fit=crop&w=500&q=60")
        var contact5=Contact("Swab","073676384","mercyyugi@gmail.com","kisimani","https://images.unsplash.com/photo-1602009786299-3a425d5a2bac?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8NzB8fGFmcmljYW58ZW58MHx8MHx8&auto=format&fit=crop&w=500&q=60")
        var contact6=Contact("Cudra","073676384","mercyyugi@gmail.com","kisimani","https://images.unsplash.com/photo-1517090186835-e348b621c9ca?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MTI4fHxhZnJpY2FufGVufDB8fDB8fA%3D%3D&auto=format&fit=crop&w=500&q=60")
        var contactsList=
            listOf(contact1,contact2,contact3,contact4,contact5,contact6)
        var contactAdapter=ContactRvAdapter(contactsList)
        binding.rvContacts.layoutManager=LinearLayoutManager(this)
        binding.rvContacts.adapter=contactAdapter
    }
}