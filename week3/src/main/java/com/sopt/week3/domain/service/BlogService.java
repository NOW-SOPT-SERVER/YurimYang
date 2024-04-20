package com.sopt.week3.domain.service;

import com.sopt.week3.domain.dto.BlogCreateRequest;
import com.sopt.week3.domain.dto.BlogTitleUpdateRequest;
import com.sopt.week3.domain.entity.Blog;
import com.sopt.week3.domain.entity.Member;
import com.sopt.week3.domain.global.exception.NotFoundException;
import com.sopt.week3.domain.global.exception.message.ErrorMessage;
import com.sopt.week3.domain.repository.BlogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BlogService {

    private final BlogRepository blogRepository;
    private final MemberService memberService;

    public String createBlog(Long memberId, BlogCreateRequest blogCreateRequest){
        Member member = memberService.findById(memberId);
        Blog blog = blogRepository.save(Blog.create(member, blogCreateRequest));
        return blog.getId().toString();
    }

    @Transactional
    public void updateTitle(Long blogId, BlogTitleUpdateRequest blogTitleUpdateRequest){
        Blog blog = blogRepository.findById(blogId).orElseThrow(
            () -> new NotFoundException(ErrorMessage.BLOG_NOT_FOUND));
        blog.updateTitle(blogTitleUpdateRequest.title());
    }

}
