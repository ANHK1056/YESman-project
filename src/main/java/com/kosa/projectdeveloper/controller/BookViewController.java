package com.kosa.projectdeveloper.controller;

import com.kosa.projectdeveloper.domain.*;
import com.kosa.projectdeveloper.dto.BookViewResponse;
import com.kosa.projectdeveloper.repository.ShowDetailRepository;
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
    private final ShowDetailRepository showDetailRepository;

    @GetMapping("/users/userBookList/{bookId}")
    public String getBook(@PathVariable Long bookId, Model model){
        Book book = bookService.findByBookId(bookId);

        ShowDetail showDetail = showDetailRepository.findById(book.getShow().getShowId()).orElse(null);

        User user = userService.findAll().get(0);

        model.addAttribute("book", new BookViewResponse(book));
        model.addAttribute("showDetail", showDetail);
        model.addAttribute("user", user);

        return "BookingPick";
    }

//    @GetMapping("/books/{bookId}")
//    public String getBookTest(@PathVariable Long bookId, Model model){
//        Book book = bookService.findByBookId(bookId);
//
//        ShowDetail showDetail = showDetailRepository.findById(book.getShow().getShowId()).orElse(null);
//
//        model.addAttribute("book", new BookViewResponse(book));
//        model.addAttribute("showDetail", showDetail);
//
////        return "book";
//        return "BookingPick";
//    }



    @GetMapping("/testBookingPick")
    public String testBookingPick() {
        return "BookingPick";
    }

    @GetMapping("/new-book")
    public String newBook(Model model){
        User user = userService.findAll().get(0);
        Show show = showRepository.findAll().get(0);
        ShowDetail showDetail = showDetailRepository.findById(show.getShowId()).orElse(null);

        model.addAttribute("book", new BookViewResponse());
        model.addAttribute("user", user);
        model.addAttribute("show", show);
        model.addAttribute("showDetail", showDetail);

        return "newBook";
    }

}
