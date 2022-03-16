package com.kakao.cafe.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import com.kakao.cafe.domain.Article;
import com.kakao.cafe.dto.ArticleRequestDto;
import com.kakao.cafe.dto.ArticleResponseDto;
import com.kakao.cafe.service.ArticleService;
import java.time.LocalDateTime;
import java.util.Date;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

@DisplayName("ArticleController 단위 테스트")
@WebMvcTest(ArticleController.class)
public class ArticleControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ArticleService articleService;

    @DisplayName("사용자가 게시글 저장을 요청하면 게시글 정보를 저장하고 /로 리다이렉트한다.")
    @Test
    void 게시글_저장() throws Exception {
        // given
        MultiValueMap<String, String> articleParams = new LinkedMultiValueMap<>();
        articleParams.add("writer", "ikjo");
        articleParams.add("title", "java");
        articleParams.add("contents", "java is fun");

        Article article = new Article(1, "ikjo", "java", "java is fun", LocalDateTime.now());
        given(articleService.upload(any(ArticleRequestDto.class))).willReturn(article);

        // when
        ResultActions resultActions = mockMvc.perform(post("/questions").params(articleParams));

        // then
        resultActions.andExpect(redirectedUrl("/"));
    }

    @DisplayName("사용자가 특정 게시글 정보를 요청하면 model과 /qna/show view를 반환한다.")
    @Test
    void 특정_게시글_조회() throws Exception {
        // given
        ArticleResponseDto articleResponseDto = new ArticleResponseDto( 1, "ikjo", "java", "java is fun", LocalDateTime.now());
        given(articleService.findOne(1)).willReturn(articleResponseDto);

        // when
        ResultActions resultActions = mockMvc.perform(get("/articles/1"));

        // then
        resultActions.andExpect(status().isOk())
            .andExpect(view().name("/qna/show"))
            .andExpect(model().attribute("article", articleResponseDto));
    }
}
