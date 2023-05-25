package com.example.blog.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@Entity
@NoArgsConstructor
@Table(name="Blog")
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(columnDefinition = "varchar(20) not null")
    @NotNull(message = "title cant be null")
    private String title;
    @Column(columnDefinition = "varchar(20) not null check (category='health' or category='education' or category='programming' )")
    @NotNull(message="category cant be null!")
    @Pattern(regexp = "(education|programming|health)" , message = "category invalid!")
    private String category;
    @Column(columnDefinition = "varchar(300) not null")
    @NotNull(message="body cant be null!")
    @Size(max=300,message = "body cant be longer thant 300 charchters!")
    private String body;
    @Column(columnDefinition = "boolean DEFAULT false")
    private boolean isPublished;


}
