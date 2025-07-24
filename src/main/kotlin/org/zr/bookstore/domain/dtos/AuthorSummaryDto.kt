package org.zr.bookstore.domain.dtos

data class AuthorSummaryDto(
    val id: Long,
    val name: String?,
    val image: String?
)
