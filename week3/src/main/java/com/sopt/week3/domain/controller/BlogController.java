package com.sopt.week3.domain.controller;

import com.sopt.week3.domain.dto.BlogTitleUpdateRequest;
import com.sopt.week3.domain.global.exception.message.SuccessMessage;
import com.sopt.week3.domain.global.dto.SuccessStatusResponse;
import com.sopt.week3.domain.dto.BlogCreateRequest;
import com.sopt.week3.domain.service.BlogService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class BlogController {

    private final BlogService blogService;

    @PostMapping("/blog")
    public ResponseEntity<SuccessStatusResponse> createBlog(
        @RequestHeader(name="memberId") Long memberId, @RequestBody BlogCreateRequest blogCreateRequest) {

        return ResponseEntity.status(HttpStatus.CREATED)
            .header("Location", blogService.createBlog(memberId, blogCreateRequest))
            .body(SuccessStatusResponse.of(SuccessMessage.BLOG_CREATE_SUCCESS));
    }

    @PatchMapping("/blog/{blogId}/title")
    public ResponseEntity updateBlogTitle(
        @PathVariable Long blogId,
        @Valid @RequestBody BlogTitleUpdateRequest blogTitleUpdateRequest
    ) {
        blogService.updateTitle(blogId, blogTitleUpdateRequest);
        return ResponseEntity.noContent().build();
    }

}
