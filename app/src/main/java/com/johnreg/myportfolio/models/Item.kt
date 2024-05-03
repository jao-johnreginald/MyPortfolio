package com.johnreg.myportfolio.models

data class Item(
    val name: String,
    val description: String,
    val image: Int
)

/**

 * Drawables, like layouts files and layout IDs, are 'resources'
 * Android studio takes care of creating these in the 'R' place
 * They are referred in Java code as R.drawable.name_of_the_file

When android studio takes the stuff in the 'resources' folder, it puts them into Java code
and gives them a name that is converted into numbers like 6942069.

 * For every resource that we have, android will make a numeric ID that we can use from Java
 * Long story short, for our drawable, it is a variable of type 'int'

 */
