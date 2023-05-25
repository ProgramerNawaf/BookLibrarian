package com.example.blog.Controller;

import com.example.blog.Model.Book;
import com.example.blog.Model.Librarian;
import com.example.blog.Service.LibrarianService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/librarian")
@RequiredArgsConstructor
public class LibrarianController {

    private final LibrarianService librarianService;


    @GetMapping("/get")
    public ResponseEntity getLibrarians(){
        return ResponseEntity.status(200).body(librarianService.getLibrarian());
    }

    @PostMapping("/create")
    public ResponseEntity addLibrarian(@Valid @RequestBody Librarian b){
        librarianService.addLibrarian(b);
        return ResponseEntity.status(200).body("Librarian added!");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateLibrarian(@Valid @RequestBody Librarian b , @PathVariable Integer id){
        librarianService.updateLibrarian(id,b);
        return ResponseEntity.status(200).body("Librarian updated!");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deletLibrarian(@PathVariable Integer id){
        librarianService.deletLibrarian(id);
        return ResponseEntity.status(200).body("Librarian deleted!");
    }

    @GetMapping("/check/{email}/{passoword}")
    public ResponseEntity deletLibrarian(@PathVariable("email") String email , @PathVariable("passoword") String passoword){
        librarianService.check(email,passoword);
        return ResponseEntity.status(200).body("Librarian Logged in!");
    }

    @GetMapping("/get-email/{email}")
    public ResponseEntity getByEmail(@PathVariable String email){
        return ResponseEntity.status(200).body(librarianService.getByEmail(email));
    }
    @GetMapping("/get-id/{id}")
    public ResponseEntity getById(@PathVariable Integer id){
        return ResponseEntity.status(200).body(librarianService.getById(id));
    }

}
