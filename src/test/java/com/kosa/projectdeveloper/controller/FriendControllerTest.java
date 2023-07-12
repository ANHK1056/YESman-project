package com.kosa.projectdeveloper.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kosa.projectdeveloper.domain.FriendReview;
import com.kosa.projectdeveloper.domain.User;
import com.kosa.projectdeveloper.domain.UserTest;
import com.kosa.projectdeveloper.dto.FriendReviewAddResponse;
import com.kosa.projectdeveloper.dto.FriendUpdateRequest;
import com.kosa.projectdeveloper.repository.FriendRepository;
import com.kosa.projectdeveloper.repository.UserRepository;
import com.kosa.projectdeveloper.repository.UserTestRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class FriendControllerTest {

    @Autowired
    protected MockMvc mockMvc;

    @Autowired
    protected ObjectMapper objectMapper;

    @Autowired
    private WebApplicationContext context;

    @Autowired
    FriendRepository friendRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserTestRepository userTestRepository;

//    @Autowired
//    LocalDateTime createdAt;

    @BeforeEach
    public void mockMvcSetUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(context)
                .build();
        friendRepository.deleteAll();
        userRepository.deleteAll();
    }

    @DisplayName("addFriend: 블로그 글 추가에 성공한다.")
    @Test
    public void addFriend() throws Exception{
    final String url = "/api/friend";
    final String title = "title";
    final String content = "content";
    final LocalDateTime createdAt = LocalDateTime.now();

    final FriendReviewAddResponse userRequest = new FriendReviewAddResponse(title, content, createdAt);

    final String requestBody = objectMapper.writeValueAsString(userRequest);

        ResultActions result = mockMvc.perform(post(url)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(requestBody));

        result.andExpect(status().isCreated());


        List<FriendReview> friendReviews = friendRepository.findAll();

        assertThat(friendReviews.size()).isEqualTo(1);
        assertThat(friendReviews.get(0).getTitle()).isEqualTo(title);
        assertThat(friendReviews.get(0).getContent()).isEqualTo(content);
    }


    @DisplayName("findAllFriends: 블로그 글 목록 조회에 성공한다.")
    @Test
    public void findAllFriends() throws Exception {
        //given
        final String url = "/api/friend";
        final String title = "title";
        final String content ="content";

        friendRepository.save(FriendReview.builder()
                .title(title)
                .content(content)
                .build());
        //when
        final ResultActions resultActions = mockMvc.perform(get(url)
                .accept(MediaType.APPLICATION_JSON));

        //then
        resultActions
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].title").value(title))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].content").value(content));
    }


    @DisplayName("findFriend : 블로그 글 조회에 성공한다.")
    @Test
    public void friendResponse() throws Exception {
        final String url = "/api/friend/{id}";
        final String content = "content";
        final LocalDateTime createdAt = LocalDateTime.now();
        final String title = "title";

        final String userId = "userId";
        final String userName = "userName";
        final String userPw = "userPw";
        final String userPhNm = "userPhNm";

        User savedUser = userRepository.save(User.builder()
                .userEmail(userId)
                .userName(userName)
                .userPw(userPw)
                .userPhNm(userPhNm)
                .build());

        FriendReview saveFriend = friendRepository.save(FriendReview.builder()
                        .title(title)
                        .content(content)
                        .createdAt(createdAt)
                        .user(savedUser)
                        .build());


        final ResultActions  resultActions = mockMvc.perform(get(url, saveFriend.getId()));


        resultActions
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.title").value(title))
                .andExpect(MockMvcResultMatchers.jsonPath("$.content").value(content))
                .andExpect(MockMvcResultMatchers.jsonPath("$.user.userEmail").value(userId));



    }


    @DisplayName("deleteFriend: 블로그 글 삭제에 성공한다")
    @Test
    public void deleteFriendReview() throws Exception {

        //given
        final String url = "/api/friend/{id}";
        final String title = "title";
        final String content ="content";

        FriendReview savedfriend = friendRepository.save(FriendReview.builder()
                .title(title)
                .content(content)
                .build());

        //when
        mockMvc.perform(delete(url,savedfriend.getId()))
                .andExpect(status().isOk());

        //then
        List<FriendReview> friendReviews = friendRepository.findAll();
        assertThat(friendReviews).isEmpty();
    }


    @DisplayName("updateFriend: 블로그 글 수정에 성공한다.")
    @Test
    public void updateFriendReview() throws  Exception{
        final String url = "/api/friend/{id}";
        final String title = "title";
        final LocalDateTime createdAt = LocalDateTime.now();
        final String content ="content";
        final String userId = "userId";
        final String userName = "userName";
        final String userPw = "userPw";
        final String userPhNm = "userPhNm";

        User savedUser = userRepository.save(User.builder()
                .userEmail(userId)
                .userName(userName)
                .userPw(userPw)
                .userPhNm(userPhNm)
                .build());

        FriendReview savedfriend = friendRepository.save(FriendReview.builder()
                .title(title)
                .content(content)
                .createdAt(createdAt)
                .user(savedUser)
                .build());


        final String newTitle = "new title";
        final String newContent = "new content";

        FriendUpdateRequest request = new FriendUpdateRequest(savedUser,newTitle, newContent, createdAt);

        System.out.println(objectMapper.writeValueAsString(request));

        // when
        ResultActions result = mockMvc.perform(put(url,savedfriend.getId())
                .with(SecurityMockMvcRequestPostProcessors.oauth2Login()
                        .authorities(List.of(new SimpleGrantedAuthority("user"))))
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(objectMapper.writeValueAsString(request)));

        // then
        result.andExpect(status().isOk());

        FriendReview updatedFriend = friendRepository.findById(savedfriend.getId()).get();


        assertThat(updatedFriend.getUser().getUserEmail()).isEqualTo(userId);
        assertThat(updatedFriend.getUser().getUserPhNm()).isEqualTo(userPhNm);
        assertThat(updatedFriend.getTitle()).isEqualTo(newTitle);
        assertThat(updatedFriend.getContent()).isEqualTo(newContent);

    }

