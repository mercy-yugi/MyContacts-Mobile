package com.yugi.mycontacts

import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView

class ContactRvAdapter (var contactList: List<Contact>):
RecyclerView.Adapter<ContactsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactsViewHolder {
     var itemView=LayoutInflater.from(parent.context)
         .inflate(R.layout.contacts_list_item,parent,false)
        return ContactsViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ContactsViewHolder, position: Int) {
        var currentContact=contactList.get(position)
        holder.tvNmae.text=currentContact.name
        holder.tvPhoneNo.text=currentContact.phoneNumber
        holder.tvEmail.text=currentContact.email
        holder.tvAddress.text=currentContact.address
    }

    override fun getItemCount(): Int {
       return  3
    }
}
class ContactsViewHolder(itemView: View):
        RecyclerView.ViewHolder(itemView){
            var tvNmae=itemView.findViewById<TextView>(R.id.tvNmae)
            var tvPhoneNo=itemView.findViewById<TextView>(R.id.tvPhoneNo)
            var tvAddress=itemView.findViewById<TextView>(R.id.tvAddress)
            var tvEmail=itemView.findViewById<TextView>(R.id.tvEmail)
            var imgContact=itemView.findViewById<ImageView>(R.id.imgContact)
        }
