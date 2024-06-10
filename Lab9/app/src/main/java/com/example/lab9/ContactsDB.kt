package com.example.lab9

import androidx.room.ColumnInfo
import androidx.room.Dao
import androidx.room.Database
import androidx.room.Delete
import androidx.room.Entity
import androidx.room.Insert
import androidx.room.PrimaryKey
import androidx.room.Query
import androidx.room.RoomDatabase

@Database(entities = [Contact::class], version = 1)
abstract class ContactsDB: RoomDatabase() {
    abstract fun contactDao(): ContactDao
}

@Entity(tableName = "contacts")
data class Contact(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "phone") val phone: String?,
    @ColumnInfo(name = "email") val email: String?
)

@Dao
interface ContactDao {
    @Query("SELECT * FROM contacts")
    fun getAll(): List<Contact>

    @Insert
    fun insertAll(vararg contacts: Contact)

    @Delete
    fun delete (contact: Contact)

    @Query("DELETE FROM contacts WHERE id = :contactId")
    fun deleteById(contactId: Int)
}
