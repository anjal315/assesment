package com.edstem.book.service;

import com.edstem.book.model.Book;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@RestController
public class BookService {
    private static List<Book> books = new ArrayList<>();

    private static Integer booksCount = 0;

    static {
        books.add(new Book(booksCount++, "Harry Potter Part One", "Aishu", 100001, LocalDate.now().minusYears(25)));
        books.add(new Book(booksCount++, "Harry Potter Part Two", "Raju", 100001, LocalDate.now().minusYears(20)));
        books.add(new Book(booksCount++, "Harry Potter Part Three", "Rakeshu", 100001, LocalDate.now().minusYears(15)));
        books.add(new Book(booksCount++, "Harry Potter Part Four", "Shambu", 100001, LocalDate.now().minusYears(10)));
    }

//    public BookService(BookRepository bookRepository) {
//    }

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
