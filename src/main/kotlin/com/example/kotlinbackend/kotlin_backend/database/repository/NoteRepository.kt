package com.example.kotlinbackend.kotlin_backend.database.repository

import com.example.kotlinbackend.kotlin_backend.database.model.Note
import org.bson.types.ObjectId
import org.springframework.data.mongodb.repository.MongoRepository

interface NoteRepository: MongoRepository<Note, ObjectId> {
    fun findNoteByOwnerId(ownerId: ObjectId): List<Note> {
        return listOf()
    }

}