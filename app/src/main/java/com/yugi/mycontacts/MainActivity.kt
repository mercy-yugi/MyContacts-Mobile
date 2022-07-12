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
        var contact1=Contact("Mercy","073676384","mercyyugi@gmail.com","kisimani","")
        var contact2=Contact("Rosemary","079984894","rose@gmail.com","embu","")
        var contact3=Contact("Kirigo","073676384","mercyyugi@gmail.com","kikuyu","")
        var contact4=Contact("Zuena","073676384","mercyyugi@gmail.com","kisimani","")
        var contact5=Contact("Swab","073676384","mercyyugi@gmail.com","kisimani","")
        var contact6=Contact("Cudra","073676384","mercyyugi@gmail.com","kisimani","")
        var contactsList=
            listOf(contact1,contact2,contact3,contact4,contact5,contact6)
        var contactAdapter=ContactRvAdapter(contactsList)
        binding.rvContacts.layoutManager=LinearLayoutManager(this)
        binding.rvContacts.adapter=contactAdapter
    }
}