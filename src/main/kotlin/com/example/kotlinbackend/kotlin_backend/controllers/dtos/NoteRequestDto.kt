package com.example.kotlinbackend.kotlin_backend.controllers.dtos

import org.bson.types.ObjectId

data class NoteRequestDto(
    val id: String?,
    val title: String,
    val content: String,
    val color: Long,
    val ownerId: String,
)