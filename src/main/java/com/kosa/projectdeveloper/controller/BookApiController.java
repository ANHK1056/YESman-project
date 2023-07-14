package com.kosa.projectdeveloper.controller;

import com.kosa.projectdeveloper.domain.Book;
import com.kosa.projectdeveloper.dto.AddBookRequest;
import com.kosa.projectdeveloper.dto.ReadBookResponse;
import com.kosa.projectdeveloper.repository.BookRepository;
import com.kosa.projectdeveloper.repository.ShowRepository;
import com.kosa.projectdeveloper.repository.UserRepository;
import com.kosa.projectdeveloper.service.BookService;
import com.kosa.projectdeveloper.service.ShowService;
import com.kosa.projectdeveloper.service.UserService;
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
    private final UserRepository userRepository;
    private final ShowRepository showRepository;
    private final BookRepository bookRepository;

    // 예매 추가 기능
    @PostMapping("/api/users/userBookList")
    public ResponseEntity<Book> addBook(@RequestBody AddBookRequest request){
        System.out.println("checkUser : " + request.getUserEmail());

        System.out.println("checkShow : " + request.getShowId());

        Book savedBook = Book.builder()
                .showDate(request.getShowDate())
                .seat(request.getSeat())
                .user(userRepository.findByUserEmail(request.getUserEmail()).orElseThrow(() -> new IllegalArgumentException("not found user")))
                .show(showRepository.findById(request.getShowId()).orElseThrow(() -> new IllegalArgumentException("not found show")))
                .build();

        bookRepository.save(savedBook);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(savedBook);

    }

    // 모든 예매 조회 기능
    @GetMapping("/api/users/userBookList")
    public ResponseEntity<List<ReadBookResponse>> findAllbooks() {
        List<ReadBookResponse> books = bookService.findAllBooks()
                .stream()
                .map(ReadBookResponse::new)
                .toList();

        return ResponseEntity.ok()
                .body(books);
    }

    // 한 개의 예매 조회 기능
    @GetMapping("/api/users/userBookList/{bookId}")
    public ResponseEntity<ReadBookResponse> findBook(@PathVariable long bookId){
        Book book = bookService.findByBookId(bookId);

        return ResponseEntity.ok()
                .body(new ReadBookResponse(book));
    }

    // 예매 취소 기능
    @DeleteMapping("/api/users/userBookList/{bookId}")
    public ResponseEntity<ReadBookResponse> deleteBook(@PathVariable long bookId){
        bookService.deleteByBookId(bookId);

        return ResponseEntity.ok()
                .build();
    }
}
