package ru.trinitydigital.customviews.model

data class Marketing(
    val browseUrl: String,
    val buttonText: String,
    val description: String,
    val `external`: Boolean,
    val id_table: String,
    val image: Image,
    val iri: String,
    val name: String
)