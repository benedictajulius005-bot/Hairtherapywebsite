package com.hairtherapy.hairtherapy.service;

import com.hairtherapy.hairtherapy.dto.BlogDto;
import com.hairtherapy.hairtherapy.entity.Blog;

import java.util.List;

public interface BlogService {

    Blog addBlog(BlogDto blogDto);
    List<Blog> getAllBlogs();
    Blog getBlogById(int id);
    Blog updateBlog(int id, BlogDto blogDto);
    void deleteBlog(int id);

}
