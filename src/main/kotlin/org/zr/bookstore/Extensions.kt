package org.zr.bookstore

import org.zr.bookstore.domain.dtos.AuthorDto
import org.zr.bookstore.domain.entities.Author

fun Author.toAuthorDto() = AuthorDto(
    id = this.id,
    name = this.name,
    age = this.age,
    description = this.description,
    image = this.image,
)

fun AuthorDto.toAuthor() = Author(
    id = this.id,
    name = this.name,
    age = this.age,
    description = this.description,
    image = this.image,
)