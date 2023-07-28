package com.edstem.book.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import lombok.*;

@Entity
@Table(name = "book_details")
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    //  id, title, author, isbn, publicationDate.
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)

    private Integer id;
    private String title;
    private String author;
    private long isbn;
    private LocalDate publicationDate;

    public void setPublicationDate(LocalDate today) {
    }
}
