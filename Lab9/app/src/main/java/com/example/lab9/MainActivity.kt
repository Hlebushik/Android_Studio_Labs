package com.example.lab9

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import com.example.lab9.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    companion object {
        lateinit var database: ContactsDB
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        database = Room.databaseBuilder(
            applicationContext,
            ContactsDB::class.java, "contact_database"
        ).build()
        val contactDao = database.contactDao()

        binding.addContactButton.setOnClickListener{
            val name = binding.nameEdit.text.toString()
            val phone = binding.phoneEdit.text.toString()
            val email = binding.emailEdit.text.toString()
            val contact = Contact(name = name, phone = phone, email = email)
            GlobalScope.launch {
                contactDao.insertAll(contact)
            }

            Toast.makeText(
                applicationContext,
                "Користувача успішно додано",
                Toast.LENGTH_LONG
            ).show()
        }

        binding.allContactsButton.setOnClickListener{
            GlobalScope.launch {
                val contacts = contactDao.getAll()
                var contactsInfo = ""
                contacts.forEach{
                    contactsInfo += "${it.name} ${it.phone} ${it.email}\n"
                }
                runOnUiThread{
                    binding.textView.text = contactsInfo
                }
            }
        }

        binding.deleteButton.setOnClickListener{
            val index = binding.idEdit.text.toString().toIntOrNull()

            if (index == null || index < 0) {
                Toast.makeText(this, "Невірний індекс", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            lifecycleScope.launch(Dispatchers.IO) {
                val contacts = contactDao.getAll()
                if (contacts.isNotEmpty() && index < contacts.size) {
                    val contactToDelete = contacts[index]
                    contactDao.deleteById(contactToDelete.id)
                    withContext(Dispatchers.Main) {
                        Toast.makeText(this@MainActivity, "Контакт успішно видалено", Toast.LENGTH_SHORT).show()
                    }
                } else {
                    withContext(Dispatchers.Main) {
                        Toast.makeText(this@MainActivity, "Невірний індекс", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }
}

