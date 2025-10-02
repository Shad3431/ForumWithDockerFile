package cohort_65.java.forumservice;

import com.fasterxml.jackson.databind.ObjectMapper;
import cohort_65.java.forumservice.post.controller.PostController;
import cohort_65.java.forumservice.post.dto.NewPostDto;
import cohort_65.java.forumservice.post.dto.PostDto;
import cohort_65.java.forumservice.post.service.PostService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;
import java.util.Set;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(PostController.class)
class ForumServiceApplicationTests {

    @Autowired MockMvc mvc;
    @Autowired ObjectMapper json;

    @MockitoBean PostService postService;

    @Test
    void createPost_returnsDto() throws Exception {
        var expected = PostDto.builder()
                .id("123")
                .author("alice")
                .title("Hello")
                .content("Test content")
                .likes(0)
                .dateCreated(LocalDateTime.now())
                .tags(Set.of("java", "spring"))
                .build();

        var body = """
            {"title":"Hello","content":"Test content","tags":["java","spring"]}
            """;

        given(postService.addNewPost(any(NewPostDto.class), eq("alice"))).willReturn(expected);

        mvc.perform(post("/forum/post/{author}", "alice")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(body))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value("123"))
                .andExpect(jsonPath("$.author").value("alice"))
                .andExpect(jsonPath("$.title").value("Hello"));
    }

    @Test
    void likePost_returns204() throws Exception {
        doNothing().when(postService).likePost("p1");

        mvc.perform(put("/forum/post/{id}/like", "p1"))
                .andExpect(status().isNoContent());
    }
}
