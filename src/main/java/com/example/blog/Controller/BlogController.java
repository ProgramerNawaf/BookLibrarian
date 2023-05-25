package com.example.blog.Controller;

import com.example.blog.Model.Blog;
import com.example.blog.Service.BlogService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/blog")
@RequiredArgsConstructor
public class BlogController {

    private final BlogService blogService;

    @GetMapping("/get")
    public List<Blog> get(){
        return blogService.getBlogs();
    }

    @PostMapping("/create")
    public ResponseEntity add(@Valid @RequestBody Blog b){
        blogService.addBlog(b);
        return ResponseEntity.status(200).body("Blog added");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity update(@Valid @RequestBody Blog b , @PathVariable Integer id){
        blogService.update(id,b);
        return ResponseEntity.status(200).body("Blog updated");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable Integer id){
        blogService.delete(id);
        return ResponseEntity.status(200).body("Blog deleted");
    }

    @GetMapping("/get-id/{id}")
    public ResponseEntity getById(@PathVariable Integer id){
        return ResponseEntity.status(200).body(blogService.getBlogById(id));
    }

    @GetMapping("/get-title/{title}")
    public ResponseEntity getByTitle(@PathVariable String title){
        return ResponseEntity.status(200).body(blogService.getBlogByTitle(title));
    }

    @GetMapping("/get-category/{category}")
    public ResponseEntity getByCategory(@PathVariable String category){
        return ResponseEntity.status(200).body(blogService.getBlogByCategory(category));
    }

    @PutMapping("/publish/{id}")
    public ResponseEntity updatePublished(@PathVariable Integer id){
        blogService.setPublished(id);
        return ResponseEntity.status(200).body("Blog published!");
    }

}
