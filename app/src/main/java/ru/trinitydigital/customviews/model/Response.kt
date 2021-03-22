package ru.trinitydigital.customviews.model

data class Response(
    val hash: String,
    val id: String,
    val isMenu: Boolean,
    val marketing: List<Marketing>,
    val menu: List<Menu>,
    val name: String,
    val recipes: List<Recipe>,
    val shopping: List<Shopping>,
    val tags: List<Tag>,
    val type: String,
    val updatedAt: String,
    val wishlist: List<Any>
)