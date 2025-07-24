package org.zr.bookstore.domain.dtos

data class BookSummaryDto(
    val isbn: String,
    val title: String,
    val description: String,
    val image: String,
    val authorDto: AuthorSummaryDto
)
