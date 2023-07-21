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

    // 계정에서 예매 상세 내역 조회
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

    // 예매 진행시 JS를 통해 작성 페이지로 연결
    // js파일에서 JSON으로 유저, 연극 엔티티에 대해 객체 그대로 전달이 안 되어
    // 테스트를 위해 모든 유저, 모든 연극 각각 첫 번째로 찾아 그 객체를 통해 예매 진행
    // 시간 부족으로 인해 연극, 유저 각각 실제 접속한 유저, 실제 예매할 연극으로 구현은 하지 못함
    @GetMapping("/new-book")
    public String newBook(Model model){
        // 모든 유저 중 첫번째 유저
        User user = userService.findAll().get(0);
        // 모든 연극 중 첫번째 연극
        Show show = showRepository.findAll().get(0);
        ShowDetail showDetail = showDetailRepository.findById(show.getShowId()).orElse(null);

        model.addAttribute("book", new BookViewResponse());
        model.addAttribute("user", user);
        model.addAttribute("show", show);
        model.addAttribute("showDetail", showDetail);

        return "newBook";
    }

}
