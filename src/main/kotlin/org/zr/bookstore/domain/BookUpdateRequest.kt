package org.zr.bookstore.domain

data class BookUpdateRequest(
    val title: String?,
    val description: String?,
    val image: String?
)
