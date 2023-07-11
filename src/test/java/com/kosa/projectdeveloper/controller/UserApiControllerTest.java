package com.kosa.projectdeveloper.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kosa.projectdeveloper.domain.User;
import com.kosa.projectdeveloper.dto.AddUserRequest;
import com.kosa.projectdeveloper.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
class UserApiControllerTest {
    @Autowired
    protected MockMvc mockMvc;

    @Autowired
    protected ObjectMapper objectMapper;

    @Autowired
    private WebApplicationContext context;

    @Autowired
    UserRepository userRepository;

    @BeforeEach
    public void mockMvcSetUP() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(context)
                .build();
        userRepository.deleteAll();

    }


    @DisplayName("addUser: 유저를 추가에 성공한다.")
    @Test
    public void addUser() throws  Exception{
        //테스트 시 adduserrequest에서  encoder 주석


        //given
        final String url = "/api/users";
        final String userName = "testName";
        final String userPw ="test";
        final String userAddress = "testkosa";
        final String userPhNm = "010-111-111";
        final String userEmail = "testName@naver.com";
        final String userGender ="Male";
        final String userBirth = "010101";
        final AddUserRequest userRequest = new AddUserRequest();
        final String requestBody = objectMapper.writeValueAsString(userRequest);


        //when
        ResultActions result =mockMvc.perform(post(url)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(requestBody));

        //then
        result.andExpect(status().isCreated());

        List<User> users = userRepository.findAll();

        assertThat(users.size()).isEqualTo(1);

        assertThat(users.get(0).getUserPw()).isEqualTo(userPw);
        assertThat(users.get(0).getUserEmail()).isEqualTo(userEmail);
        assertThat(users.get(0).getUserPhNm()).isEqualTo(userPhNm);
        // TODO: 2023-07-09 userName이 userEmail로 들어감 수정 필요
        assertThat(users.get(0).getUsername()).isEqualTo(userName);
    }
}