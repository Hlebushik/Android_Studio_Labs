package com.example.lab8

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lab8.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)

        // Vertical RecyclerView
        binding.recyclerViewVert.layoutManager = LinearLayoutManager(this)
        val sportsData = listOf(
            Pair("Basketball", "https://media.istockphoto.com/id/1636022764/photo/basketball-ball.jpg?s=612x612&w=0&k=20&c=NVi1V5dCAZKUHdrhnRq-G5t8XSvZE1YXvgw8NxX3N0I="),
            Pair("Soccer", "https://thumbs.dreamstime.com/b/%D1%84%D1%83%D1%82%D0%B1%D0%BE%D0%BB-%D1%84%D1%83%D1%82%D0%B1%D0%BE%D0%BB%D0%B0-%D1%88%D0%B0%D1%80%D0%B8%D0%BA%D0%B0-4796264.jpg"),
            Pair("Football", "https://t4.ftcdn.net/jpg/00/96/13/71/360_F_96137109_ojPuIAl4e3LqslKAMxJ5CgmbqOQeCcHr.jpg"),
            Pair("Hockey", ""),
            Pair("Baseball", "https://t4.ftcdn.net/jpg/00/54/49/95/360_F_54499577_XtMzy2S7xoVgAJNh2GqafxSgbMMPBhaY.jpg"),
            Pair("Volleyball", "https://i.pinimg.com/564x/3f/2c/ce/3f2cce5d6a8b9cbfaeace62db6f5b379.jpg"),
            Pair("Tennis", "https://t4.ftcdn.net/jpg/03/95/23/75/360_F_395237579_t1gHzSvzZqfSk1JFZHa38zv3DPc6GE70.jpg"),
            Pair("Cricket", null),
        )
        val adapter = SportsAdapter(sportsData){ position: Int ->
//            Toast.makeText(this, sportsData[position].first, Toast.LENGTH_SHORT).show()
            val intent = Intent(this, SportsDetailsActivity::class.java)
            intent.putExtra("sportsName", sportsData[position].first)
            startActivity(intent)
        }
        binding.recyclerViewVert.adapter = adapter

        // Horizontal RecyclerView
        binding.recyclerViewHor.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        val textData = listOf(
            "Basketball",
            "Soccer",
            "Football",
            "Hockey",
            "Baseball",
            "Volleyball",
            "Tennis",
            "Cricket"
        )
        val adapterSecond = HorizontalViewAdapter(textData)
        binding.recyclerViewHor.adapter = adapterSecond

    }
}