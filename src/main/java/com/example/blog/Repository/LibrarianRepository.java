package com.example.blog.Repository;

import com.example.blog.Model.Book;
import com.example.blog.Model.Librarian;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LibrarianRepository extends JpaRepository<Librarian,Integer> {

    Librarian findLibrarianById(Integer id);

    Librarian findLibrarianByEmailAndPassword(String email,String password);

    @Query("select l from Librarian l where l.email =?1")
    Librarian getByEmail(String email);

}
