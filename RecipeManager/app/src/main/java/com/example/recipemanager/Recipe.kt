package com.example.recipemanager

data class Recipe(val name: String,
                  val description: String,
                  val image: String,
                  val ingredients: String,
                  val directions: String)