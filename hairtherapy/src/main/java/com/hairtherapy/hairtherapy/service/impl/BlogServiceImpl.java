package com.hairtherapy.hairtherapy.service.impl;

import com.hairtherapy.hairtherapy.dto.BlogDto;
import com.hairtherapy.hairtherapy.entity.Blog;
import com.hairtherapy.hairtherapy.entity.User;
import com.hairtherapy.hairtherapy.repository.BlogRepository;
import com.hairtherapy.hairtherapy.repository.UserRepository;
import com.hairtherapy.hairtherapy.service.BlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BlogServiceImpl implements BlogService {

    private final BlogRepository blogRepository;
    private final UserRepository userRepository;

    @Override
    public Blog addBlog(BlogDto blogDto) {
        User author = userRepository.findById(blogDto.getAuthorId())
                .orElseThrow(() -> new RuntimeException("Author not found"));

        Blog blog = new Blog();
        blog.setTitle(blogDto.getTitle());
        blog.setContent(blogDto.getContent());
        blog.setAuthor(author);

        return blogRepository.save(blog);
    }

    @Override
    public List<Blog> getAllBlogs() {
        return blogRepository.findAll();
    }

    @Override
    public Blog getBlogById(int id) {
        return blogRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Blog not found"));
    }

    @Override
    public Blog updateBlog(int id, BlogDto blogDto) {
        Blog existing = getBlogById(id);
        existing.setTitle(blogDto.getTitle());
        existing.setContent(blogDto.getContent());
        return blogRepository.save(existing);
    }

    @Override
    public void deleteBlog(int id) {
        blogRepository.deleteById(id);
    }
}
