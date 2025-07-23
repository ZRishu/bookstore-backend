package org.zr.bookstore.services.Impl

import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
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

    override fun getSingleAuthor(id: Long): Author? {
        return authorRepository.findByIdOrNull(id)
    }

    @Transactional
    override fun fullUpdateAuthor(
        id: Long,
        author: Author
    ): Author {
        check(authorRepository.existsById(id))
        val normalisedAuthor = author.copy(id = id)
        return authorRepository.save(normalisedAuthor)
    }
}