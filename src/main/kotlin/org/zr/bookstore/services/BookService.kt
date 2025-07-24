package org.zr.bookstore.services

import org.zr.bookstore.domain.BookSummary
import org.zr.bookstore.domain.BookUpdateRequest
import org.zr.bookstore.domain.dtos.BookUpdateRequestDto
import org.zr.bookstore.domain.entities.Book

interface BookService {
    fun createUpdate(isbn: String, bookSummary: BookSummary): Pair<Book, Boolean>
    fun listBooks(authorId: Long?): List<Book>
    fun getBook(isbn: String): Book?
    fun partialUpdateBook(isbn: String, book: BookUpdateRequest): Book
}