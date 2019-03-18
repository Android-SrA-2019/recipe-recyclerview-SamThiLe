package com.example.recipemanager

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import java.util.*
import android.view.LayoutInflater

class RecipeListAdapter(context: Context , recipeList : LinkedList<Recipe> ) : RecyclerView.Adapter<RecipeListAdapter.WordViewHolder>() {
    private var mRecipeList  = DataProvider.recipes
    private var mInflater: LayoutInflater? = null

    val EXTRA_NAME: String = "name"
    val EXTRA_IMAGE: String = "image"
    val EXTRA_INGREDIENTS: String = "ingredients"
    val EXTRA_DIRECTIONS: String = "directions"
    val parent_context:Context
    init{
        mInflater = LayoutInflater.from(context)
        mRecipeList = recipeList
        parent_context =context
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder {
        val mItemView = mInflater!!.inflate(R.layout.recipe_list_item,  parent ,false)
        return WordViewHolder(mItemView, this)
    }

    override fun getItemCount(): Int {
        return mRecipeList.size
    }

    override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
        holder.nameItemView.text = mRecipeList[position].name
        holder.descriptionItemView.text = mRecipeList[position].description
    }


    inner class WordViewHolder(itemView: View, adapter: RecipeListAdapter ) : RecyclerView.ViewHolder(itemView),View.OnClickListener {
        init {
            itemView.setOnClickListener(this)
        }
        override fun onClick(v: View?) {
            // Get the position of the item that was clicked.
            val mPosition = layoutPosition

            val intent = Intent(parent_context , RecipeView::class.java)
            intent.putExtra(EXTRA_NAME, mRecipeList[mPosition].name)
            intent.putExtra(EXTRA_DIRECTIONS, mRecipeList[mPosition].directions)
            intent.putExtra(EXTRA_IMAGE, mRecipeList[mPosition].image)
            intent.putExtra(EXTRA_INGREDIENTS, mRecipeList[mPosition].ingredients)

            parent_context.startActivity(intent)

            // Notify the adapter, that the data has changed so it can
            mAdapter.notifyDataSetChanged()
        }

        val nameItemView: TextView = itemView.findViewById(R.id.name)
        val descriptionItemView: TextView = itemView.findViewById(R.id.description)
        val mAdapter: RecipeListAdapter = adapter
    }
}

