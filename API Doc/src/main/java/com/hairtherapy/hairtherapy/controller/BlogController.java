package com.hairtherapy.hairtherapy.controller;

import com.hairtherapy.hairtherapy.dto.BlogDto;
import com.hairtherapy.hairtherapy.entity.Blog;
import com.hairtherapy.hairtherapy.service.BlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/blogs")
public class BlogController {

    private final BlogService blogService;

    @PostMapping
    public ResponseEntity<Blog> addBlog(@RequestBody BlogDto blogDto) {
        return ResponseEntity.ok(blogService.addBlog(blogDto));
    }

    @GetMapping
    public ResponseEntity<List<Blog>> getAllBlogs() {
        return ResponseEntity.ok(blogService.getAllBlogs());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Blog> getBlogById(@PathVariable int id) {
        return ResponseEntity.ok(blogService.getBlogById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Blog> updateBlog(@PathVariable int id, @RequestBody BlogDto blogDto) {
        return ResponseEntity.ok(blogService.updateBlog(id, blogDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBlog(@PathVariable int id) {
        blogService.deleteBlog(id);
        return ResponseEntity.ok("Blog deleted successfully");
    }
}
