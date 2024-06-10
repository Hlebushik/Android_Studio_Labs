package com.example.lab10

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.lab10.databinding.ActivityMainBinding
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getTasks()

        binding.button.setOnClickListener {
            addTasks()
        }
    }

    private fun getTasks(){
        val retrofit = RetrofitClient.getInstance()
        val apiInterface = retrofit.create(ApiInterface::class.java)
        lifecycleScope.launch {
            val response = apiInterface.getTasks()
            binding.txtData.text = response.body()?.title
            print(response.body()?.title)
        }
    }

    private fun addTasks(){
        val retrofit = RetrofitClient.getInstance()
        val apiInterface = retrofit.create(ApiInterface::class.java)
        lifecycleScope.launch {
            try {
                val tasks = Tasks(
                    userId = 47,
                    id = 293,
                    title = "Новий таск",
                    completed = false,
                )
                val response = apiInterface.addTasks(tasks)
                if (response.isSuccessful && response.body() != null) {
                    Toast.makeText(applicationContext, "Новий таск з id ${response.body()?.id} успішно створено", Toast.LENGTH_SHORT).show()
                }
            } catch (Ex: Exception) {
                Toast.makeText(applicationContext, "Помилка", Toast.LENGTH_SHORT).show()
            }
        }
    }
}