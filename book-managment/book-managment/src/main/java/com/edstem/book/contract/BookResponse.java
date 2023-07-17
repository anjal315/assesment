package com.edstem.book.contract;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
@Builder
@Getter
public class BookResponse {
    private int id;
    private String title;
    private String author;
    private long isbn;
    private LocalDate publicationDate;
}
