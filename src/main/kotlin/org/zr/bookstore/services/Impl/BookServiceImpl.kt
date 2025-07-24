package org.zr.bookstore.services.Impl

import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.zr.bookstore.domain.BookSummary
import org.zr.bookstore.domain.BookUpdateRequest
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

    override fun listBooks(authorId: Long?): List<Book> {
        return authorId?.let {
            bookRepository.findAllByAuthorId(it)
        } ?: bookRepository.findAll()
    }

    override fun getBook(isbn: String): Book? {
        return bookRepository.findByIdOrNull(isbn)
    }

    override fun partialUpdateBook(
        isbn: String,
        book: BookUpdateRequest
    ): Book {

        val existingBook = bookRepository.findByIdOrNull(isbn)
        checkNotNull(existingBook)

        val updatedBook = existingBook.copy(
            title = book.title ?: existingBook.title,
            description = book.description ?: existingBook.description,
            image = book.image ?: existingBook.image,
        )

        return bookRepository.save(updatedBook)
    }
}