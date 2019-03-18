package com.example.recipemanager

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso


class RecipeView : AppCompatActivity() {
    lateinit var name_textview :TextView
    lateinit var directions_textview :TextView
    lateinit var image_view :ImageView
    lateinit var ingredients_textview :TextView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe_view)

        name_textview = findViewById(R.id.name)
        directions_textview = findViewById(R.id.directions)
        image_view = findViewById(R.id.imageView)
        ingredients_textview = findViewById(R.id.ingredients)

        val my_name :String = intent.getStringExtra("name")
        val my_directions :String = intent.getStringExtra("directions")
        val my_ingredients :String = intent.getStringExtra("ingredients")
        name_textview.text = my_name
        directions_textview.text = my_directions
        ingredients_textview.text = my_ingredients

        val my_image_url :String = intent.getStringExtra("image")
        Picasso.get().load(my_image_url).fit().placeholder(R.drawable.ic_launcher_background).error(R.drawable.ic_launcher_background).into(image_view)

    }
}
