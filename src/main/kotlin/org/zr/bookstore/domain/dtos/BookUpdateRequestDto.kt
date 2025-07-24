package org.zr.bookstore.domain.dtos

data class BookUpdateRequestDto(
    val title: String?,
    val description: String?,
    val image: String?
)
