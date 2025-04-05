package com.example.kotlinbackend.kotlin_backend.controllers.dtos

data class NoteRequestDto(
    val id: String?,
    val title: String,
    val content: String,
    val color: Long,
)