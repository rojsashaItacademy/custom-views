package ru.trinitydigital.customviews.model

data class MainModel(
    val hash: String,
    val lastModifiedAt: String,
    val response: List<Response>,
    val totalItems: Int,
    val type: String
)