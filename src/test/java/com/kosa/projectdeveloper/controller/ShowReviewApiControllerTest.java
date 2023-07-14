package com.kosa.projectdeveloper.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kosa.projectdeveloper.domain.Book;
import com.kosa.projectdeveloper.domain.Show;
import com.kosa.projectdeveloper.domain.ShowReview;
import com.kosa.projectdeveloper.domain.User;
import com.kosa.projectdeveloper.dto.AddShowReviewRequest;
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
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ShowReviewApiControllerTest {

    @Autowired
    protected MockMvc mockMvc;

    @Autowired
    protected ObjectMapper objectMapper;

    @Autowired
    private WebApplicationContext context;

    @Autowired
    ShowReviewRepository showReviewRepository;
    @Autowired
    BookRepository bookRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ShowRepository showRepository;


    @BeforeEach
    public void mockMvcSetUP() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(context)
                .build();
        showReviewRepository.deleteAll();

    }

    @DisplayName("addRe: 리뷰 추가 성공")
    @Test
    public void addRe() throws  Exception{

        //given
        final String url = "/api/show-review";
        final String review_Title = "title";
        final String review_Content = "content";

        final String userId = "userId";
        final String userName = "userName";
        final String userPw = "userPw";
        final String userPhNm = "userPhNm";

        final String showDate = "showDate";
        final String showId = "showId";
        final String seat = "seat";
        final Show savedShow = showRepository.save(new Show("1", "2", "3", "4",
                "5", "6", "7", "8", "9"));
        final User savedUser = userRepository.save(User.builder()
                .userEmail(userId)
                .userName(userName)
                .userPw(userPw)
                .userPhNm(userPhNm)
                .build());

        final Book savedBook = bookRepository.save(Book.builder()
                .user(savedUser)
                .seat(seat)
                .showDate(showDate)
                .show(savedShow)
                .build());

        final AddShowReviewRequest request = new AddShowReviewRequest(review_Title, review_Content,savedBook);

        final String requestBody = objectMapper.writeValueAsString(request);


        //when
        ResultActions result =mockMvc.perform(post(url)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(requestBody));


        //then
        result.andExpect(status().isCreated());

        List<ShowReview> showReviews = showReviewRepository.findAll();

        assertThat(showReviews.size()).isEqualTo(1);
        assertThat(showReviews.get(0).getReviewTitle()).isEqualTo(review_Title);
        assertThat(showReviews.get(0).getReviewContent()).isEqualTo(review_Content);


    }
//    @DisplayName("findAllUsers: 모든 유저 조회에 성공한다")
//    @Test
//    public void findAllUsers() throws Exception {
//        //given
//        final String url = "/api/user";
//        final String userName = "testName";
//        final String userPw ="test";
//        final String userPhNm = "010-111-111";
//        final String userEmail = "testName@naver.com";
//
//        userRepository.save(User.builder()
//                .userPw(userPw)
//                .userEmail(userEmail)
//                .userPhNm(userPhNm)
//                .build());
//        //when
//        final ResultActions resultActions = mockMvc.perform(get(url)
//                .accept(MediaType.APPLICATION_JSON));
//
//        //then
//        resultActions
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$[0].userEmail").value(userEmail))
//                .andExpect(jsonPath("$[0].userPhNm").value(userPhNm));
//    }
//    @DisplayName("findUsers: 유저 조회에 성공한다")
//    @Test
//    public void findUsers() throws Exception {
//        //given
//        final String url = "/api/user/{id}";
//        final String userName = "testName";
//        final String userPw ="test";
//        final String userPhNm = "010-111-111";
//        final String userEmail = "testName@naver.com";
//
//        User saveduser=userRepository.save(User.builder()
//                .userPw(userPw)
//                .userEmail(userEmail)
//                .userPhNm(userPhNm)
//                .build());
//        //when
//        final ResultActions resultActions = mockMvc.perform(get(url, saveduser.getUserId()));
//
//        //then
//        resultActions
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.userEmail").value(userEmail))
//                .andExpect(jsonPath("$.userPhNm").value(userPhNm));
//
//    }
//
//    @DisplayName("deleteUser: 유저 삭제에 성공한다")
//    @Test
//    public void deleteUser() throws Exception {
//
//        //given
//        final String url = "/api/user/{id}";
//        final String userName = "testName";
//        final String userPw ="test";
//        final String userPhNm = "010-111-111";
//        final String userEmail = "testName@naver.com";
//
//        User saveduser=userRepository.save(User.builder()
//                .userName(userName)
//                .userPw(userPw)
//                .userEmail(userEmail)
//                .userPhNm(userPhNm)
//                .build());
//        //when
//        mockMvc.perform(delete(url,saveduser.getUserId()))
//                .andExpect(status().isOk());
//
//        //then
//        List<User> users =userRepository.findAll();
//        assertThat(users).isEmpty();
//    }
//
//    @DisplayName("updateUser: 유저 정보 수정에 성공한다.")
//    @Test
//    public void updateUser() throws  Exception{
//        final String url = "/api/user/{id}";
//        final String userName = "testName";
//        final String userPw ="test";
//        final String userPhNm = "010-111-111";
//        final String userEmail = "testName@naver.com";
//        User saveduser=userRepository.save(User.builder()
//                .userPw(userPw)
//                .userEmail(userEmail)
//                .userPhNm(userPhNm)
//                .build());
//
//        final String newPhNm = "010-1111-1111";
//
//        UpdateUserRequest request = new UpdateUserRequest(newPhNm);
//
//
//        // when
//        ResultActions result = mockMvc.perform(put(url,saveduser.getUserId())
//                .contentType(MediaType.APPLICATION_JSON_VALUE)
//                .content(objectMapper.writeValueAsString(request)));
//
//        // then
//        result.andExpect(status().isOk());
//
//        User user = userRepository.findByUserId(saveduser.getUserId()).get();
//
//
//        assertThat(user.getUserEmail()).isEqualTo(userEmail);
//        assertThat(user.getUserPhNm()).isEqualTo(newPhNm);
//    }





}