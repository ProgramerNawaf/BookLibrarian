package com.example.blog.Service;

import com.example.blog.ApiException.ApiException;
import com.example.blog.Model.Blog;
import com.example.blog.Repository.BlogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BlogService {
    private final BlogRepository blogRepository;

    public List<Blog> getBlogs(){
        return blogRepository.findAll();
    }

    public void addBlog(Blog b){
        blogRepository.save(b);
    }

    public void update(Integer id,Blog b){
        Blog blog =blogRepository.findBlogById(id);
        if(blog == null)
            throw new ApiException("Blog with this ID dosent exist!");
        blog.setCategory(b.getCategory());
        blog.setBody(b.getBody());
        blogRepository.save(blog);
    }


    public void delete(Integer id){
       Blog blog= blogRepository.findBlogById(id);
        if(blog == null)
            throw new ApiException("Blog with this ID dosent exist!");
        blogRepository.delete(blog);
    }

    public Blog getBlogById(Integer id){
        Blog blog= blogRepository.findBlogById(id);
        if(blog == null)
            throw new ApiException("Blog with this ID dosent exist!");
        return blog;
    }

    public Blog getBlogByTitle(String title){
        Blog b = blogRepository.findBlogByTitle(title);
        if(b == null)
            throw new ApiException("Blog with this title dosent exist!");
        return b;
    }

    public List<Blog> getBlogByCategory(String category){
        List<Blog> b = blogRepository.findBlogByCategory(category);
        if(b.size() == 0)
            throw new ApiException("No blogs with this Category!");
        return b;
    }

    public void setPublished(Integer id){
        Blog blog= blogRepository.findBlogById(id);
        blog.setPublished(true);
        blogRepository.save(blog);

    }




}
