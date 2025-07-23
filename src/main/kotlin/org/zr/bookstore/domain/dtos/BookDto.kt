package org.zr.bookstore.domain.dtos

data class BookDto(
    val isbn: String,
    val title: String,
    val description: String,
    val image: String,
    val authorDto: AuthorDto
)
