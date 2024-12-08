package com.example.learnkotlin.admin.data

abstract class FormElementDTO(
    val name: String,
    val size: Int,
    val type: String
)

class TextFromElementDTO(
    name: String,
    size: Int
): FormElementDTO(name = name, size = size, type = "text")

class DateFromElementDTO(    name: String,
                             size: Int
): FormElementDTO(name = name, size = size, type = "data")

class SelectFromElementDTO(    name: String,
                               size: Int
): FormElementDTO(name = name, size = size, type = "select")