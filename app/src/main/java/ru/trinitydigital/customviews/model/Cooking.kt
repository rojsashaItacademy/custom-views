package ru.trinitydigital.customviews.model

data class Cooking(
    val accessories: List<Any>,
    val id: String,
    val ingredientsByPortions: List<Any>,
    val steps: List<Any>,
    val time: Int
)