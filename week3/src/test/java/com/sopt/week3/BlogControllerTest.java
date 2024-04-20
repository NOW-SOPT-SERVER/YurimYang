package com.sopt.week3;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.sopt.week3.domain.controller.BlogController;
import com.sopt.week3.domain.dto.BlogCreateRequest;
import com.sopt.week3.domain.repository.BlogRepository;
import com.sopt.week3.domain.repository.MemberRepository;
import com.sopt.week3.domain.service.BlogService;
import com.sopt.week3.domain.service.MemberService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(BlogController.class)
@AutoConfigureMockMvc
public class BlogControllerTest {

    @SpyBean
    private BlogService blogService;

    @SpyBean
    private MemberService memberService;

    @MockBean
    private BlogRepository blogRepository;

    @MockBean
    private MemberRepository memberRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @Nested
    class createBlog {

        @Autowired
        private MockMvc mockMvc;

        @Test
        @DisplayName("Blog 생성 실패 테스트")
        public void createBlogSuccess() throws Exception {

            //given
            String request = objectMapper.writeValueAsString(
                new BlogCreateRequest("유림이네 블로그", "블로그설명"));

            //when
            mockMvc.perform(post("/api/v1/blog")
                    .content(request).header("memberId", 1)
                    .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andDo(print());
        }
    }


}
