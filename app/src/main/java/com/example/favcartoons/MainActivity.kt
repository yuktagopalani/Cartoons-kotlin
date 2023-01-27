package com.example.favcartoons

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.LinearLayoutManager

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val horizontalRecyclerView = findViewById<RecyclerView>(R.id.horizontalRecyclerView)
        recyclerView?.setHasFixedSize(true)
        horizontalRecyclerView?.setHasFixedSize(true)
        recyclerView?.layoutManager = LinearLayoutManager(this)
        horizontalRecyclerView?.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        val myCartoonData = arrayOf(
            CartoonData("Doraemon", "I am a Robot", R.drawable.doraemon),
            CartoonData("Mario", "I am Adventurous", R.drawable.mario),
            CartoonData("Pooh", "I am Fat", R.drawable.pooh),
            CartoonData("Krishna", "I am from Mathura", R.drawable.krishna),
            CartoonData("Tom", "I am a Cat", R.drawable.tom),
            CartoonData("Mermaid", "I am a mermaid", R.drawable.mermaid),
            CartoonData("Super Mario", "I play Games", R.drawable.super_mario),
            CartoonData("Tweety", "I am Cute", R.drawable.tweety),
            CartoonData("Winnie The Pooh", "I love my Friends", R.drawable.winnie)
        )
        val myCartoonAdaptor = CartoonAdaptor(myCartoonData, this@MainActivity)
        val myPhotosAdaptor = PhotosAdaptor(myCartoonData, this@MainActivity)
        recyclerView?.adapter = myCartoonAdaptor
        horizontalRecyclerView?.adapter = myPhotosAdaptor
    }
}