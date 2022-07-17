package com.yugi.mycontacts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.squareup.picasso.NetworkPolicy
import com.squareup.picasso.Picasso
import com.yugi.mycontacts.databinding.ActivityViewContactBinding
import com.yugi.mycontacts.databinding.ContactsListItemBinding

class ViewContactActivity : AppCompatActivity() {
    lateinit var binding: ContactsListItemBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ContactsListItemBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getExtras()
    }
    fun getExtras(){
        val extras=intent.extras
        val image=extras?.getString("IMAGE","")
        Picasso.get()
            .load(image)
            .placeholder(R.drawable.ic_baseline_person_24)
            .error(R.drawable.ic_baseline_error_outline_24)
            .resize(300,300)
            .centerCrop()
            .networkPolicy(NetworkPolicy.OFFLINE)
            .into(binding.imgContact)
        val name=extras?.getString("NAME","")
        binding.tvNmae.text=name
        val email=extras?.getString("EMAIL","")
        binding.tvEmail.text=email
        val phonenumber=extras?.getString("PHONE_NUMBER","")
        binding.tvPhoneNo.text=phonenumber
        val address=extras?.getString("ADDRESS","")
        binding.tvAddress.text=address

        Toast.makeText(this,"$name:$email:$phonenumber:$address",Toast.LENGTH_LONG).show()
    }
}