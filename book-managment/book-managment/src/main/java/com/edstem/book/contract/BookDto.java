package com.edstem.book.contract;

import com.edstem.book.validation.author.ValidAuthor;
import com.edstem.book.validation.isbn.ValidIsbn;
import com.edstem.book.validation.publication.ValidPublication;
import com.edstem.book.validation.title.ValidTitle;
import lombok.*;

import java.time.LocalDate;
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookDto {
    private int id;

    @ValidTitle
    private String title;

    @ValidAuthor
    private String author;

    @ValidIsbn
    private long isbn;

    @ValidPublication
    private LocalDate publicationDate;
}
