package com.kosa.projectdeveloper.testErd;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kosa.projectdeveloper.domain.Book;
import com.kosa.projectdeveloper.domain.Show;
import com.kosa.projectdeveloper.domain.ShowReview;
import com.kosa.projectdeveloper.domain.User;
import com.kosa.projectdeveloper.repository.BookRepository;
import com.kosa.projectdeveloper.repository.ShowRepository;
import com.kosa.projectdeveloper.repository.ShowReviewRepository;
import com.kosa.projectdeveloper.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
//@EnableJpaAuditing
@AutoConfigureMockMvc
public class testErd {
    @Autowired
    protected MockMvc mockMvc;

    @Autowired
    protected ObjectMapper objectMapper;

    @Autowired
    private WebApplicationContext context;

    @Autowired
    BookRepository bookRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ShowRepository showRepository;

    @Autowired
    ShowReviewRepository showReviewRepository;

    @BeforeEach
    public void test123(){
        showReviewRepository.deleteAll();
        bookRepository.deleteAll();
        showRepository.deleteAll();
        userRepository.deleteAll();
    }

    @DisplayName("testErd")
    @Test
    public void testErd() throws Exception {
        //given
        final String userId = "userId";
        final String userName = "userName";
        final String userPw = "userPw";
        final String userPhNm = "userPhNm";

        final String showDate = "showDate";
        final String showId = "showId";
        final String seat = "seat";

        Show savedShow = showRepository.save(new Show("1", "2", "3", "4",
                "5", "6", "7", "8", "9"));



        User savedUser = userRepository.save(User.builder()
                        .userEmail(userId)
                        .userName(userName)
                        .userPw(userPw)
                        .userPhNm(userPhNm)
                        .build());

        bookRepository.save(Book.builder()
                        .user(savedUser)
                        .seat(seat)
                        .showDate(showDate)
                        .show(savedShow)
                        .build());
        //when

        Book savedBook = bookRepository.findByBookId(1).get();

        //then
        assertThat(savedBook.getSeat()).isEqualTo(seat);
        assertThat(savedBook.getUser().getUserPw()).isEqualTo(userPw);

    }


    ////////////////////////////////////////////////////

    @DisplayName("testReview")
    @Test
    public void testReview() throws Exception {
        //given
        final String userId = "userId";
        final String userName = "userName";
        final String userPw = "userPw";
        final String userPhNm = "userPhNm";

        final String showDate = "showDate";
        final String showId = "showId";
        final String seat = "seat";

        final String title = "title";
        final String content = "content";

        Show savedShow = showRepository.save(new Show("1", "2", "3", "4",
                "5", "6", "7", "8", "9"));



        User savedUser = userRepository.save(User.builder()
                .userEmail(userId)
                .userName(userName)
                .userPw(userPw)
                .userPhNm(userPhNm)
                .build());

        Book savedBook = bookRepository.save(Book.builder()
                .user(savedUser)
                .seat(seat)
                .showDate(showDate)
                .show(savedShow)
                .build());

        showReviewRepository.save(ShowReview.builder()
                .reviewContent(content)
                .reviewTitle(title)
                .book(savedBook)
                .build());

        //when

        ShowReview savedShowReview = showReviewRepository.findById(1).get();
        assertThat(savedShowReview.getReviewContent()).isEqualTo(content);
        assertThat(savedShowReview.getBook().getSeat()).isEqualTo(seat);
        assertThat(savedShowReview.getBook().getUser().getUserPw()).isEqualTo(userPw);
        //then
    }

}
