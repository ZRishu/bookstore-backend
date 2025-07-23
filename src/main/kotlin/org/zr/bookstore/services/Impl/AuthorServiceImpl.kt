package org.zr.bookstore.services.Impl

import org.springframework.stereotype.Service
import org.zr.bookstore.domain.entities.Author
import org.zr.bookstore.repositories.AuthorRepository
import org.zr.bookstore.services.AuthorService

@Service
class AuthorServiceImpl(
    private val authorRepository: AuthorRepository
) : AuthorService {

    override fun createAuthor(author: Author): Author {
        return authorRepository.save(author)
    }

    override fun listAuthors(): List<Author> {
        return authorRepository.findAll()
    }
}