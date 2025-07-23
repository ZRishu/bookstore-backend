package org.zr.bookstore.controllers

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.zr.bookstore.domain.dtos.AuthorDto
import org.zr.bookstore.services.AuthorService
import org.zr.bookstore.toAuthor
import org.zr.bookstore.toAuthorDto

@RestController
@RequestMapping(path = ["/v1/authors"])
class AuthorController(
    private val authorService: AuthorService
) {

    @PostMapping
    fun createAuthor(
        @RequestBody authorDto: AuthorDto
    ): ResponseEntity<AuthorDto> {
        val createdAuthor = authorService.createAuthor(
            authorDto.toAuthor()
        ).toAuthorDto()
        return ResponseEntity(createdAuthor, HttpStatus.CREATED)
    }
}