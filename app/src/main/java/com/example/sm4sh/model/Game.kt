package com.example.sm4sh.model

import java.util.*

data class Game (
    val objectId: String,
    val name: String,
    val universe: String,
    val price: String,
    val imageURL: String,
    val kind: String,
    val popular: Boolean,
    val rating: String,
    val downloads: String,
    val description: String,
    val SKU: String,
    val createdAt: String,
    val updatedAt: String
)

data class Result(
    val results: List<Game>
)

   
