package com.kosa.projectdeveloper.controller;

import com.kosa.projectdeveloper.dto.BookListViewResponse;
import com.kosa.projectdeveloper.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class BookListViewController {
    private final BookService bookService;

    // 계정에서 예매 목록 조회
    @GetMapping("/users/userBookList")
    public String getBooks(Model model){
        List<BookListViewResponse> books = bookService.findAllBooks()
                .stream()
                .map(BookListViewResponse::new)
                .toList();

        model.addAttribute("books", books);

        return "BookList";
    }

}
