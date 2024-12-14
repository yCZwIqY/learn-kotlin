package com.example.learnkotlin.admin.data

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity

class ApiResponse<T>(status: HttpStatus) : ResponseEntity<T>(status) {
    companion object {
        fun successCreate(): ResponseEntity<Any> {
            return ResponseEntity.ok("데이터가 생성 되었습니다.")
        }
        fun successUpdate(): ResponseEntity<Any> {
            return ResponseEntity.ok("데이터가 저장 되었습니다.")
        }

        fun successDelete(): ResponseEntity<Any> {
            return ResponseEntity.ok("데이터가 삭제 되었습니다.")
        }

    }
}