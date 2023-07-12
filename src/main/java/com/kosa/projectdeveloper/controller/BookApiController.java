package com.kosa.projectdeveloper.controller;

import com.kosa.projectdeveloper.domain.Book;
import com.kosa.projectdeveloper.dto.AddBookRequest;
import com.kosa.projectdeveloper.dto.ReadBookResponse;
import com.kosa.projectdeveloper.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
// 예매 기능 관련 컨트롤러
public class BookApiController {
    private final BookService bookService;

    // 예매 추가 기능
    @PostMapping("/api/books")
    public ResponseEntity<Book> addBook(@RequestBody AddBookRequest request){
        Book savedBook = bookService.save(request);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(savedBook);

    }

    // 모든 예매 조회 기능
    @GetMapping("/api/books")
    public ResponseEntity<List<ReadBookResponse>> findAllbooks() {
        List<ReadBookResponse> books = bookService.findAllBooks()
                .stream()
                .map(ReadBookResponse::new)
                .toList();

        return ResponseEntity.ok()
                .body(books);
    }

    // 한 개의 예매 조회 기능
    @GetMapping("/api/books/{bookId}")
    public ResponseEntity<ReadBookResponse> findBook(@PathVariable long bookId){
        Book book = bookService.findByBookId(bookId);

        return ResponseEntity.ok()
                .body(new ReadBookResponse(book));
    }

    // 예매 취소 기능
    @DeleteMapping("/api/books/{bookId}")
    public ResponseEntity<ReadBookResponse> deleteBook(@PathVariable long bookId){
        bookService.deleteByBookId(bookId);

        return ResponseEntity.ok()
                .build();
    }
}