//    @DisplayName("updateFriend: 블로그 글 수정에 성공한다. UserTest")
//    @Test
//    public void updateFriendReviewTest() throws  Exception{
//        final String url = "/api/friend/{id}";
//        final String title = "title";
//        final LocalDateTime createdAt = LocalDateTime.now();
//        final String content ="content";
//        final String userId = "userId";
//        final String userName = "userName";
//        final String userPw = "userPw";
//        final String userPhNm = "userPhNm";
//
//        UserTest savedUser = userTestRepository.save(UserTest.builder()
//                .userEmail(userId)
//                .userName(userName)
//                .userPw(userPw)
//                .userPhNm(userPhNm)
//                .build());
//
//
//
//        FriendReview savedfriend = friendRepository.save(FriendReview.builder()
//                .title(title)
//                .content(content)
//                .createdAt(createdAt)
//                .user(savedUser)
//                .build());
//
//
//        final String newTitle = "new title";
//        final String newContent = "new content";
//
//        FriendUpdateRequest request = new FriendUpdateRequest(savedUser,newTitle, newContent, createdAt);
//
//        System.out.println(objectMapper.writeValueAsString(request));
//
//        // when
//        ResultActions result = mockMvc.perform(put(url,savedfriend.getId())
//                .contentType(MediaType.APPLICATION_JSON_VALUE)
//                .content(objectMapper.writeValueAsString(request)));
//
//        // then
//        result.andExpect(status().isOk());
//
//        FriendReview updatedFriend = friendRepository.findById(savedfriend.getId()).get();
//
//
//        assertThat(updatedFriend.getUser().getUserEmail()).isEqualTo(userId);
//        assertThat(updatedFriend.getUser().getUserPhNm()).isEqualTo(userPhNm);
//        assertThat(updatedFriend.getTitle()).isEqualTo(newTitle);
//        assertThat(updatedFriend.getContent()).isEqualTo(newContent);
//
//    }




}