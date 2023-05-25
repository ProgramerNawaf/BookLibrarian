package com.example.blog.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Entity
@Data
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(columnDefinition = "varchar(20) not null unique")
    @NotNull(message = "title cant be empty!")
    private String title;
    @Column(columnDefinition = "varchar(20) not null")
    @NotNull(message = "author cant be empty!")
    private String author;
    @Column(columnDefinition = "varchar(20) not null check (category='Academic' or category='Mystery' or category='Novel')")
    @NotNull(message = "category cant be empty!")
    private String category;
    @Column(columnDefinition = "int not null")
    private Integer ISBN;
    @Column(columnDefinition = "int not null")
    @Min(value = 49 , message = "numOfPages should be at least 50 pages!")
    private Integer numOfPages;
}
