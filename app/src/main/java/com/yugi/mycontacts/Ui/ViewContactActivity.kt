package com.yugi.mycontacts.Ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.squareup.picasso.NetworkPolicy
import com.squareup.picasso.Picasso
import com.yugi.mycontacts.R
import com.yugi.mycontacts.databinding.ActivityViewContactBinding

class ViewContactActivity : AppCompatActivity() {
    lateinit var binding: ActivityViewContactBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityViewContactBinding.inflate(layoutInflater)
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
            .into(binding.imgContact1)
        val name=extras?.getString("NAME","")
        binding.tvName1.text=name
        val email=extras?.getString("EMAIL","")
        binding.tvEmail2.text=email
        val phonenumber=extras?.getString("PHONE_NUMBER","")
        binding.tvNumber1.text=phonenumber
        val address=extras?.getString("ADDRESS","")
        binding.tvAddress2.text=address

        Toast.makeText(this,"$name:$email",Toast.LENGTH_LONG).show()
    }
}