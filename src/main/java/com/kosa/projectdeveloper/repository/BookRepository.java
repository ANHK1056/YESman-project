package com.kosa.projectdeveloper.repository;

import com.kosa.projectdeveloper.domain.Show;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {
    // TODO: 2023-07-05 필요하면 메서드 추가
    Optional<Book> findByBookId(long bookId);
    Optional<Book> findByShow(Show show);
}
