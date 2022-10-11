package com.yugi.mycontacts.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.yugi.mycontacts.Model.Contact

@Database(entities = arrayOf(Contact::class), version = 1)
abstract class ContactsDb:RoomDatabase() {
    abstract fun contactDao():ContactDao

    companion object{
        private var database: ContactsDb? =null

        fun getDatabase(context: Context): ContactsDb {
            if (database == null) {
                database = Room.databaseBuilder(context,
                    ContactsDb::class.java, "contactsDb")
                    .fallbackToDestructiveMigration().build()
            }
            return database as ContactsDb
        }
    }

}