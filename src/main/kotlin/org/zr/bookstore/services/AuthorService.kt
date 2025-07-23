package org.zr.bookstore.services

import org.zr.bookstore.domain.entities.Author

interface AuthorService {
    fun createAuthor(author: Author): Author
    fun listAuthors(): List<Author>
    fun getSingleAuthor(id: Long): Author?
}