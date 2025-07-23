package org.zr.bookstore.controllers

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
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
        return try {
            val createdAuthor = authorService.createAuthor(
                authorDto.toAuthor()
            ).toAuthorDto()
            ResponseEntity(createdAuthor, HttpStatus.CREATED)

        } catch (e: IllegalArgumentException) {
            ResponseEntity(HttpStatus.BAD_REQUEST)
        }
    }

    @GetMapping
    fun readManyAuthors(): ResponseEntity<List<AuthorDto>> {
        val authors = authorService.listAuthors().map { it.toAuthorDto() }
        return ResponseEntity(authors, HttpStatus.OK)
    }


    @GetMapping(path = ["/{id}"])
    fun readOneAuthor(@PathVariable id: Long): ResponseEntity<AuthorDto> {
        return authorService.getSingleAuthor(id)?.toAuthorDto()
            ?.let { ResponseEntity(it, HttpStatus.OK) }
            ?: ResponseEntity.notFound().build()
    }

    @PutMapping(path = ["/{id}"])
    fun fullUpdateAuthor(
        @PathVariable id: Long,
        @RequestBody authorDto: AuthorDto
    ): ResponseEntity<AuthorDto> {
        return try {
            val updatedAuthor = authorService.fullUpdateAuthor(id, authorDto.toAuthor()).toAuthorDto()
            ResponseEntity(updatedAuthor, HttpStatus.OK)

        } catch (e: IllegalStateException) {
            ResponseEntity(HttpStatus.BAD_REQUEST)
        }
    }
}