package com.kosa.projectdeveloper.controller;

import com.kosa.projectdeveloper.domain.Book;
import com.kosa.projectdeveloper.domain.Show;
import com.kosa.projectdeveloper.domain.ShowReview;
import com.kosa.projectdeveloper.domain.User;
import com.kosa.projectdeveloper.dto.BookViewResponse;
import com.kosa.projectdeveloper.repository.ShowRepository;
import com.kosa.projectdeveloper.service.BookService;
import com.kosa.projectdeveloper.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@Controller
public class BookViewController {
    private final BookService bookService;
    private final UserService userService;
    private final ShowRepository showRepository;

    @GetMapping("/books/{bookId}")
    public String getBook(@PathVariable Long bookId, Model model){
        Book book = bookService.findByBookId(bookId);

        model.addAttribute("book", new BookViewResponse(book));

        return "book";
    }

    @GetMapping("/new-book")
    public String newBook(Model model){
        User user = userService.findAll().get(0);
        Show show = showRepository.findAll().get(0);

        model.addAttribute("book", new BookViewResponse());
        model.addAttribute("user", user);
        model.addAttribute("show", show);

        return "newBook";
    }

}
