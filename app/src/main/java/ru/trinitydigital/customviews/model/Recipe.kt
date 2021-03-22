package ru.trinitydigital.customviews.model

data class Recipe(
    val complexity: Complexity,
    val cooking: Cooking,
    val favorited: Boolean,
    val id: String,
    val image: ImageXX,
    val inWishlist: Boolean,
    val liked: Boolean,
    val likesCount: Int,
    val name: String,
    val updatedAt: String
)