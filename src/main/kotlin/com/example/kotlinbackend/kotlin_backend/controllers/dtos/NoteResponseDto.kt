package com.example.kotlinbackend.kotlin_backend.controllers.dtos

import java.time.Instant

data class NoteResponseDto(
    val id: String,
    val ownerId: String,
    val title: String,
    val content: String,
    val color: Long,
    val createdAt: Instant,
)