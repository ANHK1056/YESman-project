package com.kosa.projectdeveloper.service;

import com.kosa.projectdeveloper.domain.Book;
import com.kosa.projectdeveloper.dto.AddBookRequest;
import com.kosa.projectdeveloper.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BookService {

    private final BookRepository bookRepository;

    public Book save(AddBookRequest request) {
        return bookRepository.save(request.toEntity());
    }
}
