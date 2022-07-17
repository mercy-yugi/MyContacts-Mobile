package com.yugi.mycontacts

import android.content.Intent
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.MemoryPolicy
import com.squareup.picasso.NetworkPolicy
import com.squareup.picasso.Picasso
import com.yugi.mycontacts.databinding.ContactsListItemBinding
import java.util.zip.Inflater

class ContactRvAdapter (var contactList: List<Contact>):
RecyclerView.Adapter<ContactsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactsViewHolder {
        var binding=ContactsListItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        var ContactsViewHolder=ContactsViewHolder(binding)
        return ContactsViewHolder
    }

    override fun onBindViewHolder(holder: ContactsViewHolder, position: Int) {
        var currentContact=contactList.get(position)
        holder.binding.tvNmae.text=currentContact.name
        holder.binding.tvPhoneNo.text=currentContact.phoneNumber
        holder.binding.tvEmail.text=currentContact.email
        holder.binding.tvAddress.text=currentContact.address
        Picasso.get()
            .load(currentContact.image)
            .placeholder(R.drawable.ic_baseline_person_24)
            .error(R.drawable.ic_baseline_error_outline_24)
            .resize(300,300)
            .centerCrop()
            .networkPolicy(NetworkPolicy.OFFLINE)
            .into(holder.binding.imgContact)

      val context=holder.itemView.context
holder.binding.imgContact.setOnClickListener{
    Toast.makeText(context,"You have clicked on ${currentContact.name}'s image",Toast.LENGTH_SHORT).show()
}
        holder.binding.cvContact.setOnClickListener{
            val intent=Intent(context,ViewContactActivity::class.java)
            intent.putExtra("NAME",currentContact.name)
            intent.putExtra("EMAIL",currentContact.email)
            intent.putExtra("PHONE_NUMBER",currentContact.phoneNumber)
            intent.putExtra("ADDRESS",currentContact.address)
            intent.putExtra("IMAGE",currentContact.image)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
       return  contactList.size
    }
}
class ContactsViewHolder(var binding: ContactsListItemBinding): RecyclerView.ViewHolder(binding.root){

        }
