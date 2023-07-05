package com.kosa.projectdeveloper.repository;

import com.kosa.projectdeveloper.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
    // TODO: 2023-07-05 필요하면 메서드 추가 
}
