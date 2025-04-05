package com.example.kotlinbackend.kotlin_backend.controllers

import com.example.kotlinbackend.kotlin_backend.controllers.dtos.NoteRequestDto
import com.example.kotlinbackend.kotlin_backend.controllers.dtos.NoteResponseDto
import com.example.kotlinbackend.kotlin_backend.database.model.Note
import com.example.kotlinbackend.kotlin_backend.database.repository.NoteRepository
import org.bson.types.ObjectId
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.time.Instant

@RestController
@RequestMapping("/notes")
class NoteController(
    private val noteRepository: NoteRepository,
) {

    @PostMapping
    fun save(
        @RequestBody body: NoteRequestDto
    ): NoteResponseDto {
        val note = noteRepository.save(
            Note(
                id = body.id?.let { ObjectId(body.id) } ?: ObjectId.get(),
                title = body.title,
                content = body.content,
                color = body.color,
                createdAt = Instant.now(),
                ownerId = ObjectId(),
            ),
        )

        return note.toNoteResponseDto()
    }

    @GetMapping
    fun findByOwnerId(
        @RequestParam(required = true) ownerId: String
    ): List<NoteResponseDto> {
        return noteRepository.findNoteByOwnerId(ObjectId(ownerId)).map { it.toNoteResponseDto()}
    }
}

private fun Note.toNoteResponseDto() : NoteResponseDto {
    return NoteResponseDto(
        id = this.id.toHexString(),
        title = this.title,
        content = this.content,
        color = this.color,
        createdAt = this.createdAt,
        ownerId = this.ownerId.toHexString(),
    )
}