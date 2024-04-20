package com.sopt.week3.domain.repository;

import com.sopt.week3.domain.entity.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Blog, Long> {

}
