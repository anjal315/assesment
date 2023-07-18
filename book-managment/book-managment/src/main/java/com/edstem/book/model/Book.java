package com.edstem.book.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "book_details")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    //  id, title, author, isbn, publicationDate.
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Integer id;

    @NotBlank(message = "Title is required")
    @Size(max = 255, message = "Title cannot exceed 255 characters")
    private String title;


    @NotBlank(message = "Author is required")
    @Size(max = 100, message = "Author name cannot exceed 100 characters")
    private String author;

    @NotNull(message = "ISBN is required")
    private long isbn;

    @NotNull(message = "Publication date is required")
    @PastOrPresent(message = "Publication date must be in the past or present")
    private LocalDate publicationDate;

}
