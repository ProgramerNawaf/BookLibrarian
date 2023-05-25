package com.example.blog.Repository;

import com.example.blog.Model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {

    Book findBookById(Integer id);
    Book findBookByTitle(String title);
    List<Book> findBookByCategory(String category);
    @Query("select b from Book b where b.numOfPages >= ?1 ")
    List<Book> getBookByNumOfPages(Integer number);

    List<Book> findBookByAuthor(String author);


}
