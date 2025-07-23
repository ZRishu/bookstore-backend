package org.zr.bookstore.domain.dtos

data class AuthorUpdateRequestDto(
    val id: Long?,
    val name: String?,
    val age: Int?,
    val description: String?,
    val image: String?
)
