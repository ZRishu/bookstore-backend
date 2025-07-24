package org.zr.bookstore.services.Impl

import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.zr.bookstore.domain.BookSummary
import org.zr.bookstore.domain.entities.Book
import org.zr.bookstore.repositories.AuthorRepository
import org.zr.bookstore.repositories.BookRepository
import org.zr.bookstore.services.BookService
import org.zr.bookstore.toBook

@Service
class BookServiceImpl(
    private val bookRepository: BookRepository,
    private val authorRepository: AuthorRepository
) : BookService {

    @Transactional
    override fun createUpdate(
        isbn: String,
        bookSummary: BookSummary
    ): Pair<Book, Boolean> {
        val normalisedBook = bookSummary.copy(isbn = isbn)
        val isExists = bookRepository.existsById(isbn)

        val author = authorRepository.findByIdOrNull(normalisedBook.author.id)
        checkNotNull(author)

        val savedBook = bookRepository.save(normalisedBook.toBook(author))
        return Pair(savedBook, !isExists)
    }

    override fun listBooks(): List<Book> {
        return bookRepository.findAll()
    }
}