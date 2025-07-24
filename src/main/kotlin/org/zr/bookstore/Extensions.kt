package org.zr.bookstore

import org.zr.bookstore.domain.AuthorSummary
import org.zr.bookstore.domain.AuthorUpdateRequest
import org.zr.bookstore.domain.BookSummary
import org.zr.bookstore.domain.BookUpdateRequest
import org.zr.bookstore.domain.dtos.AuthorDto
import org.zr.bookstore.domain.dtos.AuthorSummaryDto
import org.zr.bookstore.domain.dtos.AuthorUpdateRequestDto
import org.zr.bookstore.domain.dtos.BookSummaryDto
import org.zr.bookstore.domain.dtos.BookUpdateRequestDto
import org.zr.bookstore.domain.entities.Author
import org.zr.bookstore.domain.entities.Book
import org.zr.bookstore.exceptions.InvalidAuthorException

fun Author.toAuthorDto() = AuthorDto(
    id = this.id,
    name = this.name,
    age = this.age,
    description = this.description,
    image = this.image
)

fun AuthorDto.toAuthor() = Author(
    id = this.id,
    name = this.name,
    age = this.age,
    description = this.description,
    image = this.image
)

fun AuthorUpdateRequestDto.toAuthorUpdateRequest() = AuthorUpdateRequest(
    id = this.id,
    name = this.name,
    age = this.age,
    description = this.description,
    image = this.image
)

fun BookSummary.toBook(author: Author) = Book(
    isbn = this.isbn,
    title = this.title,
    description = this.description,
    image = this.image,
    author = author
)

fun BookSummaryDto.toBookSummary() = BookSummary(
    isbn = this.isbn,
    title = this.title,
    description = this.description,
    image = this.image,
    author = this.authorDto.toAuthorSummary()
)

fun Book.toBookSummaryDto() = BookSummaryDto(
    isbn = this.isbn,
    title = this.title,
    description = this.description,
    image = this.image,
    authorDto = this.author.toAuthorSummaryDto()
)

fun Author.toAuthorSummaryDto(): AuthorSummaryDto {
    val authorId = this.id ?: throw InvalidAuthorException()
    checkNotNull(authorId)
    return AuthorSummaryDto(
        id = authorId,
        name = this.name,
        image = this.image
    )
}

fun AuthorSummaryDto.toAuthorSummary() = AuthorSummary(
    id = this.id,
    name = this.name,
    image = this.image
)

fun BookUpdateRequestDto.toBookUpdateRequest() = BookUpdateRequest(
    title = this.title,
    description = this.description,
    image = this.image
)