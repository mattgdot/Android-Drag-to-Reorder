package com.app.draganddrop

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val itemList = listOf(
            Item("Task 1", "Complete the assignment"),
            Item("Task 2", "Buy groceries"),
            Item("Task 3", "Call a friend")
        )

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        val adapter = RecyclerViewAdapter(itemList)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        val touchHelper = ItemTouchHelper(
            ItemMoveCallback(adapter)
        )
        touchHelper.attachToRecyclerView(recyclerView)

    }
}