package org.zr.bookstore.services

import org.zr.bookstore.domain.BookSummary
import org.zr.bookstore.domain.entities.Book

interface BookService {
    fun createUpdate(isbn: String, bookSummary: BookSummary): Pair<Book, Boolean>
    fun listBooks(authorId: Long?): List<Book>
}