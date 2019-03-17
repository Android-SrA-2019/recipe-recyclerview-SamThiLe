package com.example.recipemanager

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import java.util.*
import android.view.LayoutInflater

class RecipeListAdapter(context: Context , recipeList : LinkedList<Recipe> ) : RecyclerView.Adapter<RecipeListAdapter.WordViewHolder>() {
    private var mRecipeList  = DataProvider.recipes
    private var mInflater: LayoutInflater? = null

    init{
        mInflater = LayoutInflater.from(context)
        mRecipeList = recipeList
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder {
        val mItemView = mInflater!!.inflate(R.layout.recipe_list_item,  parent ,false)
        return WordViewHolder(mItemView, this)
    }

    override fun getItemCount(): Int {
        return mRecipeList.size
    }

    override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
        val mCurrent = mRecipeList[position]
        holder.wordItemView.text = mCurrent.toString()
    }


    inner class WordViewHolder(itemView: View, adapter: RecipeListAdapter ) : RecyclerView.ViewHolder(itemView),View.OnClickListener {
        init {
            itemView.setOnClickListener(this)
        }
        override fun onClick(v: View?) {
            // Get the position of the item that was clicked.
            val mPosition = layoutPosition
            // Use that to access the affected item in mWordList.
            val element = mRecipeList[mPosition]
            // Change the word in the mWordList.
            mRecipeList[mPosition]
            // Notify the adapter, that the data has changed so it can
            // update the RecyclerView to display the data.
            mAdapter.notifyDataSetChanged()
        }

        val wordItemView: TextView = itemView.findViewById(R.id.word)
        val mAdapter: RecipeListAdapter = adapter
    }
}

