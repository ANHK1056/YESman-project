package com.kosa.projectdeveloper.service;

import com.kosa.projectdeveloper.dto.AddBookRequest;
import com.kosa.projectdeveloper.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BookService {

    private final BookRepository bookRepository;

    // 예매 추가
    public Book save(AddBookRequest request) {
        return bookRepository.save(request.toEntity());
    }

    // 모든 예매 조회
    public List<Book> findAllBooks(){
        return bookRepository.findAll();
    }

    // 한 개 예매 조회
    public Book findByBookId(long bookId){
        return bookRepository.findByBookId(bookId)
                .orElseThrow(() -> new IllegalArgumentException("not found : " + bookId));
    }

    // 예매 취소
    public void deleteByBookId(long bookId){
        bookRepository.deleteById(bookId);
    }

}
