package com.kosa.projectdeveloper.controller;

import com.kosa.projectdeveloper.domain.Book;
import com.kosa.projectdeveloper.dto.BookViewResponse;
import com.kosa.projectdeveloper.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@Controller
public class BookViewController {
    private final BookService bookService;

    @GetMapping("/books/{bookId}")
    public String getBook(@PathVariable Long bookId, Model model){
        Book book = bookService.findByBookId(bookId);

        model.addAttribute("book", new BookViewResponse(book));

        return "book";
    }

    @GetMapping("/new-book")
    public String newBook(Model model){
        model.addAttribute("book", new BookViewResponse());

        return "newBook";
    }

}
