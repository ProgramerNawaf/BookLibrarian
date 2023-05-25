package com.example.blog.Controller;

import com.example.blog.Model.Book;
import com.example.blog.Service.BookService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/book")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;


    @GetMapping("/get")
    public ResponseEntity getBooks(){
        return ResponseEntity.status(200).body(bookService.getBooks());
    }

    @PostMapping("/create")
    public ResponseEntity addBook(@Valid @RequestBody Book b){
        bookService.addBook(b);
        return ResponseEntity.status(200).body("Book added!");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateBook(@Valid @RequestBody Book b , @PathVariable Integer id){
        bookService.updateBook(id,b);
        return ResponseEntity.status(200).body("Book updated!");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteBook(@PathVariable Integer id){
        bookService.deleteBook(id);
        return ResponseEntity.status(200).body("Book deleted!");
    }

    @GetMapping("/get-category/{category}")
    public ResponseEntity getCategory(@PathVariable String category){
        return ResponseEntity.status(200).body(bookService.getBookByCategory(category));
    }

    @GetMapping("/get-author/{author}")
    public ResponseEntity getAuthor(@PathVariable String author){
        return ResponseEntity.status(200).body(bookService.getBookByAuthor(author));
    }

    @GetMapping("/get-title/{title}")
    public ResponseEntity getTitle(@PathVariable String title){
        return ResponseEntity.status(200).body(bookService.search(title));
    }
    @GetMapping("/get-pages/{number}")
    public ResponseEntity getNumber(@PathVariable Integer number){
        return ResponseEntity.status(200).body(bookService.getBookByPages(number));
    }

}
