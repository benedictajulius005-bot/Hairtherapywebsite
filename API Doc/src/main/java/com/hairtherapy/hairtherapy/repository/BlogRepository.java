package com.hairtherapy.hairtherapy.repository;

import com.hairtherapy.hairtherapy.entity.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Blog, Integer> {
}
