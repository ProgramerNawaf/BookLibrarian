package com.example.blog.Service;

import com.example.blog.ApiException.ApiException;
import com.example.blog.Model.Book;
import com.example.blog.Repository.BookRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    public List<Book> getBooks(){
        return bookRepository.findAll();
    }

    public void addBook(Book b){
        bookRepository.save(b);
    }

    public void updateBook(Integer id, Book book){
        Book b = bookRepository.findBookById(id);
        if(b == null)
            throw new ApiException("Book with this ID dosent exist!");

        b.setTitle(book.getTitle());
        b.setCategory(book.getCategory());
        b.setISBN(book.getISBN());
        b.setNumOfPages(book.getNumOfPages());
        b.setAuthor(book.getAuthor());
        bookRepository.save(b);
    }

    public void deleteBook(Integer id){
        if(bookRepository.findBookById(id) == null)
            throw new ApiException("Book with this ID dosent exist!");
        bookRepository.delete(bookRepository.findBookById(id));
    }

    public List <Book> getBookByCategory(String category){
        List<Book> b = bookRepository.findBookByCategory(category);
        if(b.isEmpty())
            throw new ApiException("Books with this Category is not available!");

        return bookRepository.findBookByCategory(category);
    }

    public List <Book> getBookByPages(Integer number){
        List<Book> b =bookRepository.getBookByNumOfPages(number);
        if(b.isEmpty())
            throw new ApiException("Books with this number of pages dosent exist!");

        return bookRepository.getBookByNumOfPages(number);
    }
    public List <Book> getBookByAuthor(String author){
        List<Book> b =bookRepository.findBookByAuthor(author);
        if(b.isEmpty())
            throw new ApiException("Books with this Author is not available!");

        return bookRepository.findBookByAuthor(author);
    }

    public Book search(String title){
        Book b =bookRepository.findBookByTitle(title);
        if(b == null)
            throw new ApiException("Book with this Title is not available!");
        return bookRepository.findBookByTitle(title);
    }


}
