package com.example.kotlinbackend.kotlin_backend.database.repository

import com.example.kotlinbackend.kotlin_backend.database.model.User
import org.bson.types.ObjectId
import org.springframework.data.mongodb.repository.MongoRepository
import javax.print.attribute.standard.RequestingUserName

interface UserRepository: MongoRepository<User, ObjectId> {
    fun findByEmail(email: String) : User?
}