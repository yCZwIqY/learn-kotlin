package com.example.learnkotlin.admin.exception

import org.springframework.http.HttpStatus

class AdminException(httpStatus: HttpStatus, message: String) : RuntimeException(message) {
    val httpStatus: HttpStatus = httpStatus
}