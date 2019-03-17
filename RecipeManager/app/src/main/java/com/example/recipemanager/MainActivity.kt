package com.example.recipemanager

import DataProvider.Companion.recipes
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.LinearLayoutManager

class MainActivity : AppCompatActivity() {
    private var mRecyclerView: RecyclerView? = null
    private var mAdapter: RecipeListAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Get a handle to the RecyclerView.
        mRecyclerView = findViewById(R.id.recyclerview)
        // Create an adapter and supply the data to be displayed.
        mAdapter = RecipeListAdapter(this, recipes)
        // Connect the adapter with the RecyclerView.
        mRecyclerView!!.adapter = mAdapter
        // Give the RecyclerView a default layout manager.
        mRecyclerView!!.layoutManager = LinearLayoutManager(this)


    }
}
