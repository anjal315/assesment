package com.edstem.book.service;

import com.edstem.book.model.Book;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@RestController
public class BookService {
    private static List<Book> books = new ArrayList<>();

    private static Integer booksCount = 0;

    public List<Book> findAll() {
        return books;
    }

    public Book save(Book book) {
        book.setId(booksCount++);
        books.add(book);
        return book;
    }

    public Book findOne(int id) {
        Predicate<? super Book> predicate = book -> book.getId().equals(id);
        return books.stream().filter(predicate).findFirst().get();
    }

    public void deleteById(int id) {
        Predicate<? super Book> predicate = book -> book.getId().equals(id);
        books.removeIf(predicate);
    }
}
