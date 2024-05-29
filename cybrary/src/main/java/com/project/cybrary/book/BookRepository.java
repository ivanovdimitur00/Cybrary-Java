package com.project.cybrary.book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findBookByTitle(String keyword);
    List<Book> findBookByAuthor(String keyword);
}
