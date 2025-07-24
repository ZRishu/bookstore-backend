package org.zr.bookstore.controllers

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.zr.bookstore.domain.dtos.BookSummaryDto
import org.zr.bookstore.exceptions.InvalidAuthorException
import org.zr.bookstore.services.BookService
import org.zr.bookstore.toBookSummary
import org.zr.bookstore.toBookSummaryDto

@RestController
@RequestMapping("/v1/books")
class BookController(
    private val bookService: BookService
) {

    @PutMapping(path = ["/{isbn}"])
    fun createFullUpdateBook(
        @PathVariable("isbn") isbn: String,
        @RequestBody bookDto: BookSummaryDto
    ): ResponseEntity<BookSummaryDto> {
        return try {
            val (savedBook, isCreated) = bookService.createUpdate(isbn, bookDto.toBookSummary())
            val responseCode = if (isCreated) HttpStatus.CREATED else HttpStatus.OK
            ResponseEntity(savedBook.toBookSummaryDto(), responseCode)

        } catch (e: InvalidAuthorException) {
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        } catch (e: IllegalStateException) {
            ResponseEntity(HttpStatus.BAD_REQUEST)
        }
    }

    @GetMapping
    fun readManyBooks(
        @RequestParam("author") authorId: Long?
    ): List<BookSummaryDto> {
        return bookService.listBooks(authorId).map { it.toBookSummaryDto() }
    }
}