package com.kosa.projectdeveloper.repository;

import com.kosa.projectdeveloper.domain.Book;
import com.kosa.projectdeveloper.domain.Show;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {

    // bookId를 통한 검색
    Optional<Book> findByBookId(long bookId);

}
