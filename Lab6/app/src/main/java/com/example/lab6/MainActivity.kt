package com.example.lab6

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.lab6.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var user: User? = null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button1.setOnClickListener {
            user = User("Марія", 41)
            val intent = Intent(this, MainActivity2::class.java)
            intent.putExtra("user", user)
            startActivity(intent)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putParcelable("user", user)
        Log.d("Message", "onSaveInstanceState")
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        user = savedInstanceState.getParcelable("user")
        Log.d("Message", "onRestoreInstanceState")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("Message", "onFirstActivityDestroy")
    }
    override fun onStart() {
        super.onStart()
        Log.d("Message", "onFirstActivityStart")
    }
    override fun onStop() {
        super.onStop()
        Log.d("Message", "onFirstActivityStop")
    }
    override fun onPause() {
        super.onPause()
        Log.d("Message", "onFirstActivityPause")
    }
    override fun onResume() {
        super.onResume()
        Log.d("Message", "onFirstActivityResume")
    }
    override fun onRestart() {
        super.onRestart()
        Log.d("Message", "onFirstActivityRestart")
    }
}
