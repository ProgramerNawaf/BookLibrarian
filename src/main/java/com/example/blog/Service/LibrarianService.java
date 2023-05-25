package com.example.blog.Service;

import com.example.blog.ApiException.ApiException;
import com.example.blog.Model.Book;
import com.example.blog.Model.Librarian;
import com.example.blog.Repository.BookRepository;
import com.example.blog.Repository.LibrarianRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LibrarianService {

    private final LibrarianRepository librarianRepository;

    public List<Librarian> getLibrarian(){
        return librarianRepository.findAll();
    }

    public void addLibrarian(Librarian b){
        librarianRepository.save(b);
    }

    public void updateLibrarian(Integer id, Librarian librarian){
        Librarian b = librarianRepository.findLibrarianById(id);
        if(b == null)
            throw new ApiException("Librarian with this ID dosent exist!");

        b.setName(librarian.getName());
        b.setUsername(librarian.getUsername());
        b.setEmail(librarian.getEmail());
        b.setPassword(librarian.getPassword());
        librarianRepository.save(b);
    }

    public void deletLibrarian(Integer id){
        if(librarianRepository.findLibrarianById(id) == null)
            throw new ApiException("Librarian with this ID dosent exist!");
        librarianRepository.delete(librarianRepository.findLibrarianById(id));
    }

    public Librarian getById(Integer id){
        if(librarianRepository.findLibrarianById(id) == null)
            throw new ApiException("Librarian with this ID dosent exist!");
            return librarianRepository.findLibrarianById(id);
    }

    public Librarian check(String email , String password){
        if(librarianRepository.findLibrarianByEmailAndPassword(email,password) == null)
            throw new ApiException("Email or password invalid!");

        return librarianRepository.findLibrarianByEmailAndPassword(email,password);
    }

    public Librarian getByEmail(String email){
        if(librarianRepository.getByEmail(email)== null)
            throw new ApiException("Librarian with this email dosent exist!");

        return librarianRepository.getByEmail(email);
    }
}
