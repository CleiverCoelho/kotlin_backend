package com.example.kotlinbackend.kotlin_backend.controllers

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController("/health")
class HealthController {

    @GetMapping
    fun check() : String {
        return "Health Check!"
    }
}