package org.zr.bookstore.repositories

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import org.zr.bookstore.domain.Book

@Repository
interface BookRepository : JpaRepository<Book, String> {
}