package com.example.androidarchitecturepractises

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)

        val adapter = ProgrammingAdapter()

        val p1  = ProgrammingItem(1, "J", "Java")
        val p2  = ProgrammingItem(2, "K", "Kotlin")
        val p3  = ProgrammingItem(3, "A", "Android")

        /// this is how we pass our list to our RecyclerView.Adapter or ListAdapter
        adapter.submitList(listOf(p1, p2, p3))

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = adapter

        Handler(Looper.getMainLooper()).postDelayed(
            Runnable {
                val p3  = ProgrammingItem(3, "A", "Android")
                val p4  = ProgrammingItem(4, "R", "Rust")
                val p5  = ProgrammingItem(5, "G", "GoLang")
                val p6  = ProgrammingItem(6, "N", "Node")

                /// we pass a new list after some time,
                /// as p3 is repeated (same id), so it will not be re-rendered, it will be reused
                adapter.submitList(listOf(p3, p4, p5, p6))
            }, 4000
        )
    }
}