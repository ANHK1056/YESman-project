package com.kosa.projectdeveloper.controller;

import com.kosa.projectdeveloper.domain.Book;
import com.kosa.projectdeveloper.dto.AddBookRequest;
import com.kosa.projectdeveloper.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class BookApiController {
    private final BookService bookService;

    @PostMapping("/api/book")
    public ResponseEntity<Book> addBook(@RequestBody AddBookRequest request){
        Book savedBook = bookService.save(request);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(savedBook);

    }
}
